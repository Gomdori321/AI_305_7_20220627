package com.myjsp.mytest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ModifyOk
 */
@WebServlet("/ModifyOk")
public class ModifyOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		HttpSession httpSession;
		httpSession = request.getSession();
		System.out.println(httpSession.getAttribute("id"));
		
		//이름 pw phone gender값 가져오기(id는 이미 session으로 받음)
		String strName = request.getParameter("name");
		String strPhone = 
				request.getParameter("phone")+ "-" +
				request.getParameter("phone2")+ "-" + 
				request.getParameter("phone3");
		String strPW = request.getParameter("pw");
		String strGender = request.getParameter("gender");
		
		String strQuery = String.format(
				"update member set name='%s',"
				+ "hp='%s',gender='%s',pw='%s' where id='%s'", 
				strName,strPhone,strGender,strPW,
				httpSession.getAttribute("id"));
		System.out.println(strQuery+"수정");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //jar에 있는 db 연결 소스를 참조하는 것
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection conn = null; //DB 연결에 관련된 객체들
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//db연결에 필요한 정보들
			//db위치, 스키마이름, 인코딩 등
			String jdbcDriver = "jdbc:mysql://localhost:3306/jspdb?" + "useUnicode=true&characterEncoding=utf8&"
					+ "serverTimezone=UTC";
			String dbUser = "root";
			String dbPass = "1234";
			
			//연결을 만듦
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			stmt = conn.createStatement(); // 쿼리문 실행 관련 객체 생성
			int i = stmt.executeUpdate(strQuery); //db에 쿼리보냄
			if (i == 1) { // 성공(update 성공시 영향받는 컬럼은 1개니까)
				System.out.println("성공");
				//response.sendRedirect("joinResult.jsp");
				httpSession.setAttribute("name", strName);
				response.sendRedirect("modifyResult.jsp");
			} else {
				System.out.println("실패");
				response.sendRedirect("modify.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally { //db 호출하고 쿼리문 날렸으면 무조건 닫아줘야 함
			try {   //그래서 다른 사용자들도 쓰고 다시 쓸 수 있다.
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
















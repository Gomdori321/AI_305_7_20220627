package com.myjsp.mytest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NiceWorld
 */
@WebServlet({ "/NiceWorld", "/NW", "*.mytest" })
public class NiceWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NiceWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet
	(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, 
					IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, 
					IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}
	
	
	public void doAction
	(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException 
	{
		response.getWriter().append("Hey! Nice meet you!");
		
	}
	

}











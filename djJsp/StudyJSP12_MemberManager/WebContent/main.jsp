<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% //ValidMem이 없는 상태(=로그아웃 했거나 아직 아예 로그인 안한 경우)
if(session.getAttribute("ValidMem") == null ) {
%>
<jsp:forward page="login.jsp"/>
<%} 

String name = (String)session.getAttribute("name");
String id = (String)session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><%=name %>님 안녕하세요!</h1>
<form action="logout.jsp" method="post">
	<input type="submit" value="로그아웃"><br>
	<input type="button" value="정보수정" onclick="javascript:window.location='modify.jsp'">
	
	
	
</form>
</body>
</html>
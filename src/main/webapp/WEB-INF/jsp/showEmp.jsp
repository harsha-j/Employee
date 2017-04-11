<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.optus.Employee" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee</title>
</head>
<body>
<%
Employee e=(Employee)request.getAttribute("employee");
int x=e.getAge();
int y=e.getId();
String z=e.getName();
out.println(x);
out.println(y);
out.println(z);

%>
</body>
</html>
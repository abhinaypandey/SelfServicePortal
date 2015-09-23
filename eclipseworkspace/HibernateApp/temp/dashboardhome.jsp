<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date"%>
<%@page import="com.amgen.getResponse.entity.userProfileManagement.User"%>
<%@page import="com.amgen.getResponse.entity.campaign.Product"%>
<%@page import="com.amgen.getResponse.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style.css" />
<title>Home Page</title>
</head>
<body>

	<%=new Date()%>
	<%
				 User user = (User) session.getAttribute("user");
			 %>
			
	<br>
	<br>
	<div style="">
		WELCOME
		<%= user.getFirstName() + " " + user.getLastName()%> <br />
	</div>
	<br>
	<br>

	<br>
	<br>
	<br>
	<form name="frm3" method="post" action="EditProfile"
		style="height: 5px;">
		<br>
		<table align="left">
			<tr>
				<td><input type="submit" value="Update Profile" /></td>
			</tr>
			<tr>
				<td><input type="hidden" name="serviceType" value="admin" /></td>
			</tr>
		</table>
	</form>
	<br>
	<br>
	<br>
	<br>
	<table border="1" width="50%" cellpadding="7">
		<thead>
			<tr>
				<th colspan="2">Your Subscriptions</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Products</td>
				<td>Channels</td>
			</tr>

		</tbody>
	</table>
	<div>
		<form name="frm3" method="post" action="SelectProduct"
		style="height: 5px;">
		<br>
		<table align="left">
			<tr>
				<td><input type="submit" value="Edit Subscription" /></td>
			</tr>
			<tr>
				<td><input type="hidden" name="serviceType" value="admin" /></td>
			</tr>
		</table>
	</form>
	</div>


	<br>
	<br>
	<br>
	<a href="logout.jsp" align="right">Logout</a>
	<br />
	</div>

	</center>
</body>
</html>
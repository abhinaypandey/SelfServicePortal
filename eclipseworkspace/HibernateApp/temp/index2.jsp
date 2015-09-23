<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form name="frm3" method="post" action="addChannel.jsp" style="height: 5px; ">
		<br>
		<table align="center">
			<tr>
				<td><input type="submit" value="Add Channel" /></td>
			</tr>
			<tr>
				<input type="hidden" name="serviceType" value="admin" />
			</tr>
		</table>
	</form>
	<br>
	<br>
	<form name="frm" method="post" action="${pageContext.request.contextPath}/addProduct.jsp">
		<br>
		<table align="center">
			<tr>
				<td><input type="submit" value="Add Product" /></td>
			</tr>
			<tr>
				<input type="hidden" name="serviceType" value="admin" />
			</tr>
		</table>
	</form>
	<form name="frm1" method="post" action="${pageContext.request.contextPath}/AddCampaign">
		<br>
		<table align="center">
			<tr>
				<td><input type="submit" value="Add Campaign" /></td>
			</tr>
			<tr>
				<input type="hidden" name="serviceType" value="admin" />
			</tr>
		</table>
	</form>
	
</body>
</html>
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
	<%
		Product pr = new Product();
		
		List<Product> p = (List<Product>)session.getAttribute("productList");
		if (p != null) {

			for (int i = 0; i < p.size(); i++) {
				pr = p.get(i);
				out.println("products are" + p.get(0).getProductname());
				
			}
						//out.println("---------------------");
			//out.println("products are" + p.get(0).getProductName());
		}
	%>

	<center>
		<div id="mystyle">
			<h1>GetResponse</h1>

			<br>
			<%=new Date()%>
			<%
				 User user = (User) session.getAttribute("user");
			 %>
			<b>Welcome <%= user.getFirstName() + " " + user.getLastName()%></b> <br />
			<br>
			<form name="frm3" method="post" action="editprofile.jsp"
				style="height: 5px;">
				<br>
				<table align="center">
					<tr>
						<td><input type="submit" value="Update Profile" /></td>
					</tr>
					<tr>
						<td><input type="hidden" name="serviceType" value="admin" /></td>
					</tr>
				</table>
			</form>
			<br> <br>
			<form name="frm2" method="post" action="editprofile.jsp"
				style="height: 5px;">
				<br>
				<table align="center">
					<tr>
						<td><select name="select" multiple="multiple" style="width: 150px;">
								<%
						if (p != null) {
						for (int i = 0; i < p.size(); i++) {
			%><option value="<%=p.get(i).getProductname()%>"><%=p.get(i).getProductname()%></Option>

								<%
}
}%>

						</select></td>
					</tr>
				</table>
			</form>
			<br> <br> <br> <a href="logout.jsp">Logout</a> <br />
		</div>

	</center>
</body>
</html>
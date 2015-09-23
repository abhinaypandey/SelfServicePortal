<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="com.amgen.getResponse.*"%>
<%@ page import="com.amgen.getResponse.entity.userProfileManagement.User"%>
<%@ page import="java.util.List"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
  User u = (User) session.getAttribute("user");
                
                String firstname = u.getFirstName();
                String lastname = u.getLastName();
                String email = u.getEmail();
                int phone = u.getPhone();
                String uname  = u.getUserName();
                String pword = u.getPassword();
                String address = u.getAddress();
                int fax = u.getFax();
				
			 %>

<body>
	<form name=myform method="post"
		action="${pageContext.request.contextPath}/UpdateUser"
		onsubmit="return validateform();">
		<center>
			<table border="1" width="50%" cellpadding="7">
				<thead>
					<tr>
						<th colspan="2">Enter Information Here</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>First Name</td>
						<td><input type="text" name="First_Name" value="<%= firstname %>"/></td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td><input type="text" name="Last_Name" value="<%= lastname %>" /></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" name="EMAIL" value="<%= email %>" /></td>
					</tr>
					<tr>
						<td>Phone</td>
						<td><input type=int name="PHONE" value="<%= phone %>" /></td>
					</tr>
					<tr>
						<td>User Name</td>
						<td><input type="text" name="USERNAME" value="<%= uname %>" readonly /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="PASSWORD" value="<%= pword %>" /></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input type="textarea" name="Address" value="<%= address %>" /></td>
					</tr>
					<tr>
						<td>Fax</td>
						<td><input type="integer" name="Fax" value="<%= fax %>" /></td>
					</tr>
					<tr>
						<input type="hidden" name="serviceType" value="admin" />
					</tr>
					<tr>
						<td><input type="submit" value="Update" /></td>
						<td><input type="reset" value="Reset" /></td>
					</tr>
				</tbody>
			</table>
		</center>
	</form>

</body>
</html>
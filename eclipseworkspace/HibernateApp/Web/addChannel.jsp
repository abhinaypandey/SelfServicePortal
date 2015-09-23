<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="com.amgen.getResponse.*"%>
<body>
	<form name=myform method="post"
		action="${pageContext.request.contextPath}/AddChannelServlet">

		<center>
			<table border="1" width="50%" cellpadding="7">
				<thead>
					<tr>
						<th colspan="2">Enter Information Here</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Channel Name</td>
						<td><input type="text" name="CHANNELNAME" value="" /></td>
					</tr>
					
					</tbody></table>
					<br>
					
						<input type="submit" value="Add" />
					
				
			
			
		</center>
	</form>
</body>
</html>

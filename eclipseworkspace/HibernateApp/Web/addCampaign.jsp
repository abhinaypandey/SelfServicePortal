<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="com.amgen.getResponse.*"%>
<%@ page import="com.amgen.getResponse.entity.campaign.Product"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="com.amgen.getResponse.entity.campaign.Channel"%>

<body>
	<%
		Product pr = new Product();
		
		List<Product> p = (List<Product>) request.getSession().getAttribute("productList");
		if (p != null) {
			
       for (int i = 0; i < p.size(); i++) {
				pr = p.get(i);
				out.println("products are" + p.get(i).getProductname());
				
			}
		}
	%>
	<%
		Channel ch = new Channel();
		
		List<Channel> c = (List<Channel>) request.getSession().getAttribute("channelList");
		if (c != null) {
			
			for (int i = 0; i < c.size(); i++) {
				ch = c.get(i);
				out.println("products are" + c.get(i).getChannelname());
				
			}
		}
	%>
	
	<form name=myform method="post" action="${pageContext.request.contextPath}/ProdCampServlet">
	<center>
			<table border="1" width="50%" cellpadding="7">
				<thead>
					<tr>
						<th colspan="2">Enter Information Here</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Campaign Name</td>
						<td><input type="text" name="CAMPAIGNNAME" value=""></td>
					</tr>
					<tr>
						<td>Select Product</td>
						<td><select name="select" multiple="multiple" style="width: 150px;">
								<%
									if (p != null) {
										for (int i = 0; i < p.size(); i++) {
								%><option value="<%=p.get(i).getProductname()%>"><%=p.get(i).getProductname()%></option>

								<%
									}
									}
								%>
						</select></td>
					</tr>
					<tr>
						<td>Select Channel</td>
						<td><select name="selectchannel" multiple="multiple" style="width: 150px;">
								<%
									if (c != null) {
										for (int i = 0; i < c.size(); i++) {
								%><option value="<%=c.get(i).getChannelname()%>"><%=c.get(i).getChannelname()%></option>

								<%
									}
									}
								%>
						</select></td>
					</tr>
					</tbody>
			</table>
			<br> <input type="submit" value="Add">
		</center>

		
	</form>

</body>
</html>

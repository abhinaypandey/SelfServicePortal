<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="com.amgen.getResponse.*"%>
<%@ page import="com.amgen.getResponse.entity.campaign.Product"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="com.amgen.getResponse.entity.campaign.Channel" %>
 <script language="javascript" type="text/javascript">  
      var xmlHttp ; 
      var xmlHttp;
      function showState(str){
      if (typeof XMLHttpRequest != "undefined"){
      xmlHttp= new XMLHttpRequest();
      }
      else if (window.ActiveXObject){
      xmlHttp= new ActiveXObject("Microsoft.XMLHTTP");
      }
      if (xmlHttp==null){
      alert("Browser does not support XMLHTTP Request")
      return;
      } 
      var url="LoadChannels";
      url +="?count=" +str;
      xmlHttp.onreadystatechange = stateChange;
      xmlHttp.open("GET", url, true);
      xmlHttp.send(null);
      }

      function stateChange(){   
      if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){   
      document.getElementById("select").innerHTML=xmlHttp.responseText   
      }   
      }

       </script> 
<script type="text/javascript">

function callServlet(){
document.write("before action");
//var e = document.getElementById("select");
//var p = e.options[e.selectedIndex].value;

//document.write("selected product is" +p);
//document.location.href="./LoadChannels";
//document.forms[1].action="/Controller/LoadChannels";
//document.getElementById("form1").action="/Controller/LoadChannels";
document.write("after action");
document.getElementById("form1").submit();


}


</script>

<body>
	<%
		Product pr = new Product();
		
		List<Product> p = (List<Product>) session.getAttribute("productList");
		if (p != null) {
			
       for (int i = 0; i < p.size(); i++) {
				pr = p.get(i);
			
				
			}
		}
	%>
	<%
		Channel ch = new Channel();
		
		List<Channel> c = (List<Channel>) session.getAttribute("channelList");
		if (c != null) {
			
			for (int i = 0; i < c.size(); i++) {
				ch = c.get(i);
				
				
			}
		}
	%>

	<form name=myform method="post"
		action="${pageContext.request.contextPath}/UserSubscriptionServlet">
		<center>
			<table border="1" width="50%" cellpadding="7">
				<thead>
					<tr>
						<th colspan="2">Select Products</th>
					</tr>
				</thead>




				<tbody>
		<form name="Form1" method="post" action="${pageContext.request.contextPath}/LoadChannels">					
		<tr>
						<td>Select Product</td>
						<td><select id="select" style="width: 150px;" onchange="document.Form1.submit()">
						<option selected disabled>Select Product</option>
						<%
									if (p != null) {
										for (int i = 0; i < p.size(); i++) {
			%>
						<option value="<%=p.get(i).getProductname()%>"><%=p.get(i).getProductname()%></option>

						<%
									}
									}
								%>
						</select>
						</td>
					</tr></form>
					<tr>
						<td>Select Channel</td>
						<td><select name="selectchannel" multiple="multiple"
							style="width: 150px;">
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
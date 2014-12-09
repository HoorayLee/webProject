<%@ page import="Servlet.DoLogin" contentType="text/html; charset=UTF-8"
 language="java" import ="com.bean.library.*" import ="java.util.ArrayList" 
 import="java.sql.*" import = "java.util.Iterator" %><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> recommend </title>
</head>

<jsp:useBean id="resource" class = "java.util.ArrayList" scope = "session"></jsp:useBean>
<style type="text/css">

body {
	background-image: url(../img/banner-bg.jpg);
}
</style>

<body>

<table width="786" border="0" style="margin-top:50px;margin-left:50px;">
  <tr align="center" bgcolor="lightgrey">
  <td width="371"><b>文件名</b></td>
    <td width="95"><b>上传者</b></td>
    <td width="161"><b>上传时间</b></td>
    <td width="141"><b>文件大小</b></td>
  </tr>
<% 

Iterator it = resource.iterator();

while (it.hasNext())
{
	Resource files = (Resource)(it.next());	
%>

<tr>
	<td><%=files.getsFileName() %></td>
	<td><%=files.getsAuthorID() %></td>
	<td><%=files.getdUploadTime()%></td>
	<td><%=files.getlSize()%></td>

</tr>
<%
}
%>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p><input type ="button" value="yourzone" onClick="doChange()"> 
<script type="text/javascript"> 
function doChange(){ 
   window.top.location.href= 'UrZoneFrame.html'; 
} 
</script>
</body>
</html>

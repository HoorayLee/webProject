<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Iterator,com.bean.library.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>yourResources</title>
</head>
<jsp:useBean id="resourceList" class = "java.util.ArrayList" scope = "session"></jsp:useBean>
<style type="text/css">

body {
	background-image: url(D:/work/app/WebContent/img/banner-bg.jpg);
}
</style>

<body>

<table width="786" border="0" style="margin-top:50px;margin-left:50px;">
  <tr align="center" bgcolor="lightgrey">
    <td width="371"><b>文件名</b></td>
    <td width="95"><b>上传者</b></td>
    <td width="161"><b>上传时间</b></td>
    <td width="141"><b>下载量</b></td>
  </tr>
<%
	Iterator<Resource> it = resourceList.iterator();
int i=0;
while (it.hasNext())
{
	Resource resource = (Resource)it.next();	
	if(i%2==0){
%>
<tr>
	<td><%=resource.getsFileName() %></td>
	<td><%=resource.getdUploadTime() %></td>
	<td><%=resource.getlSize()%></td>
	<td><%=resource.getiDownloadNum()%></td>
	<td><form id="form1" name="form1" method="post" action="/app/Delete">
	  <div align="center">
	    <input type="submit" name="Submit" value="删除" />
	    </div>
	    <%request.getSession().setAttribute("deleteResourceID", resource.getiFileID()); %>
	</form>
    <label></label></td>

</tr>

<%
	i++;
	}
	else{
%>
<tr bgcolor="lightgrey">
	<td><%=resource.getsFileName() %></td>
	<td><%=resource.getdUploadTime() %></td>
	<td><%=resource.getlSize()%></td>
	<td><%=resource.getiDownloadNum()%></td>
	<td><form id="form1" name="form1" method="post" action="servlet/DeleteUrFileServlet">
	  <div align="center">
	    <input type="submit" name="Submit" value="删除" />
	    </div>
	    
	</form>
    <label></label></td>
</tr>

<%
	i++;
	}
}
%>
</table>
  
</body>
</html>
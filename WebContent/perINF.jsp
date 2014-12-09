<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.bean.library.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:useBean id="user" class = "com.bean.library.User" scope = "session"></jsp:useBean>
<title>perINF</title>


<style type="text/css">

body {
	background-image: url(img/banner-bg.jpg);
}
</style>
</head>
<body>


<p>学号：<%= session.getAttribute("account")%></p>
<form id="form1" name="form1" method="post" action="/app/ChangeName">
  <p>昵称：<input name="nickName" type="text" value= <%=session.getAttribute("nickname") %> />
  
  
  <label>
  <input type="submit" name="Submit" value="提交" onclick="doChange()"> 
    <script type="text/javascript"> 
    function doChange(){ 
       window.top.location.href= 'UrZoneFrame.html'; 
    } 
    </script>
  </label>
  </p>
  
</form>
<p>积分：<%= user.getiCredit()%></p>
<p>已上传资源数目：<%=user.getiFileNumber() %></p>
<p><a href="upload.html" target="loadFrame"><img src="img/upload.png" width="124" height="49" border="0" /></a></p>

</body>
</html>
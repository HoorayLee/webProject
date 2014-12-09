<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:useBean id="user" class = "com.bean.library.User" scope = "session"></jsp:useBean>
<script type="text/javascript" src="Javascript/Login_javascript.js"></script>
<style type="text/css">


body {
	background-image: url(img/banner-bg.jpg);
}


</style></head>


<body>
<script> 
var inputText=function(o,e,e2){if(!o)return;var txt=o.value; 
function inputTextChange(o,e,e2,txt){ 
o[e]=function(){var txt2=o.value;if(txt==txt2)o.value=""} 
o[e2]=function(){var txt2=o.value;if(txt2=="")o.value=txt}} 
new inputTextChange(o,e,e2,txt) 
} 
</script> 

<form id="form1" name="form" method="post" onsubmit="return validate(this)" action="/app/DoLogin"  style="margin-left:200px;margin-top:100px;">
  <label>账号：
  <input name="account" type="text" id="account" value="请输入您的教务处账号" />
  </label>
  <p>
    <label>密码：
    <input name="password" type="password" id="password" />
    </label>
  </p>
  <p>
    <label >
    <input type="image" name="imageField" src="button/sign_in.gif" onClick="doChange()" > 
    <script type="text/javascript"> 
    function doChange(){ 
    	this.form.submit();
       window.top.location.href= 'main.html'; 
    } 
    </script>
    </label>
  </p>
  <script> 
  <%
  session.setAttribute("account", user);
  %>
var inputArr=document.getElementsByTagName("input") 
for(var i in inputArr){ 
if(!inputArr[i].type=="text") continue; 
inputText(inputArr[i],"onfocus","onblur") 
} 
</script> 
</form>
</body>
</html>
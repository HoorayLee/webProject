<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" import="java.util.Iterator, com.bean.library.Comment"%>
<jsp:useBean id="resource" class = "com.bean.library.Resource" scope = "session"></jsp:useBean>

<jsp:useBean id="author" class = "com.bean.library.User" scope = "session"></jsp:useBean>
<jsp:useBean id="Comment" class = "java.util.ArrayList" scope = "session"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
<!--
.STYLE2 {color: #000000}
body {
	background-image: url(img/banner-bg.jpg);
	background-repeat: no-repeat;
}
-->
</style>
</head>

<body >
<p>
<h2>

</h2>
<table width="437" border="0">
  <tr>
    <th width="146" scope="row"><%=author.getsNickName()%></th>
    <td width="95"><%=resource.getdUploadTime()%></td>
    <td width="100"><%=resource.getiDownloadNum()%></td>
    <td width="78"><%=resource.getlSize()%></td>
  </tr>
</table>

<p>&nbsp;</p>
<p>&#20027;&#35201;&#20869;&#23481;&#65306;</p>
<p>
  <textarea name="&#20027;&#35201;&#20869;&#23481;" cols="100" rows="10"><%=resource.getsDescription()%></textarea>
</p>
<p>&nbsp;</p>
<table width="845" border="0">
  <tr>
    <th width="202" height="108" scope="row"><div align="left">
      <form name="form2" method="post" action="">
        <img src="button/&#36190;.png" alt="&#36393;" width="92" height="106">（已
            有<%=resource.getiPraise()%>人赞）
      </form>
      </div></th>
    <td width="363"><form name="form3" method="post" action="">
      <img src="button/&#36393;.png" alt="&#36393;" width="92" height="106">（已有<%=resource.getiCriticize()%>人踩）
        </form>
    <div align="center"></div></td>
    <td width="266"><div align="center">
      <form name="form4" method="post" action="">
        <img src="button/&#20030;&#25253;.png" alt="&#20030;&#25253;" width="158" height="106">
        </form>
      </div></td>
  </tr>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p>
<form name="form1" method="post" action="">
  <label></label>
  <img src="button/下载png.png" alt="&#19979;&#36733;" width="311" height="106">
  
</form>

<p><fieldset><legend>评论：</legend>
<table width="845" border="0">
<% 
Iterator<Comment> it =  Comment.iterator();

while (it.hasNext())
{
	Comment comment = (Comment)it.next();	
%>

<tr>
	<td><%=comment.getsComment()%></td>
	<td><%=comment.getCommentTime() %></td>
	
</tr>

  <%
}
%>
  </table>

<form name="form5" method="post" action="/app/StoreComment">
  <label><span class="STYLE2">发表匿名评论：</span><br>
  <textarea name="comment" cols="100" rows="8"></textarea>
  </label>
  <label>
  <input type="submit" name="Submit" value="提交" onclick="success()" >
  </label>
  <%  request.getSession().setAttribute("fileID", resource.getiFileID()); %>
</form>
<script type="text/javascript">
function success()
{
alert("您的评论已经提交")
}
</script>
<p>&nbsp; </p>
</fieldset>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: peng Wang
  Date: 2023/1/18
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
   <h1>LOGIN PAGE</h1>
      <hr>
  <form action="<%=request.getContextPath()%>/user/login" method="post">
      username:<input type="text" name="username"><br>
      password:<input type="password" name="password"><br>
      <input type="submit" value="login">


  </form>
  </body>
</html>

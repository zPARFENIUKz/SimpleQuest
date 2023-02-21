<%--
  Created by IntelliJ IDEA.
  User: zzzif
  Date: 21.02.2023
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Illegal Cookies</title>
</head>
<body>
<h1>Ваши куки модифицированы неверно, сессия обнулена</h1>
<br/>
<form action="${pageContext.request.contextPath}/" method="get">
    <input type="submit" value="Вернуться на главную страницу">
</form>
</body>
</html>

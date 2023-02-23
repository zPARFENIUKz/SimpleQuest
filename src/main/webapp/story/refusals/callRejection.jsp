<%--
  Created by IntelliJ IDEA.
  User: zzzif
  Date: 21.02.2023
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Defeat</title>
</head>
<body>
<h1>Ты проиграл</h1><br/>
<h3>Не надо было отклонять вызов</h3>
<form action="${request.contextPath}/" method="get">
    <input type="submit" value="Вернуться на главную страницу">
</form>

</body>
</html>

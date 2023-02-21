
<%@ page import="session_info_getter.SessionInfoGetter" %><%--
  Created by IntelliJ IDEA.
  User: zzzif
  Date: 21.02.2023
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>You lost your memories</title>
</head>
<body>
<h1>
    Ты потерял память
</h1>
<br/>
<h2>Принять вызов НЛО?</h2>
<br/>
<form method="post" action="challengeAccept">
    <input type="radio" name="challengeAccepted" value=false>Отказаться подниматься на мостик<br>
    <input type="radio" name="challengeAccepted" value=true>Подняться на мостик<br>
    <br>
    <input type="submit" value="Ответить">
</form>

<%
    out.println(SessionInfoGetter.getInformation(request, response));
%>
</body>

</html>

<%@ page import="session_info_getter.SessionInfoGetter" %>
<%@ page import="session_info_getter.SessionInfo" %><%--suppress HtmlUnknownTarget --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>SpaceQuest</title>
</head>
<body>
<h1><%= "Пролог" %>
</h1>
<br/>
Некая невероятная история случилась с тобой и теперь
тебя просят подняться на борт космического корабля существ,
прибывших к нам из другого измерения

<h1>
    Знакомство с экипажем
</h1>
<br/>
необходимо представиться чтобы команда знала как к тебе обращаться
<br/>
<br/>
<%
    final SessionInfo sessionInfo = SessionInfoGetter.getSessionInfo(request, response);
    if (sessionInfo == null) {
%>
<form action="authentication" method="post">
    Как к вам обращаться:
    <input type="text" name="name">
    <br/>
    <input type="submit" value="Продолжить">
</form>
<%
} else {
    out.println(sessionInfo.toString());
%>
<br/>
<form method="get" action="story">
    <input type="submit" value="Продолжить как этот пользователь">
</form>
<%}%>

</body>
</html>
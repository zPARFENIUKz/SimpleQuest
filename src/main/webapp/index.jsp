<%--suppress HtmlUnknownTarget --%>
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
<form action="startStory" method="post">
    Как к вам обращаться: <label>
    <input type="text">
</label>
    <br/>
    <input type="submit" value="Продолжить">
</form>
</body>
</html>
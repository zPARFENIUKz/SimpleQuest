<%@ page import="session_info_getter.SessionInfoGetter" %>
<%@ page import="story.StoryHolder.StoryHolder" %>
<%@ page import="story.StoryHolder.Story" %>
<%@ page import="session_info_getter.SessionInfo" %><%--
  Created by IntelliJ IDEA.
  User: zzzif
  Date: 22.02.2023
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Story</title>
</head>
<body>
<%
    final SessionInfo sessionInfo = SessionInfoGetter.getSessionInfo(request, response);
    final int numOfQuest = sessionInfo.getNumOfQuest();
    System.out.println(numOfQuest);
    if (numOfQuest == -1) {
        final int countOfGames = sessionInfo.getCountOfGames();
        session.setAttribute("countOfGames", countOfGames + 1);
        session.setAttribute("numOfQuest", 1);
        response.sendRedirect(request.getContextPath());
    } else {
        final Story story = StoryHolder.getStory(numOfQuest);
        final String h1 = story.getTitle();
        final String text = story.getText();
        final String form = story.getForm();
        out.println("<h1>" + h1 + "</h1>");
        out.println("<br/><h3>" + text + "<h3><br/>");
        out.println(form);
    }
%>
</body>
</html>

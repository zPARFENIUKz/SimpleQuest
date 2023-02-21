package session_info_getter;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SessionInfoGetter {
    public static String getInformation(final HttpServletRequest request, final HttpServletResponse response) {
        if (request == null || response == null) throw new NullPointerException();
        final HttpSession session = request.getSession(false);
        if (session == null) return "";
        String name = null;
        Integer games = null;

        try {
            for (final Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + " = " + cookie.getValue());
                if (cookie.getName().equals("countOfGames")) {
                    games = Integer.parseInt(cookie.getValue());
                } else if (cookie.getName().equals("name")) {
                    name = cookie.getValue();
                }
            }
        } catch (NumberFormatException e) {
        } finally {
            if (games == null) {
                session.invalidate();
                request.getServletContext().getRequestDispatcher("/errors/illegalCookies.jsp");
                return "";
            }
        }

        final String user_ip = request.getRemoteAddr();
        final StringBuilder sb = new StringBuilder();
        sb.append("<br/><br/><br/>")
                .append("Статистика:")
                .append("<br/>")
                .append("IP address: ")
                .append(user_ip)
                .append("<br/>")
                .append("Имя в игре: ")
                .append(name)
                .append("<br/>")
                .append("Количество игр: ")
                .append(games);
        return sb.toString();
    }
}

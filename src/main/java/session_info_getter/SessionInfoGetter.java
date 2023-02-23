package session_info_getter;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SessionInfoGetter {

    public static SessionInfo getSessionInfo(final HttpServletRequest request, final HttpServletResponse response) {
        if (request == null || response == null) throw new NullPointerException();
        final HttpSession session = request.getSession(false);
        if (session == null) return null;

        String name = (String) session.getAttribute("name");
        Integer games = (Integer) session.getAttribute("countOfGames");
        Integer numOfQuest = (Integer) session.getAttribute("numOfQuest");

        if (name == null || games == null || numOfQuest == null) {
            session.invalidate();
            request.getServletContext().getRequestDispatcher("/errors/illegalCookies.jsp");
            return null;
        }

        final String user_ip = request.getRemoteAddr();

        return new SessionInfo(user_ip, name, games, numOfQuest);
    }
}

package authentication;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AuthenticationServlet", value = "/authentication")
public class AuthenticationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String name = request.getParameter("name");
        final HttpSession session = request.getSession(true);
        session.setAttribute("name", name);
        session.setAttribute("countOfGames", 0);
        session.setAttribute("numOfQuest", 1);
        response.sendRedirect(request.getContextPath() + "/story");
    }
}

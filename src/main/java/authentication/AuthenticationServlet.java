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
        final Cookie nameCookie = new Cookie("name", name);
        final Cookie gamesCookie = new Cookie("countOfGames", "0");
        final HttpSession session = request.getSession();
        response.addCookie(nameCookie);
        response.addCookie(gamesCookie);
        response.sendRedirect(request.getContextPath() + "/startStory");
    }
}

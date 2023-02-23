package story.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import session_info_getter.SessionInfo;
import session_info_getter.SessionInfoGetter;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "story.servlets.StartStoryServlet", value = "/story")
public class StoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {//       final HttpSession session = req.getSession(false);
//        final Enumeration<String> attributeNames = session.getAttributeNames();
//        while (attributeNames.hasMoreElements()) {
//            final String attributeName = attributeNames.nextElement();
//            Object attribute = session.getAttribute(attributeName);
//            System.out.println(attributeName + " = " + attribute);
//        }
        getServletContext().getRequestDispatcher("/story/story.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final HttpSession session = req.getSession(false);

        Integer choice = Integer.parseInt(req.getParameter("choice"));
        session.setAttribute("numOfQuest", choice);
        doGet(req, resp);
    }
}

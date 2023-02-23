package story.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@WebFilter(filterName = "StartStoryFiler", urlPatterns = {"/story"})
public class StartStoryFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse resp = (HttpServletResponse) response;
        final HttpSession session = req.getSession(false);
        if (session == null) {
            redirectToStartPage(req, resp);
        }
        final String name = (String) session.getAttribute("name");
        final Integer countOfGames = (Integer) session.getAttribute("countOfGames");
        final Integer numOfQuest = (Integer) session.getAttribute("numOfQuest");
        if (name == null || countOfGames == null || numOfQuest == null) {
            redirectToStartPage(req, resp);
        }

        chain.doFilter(request, response);
    }

    private static void redirectToStartPage(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            //throw new RuntimeException(e);
        }
    }
}

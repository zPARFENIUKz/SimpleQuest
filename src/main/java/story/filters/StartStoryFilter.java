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

@WebFilter(filterName = "StartStoryFiler", value = "/startStory")
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
        Map<String, String> cookies = Arrays.stream(req.getCookies())
                .collect(Collectors.toMap(Cookie::getName, Cookie::getValue));
        if (!cookies.containsKey("name") || !cookies.containsKey("countOfGames")) {
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

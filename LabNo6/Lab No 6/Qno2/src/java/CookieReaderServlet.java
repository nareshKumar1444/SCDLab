import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "CookieReaderServlet", urlPatterns = {"/CookieReaderServlet"})
public class CookieReaderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String cookieName = "Cookies";
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    String cookieValue = cookie.getValue();
                    out.println("Value of Cookie \"" + cookieName + "\": " + cookieValue);
                    return;
                }
            }
        }
        String uniqueCode = UUID.randomUUID().toString();
        Cookie uniqueCodeCookie = new Cookie(cookieName, uniqueCode);
        uniqueCodeCookie.setMaxAge(24 * 60 * 60);
        response.addCookie(uniqueCodeCookie);
        out.println("Cookie \"" + cookieName + "\" is set with value: " + uniqueCode);
    }
}

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberme = request.getParameter("rememberme"); 
        if ("nareshkumar".equals(username) && "3842".equals(password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);
            if (rememberme != null) {
                String number = generateNumber(); 
                Cookie rememberCookie = new Cookie("rememberNumber", number);
                rememberCookie.setMaxAge(7 * 24 * 60 * 60);
                response.addCookie(rememberCookie);
                session.setAttribute("rememberMeNumber", number);
            }
            response.sendRedirect("result.jsp"); 
        } else {
            out.println("Authentication is failed please try again.");
        }
    }
    private String generateNumber() {
        return "generated this 3842 number";
    }
}

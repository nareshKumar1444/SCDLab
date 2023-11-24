import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("nareshkumar".equals(username) && "3842".equals(password)) {
            Cookie Username = new Cookie("username", username);
            Cookie Password = new Cookie("password", password);
            Username.setPath("/");
            Password.setPath("/");
            Username.setMaxAge(3600); 
            Password.setMaxAge(3600);
            response.addCookie(Username);
            response.addCookie(Password);
            response.sendRedirect("welcome.jsp"); 
        } else {
            response.getWriter().write("Authentication is Wrong please try again");
        }
    }
}
package Controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/logout")
public class LogoutUserServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		response.addCookie(new Cookie("ID",""));
		response.addCookie(new Cookie("email",""));
		response.addCookie(new Cookie("user_type",""));
		
		response.sendRedirect("http://localhost:8080/");
	}
}

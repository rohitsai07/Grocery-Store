package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Daos.BuyerDao;

@WebServlet(urlPatterns = "/UserLogin")
public class LoginUser extends HttpServlet {
	
	BuyerDao userService = new BuyerDao();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		
		if(request.getParameter("email").isEmpty() || request.getParameter("password").isEmpty() || 
				!userService.authenticate(request.getParameter("email"),request.getParameter("password"))) {
			request.setAttribute("message","Invalid Credentials");
			request.getRequestDispatcher("/WEB-INF/views/Message.jsp").forward(request, response);
		}
		else {
			Cookie email_cookie = new Cookie("email",request.getParameter("email"));
			Cookie user_type_cookie = new Cookie("user_type","user");
			int user_id = userService.get_id_from_email(request.getParameter("email"));
			Cookie user_id_cookie = new Cookie("ID",String.valueOf(user_id));
			response.addCookie(email_cookie);
			response.addCookie(user_type_cookie);
			response.addCookie(user_id_cookie);
			response.sendRedirect("http://localhost:8080/user/dashboard");
		}
		
	}
}

package Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Daos.BuyerDao;
import Entities.User;

@WebServlet(urlPatterns = "/UserRegister")
public class RegisterUser extends HttpServlet{
BuyerDao userService = new BuyerDao();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		
		if(request.getParameter("email").isEmpty() || request.getParameter("password").isEmpty() ||
				userService.get_user_via_email(request.getParameter("email"))!=null ) {
			request.setAttribute("message","Email Already Exists Or Invalid Credentials, Please Check.");
			request.getRequestDispatcher("/WEB-INF/views/Message.jsp").forward(request, response);
		}
		else {
			userService.insert_user(
					new User(
							request.getParameter("email"),
							request.getParameter("password"),
							request.getParameter("phone_number"),
							request.getParameter("name")
							)
					);
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

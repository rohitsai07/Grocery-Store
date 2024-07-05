package Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Daos.SellerDao;

@WebServlet(urlPatterns="/SellerLogin")
public class SellerLogin extends HttpServlet{
	
	SellerDao sellerService = new SellerDao();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		
		if(request.getParameter("email").isEmpty() || request.getParameter("password").isEmpty() || 
				!sellerService.authenticate(request.getParameter("email"),request.getParameter("password"))) {
			request.setAttribute("message","Invalid Credentials");
			request.getRequestDispatcher("/WEB-INF/views/Message.jsp").forward(request, response);
		}
		else {
			Cookie email_cookie = new Cookie("email",request.getParameter("email"));
			Cookie user_type_cookie = new Cookie("user_type","seller");
			int seller_id = sellerService.get_id_from_email(request.getParameter("email"));
			Cookie seller_id_cookie = new Cookie("ID",String.valueOf(seller_id));
			response.addCookie(email_cookie);
			response.addCookie(user_type_cookie);
			response.addCookie(seller_id_cookie);
			response.sendRedirect("http://localhost:8080/seller/dashboard");
		}
		
	}
}

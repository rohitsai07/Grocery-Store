package Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Daos.SellerDao;
import Entities.Seller;

@WebServlet(urlPatterns="/SellerRegister")
public class SellerRegister extends HttpServlet {
	
	SellerDao sellerService = new SellerDao();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

		if(request.getParameter("email").isEmpty() || request.getParameter("password").isEmpty() ||
				sellerService.get_seller_via_email(request.getParameter("email"))!=null ) {
			request.setAttribute("message","Email Already Exists Or Invalid Credentials, Please Check.");
			request.getRequestDispatcher("/WEB-INF/views/Message.jsp").forward(request, response);
		}
		else {
			sellerService.insert_seller(
					new Seller(
							request.getParameter("email"),
							request.getParameter("password"),
							request.getParameter("phone_number"),
							request.getParameter("name")
							)
					);
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

package Controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Daos.SellerDao;
import Daos.BuyerDao;
import Entities.Seller;
import Entities.User;

@WebServlet(urlPatterns="/profile")
public class Profile extends HttpServlet {
	
	SellerDao sellerService = new SellerDao();
	BuyerDao userService = new BuyerDao();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		Map<String,String> cookies_map = HelperClasses.UtilityResources.get_cookies_map(request);
		
		if(cookies_map.get("user_type").equals("user")) {
			User user_ = userService.get_user_via_ID(Integer.valueOf(cookies_map.get("ID")));
			System.out.print(user_);
			request.setAttribute("ID", String.valueOf(user_.getId()));
			request.setAttribute("name", user_.getName());
			request.setAttribute("email", user_.getEmail());
			request.setAttribute("phone_number", user_.getPhone_number());
		}
		
		else {
			Seller seller_ = sellerService.get_seller_via_ID(Integer.valueOf(cookies_map.get("ID")));
			System.out.print(seller_);
			request.setAttribute("ID", String.valueOf(seller_.getID()));
			request.setAttribute("name", seller_.getName());
			request.setAttribute("email", seller_.getEmail());
			request.setAttribute("phone_number", seller_.getPhone_number());
		}
		
		request.getRequestDispatcher("/WEB-INF/views/Profile.jsp").forward(request,response);
		
	}
	
}	

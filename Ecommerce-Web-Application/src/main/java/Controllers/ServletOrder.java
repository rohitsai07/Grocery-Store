package Controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Daos.OrderDao;
import Daos.ProductDao;
import Entities.Order;
import Entities.Product;

@WebServlet(urlPatterns="/orders")
public class ServletOrder extends HttpServlet{
ProductDao productService = new ProductDao();

	OrderDao orderService = new OrderDao();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		Map<String,String> cookies_map = HelperClasses.UtilityResources.get_cookies_map(request);
		
		List<Order> orders = null;
		if(cookies_map.get("user_type").equals("user")) {
			orders = orderService.get_orders("user_id", cookies_map.get("ID"));
			request.setAttribute("orders",orders);
			request.getRequestDispatcher("/WEB-INF/views/UserOrders.jsp").forward(request,response);
		}
		else {
			orders = orderService.get_orders("seller_id", cookies_map.get("ID"));
			request.setAttribute("orders",orders);
			request.getRequestDispatcher("/WEB-INF/views/SellerOrders.jsp").forward(request,response);
		}
	}
	
}

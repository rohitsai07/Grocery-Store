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

import Daos.ProductDao;
import Entities.Product;

@WebServlet(urlPatterns="/Products")
public class ServletProduct  extends HttpServlet{
	
	ProductDao productService = new ProductDao();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		Product product = new Product();
		Cookie cookies[] = request.getCookies();
		for(int i=0;i<cookies.length;i++) {
			if(cookies[i].getName().equals("email")) {
				product.setSeller_email(cookies[i].getValue());
			}
			else if(cookies[i].getName().equals("ID")) {
				product.setSeller_id(Integer.parseInt(cookies[i].getValue()));
			}
		}
		
		product.setName(request.getParameter("name"));
		product.setDescription(request.getParameter("description"));
		product.setPrice(Integer.parseInt(request.getParameter("price")));
		
		productService.insert_product(product);
		
		request.setAttribute("message","Product Added Succesfully");
		request.getRequestDispatcher("/WEB-INF/views/Message.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		Map<String,String> cookies_map = HelperClasses.UtilityResources.get_cookies_map(request);
		
		List<Product> products = null;
		if(cookies_map.get("user_type").equals("user")) {
			products = productService.get_products();
			request.setAttribute("products",products);
			request.getRequestDispatcher("/WEB-INF/views/ShopProducts.jsp").forward(request,response);
		}
		else {
			products = productService.get_products_by_seller_email(cookies_map.get("email"));
			System.out.print(products);
			request.setAttribute("products",products);
			request.getRequestDispatcher("/WEB-INF/views/SellerProducts.jsp").forward(request,response);
		}
	}
	
	
}

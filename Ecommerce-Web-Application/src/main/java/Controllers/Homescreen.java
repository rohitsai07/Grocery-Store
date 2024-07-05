package Controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Home")
public class Homescreen extends HttpServlet {
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		Map<String,String> cookies_map = HelperClasses.UtilityResources.get_cookies_map(request);
		System.out.print(cookies_map);
		if(!cookies_map.containsKey("user_type") || cookies_map.get("user_type").isBlank()) {
			request.getRequestDispatcher("/WEB-INF/views/Homepage.jsp").forward(request, response);
		}
		else if(cookies_map.get("user_type").equals("user")) {
			response.sendRedirect("http://localhost:8080/user/dashboard");
		}
		else {
			response.sendRedirect("http://localhost:8080/seller/dashboard");
		}
	}
}

package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entities.Order;
import HelperClasses.DatabaseDetails;

public class OrderDao {
	
	public int insert_order(Order order){
		String query = "INSERT INTO `order` (user_id, user_email, product_id, product_name, product_price, seller_id, seller_email, date) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = DatabaseDetails.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, order.getUser_id());
			ps.setString(2, order.getUser_email());
			ps.setInt(3, order.getProduct_id());
			ps.setString(4, order.getProduct_name());
			ps.setInt(5, order.getProduct_price());
			ps.setInt(6, order.getSeller_id());
			ps.setString(7, order.getSeller_email());
			ps.setString(8, order.getDate());
			
			int status = ps.executeUpdate();
			return status;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Order> get_orders(String field, String value){
		String query = "select * from `order` where "+field+"=?";
		Connection conn = DatabaseDetails.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(value));
			ResultSet rs = ps.executeQuery();
			List<Order> orders = new ArrayList<Order>();
			while(rs.next()) {
				Order order = new Order(
						rs.getInt("ID"),
						rs.getInt("product_id"),
						rs.getInt("seller_id"),
						rs.getInt("user_id"),
						rs.getInt("product_price"),
						rs.getString("user_email"),
						rs.getString("product_name"),
						rs.getString("seller_email"),
						rs.getString("date")
						);
				orders.add(order);
			}
			return orders;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}

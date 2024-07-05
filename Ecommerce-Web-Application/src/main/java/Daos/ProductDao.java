package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entities.Product;
import HelperClasses.DatabaseDetails;

public class ProductDao {
	

	public int insert_product(Product product){
		String query = "INSERT INTO product (name, price, description, seller_id, seller_email) VALUES(?, ?, ?, ?, ?)";
		Connection conn = DatabaseDetails.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, product.getName());
			ps.setInt(2, product.getPrice());
			ps.setString(3, product.getDescription());
			ps.setInt(4, product.getSeller_id());
			ps.setString(5, product.getSeller_email());
			int status = ps.executeUpdate();
			ps.close();
			conn.close();
			return status;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Product> get_products_by_seller_email(String email){
		String query = "select * from product where seller_email=?";
		Connection conn = DatabaseDetails.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			List<Product> products = new ArrayList<Product>();
			while(rs.next()) {
				Product product = new Product(rs.getInt("ID"),rs.getInt("price"),rs.getString("name"),
						rs.getString("description"),rs.getInt("seller_id"),rs.getString("seller_email"));
				products.add(product);	
			}
			rs.close();
			ps.close();
			conn.close();
			return products;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Product get_product_by_id(int ID){
		String query = "select * from product where ID=?";
		Connection conn = DatabaseDetails.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			Product product = null;
			while(rs.next()) {
				product = new Product(rs.getInt("ID"),rs.getInt("price"),rs.getString("name"),
						rs.getString("description"),rs.getInt("seller_id"),rs.getString("seller_email"));
			}
			rs.close();
			ps.close();
			conn.close();
			return product;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Product> get_products(){
		String query = "select * from product";
		Connection conn = DatabaseDetails.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			List<Product> products = new ArrayList<Product>();
			while(rs.next()) {
				Product product = new Product(rs.getInt("ID"),rs.getInt("price"),rs.getString("name"),
						rs.getString("description"),rs.getInt("seller_id"),rs.getString("seller_email"));
				products.add(product);
			}
			rs.close();
			ps.close();
			conn.close();
			return products;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Product> get_products_by_seller_id(int seller_id){
		String query = "select * from product where seller_id=?";
		Connection conn = DatabaseDetails.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, seller_id);
			ResultSet rs = ps.executeQuery();
			List<Product> products = new ArrayList<Product>();
			while(rs.next()) {
				Product product = new Product(rs.getInt("ID"),rs.getInt("price"),rs.getString("name"),
						rs.getString("description"),rs.getInt("seller_id"),rs.getString("seller_email"));
				products.add(product);	
			}
			rs.close();
			ps.close();
			conn.close();
			return products;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}

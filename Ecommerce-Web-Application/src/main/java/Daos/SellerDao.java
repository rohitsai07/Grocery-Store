package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entities.Seller;
import HelperClasses.DatabaseDetails;

public class SellerDao {
	
	public List<Seller> get_all_sellers(int ID) {
		String query = "select * from seller";
		Connection conn = DatabaseDetails.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			List<Seller> sellers = new ArrayList<Seller>();
			while(rs.next()) {
				Seller seller = new Seller(rs.getInt("ID"), rs.getString("email"), rs.getString("password"), rs.getString("phone_number")
						, rs.getString("name"));
				sellers.add(seller);
			}
			rs.close();
			ps.close();
			conn.close();
			return sellers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Seller get_seller_via_ID(int ID) {
		String query = "select * from seller where ID=? limit 1";
		Connection conn = DatabaseDetails.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			Seller seller = null;
			while(rs.next()) {
				seller = new Seller(rs.getInt("ID"), rs.getString("email"), rs.getString("password"), rs.getString("phone_number")
						, rs.getString("name"));
			}
			rs.close();
			ps.close();
			conn.close();
			return seller;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Seller get_seller_via_email(String email) {
		String query = "select * from seller where email=? limit 1";
		Connection conn = DatabaseDetails.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			Seller seller = null;
			while(rs.next()) {
				seller = new Seller(rs.getInt("ID"), rs.getString("email"), rs.getString("password"), rs.getString("phone_number")
						, rs.getString("name"));
			}
			rs.close();
			ps.close();
			conn.close();
			return seller;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public boolean authenticate(String email, String password) {
		Seller seller = get_seller_via_email(email);
		System.out.print(seller);
		return seller!=null && !password.isEmpty() && seller.getPassword().equals(password);
	}
	
	public int get_id_from_email(String email) {
		Seller seller = get_seller_via_email(email);
		return seller.getID();
	}
	
	public int insert_seller(Seller seller) {
		String query = "INSERT INTO seller (email, password, phone_number, name) VALUES(?, ?, ?, ?)";
		Connection conn = DatabaseDetails.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, seller.getEmail());
			ps.setString(2, seller.getPassword());
			ps.setString(3, seller.getPhone_number());
			ps.setString(4, seller.getName());
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
}

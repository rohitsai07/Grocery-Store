package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entities.Seller;
import Entities.User;
import HelperClasses.DatabaseDetails;

public class BuyerDao {
	
	public List<User> get_all_users(int ID) {
		String query = "select * from user";
		Connection conn = DatabaseDetails.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			List<User> users = new ArrayList<User>();
			while(rs.next()) {
				User user = new User(rs.getInt("ID"), rs.getString("email"), rs.getString("password"), rs.getString("phone_number")
						, rs.getString("name"));
				users.add(user);
			}
			rs.close();
			ps.close();
			conn.close();
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int get_id_from_email(String email) {
		User user = get_user_via_email(email);
		return user.getId();
	}
	
	public User get_user_via_ID(int ID) {
		String query = "select * from user where ID=?";
		Connection conn = DatabaseDetails.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			User user = null;
			while(rs.next()) {
				user = new User(rs.getInt("ID"), rs.getString("email"), rs.getString("password"), rs.getString("phone_number")
						, rs.getString("name"));
			}
			rs.close();
			ps.close();
			conn.close();
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public User get_user_via_email(String email) {
		String query = "select * from user where email=?";
		Connection conn = DatabaseDetails.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			User user = null;
			while(rs.next()) {
				user = new User(rs.getInt("ID"), rs.getString("email"), rs.getString("password"), rs.getString("phone_number")
						, rs.getString("name"));
			}
			rs.close();
			ps.close();
			conn.close();
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public int insert_user(User user) {
		String query = "INSERT INTO user (email, password, phone_number, name) VALUES(?, ?, ?, ?)";
		Connection conn = DatabaseDetails.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getPhone_number());
			ps.setString(4, user.getName());
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
	
	public boolean authenticate(String email, String password) {
		User user = get_user_via_email(email);
		System.out.print(user);
		return user!=null && !password.isEmpty() && user.getPassword().equals(password);
	}
	
}

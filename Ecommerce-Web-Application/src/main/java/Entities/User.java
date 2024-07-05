package Entities;

public class User {
	private int ID;
	private String email, password, phone_number, name;
	public int getId() {
		return ID;
	}
	public void setId(int id) {
		this.ID = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User(int id, String email, String password, String phone_number, String name) {
		super();
		this.ID = id;
		this.email = email;
		this.password = password;
		this.phone_number = phone_number;
		this.name = name;
	}
	public User() {
		super();
	}
	
	
	
	public User(String email, String password, String phone_number, String name) {
		super();
		this.email = email;
		this.password = password;
		this.phone_number = phone_number;
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + ID + ", email=" + email + ", password=" + password + ", phone_number=" + phone_number
				+ ", name=" + name + "]";
	}
	
	
}

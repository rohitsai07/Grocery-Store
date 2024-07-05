package Entities;

public class Seller {
	private int ID;
	private String name, email, phone_number, password;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Seller(int iD, String email,String password, String phone_number, String name) {
		super();
		ID = iD;
		this.name = name;
		this.email = email;
		this.phone_number = phone_number;
		this.password = password;
	}
	public Seller() {
		super();
	}
	
	
	
	public Seller(String email,String password, String phone_number, String name) {
		super();
		this.name = name;
		this.email = email;
		this.phone_number = phone_number;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Seller [ID=" + ID + ", name=" + name + ", email=" + email + ", phone_number=" + phone_number
				+ ", password=" + password + "]";
	}
	
	
}

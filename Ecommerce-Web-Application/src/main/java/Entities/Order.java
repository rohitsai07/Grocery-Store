package Entities;

public class Order {
	
	private int ID, product_id, seller_id, user_id, product_price;
	private String user_email, product_name, seller_email, date;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getSeller_email() {
		return seller_email;
	}
	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Order(int iD, int product_id, int seller_id, int user_id, int product_price, String user_email,
			String product_name, String seller_email, String date) {
		super();
		ID = iD;
		this.product_id = product_id;
		this.seller_id = seller_id;
		this.user_id = user_id;
		this.product_price = product_price;
		this.user_email = user_email;
		this.product_name = product_name;
		this.seller_email = seller_email;
		this.date = date;
	}
	public Order() {
		super();
	}
	
	
	
	public Order(int product_id, int seller_id, int user_id, int product_price, String user_email, String product_name,
			String seller_email, String date) {
		super();
		this.product_id = product_id;
		this.seller_id = seller_id;
		this.user_id = user_id;
		this.product_price = product_price;
		this.user_email = user_email;
		this.product_name = product_name;
		this.seller_email = seller_email;
		this.date = date;
	}
	@Override
	public String toString() {
		return "Order [ID=" + ID + ", product_id=" + product_id + ", seller_id=" + seller_id + ", user_id=" + user_id
				+ ", product_price=" + product_price + ", user_email=" + user_email + ", product_name=" + product_name
				+ ", seller_email=" + seller_email + ", date=" + date + "]";
	}
	
	

}

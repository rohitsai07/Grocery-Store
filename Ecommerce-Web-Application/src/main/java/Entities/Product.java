package Entities;

public class Product {
	private int ID, price,seller_id;
	private String name, description, seller_email;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public int getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	
	public String getSeller_email() {
		return seller_email;
	}
	public void setSeller_email(String seller_name) {
		this.seller_email = seller_name;
	}
	public Product() {
		super();
	}
	
	public Product(int price, int seller_id, String name, String description, String seller_name) {
		super();
		this.price = price;
		this.seller_id = seller_id;
		this.name = name;
		this.description = description;
		this.seller_email = seller_name;
	}
	public Product(int iD, int price, String name, String description, int seller_id, String seller_name) {
		super();
		ID = iD;
		this.price = price;
		this.seller_id = seller_id;
		this.name = name;
		this.description = description;
		this.seller_email = seller_name;
	}
	@Override
	public String toString() {
		return "Product [ID=" + ID + ", price=" + price + ", seller_id=" + seller_id + ", name=" + name
				+ ", description=" + description + ", seller_name=" + seller_email + "]";
	}
	
	
	
	
}

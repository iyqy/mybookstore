package cn.itcast.bookstore.domain;

public class OrderItem {
	
	private String id;
	private int quantity;
	private float price;
	
	private String ordersid;
	private String booksid;
	private Book book;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getOrdersid() {
		return ordersid;
	}
	public void setOrdersid(String ordersid) {
		this.ordersid = ordersid;
	}
	public String getBooksid() {
		return booksid;
	}
	public void setBooksid(String booksid) {
		this.booksid = booksid;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
}

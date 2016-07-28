package cn.itcast.bookstore.domain;

public class ShoppingcartItem {

	// 购物车条目
	private Book book; // 对应的商品
	private int quantity; 	// 数量
	private float price;  // 价格小计
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		// 改变商品的小计
		this.price = this.book.getPrice() * quantity;
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}

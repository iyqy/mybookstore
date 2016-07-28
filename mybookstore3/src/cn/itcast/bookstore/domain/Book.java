package cn.itcast.bookstore.domain;

public class Book {
	private String id;
	private String name;
	private String author;
	private String imagepath;	// 文件上传字段
	private String categorysid;
	private float price;
	private int pagenum;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public String getCategorysid() {
		return categorysid;
	}
	public void setCategorysid(String categorysid) {
		this.categorysid = categorysid;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	
}

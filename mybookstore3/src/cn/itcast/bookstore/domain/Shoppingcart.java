package cn.itcast.bookstore.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

//public class Shoppingcart {
//
//	private Map<String, ShoppingcartItem> map = new HashMap();// 购物车列表
//	private float price; // 购物车商品总价
//
//	public Map<String, ShoppingcartItem> getMap() {
//		return map;
//	}
//
//	public void setMap(Map<String, ShoppingcartItem> map) {
//		this.map = map;
//	}
//
//	public float getPrice() {
//		// 计算总价
//		int totalPrice = 0;
//		for (Entry e : map.entrySet()) {
//			ShoppingcartItem item = (ShoppingcartItem) e.getValue();
//			totalPrice += item.getPrice();
//		}
//		return totalPrice;
//	}
//
//	public void setPrice(float price) {
//		this.price = price;
//	}
//
//}

public class Shoppingcart {

	private Map<String, ShoppingcartItem> map = new HashMap();
	private float price;

	public Map<String, ShoppingcartItem> getMap() {
		return map;
	}

	public void setMap(Map<String, ShoppingcartItem> map) {
		this.map = map;
	}

	public float getPrice() {
		int totalprice = 0;
		for (Entry e : map.entrySet()) {
			ShoppingcartItem item = (ShoppingcartItem) e.getValue();
			totalprice += item.getPrice();
		}
		return totalprice;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}

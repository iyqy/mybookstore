package cn.itcast.bookstore.service;

import java.util.List;

import cn.itcast.bookstore.dao.CategoryDao;
import cn.itcast.bookstore.domain.Category;


public class CategoryService {

	private CategoryDao categoryDao = new CategoryDao();
	private String deleteMsg ;
	
	public Category findCategory(String id) {
		return categoryDao.find(id);
	}
	
	public List getAllCategorys() {
		return categoryDao.getAll();
	}
	
	public boolean addCategory(Category category) {
		return categoryDao.insert(category);
	}
	
	public boolean deleteCategory(String categoryid) {
		return categoryDao.delete(categoryid);
	}
	
	public boolean updateCategory(Category category) {
		return categoryDao.update(category);
	}

	public String getDeleteMsg() {
		return deleteMsg;
	}
	
	
}
 
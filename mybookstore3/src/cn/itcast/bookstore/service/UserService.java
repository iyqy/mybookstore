package cn.itcast.bookstore.service;

import cn.itcast.bookstore.dao.UserDao;
import cn.itcast.bookstore.domain.User;
import cn.itcast.bookstore.utils.Md5Utils;

public class UserService {

	private String loginError;	// 记录用户登陆的失败信息
	private String registerError;// 记录用户注册的失败信息
	
	// 用户登陆
	public User loginUser(String username, String password) {
		UserDao userDao = new UserDao();
		// 根据用户名找
		User user = userDao.find(username);
		if(user==null) {
			loginError = "用户名不存在";
			return null;
		}
		// 比较密码
		if(!user.getPassword().equals(Md5Utils.encript(password))) {
			loginError = "密码不正确";
			return null;
		}
		return user;
	}
	
	
	// 用户注册
	public boolean registerUser(User bean) {
		// 查找用户
		UserDao userDao = new UserDao();
		if(userDao.find(bean.getUsername())!=null) {
			registerError = "用户名已存在";
			return false;
		}
		// 用户名不存在
		// 将密码进行 md5
		bean.setPassword(Md5Utils.encript(bean.getPassword()));
		boolean b = userDao.insert(bean);
		if(!b)
			registerError = "注册失败";
		return b;
	}


	public String getLoginError() {
		return loginError;
	}


	public String getRegisterError() {
		return registerError;
	}

	
}

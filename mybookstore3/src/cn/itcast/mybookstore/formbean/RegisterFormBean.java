package cn.itcast.mybookstore.formbean;

import java.util.HashMap;
import java.util.Map;

public class RegisterFormBean {

	private String username;
	private String password;
	private String password2;
	private String email;
	private Map errors = new HashMap();
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public Map getErrors() {
		return errors;
	}
	public boolean validate() {
		boolean isOK = true;
		// 验证用户名不能为空
		if(username==null || username.trim()=="") {
			errors.put("username", "用户名不能为空");
			isOK = false;
		}
		// 用户名格式
		else if(!username.matches("[a-zA-Z]\\w{0,15}")) {
			errors.put("username", "用户名格式不正确");
			isOK = false;
		}
		// 密码不能为空
		if(password==null || password.trim()=="") {
			errors.put("password", "密码不能为空");
			isOK = false;
		}
		// 密码格式
		else if(!password.matches("[a-zA-Z0-9]{6,16}")) {
			errors.put("password", "密码格式不正确");
			isOK = false;
		}
		//　确认密码
		if(!password2.equals(password)) {
			errors.put("password2", "两次密码输入不一致");
			isOK = false;
		}
		// email  
		if(email==null || email.trim()=="") {
			errors.put("email", "电子邮件不能为空");
			isOK = false;
		}
		else if(!email.matches("\\w+@\\w+(\\.[a-zA-Z]{1,5})+")) {
			errors.put("email", "电子邮件格式不正确");
			isOK = false;
		}
		
		return isOK;
	}
}

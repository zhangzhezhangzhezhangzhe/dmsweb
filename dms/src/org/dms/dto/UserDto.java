package org.dms.dto;

import org.dms.model.User;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserDto {
	private int id;
	private String username;
	private String realname;
	private String password;
	private int sex;
	private String bore;
	
	private String phone;
	
	private String email;
	
	private String hyfh;
	
	private String zwh;
	
	private String introducer; 
	
	private String address;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@NotEmpty(message="用户名不能为空")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@NotEmpty(message="姓名不能为空")
	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}
	@NotEmpty(message="用户密码不能为空")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}
	@NotEmpty(message="生日不能为空")
	public String getBore() {
		return bore;
	}

	public void setBore(String bore) {
		this.bore = bore;
	}
	@NotEmpty(message="电话不能为空")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Email(message="邮件格式不正确")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@NotEmpty(message="行业分会不能为空")
	public String getHyfh() {
		return hyfh;
	}

	public void setHyfh(String hyfh) {
		this.hyfh = hyfh;
	}
	@NotEmpty(message="专委会不能为空")
	public String getZwh() {
		return zwh;
	}

	public void setZwh(String zwh) {
		this.zwh = zwh;
	}

	public String getIntroducer() {
		return introducer;
	}

	public void setIntroducer(String introducer) {
		this.introducer = introducer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserDto(int id, String username, String realname, String password, int sex, String bore, String phone,
			String email, String hyfh, String zwh, String introducer, String address) {
		super();
		this.id = id;
		this.username = username;
		this.realname = realname;
		this.password = password;
		this.sex = sex;
		this.bore = bore;
		this.phone = phone;
		this.email = email;
		this.hyfh = hyfh;
		this.zwh = zwh;
		this.introducer = introducer;
		this.address = address;
	}

	public UserDto() {
		
		
		
	}
	
	
	public User getUser(){
		User user=new User();
		user.setId(this.id);
		user.setUsername(username);
		user.setRealname(realname);
		user.setPassword(password);
		user.setSex(sex);
		user.setBore(bore);
		user.setPhone(phone);
		user.setIntroducer(introducer);
		user.setHyfh(hyfh);
		user.setZwh(zwh);
		user.setAddress(address);
		user.setEmail(email);
		return user;
	}
	
	
	
}

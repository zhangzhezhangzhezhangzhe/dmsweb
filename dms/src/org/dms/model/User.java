package org.dms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="t_user")
public class User {
	private int id;
	private String username;
	private String realname;
	private String password;
	private int status;
	
   private String address;
	
	private String phone;
	/**
	 * 介绍人
	 */
	private String introducer; 
	/**
	 * 行业分会
	 */
	private String hyfh;
	/**
	 * 专委会
	 */
	private String zwh;
	/**
	 * 单位
	 */
	private String danwei;
	/**
	 * 职称
	 */
	private String zhicheng;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 微信
	 */
	private String weixin;
	
	private String yjh;
	
	private String bore;
	
	private int sex;
	
	@Id
	@GeneratedValue
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
	
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	@NotEmpty(message="密码不能为空")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIntroducer() {
		return introducer;
	}
	public void setIntroducer(String introducer) {
		this.introducer = introducer;
	}
	public String getHyfh() {
		return hyfh;
	}
	public void setHyfh(String hyfh) {
		this.hyfh = hyfh;
	}
	public String getZwh() {
		return zwh;
	}
	public void setZwh(String zwh) {
		this.zwh = zwh;
	}
	public String getDanwei() {
		return danwei;
	}
	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}
	public String getZhicheng() {
		return zhicheng;
	}
	public void setZhicheng(String zhicheng) {
		this.zhicheng = zhicheng;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	
	
	public String getYjh() {
		return yjh;
	}
	public void setYjh(String yjh) {
		this.yjh = yjh;
	}
	public String getBore() {
		return bore;
	}
	public void setBore(String bore) {
		this.bore = bore;
	}
	
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	
}

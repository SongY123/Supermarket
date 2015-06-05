package entity;

import java.io.Serializable;


@SuppressWarnings("serial")
public class User implements Serializable{
	private int userid;//用户编号
	private String name;//用户名
	private String password;//密码
	private String authority;//权限
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

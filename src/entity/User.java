package entity;

import java.io.Serializable;


@SuppressWarnings("serial")
public class User implements Serializable{
	private int userid;//�û����
	private String name;//�û���
	private String password;//����
	private String authority;//Ȩ��
	
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

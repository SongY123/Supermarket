package entity;

import java.io.Serializable;



@SuppressWarnings("serial")
public class Goods implements Serializable{
	private int goodid;//��Ʒ���
	private String name;//��Ʒ����
	private double price;//����
	private String unit;//������λ
	private int stock;//�������

	public int getGoodid() {
		return goodid;
	}
	public void setGoodid(int goodid) {
		this.goodid = goodid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}

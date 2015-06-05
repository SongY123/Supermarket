package entity;

import java.io.Serializable;



@SuppressWarnings("serial")
public class Goods implements Serializable{
	private int goodid;//商品编号
	private String name;//商品名称
	private double price;//单价
	private String unit;//计量单位
	private int stock;//库存数量

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

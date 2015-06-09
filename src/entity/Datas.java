package entity;

import java.io.Serializable;
import java.util.HashMap;

/*
 * 数据包类 
 */
@SuppressWarnings("serial")
public class Datas implements Serializable{
	private String flags=null;//传递标志
	private Goods goods=null;//商品信息
	//private HashMap<Integer,Goods> map_goods=null;//商品列表
	private User user=null;//用户信息
	private Member member=null;//会员信息
	private Trade trade=null;
	
	double cost;//消费金额
	/*
	public HashMap<Integer, Goods> getMap_goods() {
		return map_goods;
	}
	public void setMap_goods(HashMap<Integer, Goods> map_goods) {
		this.map_goods = map_goods;
	}*/
	public String getFlags() {
		return flags;
	}
	public void setFlags(String flags) {
		this.flags = flags;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	public Trade getTrade() {
		return trade;
	}
	public void setTrade(Trade trade) {
		this.trade = trade;
	}
	
}
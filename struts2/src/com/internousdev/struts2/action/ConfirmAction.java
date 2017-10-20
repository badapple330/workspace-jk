/**
 *
 */
package com.internousdev.struts2.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.struts2.dao.ConfirmDAO;
import com.internousdev.struts2.dao.GoCartDAO;
import com.internousdev.struts2.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ConfirmAction extends ActionSupport implements SessionAware{
	//cartの中身を購入履歴に登録
	//cartの中身を削除。

	/**
	 *
	 */
	private static final long serialVersionUID = -9064408680652292822L;

	private String userID;

	private String itemID;

	private String itemName;

	private int price;

	private int quantity;

	private int subtotal;

	private int amountAll;

	private Map<String, Object> session;

	private ArrayList<ItemDTO> cartInfoList = new  ArrayList<ItemDTO>();

	public String execute(){
		String ret = SUCCESS;
		userID = (String) session.get("userID");
		GoCartDAO dao = new GoCartDAO();
		cartInfoList = dao.select(userID);
		for(int i=0;i<cartInfoList.size();i++){
			amountAll = amountAll + (cartInfoList.get(i).getSubtotal());
		}
		if(cartInfoList.size()>0){
			ConfirmDAO dao2 = new ConfirmDAO();
			if(dao2.insert(userID, cartInfoList)>0){
				if(dao2.delete(userID)>0){
					ret=SUCCESS;
				}
			}
		}
		return ret;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession(){
		return session;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}



}

/**
 *
 */
package com.internousdev.struts2.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.struts2.dao.CartUpdateDAO;
import com.internousdev.struts2.dao.GoCartDAO;
import com.internousdev.struts2.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartUpdateAction extends ActionSupport implements SessionAware{

	/**
	 *
	 */
	private static final long serialVersionUID = -7167589943951558513L;

	private String userID;

	private String itemID;

	private String itemName;

	private int price;

	private int stocks;

	private int[] quantity;

	private int subtotal;

	private int amountAll;

	private Map<String, Object> session;

	private ArrayList<ItemDTO> cartInfoList = new  ArrayList<ItemDTO>();

	private String[] itemIdAry;

	public String execute(){
		String ret = ERROR;
		userID = (String) session.get("userID");
		itemIdAry = itemID.split(",");
		for(int i=0;i<itemIdAry.length;i++){
			itemIdAry[i] = itemIdAry[i].trim();
		}
		CartUpdateDAO dao = new CartUpdateDAO();
		if(dao.update(userID, itemIdAry, quantity)>0){
			ret = SUCCESS;
		}
		GoCartDAO dao2 = new GoCartDAO();
		cartInfoList = dao2.select(userID);
		for(int i=0;i<cartInfoList.size();i++){
			amountAll = amountAll + (cartInfoList.get(i).getSubtotal());
		}
		return ret;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public int[] getQuantity() {
		return quantity;
	}

	public void setQuantity(int[] quantity) {
		this.quantity = quantity;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession(){
		return session;
	}

	public ArrayList<ItemDTO> getCartInfoList() {
		return cartInfoList;
	}

	public void setCartInfoList(ArrayList<ItemDTO> cartInfoList) {
		this.cartInfoList = cartInfoList;
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

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public int getStocks() {
		return stocks;
	}

	public void setStocks(int stocks) {
		this.stocks = stocks;
	}

	public int getAmountAll() {
		return amountAll;
	}

	public void setAmountAll(int amountAll) {
		this.amountAll = amountAll;
	}

}

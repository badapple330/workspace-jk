/**
 *
 */
package com.internousdev.struts2.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.struts2.dao.GoCartDAO;
import com.internousdev.struts2.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internousdev
 *
 */
public class GoCartFromHeaderAction extends ActionSupport implements SessionAware{

	private String userID;

	private String itemID;

	private String itemName;

	private int price;

	private int stocks;

	private int quantity;

	private int subtotal;

	private int amountAll=0;

	private ArrayList<ItemDTO> cartInfoList = new ArrayList<ItemDTO>();

	private ArrayList<ItemDTO> itemInfoList = new ArrayList<ItemDTO>();

	private ArrayList<String> itemIdList = new ArrayList<String>();

	private Map<String, Object> session;

	public String execute(){
		userID = (String) session.get("userID");
		GoCartDAO dao = new GoCartDAO();
		cartInfoList = dao.select(userID);
		for(int i=0;i<cartInfoList.size();i++){
			amountAll = amountAll + (cartInfoList.get(i).getSubtotal());
		}
		itemIdList = dao.getItemIdList();
		return SUCCESS;
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

	public int getStocks() {
		return stocks;
	}

	public void setStocks(int stocks) {
		this.stocks = stocks;
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

	public int getAmountAll() {
		return amountAll;
	}

	public void setAmountAll(int amountAll) {
		this.amountAll = amountAll;
	}

	public ArrayList<ItemDTO> getCartInfoList() {
		return cartInfoList;
	}

	public void setCartInfoList(ArrayList<ItemDTO> cartInfoList) {
		this.cartInfoList = cartInfoList;
	}

	public ArrayList<ItemDTO> getItemInfoList() {
		return itemInfoList;
	}

	public void setItemInfoList(ArrayList<ItemDTO> itemInfoList) {
		this.itemInfoList = itemInfoList;
	}

	public ArrayList<String> getItemIdList() {
		return itemIdList;
	}

	public void setItemIdList(ArrayList<String> itemIdList) {
		this.itemIdList = itemIdList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}

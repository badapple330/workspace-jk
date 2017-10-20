package com.internousdev.struts2.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.struts2.dao.CartDeleteDAO;
import com.internousdev.struts2.dao.GoCartDAO;
import com.internousdev.struts2.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartDeleteAction extends ActionSupport implements SessionAware{

	/**
	 *
	 */
	private static final long serialVersionUID = 7475383194574236818L;

	private String userID;

	private String itemID;

	private String itemName;

	private int price;

//	private int stocks;

	private int quantity;

	private int subtotal;

	private int amountAll;

//	private boolean check;

//	private String checkList;
	private ArrayList<Object> checkList = new ArrayList<Object>();

	private ArrayList<ItemDTO> cartInfoList = new ArrayList<ItemDTO>();

	private List<String> itemIdList = new ArrayList<String>();
	//cartInfoListの中にitemIdListを入れる必要がある
	//DTOに上記のリストを作っておく

	private Map<String, Object> session;

	public String execute(){
		String ret = ERROR;
		userID = (String) session.get("userID");
		GoCartDAO dao2 = new GoCartDAO();
		cartInfoList = dao2.select(userID);
//		System.out.println(check);
		System.out.println(checkList.get(0));
//		System.out.println(cartInfoList.get(0).getItemID());

		for(int i=0; i<checkList.size();i++){
//			if((int)checkList.get(i)==i){
//				String item_id = cartInfoList.get((int)checkList.get(i)).getItemID();
//				System.out.println("ITEMID="+item_id);
//				itemIdList.add(cartInfoList.get(Integer.parseInt(checkList.get(i).toString())).getItemID());
//			}
			itemIdList.add(checkList.get(i).toString());
		}
//		System.out.println(cartInfoList.get(0).getItemID());
		userID = (String) session.get("userID");
		CartDeleteDAO dao = new CartDeleteDAO();
//		ArrayList<String> itemIdList = new ArrayList<String>();
//		itemIdList = getItemIdList();
//		System.out.println(itemIdList.get(0));
		if(dao.delete(userID, itemIdList)>0){
			ret = SUCCESS;
		}
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

//	public int getStocks() {
//		return stocks;
//	}
//
//	public void setStocks(int stocks) {
//		this.stocks = stocks;
//	}

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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getAmountAll() {
		return amountAll;
	}

	public void setAmountAll(int amountAll) {
		this.amountAll = amountAll;
	}

	public List<String> getItemIdList() {
		return itemIdList;
	}

	public void setItemIdList(List<String> itemIdList) {
		this.itemIdList = itemIdList;
	}

//	public boolean getCheck() {
//		return check;
//	}
//
//	public void setCheck(boolean check) {
//		this.check = check;
//	}

	/**
	 * checkList取得メソッド
	 * @auther jk
	 * @return checkList
	 */
	public ArrayList<Object> getCheckList() {
		return checkList;
	}

	/**
	 *  checkList格納メソッド
	 * @auther jk
	 * @param checkList
	 */
	public void setCheckList(ArrayList<Object> checkList) {
		this.checkList = checkList;
	}

	/**
	 * cartInfoList取得メソッド
	 * @auther jk
	 * @return cartInfoList
	 */
	public ArrayList<ItemDTO> getCartInfoList() {
		return cartInfoList;
	}

	/**
	 *  cartInfoList格納メソッド
	 * @auther jk
	 * @param cartInfoList
	 */
	public void setcartInfoList(ArrayList<ItemDTO> cartInfoList) {
		this.cartInfoList = cartInfoList;
	}

}

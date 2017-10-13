/**
 *
 */
package com.internousdev.struts2.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.struts2.dao.GoItemDetailActionDAO;
import com.internousdev.struts2.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoItemDetailAction extends ActionSupport implements SessionAware{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String itemID;

	private String itemName;

	private int price;

	private int stocks;

	private Map<String, Object> session;

	private ArrayList<ItemDTO> itemInfoList = new ArrayList<ItemDTO>();


	public String execute(){
		String result = ERROR;
		GoItemDetailActionDAO dao = new GoItemDetailActionDAO();
		ItemDTO dto = new ItemDTO();
		dto = dao.select(itemID);
		if(dto.getItemName() != null){
			session.put("itemID", dto.getItemID());
			result = SUCCESS;
		}
		return result;
	}



	/**
	 * itemID取得メソッド
	 * @auther jk
	 * @return itemID
	 */
	public String getItemID() {
		return itemID;
	}

	/**
	 *  itemID格納メソッド
	 * @auther jk
	 * @param itemID
	 */
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	/**
	 * itemName取得メソッド
	 * @auther jk
	 * @return itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 *  itemName格納メソッド
	 * @auther jk
	 * @param itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * price取得メソッド
	 * @auther jk
	 * @return price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 *  price格納メソッド
	 * @auther jk
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * stocks取得メソッド
	 * @auther jk
	 * @return stocks
	 */
	public int getStocks() {
		return stocks;
	}

	/**
	 *  stocks格納メソッド
	 * @auther jk
	 * @param stocks
	 */
	public void setStocks(int stocks) {
		this.stocks = stocks;
	}



	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession(){
		return session;
	}



	/**
	 * itemInfoList取得メソッド
	 * @auther jk
	 * @return itemInfoList
	 */
	public ArrayList<ItemDTO> getItemInfoList() {
		return itemInfoList;
	}



	/**
	 *  itemInfoList格納メソッド
	 * @auther jk
	 * @param itemInfoList
	 */
	public void setItemInfoList(ArrayList<ItemDTO> itemInfoList) {
		this.itemInfoList = itemInfoList;
	}


}
/**
 *
 */
package com.internousdev.struts2.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.struts2.dao.GoCartDAO;
import com.internousdev.struts2.dao.GoItemDetailDAO;
import com.internousdev.struts2.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoCartAction extends ActionSupport implements SessionAware {

	/**
	 *
	 */
	private static final long serialVersionUID = -2206324311654435506L;

	//stocks = 0ならtopへ
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
		String ret = ERROR;
		GoCartDAO dao = new GoCartDAO();
		userID = (String) session.get("userID");
		itemID = (String) session.get("itemID");
		//cart内部同じ商品gな存在するときの処理
		ItemDTO dto = new ItemDTO();
		dto = dao.check(userID, itemID);
		if(dto.getQuantity()>0){
			System.out.println("ccc");
			if(dao.update(userID, itemID, dto.getQuantity()+1)>0){
				System.out.println("dddd");
				ret = SUCCESS;
				cartInfoList = dao.select(userID);
				for(int i=0;i<cartInfoList.size();i++){
					amountAll = amountAll + (cartInfoList.get(i).getSubtotal());
				}
				itemIdList = dao.getItemIdList();
			}
			return ret;
		}else{
//		在庫切れ判定。といっても実際には使ってない。
			if(stocks == 0){
				System.out.println("この商品は在庫切れ");
				GoItemDetailDAO dao2 = new GoItemDetailDAO();
				setItemInfoList(dao2.select(userID));
				return ret;
			}else{
				if(dao.insert(userID, itemID, itemName, price, 1)>0){
					cartInfoList = dao.select(userID);
					for(int i=0;i<cartInfoList.size();i++){
						amountAll = amountAll + (cartInfoList.get(i).getSubtotal());
					}
					itemIdList = dao.getItemIdList();
					ret = SUCCESS;
				}
			}
		}
		return ret;
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
	 * userID取得メソッド
	 * @auther jk
	 * @return userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 *  userID格納メソッド
	 * @auther jk
	 * @param userID
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * セッション情報を取得するメソッド
	 * @return session セッション情報
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * セッション情報を格納するメソッド
	 * @param session
	 *            セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
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
	public void setCartInfoList(ArrayList<ItemDTO> cartInfoList) {
		this.cartInfoList = cartInfoList;
	}

	/**
	 * quantity取得メソッド
	 * @auther jk
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 *  quantity格納メソッド
	 * @auther jk
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * subtotal取得メソッド
	 * @auther jk
	 * @return subtotal
	 */
	public int getSubtotal() {
		return subtotal;
	}

	/**
	 *  subtotal格納メソッド
	 * @auther jk
	 * @param subtotal
	 */
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public int getAmountAll() {
		return amountAll;
	}

	public void setAmountAll(int amountAll) {
		this.amountAll = amountAll;
	}

	public ArrayList<String> getItemIdList() {
		return itemIdList;
	}

	public void setItemIdList(ArrayList<String> itemIdList) {
		this.itemIdList = itemIdList;
	}

	public ArrayList<ItemDTO> getItemInfoList() {
		return itemInfoList;
	}

	public void setItemInfoList(ArrayList<ItemDTO> itemInfoList) {
		this.itemInfoList = itemInfoList;
	}

}

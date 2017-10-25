/**
 *
 */
package com.internousdev.struts2.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.struts2.dao.MypageDAO;
import com.internousdev.struts2.dao.PaymentDAO;
import com.internousdev.struts2.dao.UpdateCreditcardDAO;
import com.internousdev.struts2.dto.ItemDTO;
import com.internousdev.struts2.dto.PaymentDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internousdev
 *
 */
public class UpdateCreditcardAction extends ActionSupport implements SessionAware{

	/**
	 *
	 */
	private static final long serialVersionUID = 5679775953195747945L;

	private String password;

	private  ArrayList<ItemDTO> itemList = new  ArrayList<ItemDTO>();

	private String itemID;

	private String itemName;

	private String price;

	private String quantity;

	private String subtotal;

	//payment
	private String userID;

	private String cardCategory;

	private String cardHolder;

	private String cardNumber;

	private String month;

	private String year;

	private String security;

	private ArrayList<ItemDTO> cartInfoList = new ArrayList<ItemDTO>();

    private Map<String, Object> session;

    public String execute(){
    	String ret = ERROR;
    	UpdateCreditcardDAO dao = new UpdateCreditcardDAO();
		PaymentDAO dao2 = new PaymentDAO();
		PaymentDTO dto2 = new PaymentDTO();
		MypageDAO dao3 = new MypageDAO();
		itemList = dao3.selecthistory(userID);
    /**
     * 最初は多分selectで検索。存在するなら
     * updateを実行。そもそもクレジットカードが存在しないなら更新できないから
     * 登録リンク貼っとけばいいよ。
     */
    	userID = (String) session.get("userID");
    	PaymentDTO dto = new PaymentDTO();
    	if((dao.update(cardCategory,cardHolder,cardNumber,month,year,security,userID))>0){
    		ret = SUCCESS;
			if((dto2 = dao2.getinfo(userID))!=null){
				cardCategory = dto2.getCardCategory();
				cardHolder = dto2.getCardHolder();
				cardNumber = dto2.getCardNumber();
				month = dto2.getMonth();
				year = dto2.getYear();
				security = dto2.getSecurity();
			}
    	}
    	return ret;
    }

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getCardCategory() {
		return cardCategory;
	}

	public void setCardCategory(String cardCategory) {
		this.cardCategory = cardCategory;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public ArrayList<ItemDTO> getCartInfoList() {
		return cartInfoList;
	}

	public void setCartInfoList(ArrayList<ItemDTO> cartInfoList) {
		this.cartInfoList = cartInfoList;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<ItemDTO> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<ItemDTO> itemList) {
		this.itemList = itemList;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

}

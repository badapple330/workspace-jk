
package com.internousdev.struts2.dto;


public class ItemDTO {

	private String itemID;

	private String itemName;

	private int price;

	private int stocks;

	private int quantity;

	private int imgPath;

	private int subtotal;

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

	/**
	 * imgPath取得メソッド
	 * @auther jk
	 * @return imgPath
	 */
	public int getImgPath() {
		return imgPath;
	}

	/**
	 *  imgPath格納メソッド
	 * @auther jk
	 * @param imgPath
	 */
	public void setImgPath(int imgPath) {
		this.imgPath = imgPath;
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

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}


}

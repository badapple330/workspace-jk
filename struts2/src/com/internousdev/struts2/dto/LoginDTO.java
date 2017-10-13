/**
 *
 */
package com.internousdev.struts2.dto;


public class LoginDTO {

	private int id;
	private String name;
	private String password;
	/**
	 * id取得メソッド
	 * @auther  
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 *  id格納メソッド
	 * @auther  
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * name取得メソッド
	 * @auther  
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 *  name格納メソッド
	 * @auther  
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * password取得メソッド
	 * @auther  
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 *  password格納メソッド
	 * @auther  
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}

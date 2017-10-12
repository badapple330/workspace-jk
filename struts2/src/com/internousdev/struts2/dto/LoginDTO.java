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
	 * @auther Toshifumi Yamashita
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 *  id格納メソッド
	 * @auther Toshifumi Yamashita
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * name取得メソッド
	 * @auther Toshifumi Yamashita
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 *  name格納メソッド
	 * @auther Toshifumi Yamashita
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * password取得メソッド
	 * @auther Toshifumi Yamashita
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 *  password格納メソッド
	 * @auther Toshifumi Yamashita
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}

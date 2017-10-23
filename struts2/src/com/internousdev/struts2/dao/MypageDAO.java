/**
 *
 */
package com.internousdev.struts2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.struts2.dto.ItemDTO;
import com.internousdev.struts2.dto.LoginDTO;
import com.internousdev.struts2.util.DBConnector;

public class MypageDAO {

	public LoginDTO select(String userID){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		LoginDTO dto = new LoginDTO();
		String sql = "select * from user where userID = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				dto.setUserID(rs.getString("user_id"));
				dto.setPassword(rs.getString("password"));
				dto.setId(rs.getInt("id"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return dto;
	}
//購入履歴取得
	public ArrayList<ItemDTO> selecthistory(String userID){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<ItemDTO> itemInfoList = new ArrayList<ItemDTO>();
		String sql = "select * from history where user_id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				ItemDTO dto = new ItemDTO();
				dto.setItemID(rs.getString("item_id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setPrice(rs.getInt("price"));
				dto.setQuantity(rs.getInt("quantity"));
				dto.setSubtotal(rs.getInt(dto.getPrice()*dto.getQuantity()));
				itemInfoList.add(dto);
			}
		}catch(SQLException e){
        	e.printStackTrace();
        	}finally{
        		try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
        	}
		return itemInfoList;
	}

	//個人情報の変更
	//あ、これここ変更したらhisotyのuserIDも変えなきゃだめだわ。ついでにいうとカートとかも。
	public LoginDTO update(String oldID, String userID, String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		LoginDTO dto = new LoginDTO();
//sessionで元のuserID取得するのがいいか。
		String sql = "update user set user_id=? and password=? where user_id=?";
		String sql2 = "update cart set user_id = ? where user_id=?";
		String sql3 = "update creditcard user_id = ? where user_id=?";
		String sql4 = "update history user_id = ? where user_id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userID);
			ps.setString(2, password);
			ps.setString(3, oldID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				dto.setUserID(rs.getString("user_id"));
				dto.setPassword(rs.getString("password"));
			}
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setString(1, userID);
			ps2.setString(2, oldID);
			PreparedStatement ps3 = con.prepareStatement(sql3);
			ps3.setString(1, userID);
			ps3.setString(2, oldID);
			PreparedStatement ps4 = con.prepareStatement(sql4);
			ps4.setString(1, userID);
			ps4.setString(2, oldID);
		}catch(SQLException e){
        	e.printStackTrace();
        	}finally{
        		try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
        	}
		return dto;
	}

}
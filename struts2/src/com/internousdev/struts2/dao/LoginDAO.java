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

public class LoginDAO {

	public LoginDTO select(String name, String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		LoginDTO dto = new LoginDTO();

		String sql = "select * from user where user_name=? and password=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1,  name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				dto.setName(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));
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

	public ArrayList<ItemDTO> getitemID(){
		ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from items";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				ItemDTO dto = new ItemDTO();
				dto.setItemID(rs.getString("itemID"));
				itemList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
			con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return itemList;
	}

}

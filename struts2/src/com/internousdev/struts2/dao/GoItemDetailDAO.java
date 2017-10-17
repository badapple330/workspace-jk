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
import com.internousdev.struts2.util.DBConnector;

public class GoItemDetailDAO {

	public ArrayList<ItemDTO> select(String itemID){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<ItemDTO> itemInfoList = new ArrayList<ItemDTO>();
//		ItemDTO dto = new ItemDTO();

		String sql = "select * from items where item_id = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, itemID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				ItemDTO dto = new ItemDTO();
				dto.setItemID(rs.getString("item_id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setPrice(rs.getInt("price"));
				dto.setStocks(rs.getInt("stocks"));
				itemInfoList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return itemInfoList;
	}

}

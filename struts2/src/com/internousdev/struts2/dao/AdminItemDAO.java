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

/**
 * @author internousdev
 *
 */
public class AdminItemDAO {

	//全件表示
	public ArrayList<ItemDTO> select(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<ItemDTO> itemAllList = new ArrayList<ItemDTO>();
		String sql = "select * from items";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				ItemDTO dto = new ItemDTO();
				dto.setItemID(rs.getString("item_id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setPrice(rs.getInt("price"));
				dto.setDeleteflg(rs.getInt("deleteflg"));
				itemAllList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return itemAllList;
	}

	//

}

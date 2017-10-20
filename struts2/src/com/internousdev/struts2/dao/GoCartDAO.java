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

public class GoCartDAO {

	public int insert(String userID, String itemID, String itemName, int price, int quantity){
		int ret = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
//		ItemDTO dto = new ItemDTO();
		String sql = "insert into cart(user_id, item_id, item_name, price, quantity) "
				+ "values(?,?,?,?,?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userID);
			ps.setString(2, itemID);
			ps.setString(3, itemName);
			ps.setInt(4, price);
			ps.setInt(5, quantity);
			ret = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ret;
	}


//表示用のリストをcartから取得
	public ArrayList<ItemDTO> select(String userID){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<ItemDTO> cartInfoList = new ArrayList<ItemDTO>();


		String sql="select * from cart where user_id=?";
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
				dto.setSubtotal(dto.getPrice() * dto.getQuantity());
				cartInfoList.add(dto);
				itemIdList.add(rs.getString("item_id"));
			}
			//itemIdのリストをセット。選択削除のときにリストで返ってくるから
			setItemIdList(itemIdList);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
			con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return cartInfoList;
	}

	//選択削除用
	ArrayList<String> itemIdList = new ArrayList<String>();
	//itemIdList get.set
	public ArrayList<String> getItemIdList(){
		return itemIdList;
	}
	public void  setItemIdList(ArrayList<String> itemIdList){
		this.itemIdList = itemIdList;
	}


}

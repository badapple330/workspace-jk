/**
 *
 */
package com.internousdev.struts2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.struts2.dto.ItemDTO;
import com.internousdev.struts2.util.DBConnector;

/**
 * @author internousdev
 *
 */
public class ConfirmDAO {

	//履歴に追加
	//めんどくさいからcartInfoListそのまま履歴に放り込む
	public int insert(String userID, ArrayList<ItemDTO> cartInfoList){
		int ret = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "insert into history(user_id, item_id, item_name, price, quantity) "
				+ "values(?,?,?,?,?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			for(int i=0;i<cartInfoList.size();i++){
				ps.setString(1, userID);
				ps.setString(2, cartInfoList.get(i).getItemID());
				ps.setString(3, cartInfoList.get(i).getItemName());
				ps.setInt(4, cartInfoList.get(i).getPrice());
				ps.setInt(5, cartInfoList.get(i).getQuantity());
				ret = ps.executeUpdate();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ret;
	}

	//全削除
	public int delete(String userID){
		int ret = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "delete from cart where user_id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userID);
			ret = ps.executeUpdate();
		}catch (SQLException e) {
				e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return ret;
	}

}

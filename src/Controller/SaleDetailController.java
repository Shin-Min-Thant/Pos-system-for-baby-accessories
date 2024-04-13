package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Connection.ClsDBConnection;
import Model.ItemModel;
import Model.PurchaseDetailModel;
import Model.SaleDetailModel;

public class SaleDetailController {
	public static Connection con = null;
	static {
		ClsDBConnection cls = new ClsDBConnection();
		try {
			con = cls.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Insert Fail,Inter error","Fail", JOptionPane.ERROR_MESSAGE);
		}
	
	}
	
	public int insert(SaleDetailModel dain) {
		int result =0;
		String sql = "insert into pos_baby.sale_detail (sale_id,item_id,sale_price,sale_qty) values(?,?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, dain.getSale_id());
			ps.setString(2, dain.getItem_id());
			ps.setInt(3, dain.getSale_price());
			ps.setInt(4, dain.getSale_qty());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	public List<SaleDetailModel> showAll() throws SQLException{
		List<SaleDetailModel> list = new ArrayList<SaleDetailModel>();
		String sql = "select * from pos_baby.sale_detail order by sale_id desc";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
        	SaleDetailModel sm = new SaleDetailModel();
        	sm.setSale_id(rs.getString("sale_id"));
        	sm.setItem_id(rs.getString("item_id"));
        	sm.setSale_price(rs.getInt("sale_price"));
        	sm.setSale_qty(rs.getInt("sale_qty"));
        	
        	ItemModel im = new ItemModel();
        	ItemController ic = new ItemController();
        	im.setItem_id(sm.getItem_id());
        	sm.setItem_name(ic.searchItemName(im));
        	list.add(sm);
        }
		return list;
	}
	
	public List<SaleDetailModel> showOne(SaleDetailModel dain) throws SQLException{
		List<SaleDetailModel> list = new ArrayList<SaleDetailModel>();
		String sql = "select * from pos_baby.sale_detail where item_id in(select item_id from item where item_name like ?) order by sale_id desc";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, dain.getItem_name()+"%");
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
        	SaleDetailModel sm = new SaleDetailModel();
        	sm.setSale_id(rs.getString("sale_id"));
        	sm.setItem_id(rs.getString("item_id"));
        	sm.setSale_price(rs.getInt("sale_price"));
        	sm.setSale_qty(rs.getInt("sale_qty"));
        	
        	ItemModel im = new ItemModel();
        	ItemController ic = new ItemController();
        	im.setItem_id(sm.getItem_id());
        	sm.setItem_name(ic.searchItemName(im));
        	list.add(sm);
        }
		return list;
	}

}

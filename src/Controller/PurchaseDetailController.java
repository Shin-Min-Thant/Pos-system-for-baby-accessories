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
import Model.PurchaseModel;


public class PurchaseDetailController {
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

	public int insert(PurchaseDetailModel dain) {
		int result =0;
		String sql = "insert into pos_baby.purchase_detail (purchase_id,item_id,purchase_price,purchase_qty) values(?,?,?,?)";

		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, dain.getPurchase_id());
			ps.setString(2, dain.getItem_id());
			ps.setInt(3, dain.getPurchase_price());
			ps.setInt(4, dain.getPurchase_qty());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	public String getTotalPrice() throws SQLException {
		String totalPrice = null;
		String sql = "SELECT total_price FROM pos_baby.purchase_detail";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			totalPrice = rs.getString("total_price");
		}
		System.out.println(totalPrice);
		return totalPrice;
	}
	
	public List<PurchaseDetailModel> showAll() throws SQLException{
		List<PurchaseDetailModel> list = new ArrayList<PurchaseDetailModel>();
		String sql = "select * from pos_baby.purchase_detail order by purchase_id desc";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
        	PurchaseDetailController pdc = new PurchaseDetailController();
        	PurchaseDetailModel pdm = new PurchaseDetailModel();
        	pdm.setPurchase_id(rs.getString("purchase_id"));
        	pdm.setItem_id(rs.getString("item_id"));
        	pdm.setPurchase_price(rs.getInt("purchase_price"));
        	pdm.setPurchase_qty(rs.getInt("purchase_qty"));
        	
        	ItemModel im = new ItemModel();
        	ItemController ic = new ItemController();
        	im.setItem_id(pdm.getItem_id());
        	pdm.setItem_name(ic.searchItemName(im));
        	list.add(pdm);
        }
		return list;
	}
	
	public List<PurchaseDetailModel> showOne(PurchaseDetailModel dain) throws SQLException{
		List<PurchaseDetailModel> list = new ArrayList<PurchaseDetailModel>();
		String sql = "select * from pos_baby.purchase_detail where item_id in(select item_id from item where item_name like ?) order by purchase_id desc";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, dain.getItem_name()+"%");
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
        	PurchaseDetailController pdc = new PurchaseDetailController();
        	PurchaseDetailModel pdm = new PurchaseDetailModel();
        	pdm.setPurchase_id(rs.getString("purchase_id"));
        	pdm.setItem_id(rs.getString("item_id"));
        	pdm.setPurchase_price(rs.getInt("purchase_price"));
        	pdm.setPurchase_qty(rs.getInt("purchase_qty"));
        	
        	ItemModel im = new ItemModel();
        	ItemController ic = new ItemController();
        	im.setItem_id(pdm.getItem_id());
        	pdm.setItem_name(ic.searchItemName(im));
        	list.add(pdm);
        }
		return list;
	}
	
	

}

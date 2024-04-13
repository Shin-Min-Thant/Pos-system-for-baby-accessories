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
import Model.OrderDetailModel;
import Model.OrderModel;


public class OrderDetailController {
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
	
	public int insert(OrderDetailModel dain) {
		int result =0;
		String sql = "INSERT INTO pos_baby.order_detail (order_id, item_id, order_price, order_qty, `unique`) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, dain.getOrder_id());
			ps.setString(2, dain.getItem_id());
			ps.setInt(3, dain.getOrder_price());
			ps.setInt(4, dain.getOrder_qty());
			ps.setString(5, dain.getUnique());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	public List<OrderDetailModel> showAll() throws SQLException{
		List<OrderDetailModel> list = new ArrayList<OrderDetailModel>();
		String sql = "SELECT * FROM pos_baby.order_detail ORDER BY order_id DESC";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
        	OrderDetailController odc = new OrderDetailController();
        	OrderDetailModel odm = new OrderDetailModel();
        	odm.setOrder_id(rs.getString("order_id"));
        	odm.setItem_id(rs.getString("item_id"));
        	odm.setOrder_price(rs.getInt("order_price"));
        	odm.setOrder_qty(rs.getInt("order_qty"));
        	odm.setUnique(rs.getString("unique"));
        	ItemModel im = new ItemModel();
        	ItemController ic = new ItemController();
        	im.setItem_id(odm.getItem_id());
        	odm.setItem_name(ic.searchItemName(im));
        	list.add(odm);
        }
		return list;
	}
	
	public List<OrderDetailModel> searhOrderDetail(OrderDetailModel dain) throws SQLException{
		List<OrderDetailModel> list = new ArrayList<OrderDetailModel>();
		String sql = "SELECT * FROM pos_baby.order_detail WHERE `unique` = ? ORDER BY order_id DESC";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, dain.getUnique());
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
        	OrderDetailController odc = new OrderDetailController();
        	OrderDetailModel odm = new OrderDetailModel();
        	odm.setOrder_id(rs.getString("order_id"));
        	odm.setItem_id(rs.getString("item_id"));
        	odm.setOrder_price(rs.getInt("order_price"));
        	odm.setOrder_qty(rs.getInt("order_qty"));
        	odm.setUnique(rs.getString("unique"));
        	ItemModel im = new ItemModel();
        	ItemController ic = new ItemController();
        	im.setItem_id(odm.getItem_id());
        	odm.setItem_name(ic.searchItemName(im));
        	list.add(odm);
        }
		return list;
	}
	
	public List<OrderDetailModel> showOne(OrderDetailModel dain) throws SQLException{
		List<OrderDetailModel> list = new ArrayList<OrderDetailModel>();
		String sql = "select * from pos_baby.order_detail where item_id in(select item_id from item where item_name like ?) order by order_id desc";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, dain.getItem_name()+"%");
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
        	OrderDetailController odc = new OrderDetailController();
        	OrderDetailModel odm = new OrderDetailModel();
        	odm.setOrder_id(rs.getString("order_id"));
        	odm.setItem_id(rs.getString("item_id"));
        	odm.setOrder_price(rs.getInt("order_price"));
        	odm.setOrder_qty(rs.getInt("order_qty"));
        	odm.setUnique(rs.getString("unique"));
        	ItemModel im = new ItemModel();
        	ItemController ic = new ItemController();
        	im.setItem_id(odm.getItem_id());
        	odm.setItem_name(ic.searchItemName(im));
        	list.add(odm);
        }
		return list;
	}
	
	public String searchItemIDbyOrderID(OrderDetailModel dain) {
		String result = null;
		String sql = "select item_id from pos_baby.order_detail where order_id =? order by order_id desc";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement)con.prepareStatement(sql);
			ps.setString(1, dain.getOrder_id());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getString("item_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
				
	}
	
	
	

}

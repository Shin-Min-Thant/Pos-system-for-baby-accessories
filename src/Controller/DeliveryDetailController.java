package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Connection.ClsDBConnection;
import Model.OrderModel;
import Model.DeliveryDetailModel;
import Model.DeliveryModel;
import Model.ItemModel;
import Model.OrderDetailModel;


public class DeliveryDetailController {
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
	
	public int insert(DeliveryDetailModel dain) {
		int result =0;
		String sql = "insert into pos_baby.delivery_detail (delivery_id,order_id,delivery_price,delivery_qty,delive_fees) values(?,?,?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, dain.getDelivery_id());
			System.out.println(dain.getDelivery_id());
			ps.setString(2, dain.getOrder_id());
			ps.setInt(3, dain.getDelivery_price());
			ps.setInt(4, dain.getDelivery_qty());
			ps.setString(5, dain.getDelive_fees());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	public List<DeliveryDetailModel> showAll() throws SQLException{
		List<DeliveryDetailModel> list = new ArrayList<DeliveryDetailModel>();
		String sql = "select * from pos_baby.delivery_detail order by delivery_id desc";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
//        	DeliveryDetailController ddc = new DeliveryDetailController();
        	DeliveryDetailModel ddm = new DeliveryDetailModel();
        	ddm.setDelivery_id(rs.getString("delivery_id"));
        	ddm.setOrder_id(rs.getString("order_id"));
        	ddm.setDelivery_price(rs.getInt("delivery_price"));
        	ddm.setDelivery_qty(rs.getInt("delivery_qty"));
        	ddm.setDelive_fees(rs.getString("delive_fees"));
        	
        	OrderDetailController odc = new OrderDetailController();
        	OrderDetailModel odm = new OrderDetailModel();
        	odm.setOrder_id(ddm.getOrder_id());
        	odm.setItem_id(odc.searchItemIDbyOrderID(odm));
        	ItemController ic = new ItemController();
        	ItemModel im = new ItemModel();
        	im.setItem_id(odm.getItem_id());
        	ddm.setItem_name(ic.searchItemName(im));
        	list.add(ddm);
        }
		return list;
	}
	
	public List<DeliveryDetailModel> showOne(DeliveryDetailModel dain) throws SQLException{
		List<DeliveryDetailModel> list = new ArrayList<DeliveryDetailModel>();
		String sql = "select * from pos_baby.delivery_detail where order_id in(select order_id from order_detail where item_id in"
				+ "(select item_id from item where item_name like ?)) "
				+ "order by delivery_id desc";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, dain.getItem_name()+"%");
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
        	DeliveryDetailController ddc = new DeliveryDetailController();
        	DeliveryDetailModel ddm = new DeliveryDetailModel();
        	ddm.setDelivery_id(rs.getString("delivery_id"));
        	ddm.setOrder_id(rs.getString("order_id"));
        	ddm.setDelivery_price(rs.getInt("delivery_price"));
        	ddm.setDelivery_qty(rs.getInt("delivery_qty"));
        	ddm.setDelive_fees(rs.getString("delive_fees"));
        	
        	OrderDetailController odc = new OrderDetailController();
        	OrderDetailModel odm = new OrderDetailModel();
        	odm.setOrder_id(ddm.getOrder_id());
        	odm.setItem_id(odc.searchItemIDbyOrderID(odm));
        	ItemController ic = new ItemController();
        	ItemModel im = new ItemModel();
        	im.setItem_id(odm.getItem_id());
        	ddm.setItem_name(ic.searchItemName(im));
        	list.add(ddm);
        }
		return list;
	}
	
	

}

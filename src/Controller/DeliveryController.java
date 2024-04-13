package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Connection.ClsDBConnection;
import Model.BrandModel;
import Model.ItemModel;
import Model.DeliveryModel;
import Model.TypeModel;
public class DeliveryController {
	public static Connection con = null;
	static {
		ClsDBConnection cls = new ClsDBConnection();
		try {
			con = (Connection) cls.getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int insert(DeliveryModel dain) {
		int result =0;
		String sql = "insert into pos_baby.delivery (delivery_id,deliver_id,delivery_date) values(?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, dain.getDelivery_id());
			ps.setString(2, dain.getDeliver_id());
			ps.setString(3, dain.getDelivery_date());
			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Fail insert,Inter Error","Fail",JOptionPane.ERROR_MESSAGE);
		}
		return result;
	}
	public int update(DeliveryModel dain) {
		int result =0;
		String sql = "update pos_baby.delivery set deliver_id=?,delivery_date=? where delivery_id=?;";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, dain.getDelivery_id());
			ps.setString(2, dain.getDeliver_id());
			ps.setString(3, dain.getDelivery_date());
			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Fail update,Inter Error","Fail",JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	public int delete(DeliveryModel dain) {
		int result =0;
		String sql = "delete from pos_baby.delivery where delivery_id=?";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, dain.getDelivery_id());
			
			result =  ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Fail delete,Inter Error","Fail",JOptionPane.ERROR_MESSAGE);
		}
		return result;
	}
	
	public List<DeliveryModel> selectall()throws SQLException{
		List<DeliveryModel> list = new ArrayList<DeliveryModel>();
		String sql = "select * from pos_baby.delivery order by delivery_id desc";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			DeliveryModel dm = new DeliveryModel();
			dm.setDelivery_id(rs.getString("delivery_id"));
		    dm.setDeliver_id(rs.getString("deliver_id"));
		    dm.setDelivery_date(rs.getString("delivery_date"));

		    list.add(dm);
		}
		return list;
	}
	
	public List<DeliveryModel> selectone(DeliveryModel dain) throws SQLException{
		List<DeliveryModel> list = new ArrayList<DeliveryModel>();
		String sql = "select * from pos_baby.delivery where name like ? order by delivery_id desc";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, dain.getDelivery_date()+"%");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			DeliveryModel dm = new DeliveryModel();
			dm.setDelivery_id(rs.getString("delivery_id"));
		    dm.setDeliver_id(rs.getString("deliver_id"));
		    dm.setDelivery_date(rs.getString("delivery_date"));

		    list.add(dm);
		}
		return list;
	}
	
	public List<DeliveryModel> searchItemDeatail(DeliveryModel dain){
		List<DeliveryModel> list = new ArrayList<DeliveryModel>();
		String sql = "select * from pos_baby.delivery where Delivery_date=? order by delivery_id desc";
		try {
			PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
			ps.setString(1, dain.getDelivery_date());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				DeliveryModel dm = new DeliveryModel();
				dm.setDelivery_id(rs.getString("delivery_id"));
			    dm.setDeliver_id(rs.getString("deliver_id"));
			    dm.setDelivery_date(rs.getString("delivery_date"));

			    list.add(dm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean isduplicate(DeliveryModel dain) throws SQLException{
		boolean duplicate = false;
		String sql = "select * from pos_baby.delivery where delivery_date=?";
		PreparedStatement ps =(PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, dain.getDelivery_date());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			duplicate = true;
		}else {
			duplicate = false;
		}
		return duplicate;
	}

}

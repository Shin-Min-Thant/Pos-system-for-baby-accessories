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
import Model.CustomerModel;
import Model.ItemModel;
import Model.OrderModel;
import Model.TypeModel;
public class OrderController {
	public static Connection con = null;
	static {
		ClsDBConnection cls = new ClsDBConnection();
		try {
			con = (Connection) cls.getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int insert(OrderModel dain) {
		int result =0;
		String sql = "insert into pos_baby.order (order_id,customer_id,order_date) values(?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, dain.getOrder_id());
			ps.setString(2, dain.getCustomer_id());
			ps.setString(3, dain.getOrder_date());
			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Fail insert,Inter Error","Fail",JOptionPane.ERROR_MESSAGE);
		}
		return result;
	}
	public int update(OrderModel dain) {
		int result =0;
		String sql = "update pos_baby.order set customer_id=?,order_date=? where order_id=?;";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, dain.getOrder_id());
			ps.setString(2, dain.getCustomer_id());
			ps.setString(3, dain.getOrder_date());	
			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Fail update,Inter Error","Fail",JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	public int delete(OrderModel dain) {
		int result =0;
		String sql = "delete from pos_baby.order where order_id=?";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, dain.getOrder_id());
			
			result =  ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Fail delete,Inter Error","Fail",JOptionPane.ERROR_MESSAGE);
		}
		return result;
	}
	
	public List<OrderModel> selectall()throws SQLException{
		List<OrderModel> list = new ArrayList<OrderModel>();
		String sql = "select * from pos_baby.order order by order_id desc";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			OrderModel om = new OrderModel();
			om.setOrder_id(rs.getString("order_id"));
		    om.setCustomer_id(rs.getString("customer_id"));
		    om.setOrder_date(rs.getString("order_date"));

		    list.add(om);
		}
		return list;
	}
	
	public List<OrderModel> selectone(OrderModel dain) throws SQLException{
		List<OrderModel> list = new ArrayList<OrderModel>();
		String sql = "select * from pos_baby.order where name like ? order by order_id desc";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, dain.getOrder_date()+"%");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			OrderModel om = new OrderModel();
			om.setOrder_id(rs.getString("order_id"));
		    om.setCustomer_id(rs.getString("customer_id"));
		    om.setOrder_date(rs.getString("order_date"));
		    list.add(om);
		}
		return list;
	}
	
	public List<OrderModel> searchItemDeatail(OrderModel dain){
		List<OrderModel> list = new ArrayList<OrderModel>();
		String sql = "select * from pos_baby.order where order_date=? order by order_id desc";
		try {
			PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
			ps.setString(1, dain.getOrder_date());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				OrderModel om = new OrderModel();
				om.setOrder_id(rs.getString("order_id"));
			    om.setCustomer_id(rs.getString("customer_id"));
			    om.setOrder_date(rs.getString("order_date"));
			    list.add(om);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public String searchCustomerID(OrderModel dain) {
		String name = null;
		String sql = "select customer_id from pos_baby.order where order_id=?";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, dain.getOrder_id());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				name = rs.getString("customer_id");
			}else {
				System.out.println("Customer Name is not found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return name;
	}
	
	
	public boolean isduplicate(OrderModel dain) throws SQLException{
		boolean duplicate = false;
		String sql = "select * from pos_baby.order where order_date=?";
		PreparedStatement ps =(PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, dain.getOrder_date());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			duplicate = true;
		}else {
			duplicate = false;
		}
		return duplicate;
	}

}

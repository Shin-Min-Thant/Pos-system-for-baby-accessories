package Controller;

import java.awt.Image;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Connection.ClsDBConnection;
import Model.BrandModel;
import Model.ItemModel;
import Model.TypeModel;
import Model.loss_profitModel;

public class Loss_ProfitController {
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
	
	
	public int insertPurchase(loss_profitModel dain) throws FileNotFoundException {
		int result =0;
		String sql = "insert into pos_baby.loss_profit (total_purchase) values(?)";
		try {
			PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
			ps.setString(1, dain.getTotal_purchase());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			JOptionPane.showMessageDialog(null,"Insert Fail,Inter error","Fail", JOptionPane.ERROR_MESSAGE);
		}
		return result;
			
	}
	
	public int insertDelivery(loss_profitModel dain) throws FileNotFoundException {
		int result =0;
		String sql = "insert into pos_baby.loss_profit (total_delivery) values(?)";
		try {
			PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
			ps.setString(1, dain.getTotal_delivery());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Insert Fail,Inter error","Fail", JOptionPane.ERROR_MESSAGE);
		}
		return result;
			
	}
	
	public int insertSale(loss_profitModel dain) throws FileNotFoundException {
		int result =0;
		String sql = "insert into pos_baby.loss_profit (total_sale) values(?)";
		try {
			PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
			ps.setString(1, dain.getTotal_sale());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Insert Fail,Inter error","Fail", JOptionPane.ERROR_MESSAGE);
		}
		return result;
			
	}
	
	public int insertOrder(loss_profitModel dain) throws FileNotFoundException {
		int result =0;
		String sql = "insert into pos_baby.loss_profit (total_order) values(?)";
		try {
			PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
			ps.setString(1, dain.getTotal_order());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Insert Fail,Inter error","Fail", JOptionPane.ERROR_MESSAGE);
		}
		return result;
			
	}
	
	public List<loss_profitModel> showPurchase() throws SQLException{
		List<loss_profitModel> list = new ArrayList<loss_profitModel> ();
		String sql = "select total_purchase from pos_baby.loss_profit";
		PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			loss_profitModel im = new loss_profitModel();
			im.setTotal_purchase(rs.getString("total_purchase"));
			list.add(im);
		}
		
		return list;
	}
	
	public List<loss_profitModel> showSale() throws SQLException{
		List<loss_profitModel> list = new ArrayList<loss_profitModel> ();
		String sql = "select total_sale from pos_baby.loss_profit";
		PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			loss_profitModel im = new loss_profitModel();
			im.setTotal_sale(rs.getString("total_sale"));
			list.add(im);
		}
		
		return list;
	}
	
	public List<loss_profitModel> showOrder() throws SQLException{
		List<loss_profitModel> list = new ArrayList<loss_profitModel> ();
		String sql = "select total_order from pos_baby.loss_profit";
		PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			loss_profitModel im = new loss_profitModel();
			im.setTotal_sale(rs.getString("total_order"));
			list.add(im);
		}
		
		return list;
	}

	public List<loss_profitModel> showDelivery() throws SQLException{
		List<loss_profitModel> list = new ArrayList<loss_profitModel> ();
		String sql = "select total_delivery from pos_baby.loss_profit";
		PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			loss_profitModel im = new loss_profitModel();
			im.setTotal_sale(rs.getString("total_delivery"));
			list.add(im);
		}
		
		return list;
	}

}

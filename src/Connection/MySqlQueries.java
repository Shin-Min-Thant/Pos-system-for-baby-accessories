package Connection;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Model.ItemModel;
import Model.OrderDetailModel;
import Model.OrderModel;

public class MySqlQueries {
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
	
	public static void addCoboBox(String tableName,String columnName,JComboBox<String> comboBox) {
		String sql = "select " + columnName + " from " + tableName;
		try {
			PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			comboBox.removeAllItems();
			comboBox.addItem("-Select-");
			while(rs.next()) {
				String value = rs.getString(columnName);
				
				comboBox.addItem(value);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addComboBox1(String tableName, String columnName, JComboBox<String> comboBox) {
	    String sql = "SELECT `" + columnName + "` FROM `" + tableName + "`";
	    try {
	        PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        comboBox.removeAllItems();
	        comboBox.addItem("-Select-");
	        while (rs.next()) {
	            String value = rs.getString(columnName);
	            comboBox.addItem(value);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	public static String[] getItemData(ItemModel dain)throws SQLException{
		String str[] = new String[7];
		String sql = "select * from pos_baby.item where item_name = ?";
		PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
        ps.setString(1, dain.getItem_name());
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
        	str[0] = rs.getString(1); //id
        	str[1] = rs.getString(4);  //name
        	str[2] = rs.getString(5); //price
        	str[3] = rs.getString(2);//brand_id
        	str[4] = rs.getString(3);//type_id
        	str[5] = rs.getString(6);//qty
        	str[6] = rs.getString(7);//remark
        }
        
		return str;
	}
	
	
	
	public static String getBrandName(String brandid)throws SQLException {
		String brandname = null;
		String sql = "select * from pos_baby.brand where brand_id = ?";
		PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
        ps.setString(1, brandid);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
        	brandname = rs.getString(2);
        }
		return brandname;
	}
	public static String getTypeName(String typeid)throws SQLException{
		String typename = null;
		String sql = "select * from pos_baby.type where type_id=?";
		PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
		ps.setString(1,typeid);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			typename = rs.getString(2);
		}
		return typename;
				
	}
	
	public static String[] getItemData1(ItemModel dain)throws SQLException{
		String str[] = new String[7];
		String sql = "select * from pos_baby.item where item_id = ?";
		PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
        ps.setString(1, dain.getItem_id());
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
        	str[0] = rs.getString(1); //id
        	str[1] = rs.getString(4);  //name
        	str[2] = rs.getString(5); //price
        	str[3] = rs.getString(2);//brand_id
        	str[4] = rs.getString(3);//type_id
        	str[5] = rs.getString(6);//qty
        	str[6] = rs.getString(7);//remark
        }
		return str;
	}
	
	public static String[] getItemData2(OrderDetailModel dain)throws SQLException{
		String str[] = new String[6];
		String sql = "select * from pos_baby.order_detail where `unique` =?";
		PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
        ps.setInt(1, dain.getUnique());
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
        	str[0] = rs.getString("order_id");
        	str[1] = rs.getString("item_id"); 
        	str[2] = rs.getString("order_price"); 
        	str[3] = rs.getString("order_qty");
        	str[4] = rs.getString("unique");
        	str[5] = rs.getString("status");
        }
        System.out.println(str[3]);
		return str;
	}

	

}

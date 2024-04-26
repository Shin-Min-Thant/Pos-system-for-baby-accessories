package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Connection.ClsDBConnection;
import Model.Grand_TotalModel;
import Model.OrderDetailModel;
import Model.loss_profitModel;

public class Grand_TotalController {
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
	
	public int insert(Grand_TotalModel dain) {
		int result =0;
		String sql = "INSERT INTO pos_baby.loss_profit_record (grand_purchase, grand_delivery, grand_sale, grand_order,loss,profit) VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, dain.getGrand_purchase());
			ps.setString(2, dain.getGrand_delivery());
			ps.setString(3, dain.getGrand_sale());
			ps.setString(4, dain.getGrand_order());
			ps.setString(5, dain.getLoss());
			System.out.println(dain.getLoss());
			System.out.println(dain.getProfit());
			ps.setString(6, dain.getProfit());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	public List<Grand_TotalModel> showAll(int selectedIndex) throws SQLException{
		List<Grand_TotalModel> list = new ArrayList<Grand_TotalModel> ();
		String sql = "select * from pos_baby.loss_profit_record where MONTH(date) = ?";
		PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
		ps.setInt(1, selectedIndex);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Grand_TotalModel gm = new Grand_TotalModel();
			gm.setGrand_purchase(rs.getString("grand_purchase"));
			gm.setGrand_delivery(rs.getString("grand_delivery"));
			gm.setGrand_sale(rs.getString("grand_sale"));
			gm.setGrand_order(rs.getString("grand_order"));
			gm.setLoss(rs.getString("loss"));
			gm.setProfit(rs.getString("profit"));
			list.add(gm);
		}
		
		return list;
	}
	
	
	public List<Integer> showMonth(int selectedIndex) throws SQLException {
	    List<Integer> months = new ArrayList<>();
	    String sql = "SELECT DISTINCT MONTH(date) AS month FROM pos_baby.loss_profit_record where MONTH(date) = ?";
		PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
		ps.setInt(1,selectedIndex);
		 ResultSet rs = ps.executeQuery();
		 while (rs.next()) {
	            int month = rs.getInt("month");
	            months.add(month);
	        }
	    rs.close();
	    ps.close();
	    return months;
	}


	

}

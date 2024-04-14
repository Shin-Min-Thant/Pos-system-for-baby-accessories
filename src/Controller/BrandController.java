package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import Connection.ClsDBConnection;
import Model.BrandModel;
public class BrandController {
	public static Connection con = null;
	static {
		ClsDBConnection cls = new ClsDBConnection();
		try {
			con = (Connection) cls.getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int insert(BrandModel dain) {
		int result =0;
		String sql = "insert into pos_baby.brand (brand_id,name) values(?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, dain.getBrand_id());
			ps.setString(2, dain.getName());
			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Fail insert,Inter Error","Fail",JOptionPane.ERROR_MESSAGE);
		}
		return result;
	}
	public int update(BrandModel dain) {
		int result =0;
		String sql = "update pos_baby.brand set name=? where brand_id=?;";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, dain.getName());
			ps.setString(2, dain.getBrand_id());
			System.out.println(dain.getName() + " " + dain.getBrand_id());
			result = ps.executeUpdate();
			System.out.println("===" + result);
		}catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Fail update,Inter Error","Fail",JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	public int delete(BrandModel dain)throws SQLException {
		int result =0;
		String sql = "delete from pos_baby.brand where brand_id=?";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, dain.getBrand_id());
			
			result =  ps.executeUpdate();
		}catch(MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Cannot delete the brand because it is referenced by another record.", "Error", JOptionPane.ERROR_MESSAGE);	
		}
		return result;
	}
	
	public List<BrandModel> selectall()throws SQLException{
		List<BrandModel> list = new ArrayList<BrandModel>();
		String sql = "select * from pos_baby.brand order by brand_id desc";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			BrandModel bm = new BrandModel();
			bm.setBrand_id(rs.getString("brand_id"));
		    bm.setName(rs.getString("name"));
		    list.add(bm);
		}
		return list;
	}
	
	public List<BrandModel> selectone(BrandModel dain) throws SQLException{
		List<BrandModel> list = new ArrayList<BrandModel>();
		String sql = "select * from pos_baby.brand where name like ? order by brand_id desc";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, dain.getName()+"%");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			BrandModel bm = new BrandModel();
			bm.setBrand_id(rs.getString("brand_id"));
			bm.setName(rs.getString("name"));
			list.add(bm);
		}
		return list;
	}
	
	public String searchBrandName(BrandModel dain) {
		String result=null;
		String sql = "select name from pos_baby.brand where brand_id =?";
		PreparedStatement ps ;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, dain.getBrand_id());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getString("name");
			}else{
				System.out.println("This brand is not found");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
	public String searchBrandId(BrandModel dain) {
		String result = null;
		String sql = "select brand_id from pos_baby.brand where name=?";
		try {
			PreparedStatement ps =(PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, dain.getName());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getString("brand_id") ;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	    return result;
	}
	
	public boolean isduplicate(BrandModel dain) throws SQLException{
		boolean duplicate = false;
		String sql = "select * from pos_baby.brand where name=?";
		PreparedStatement ps =(PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, dain.getName());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			duplicate = true;
		}else {
			duplicate = false;
		}
		return duplicate;
	}

}

package Controller;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
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
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import Connection.ClsDBConnection;
import Model.SupplierModel;


public class SupplierController {
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
	
	public int insert(SupplierModel dain,String path2) throws FileNotFoundException {
		int result =0;
		String sql = "insert into pos_baby.supplier (supplier_id,name,address,phone,email,img) values (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, dain.getSupplier_id());
			ps.setString(2,dain.getName());
			ps.setString(3, dain.getAddress());
			ps.setString(4,dain.getPhone());
			ps.setString(5,dain.getEmail());
			File myFile = new File(path2);
			FileInputStream is= new FileInputStream(myFile);
			ps.setBlob(6, is,(int)myFile.length());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Insert Fail,Inter error","Fail", JOptionPane.ERROR_MESSAGE);
		}
		return result;
		
	}
	
	public int update(SupplierModel dain,String path2) throws FileNotFoundException {
		int result =0;
		String sql = "update pos_baby.supplier set name=?,address=?,phone=?,email=?,img=? where supplier_id=?";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			
			ps.setString(1,dain.getName());
			ps.setString(2, dain.getAddress());
			ps.setString(3,dain.getPhone());
			ps.setString(4,dain.getEmail());
			File myFile = new File(path2);
			FileInputStream is= new FileInputStream(myFile);
			ps.setBlob(5, is,(int)myFile.length());
			ps.setString(6, dain.getSupplier_id());
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	public int delete(SupplierModel dain,String path2) throws MySQLIntegrityConstraintViolationException{
		int result =0;
		String sql = "delete from pos_baby.supplier where supplier_id=?";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, dain.getSupplier_id());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Cannot delete the customer because it is referenced by another record.", "Error", JOptionPane.ERROR_MESSAGE);	
		}
		return result;
		
	}
	
	public List<SupplierModel> selectall() throws SQLException {
		List<SupplierModel> list = new ArrayList<SupplierModel> ();
		String sql = "select * from pos_baby.supplier order by supplier_id desc";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			SupplierModel tm = new SupplierModel();
			tm.setSupplier_id(rs.getString("supplier_id"));
			tm.setName(rs.getString("name"));
			tm.setAddress(rs.getString("address"));
			tm.setPhone(rs.getString("phone"));
			tm.setEmail(rs.getString("email"));
			Blob blob = (Blob) rs.getBlob("img");
			if(blob != null) {
				byte[] bytes = blob.getBytes(1, (int)blob.length());
				ImageIcon imageIcon = new ImageIcon(bytes);
				Image img = imageIcon.getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH);
				ImageIcon scaledImageIcon = new ImageIcon(img);
				tm.setImg(scaledImageIcon);
			}
			
			list.add(tm);
		}
		return list;
	}
	
	public List<SupplierModel> selectone(SupplierModel dain,String path2) throws SQLException {
		List<SupplierModel> list = new ArrayList<SupplierModel> ();
		String sql = "select * from pos_baby.supplier where name like ? order by supplier_id desc";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, dain.getName()+"%");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			SupplierModel tm = new SupplierModel();
			tm.setSupplier_id(rs.getString("supplier_id"));
			tm.setName(rs.getString("name"));
			tm.setAddress(rs.getString("address"));
			tm.setPhone(rs.getString("phone"));
			tm.setEmail(rs.getString("email"));
			Blob blob = (Blob) rs.getBlob("img");
			if(blob != null) {
				byte[] bytes = blob.getBytes(1, (int)blob.length());
				ImageIcon imageIcon = new ImageIcon(bytes);
				Image img = imageIcon.getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH);
				ImageIcon scaledImageIcon = new ImageIcon(img);
				tm.setImg(scaledImageIcon);
			}
			list.add(tm);
		}
		return list;
	}
	
	public String searchTypeName(SupplierModel dain) {
		String result = null;
		String sql = "select name from pos_baby.supplier where supplier_id=?";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,dain.getSupplier_id());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getString("name");
			}else{
				System.out.println("This supplier is not found");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public List<SupplierModel> serachSupplierDetail(SupplierModel dain)throws SQLException{
		List<SupplierModel> list = new ArrayList<SupplierModel>();
		String suppliername = dain.getName();
		String sql = "select * from pos_baby.supplier where name = ? order by supplier_id desc";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1,suppliername);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			SupplierModel sm = new SupplierModel();
			sm.setSupplier_id(rs.getString("supplier_id"));
			sm.setName(rs.getString("name"));
			sm.setAddress(rs.getString("address"));
			sm.setPhone(rs.getString("phone"));
			sm.setEmail(rs.getString("email"));
			list.add(sm);
		}
		return list;
	}
	
	public String searchTypeId(SupplierModel dain) {
		String result = null;
		String sql = "select supplier_id from pos_baby.supplier where name=?";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,dain.getName());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getString("supplier_id");
			}else{
				System.out.println("This brand is not found");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean isduplicate(SupplierModel dain) throws SQLException{
		boolean duplicate = false;
		String sql = "select * from pos_baby.supplier where name = ?";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, dain.getName());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			duplicate = true;
		}else {
			duplicate = false;
		}
		return duplicate;
	}
	
	public ImageIcon getOriginalImageFromDatabase(String customerId) {
	    ImageIcon originalImage = null;
	    try {
	        String sql = "SELECT img FROM testing.customer_information WHERE customer_id = ?";
	        PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
	        ps.setString(1, customerId);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            byte[] imgBytes = rs.getBytes("img");
	            if (imgBytes != null) {
	                originalImage = new ImageIcon(imgBytes);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error retrieving image from database: " + e.getMessage(),
	                "Database Error", JOptionPane.ERROR_MESSAGE);
	    }
	    return originalImage;
	}
	
	

}

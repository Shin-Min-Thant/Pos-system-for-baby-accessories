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
import Model.CustomerModel;
import Model.SupplierModel;

public class CustomerController {
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
	
	public int insert(CustomerModel dain,String path2) throws FileNotFoundException {
		int result = 0;
		String sql = "insert into pos_baby.customer (customer_id,name,address,phone,email,img) values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			
			ps.setString(1,dain.getCustomer_id());
			ps.setString(2,dain.getName());
			ps.setString(3,dain.getAddress());
			ps.setString(4,dain.getPhone());
			ps.setString(5, dain.getEmail());
			File myFile = new File(path2);
			FileInputStream is= new FileInputStream(myFile);
			ps.setBlob(6, is,(int)myFile.length());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int update(CustomerModel dain,String path2) throws FileNotFoundException {
		int result = 0;
		String sql = "update pos_baby.customer set name=?,address=?,phone=?,email=?,img=? where customer_id=?";
		
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,dain.getName());
			ps.setString(2,dain.getAddress());
			ps.setString(3,dain.getPhone());
			ps.setString(4, dain.getEmail());
			File myFile = new File(path2);
			FileInputStream is= new FileInputStream(myFile);
			ps.setBlob(5, is,(int)myFile.length());
			ps.setString(6,dain.getCustomer_id());
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int delete(CustomerModel dain,String path2) throws SQLException {
		int result =0;
		String sql = "delete from pos_baby.customer where customer_id=?";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,dain.getCustomer_id());
			result = ps.executeUpdate();
		} catch (MySQLIntegrityConstraintViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Cannot delete the customer because it is referenced by another record.", "Error", JOptionPane.ERROR_MESSAGE);		}
		return result;
		
	}
	
	public List<CustomerModel> selectall() throws SQLException{
		List<CustomerModel> list = new ArrayList<CustomerModel>();
		String sql = "select * from pos_baby.customer order by customer_id desc";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			CustomerModel cs = new CustomerModel();
			cs.setCustomer_id(rs.getString("customer_id"));
			cs.setName(rs.getString("name"));
			cs.setAddress(rs.getString("address"));
			cs.setPhone(rs.getString("phone"));
			cs.setEmail(rs.getString("email"));
			Blob blob = (Blob) rs.getBlob("img");
			if(blob != null) {
				byte[] bytes = blob.getBytes(1, (int)blob.length());
				ImageIcon imageIcon = new ImageIcon(bytes);
				Image img = imageIcon.getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH);
				ImageIcon scaledImageIcon = new ImageIcon(img);
				cs.setImg(scaledImageIcon);
			}
			list.add(cs);
		}
		return list;
	}
	public List<CustomerModel> selectone(CustomerModel dain,String path2) throws SQLException{
		List<CustomerModel> list = new ArrayList<CustomerModel>();
		String sql = "select * from pos_baby.customer where name like ? order by customer_id desc";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, dain.getName()+"%");
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CustomerModel cs = new CustomerModel();
			cs.setCustomer_id(rs.getString("customer_id"));
			cs.setName(rs.getString("name"));
			cs.setAddress(rs.getString("address"));
			cs.setPhone(rs.getString("phone"));
			cs.setEmail(rs.getString("email"));
			Blob blob = (Blob) rs.getBlob("img");
			if(blob != null) {
				byte[] bytes = blob.getBytes(1, (int)blob.length());
				ImageIcon imageIcon = new ImageIcon(bytes);
				Image img = imageIcon.getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH);
				ImageIcon scaledImageIcon = new ImageIcon(img);
				cs.setImg(scaledImageIcon);
			}
			list.add(cs);
		}
		return list;
	}
	
	public List<CustomerModel> searchCustomerDetail(CustomerModel dain) throws SQLException{
		List<CustomerModel> list = new ArrayList<CustomerModel>();
		String sql = "select * from pos_baby.customer where customer_id=? order by customer_id desc";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, dain.getCustomer_id());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			CustomerModel cs = new CustomerModel();
			cs.setCustomer_id(rs.getString("customer_id"));
			cs.setName(rs.getString("name"));
			cs.setAddress(rs.getString("address"));
			cs.setPhone(rs.getString("phone"));
			cs.setEmail(rs.getString("email"));
			list.add(cs);
		}
		return list;
	}
	
	public String searchCustomerName(CustomerModel dain) {
		String name = null;
		String sql = "select name from pos_baby.customer where customer_id=?";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, dain.getCustomer_id());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				name = rs.getString("name");
			}else {
				System.out.println("Customer Name is not found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return name;
	}
	
	public String searchCustomerAddress(CustomerModel dain) {
		String name = null;
		String sql = "select address from pos_baby.customer where customer_id=?";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, dain.getCustomer_id());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				name = rs.getString("address");
			}else {
				System.out.println("Customer Name is not found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return name;
	}
	
	public String searchCustomerId(CustomerModel dain) {
		String name = null;
		String sql = "select customer_id from pos_baby.customer where name=?";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, dain.getCustomer_id());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				name = rs.getString("name");
			}else {
				System.out.println("Customer Name is not found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return name;
	}
	
	
	public boolean isduplicate(CustomerModel dain) throws SQLException{
		boolean duplicate = false;
		String sql = "select * from pos_baby.customer where name = ?";
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

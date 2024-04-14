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
import Model.DeliverModel;


public class DeliverController {
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
	
	public int insert(DeliverModel dain,String path2) throws FileNotFoundException {
		int result =0;
		String sql = "insert into pos_baby.deliver (deliver_id,name,address,phone,email,deliver_capacity,img) values (?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, dain.getDeliver_id());
			ps.setString(2,dain.getName());
			ps.setString(3, dain.getAddress());
			ps.setString(4,dain.getPhone());
			ps.setString(5,dain.getEmail());
			ps.setInt(6, dain.getDeliver_capacity());
			File myFile = new File(path2);
			FileInputStream is= new FileInputStream(myFile);
			ps.setBlob(7, is,(int)myFile.length());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Insert Fail,Inter error","Fail", JOptionPane.ERROR_MESSAGE);
		}
		return result;
		
	}
	
	public int update(DeliverModel dain,String path2) throws FileNotFoundException {
		int result =0;
		String sql = "update pos_baby.deliver set name=?,address=?,phone=?,email=?,deliver_capacity=?,img=? where deliver_id=?";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			
			ps.setString(1,dain.getName());
			ps.setString(2, dain.getAddress());
			ps.setString(3,dain.getPhone());
			ps.setString(4,dain.getEmail());
			ps.setInt(5, dain.getDeliver_capacity());
			File myFile = new File(path2);
			FileInputStream is= new FileInputStream(myFile);
			ps.setBlob(6, is,(int)myFile.length());
			ps.setString(7, dain.getDeliver_id());
			
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	public int delete(DeliverModel dain,String path2) throws SQLException{
		int result =0;
		String sql = "delete from pos_baby.deliver where deliver_id=?";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, dain.getDeliver_id());
			result = ps.executeUpdate();
		} catch (MySQLIntegrityConstraintViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Cannot delete the deliver because it is referenced by another record.", "Error", JOptionPane.ERROR_MESSAGE);	
		}
		return result;
		
	}
	
	public List<DeliverModel> selectall() throws SQLException {
		List<DeliverModel> list = new ArrayList<DeliverModel> ();
		String sql = "select * from pos_baby.deliver order by deliver_id desc";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			DeliverModel dm = new DeliverModel();
			dm.setDeliver_id(rs.getString("deliver_id"));
			dm.setName(rs.getString("name"));
			dm.setAddress(rs.getString("address"));
			dm.setPhone(rs.getString("phone"));
			dm.setEmail(rs.getString("email"));
			dm.setDeliver_capacity(rs.getInt("deliver_capacity"));
			Blob blob = (Blob) rs.getBlob("img");
			if(blob != null) {
				byte[] bytes = blob.getBytes(1, (int)blob.length());
				ImageIcon imageIcon = new ImageIcon(bytes);
				Image img = imageIcon.getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH);
				ImageIcon scaledImageIcon = new ImageIcon(img);
				dm.setImg(scaledImageIcon);
			}
			list.add(dm);
		}
		return list;
	}
	
	public List<DeliverModel> selectone(DeliverModel dain,String path2) throws SQLException {
		List<DeliverModel> list = new ArrayList<DeliverModel> ();
		String sql = "select * from pos_baby.deliver where name like ? order by deliver_id desc";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, dain.getName()+"%");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			DeliverModel dm = new DeliverModel();
			dm.setDeliver_id(rs.getString("deliver_id"));
			dm.setName(rs.getString("name"));
			dm.setAddress(rs.getString("address"));
			dm.setPhone(rs.getString("phone"));
			dm.setEmail(rs.getString("email"));
			dm.setDeliver_capacity(rs.getInt("deliver_capacity"));
			Blob blob = (Blob) rs.getBlob("img");
			if(blob != null) {
				byte[] bytes = blob.getBytes(1, (int)blob.length());
				ImageIcon imageIcon = new ImageIcon(bytes);
				Image img = imageIcon.getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH);
				ImageIcon scaledImageIcon = new ImageIcon(img);
				dm.setImg(scaledImageIcon);
			}
			list.add(dm);
		}
		return list;
	}
	
	public String searchTypeName(DeliverModel dain) {
		String result = null;
		String sql = "select name from pos_baby.deliver where deliver_id=?";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,dain.getDeliver_id());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getString("name");
			}else{
				System.out.println("This deliver is not found");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public List<DeliverModel> serachDeliverDetail(DeliverModel dain)throws SQLException{
		List<DeliverModel> list = new ArrayList<DeliverModel>();
		String sql = "select * from pos_baby.deliver where deliver_id = ? order by deliver_id desc";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1,dain.getDeliver_id());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			DeliverModel dm = new DeliverModel();
			dm.setDeliver_id(rs.getString("deliver_id"));
			dm.setName(rs.getString("name"));
			dm.setAddress(rs.getString("address"));
			dm.setPhone(rs.getString("phone"));
			dm.setEmail(rs.getString("email"));
			dm.setDeliver_capacity(rs.getInt("deliver_capacity"));
			list.add(dm);
		}
		return list;
	}
	
	public String searchDeliverId(DeliverModel dain) {
		String result = null;
		String sql = "select deliver_id from pos_baby.deliver where name=?";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,dain.getName());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getString("deliver_id");
			}else{
				System.out.println("This deliver is not found");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean isduplicate(DeliverModel dain) throws SQLException{
		boolean duplicate = false;
		String sql = "select * from pos_baby.deliver where name=?";
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
	
	

}

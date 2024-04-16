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
import Model.BrandModel;
import Model.ItemModel;
import Model.TypeModel;

public class ItemController {
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
	
	public int insert(ItemModel dain,String path2) throws FileNotFoundException {
		int result =0;
		String sql = "insert into pos_baby.item (item_id,brand_id,type_id,item_name,current_price,qty,remark,img) values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
			ps.setString(1, dain.getItem_id());
			ps.setString(2, dain.getBrand_id());
			ps.setString(3, dain.getType_id());
			ps.setString(4, dain.getItem_name());
			ps.setInt(5, dain.getPrice());
			ps.setInt(6, dain.getQty());
			ps.setString(7, dain.getRemark());
			File myFile = new File(path2);
			FileInputStream is= new FileInputStream(myFile);
			ps.setBlob(8, is,(int)myFile.length());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Insert Fail,Inter error","Fail", JOptionPane.ERROR_MESSAGE);
		}
		return result;
			
	}
	
	public int update(ItemModel dain,String path2) throws FileNotFoundException {
		int result =0;
		String sql = "update pos_baby.item set brand_id=?,type_id=?,item_name=?,current_price=?,qty=?,remark=?,img=? where item_id=?";
		try {
			PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
			
			ps.setString(1, dain.getBrand_id());
			ps.setString(2, dain.getType_id());
			ps.setString(3, dain.getItem_name());
			ps.setInt(4, dain.getPrice());
			ps.setInt(5, dain.getQty());
			ps.setString(6, dain.getRemark());
			ps.setString(7, dain.getItem_id());
			File myFile = new File(path2);
			FileInputStream is= new FileInputStream(myFile);
			ps.setBlob(8, is,(int)myFile.length());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Update Fail,Inter error","Fail", JOptionPane.ERROR_MESSAGE);
		}
		return result;
			
	}
	
	public int delete(ItemModel dain,String path2) throws SQLException{
		int result =0;
		String sql = "delete from pos_baby.item where item_id=? and qty=0";
		try {
			PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
			ps.setString(1, dain.getItem_id());
			result = ps.executeUpdate();
		} catch (MySQLIntegrityConstraintViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Cannot delete the item because it is referenced by another record.", "Error", JOptionPane.ERROR_MESSAGE);	
		}
		return result;
			
	}
	
	public List<ItemModel> selectall() throws SQLException{
		List<ItemModel> list = new ArrayList<ItemModel> ();
		String sql = "select * from pos_baby.item order by item_id desc";
		PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			ItemModel im = new ItemModel();
			
			
			im.setItem_id(rs.getString("item_id"));
			im.setBrand_id(rs.getString("brand_id"));
			im.setType_id(rs.getString("type_id"));
			im.setItem_name(rs.getString("item_name"));
			im.setPrice(rs.getInt("current_price"));
			im.setQty(rs.getInt("qty"));
			im.setRemark(rs.getString("remark"));
			
			BrandModel bm = new BrandModel();
			BrandController bc = new BrandController();
			bm.setBrand_id(im.getBrand_id());
			im.setBrand_name(bc.searchBrandName(bm));
			
			TypeModel tm = new TypeModel();
			TypeController tc = new TypeController();
			tm.setType_id(im.getType_id());
			im.setType_name(tc.searchTypeName(tm));
			Blob blob = (Blob) rs.getBlob("img");
			if(blob != null) {
				byte[] bytes = blob.getBytes(1, (int)blob.length());
				ImageIcon imageIcon = new ImageIcon(bytes);
				Image img = imageIcon.getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH);
				ImageIcon scaledImageIcon = new ImageIcon(img);
				im.setImg(scaledImageIcon);
			}
			list.add(im);
		}
		
		return list;
	}
	
	public List<ItemModel> selectone(ItemModel dain,String path2){
		List<ItemModel> list = new ArrayList<ItemModel>();
		String sql = "select * from pos_baby.item where item_name like ? order by item_id desc";
		try {
			PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
			ps.setString(1, dain.getItem_name()+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ItemModel im = new ItemModel();
				im.setItem_id(rs.getString("item_id"));
				im.setBrand_id(rs.getString("brand_id"));
				im.setType_id(rs.getString("type_id"));
				im.setItem_name(rs.getString("item_name"));
				im.setPrice(rs.getInt("current_price"));
				im.setQty(rs.getInt("qty"));
				im.setRemark(rs.getString("remark"));
				
				BrandModel bm = new BrandModel();
				BrandController bc = new BrandController();
				bm.setBrand_id(im.getBrand_id());
				im.setBrand_name(bc.searchBrandName(bm));
				
				TypeModel tm = new TypeModel();
				TypeController tc = new TypeController();
				tm.setType_id(im.getType_id());
				im.setType_name(tc.searchTypeName(tm));
				Blob blob = (Blob) rs.getBlob("img");
				if(blob != null) {
					byte[] bytes = blob.getBytes(1, (int)blob.length());
					ImageIcon imageIcon = new ImageIcon(bytes);
					Image img = imageIcon.getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH);
					ImageIcon scaledImageIcon = new ImageIcon(img);
					im.setImg(scaledImageIcon);
				}
				list.add(im);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<ItemModel> searchItemDeatail(ItemModel dain){
		List<ItemModel> list = new ArrayList<ItemModel>();
		String sql = "select * from pos_baby.item where item_name=? order by item_id desc";
		try {
			PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
			ps.setString(1, dain.getItem_name());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ItemModel im = new ItemModel();
				im.setItem_id(rs.getString("item_id"));
				im.setBrand_id(rs.getString("brand_id"));
				im.setType_id(rs.getString("type_id"));
				im.setItem_name(rs.getString("item_name"));
				im.setPrice(rs.getInt("current_price"));
				im.setQty(rs.getInt("qty"));
				im.setRemark(rs.getString("remark"));
				
				BrandModel bm = new BrandModel();
				BrandController bc = new BrandController();
				bm.setBrand_id(im.getBrand_id());
				im.setBrand_name(bc.searchBrandName(bm));
				
				TypeModel tm = new TypeModel();
				TypeController tc = new TypeController();
				tm.setType_id(im.getType_id());
				im.setType_name(tc.searchTypeName(tm));
				list.add(im);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public String searchItemName(ItemModel dain) {
		String result = null;
		String sql = "select item_name from pos_baby.item where item_id=?";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement)con.prepareStatement(sql);
			ps.setString(1, dain.getItem_id());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getString("item_name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
				
	}
	
	public int update1(ItemModel dain) {
		int result =0;
		String sql = "update pos_baby.item set current_price=?,qty=? where item_id=?";
		try {
			PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
			ps.setInt(1, dain.getPrice());
			ps.setInt(2, dain.getQty());
			ps.setString(3, dain.getItem_id());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
	public int update2(ItemModel dain) {
		int result =0;
		String sql = "update pos_baby.item set qty=? where item_id=?";
		try {
			PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
			ps.setInt(1, dain.getQty());
			ps.setString(2, dain.getItem_id());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
}

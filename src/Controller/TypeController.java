package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Model.TypeModel;
import Connection.ClsDBConnection;
public class TypeController {
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
	
	public int insert(TypeModel dain) {
		int result =0;
		String sql = "insert into pos_baby.type (type_id,name) values (?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, dain.getType_id());
			ps.setString(2,dain.getName());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Insert Fail,Inter error","Fail", JOptionPane.ERROR_MESSAGE);
		}
		return result;
		
	}
	
	public int update(TypeModel dain) {
		int result =0;
		String sql = "update pos_baby.type set name=? where type_id=?";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,dain.getName());
			ps.setString(2, dain.getType_id());
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	public int delete(TypeModel dain) {
		int result =0;
		String sql = "delete from pos_baby.type where type_id=?";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, dain.getType_id());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Insert Fail,Inter error","Fail", JOptionPane.ERROR_MESSAGE);
		}
		return result;
		
	}
	
	public List<TypeModel> selectall() throws SQLException {
		List<TypeModel> list = new ArrayList<TypeModel> ();
		String sql = "select * from pos_baby.type order by type_id desc";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			TypeModel tm = new TypeModel();
			tm.setType_id(rs.getString("type_id"));
			tm.setName(rs.getString("name"));
			list.add(tm);
		}
		return list;
	}
	
	public List<TypeModel> selectone(TypeModel dain) throws SQLException {
		List<TypeModel> list = new ArrayList<TypeModel> ();
		String sql = "select * from pos_baby.type where name like ? order by type_id desc";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, dain.getName()+"%");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			TypeModel tm = new TypeModel();
			tm.setType_id(rs.getString("type_id"));
			tm.setName(rs.getString("name"));
			list.add(tm);
		}
		return list;
	}
	
	public String searchTypeName(TypeModel dain) {
		String result = null;
		String sql = "select name from pos_baby.type where type_id=?";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,dain.getType_id());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getString("name");
			}else{
				System.out.println("This brand is not found");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public String searchTypeId(TypeModel dain) {
		String result = null;
		String sql = "select type_id from pos_baby.type where name=?";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,dain.getName());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getString("type_id");
			}else{
				System.out.println("This brand is not found");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean isduplicate(TypeModel dain) throws SQLException{
		boolean duplicate = false;
		String sql = "select * from pos_baby.type where name = ?";
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

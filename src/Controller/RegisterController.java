package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Connection.ClsDBConnection;

public class RegisterController {
	public static Connection con = null;
	static {
		ClsDBConnection cls = new ClsDBConnection();
		try {
			con = (Connection) cls.getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean checkLogin(String username,String password) throws SQLException {
		boolean login=false ;
		String dbUsername;
		String dbPassword;
		String sql = "select name,password from pos_baby.admin";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
        	dbUsername = rs.getString("name");
        	dbPassword = rs.getString("password");
        	if(dbUsername.equals(username)&&dbPassword.equals(password)) {
        		login = true;
        		break;
        	}
        
        }
		return login;
	}

}

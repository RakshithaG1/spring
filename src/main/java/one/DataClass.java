package one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.mysql.jdbc.Driver;

public class DataClass {

	public static ResultSet getData(String username) {
		Connection CON=null;
		PreparedStatement PMT=null;
		ResultSet RS=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    CON=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","Ganesha7#");
			String querString="select * from userdetails where userName=?";
			PMT=CON.prepareStatement(querString);
			PMT.setString(1, username);
			RS=PMT.executeQuery();
			return RS;		
		} catch (Exception e) {
			return null;
		}
	}
	public static boolean dbCheck(String username,String password)  {
		
		Connection CON=null;
		PreparedStatement PMT=null;
		ResultSet RS=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    CON=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","Ganesha7#");
			String querString="select pass from userdetails where username=?";
			PMT=CON.prepareStatement(querString);
			PMT.setString(1, username);
			RS=PMT.executeQuery();
			if (RS.next())
			{				
				if (password.equals(RS.getString("pass"))) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}	
	}
}

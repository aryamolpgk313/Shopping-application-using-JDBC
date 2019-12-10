package shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectionmanager2 {
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=null;
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","");
	if(con!=null)//connection checking
	{
	return con;
	}
	else
	{
	return null;
	}
	}

}

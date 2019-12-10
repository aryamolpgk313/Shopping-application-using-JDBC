package shopping;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Admin {
	Connectionmanager2 con=new Connectionmanager2();
	Scanner s=new Scanner(System.in);
	int ch;
	public void adminData() throws ClassNotFoundException, SQLException
	{
		Statement s1=con.getConnection().createStatement();
		System.out.println("Enter the username");
		String user=s.next();
		System.out.println("Enter the password");
	    String pass=s.next();
	    ResultSet r=s1.executeQuery("select * from adminlogin");
	    int f=0;
	    while(r.next())
	    {
	    String name1=r.getString(1);
	    String pw1=r.getString(2);
	    if(name1.equals(user)&&pw1.equals(pass))
	    {
	    f=1;
	    } 
	    }   
	    if(f==1) 
	    {
	    	System.out.println("Successfully Verified");
	    	do {
	    	System.out.println("1)Add product\n2)Display\n3)Remove\n4)Update\n5)Logout");
	    	System.out.println("Enter the choice");
	    	ch=s.nextInt();
	    	switch(ch)
	    	{
	    	case 1:
	    		System.out.println("Enter the product Id:");
	    		int pid=s.nextInt();
	    		System.out.println("Enter the product Name:");
	    		String pname=s.next();
	    		System.out.println("Enter the minsellquantity:");
	    		int qnty=s.nextInt();
	    		System.out.println("Enter the price");
	    		int price=s.nextInt();
	    		System.out.println("Product added successfully");
	    		PreparedStatement ps1=(PreparedStatement)con.getConnection().prepareStatement("insert into addproduct(product_id,product_name,minsellquantity,price)values(?,?,?,?)");
	    		ps1.setInt(1,pid);
			    ps1.setString(2,pname);
			    ps1.setInt(3,qnty);
			    ps1.setInt(4,price);
			    ps1.executeUpdate();
			    con.getConnection().close();
			    break;
	    	case 2:
	    		Statement st=con.getConnection().createStatement();//callable statemnt to get some data
	    		ResultSet rs=st.executeQuery("select * from addproduct ");//result set
	    		while(rs.next())
	    		{
	    	    System.out.println("###########*******###########");
	    		System.out.println("Product ID ->"+rs.getInt(1));//print value
	    		System.out.println("Product Name ->"+rs.getString(2));
	    		System.out.println("Quantity ->"+rs.getInt(3));
	    		System.out.println("Price ->"+rs.getInt(4));
	    		System.out.println("###########*******###########");
	    		}
	    		con.getConnection().close();
			    break;
	    	case 3:
	    		
	    		Statement st1=con.getConnection().createStatement();//callable statemnt to get some data
	    		ResultSet rs1=st1.executeQuery("select Product_id,Product_name from addproduct ");
	    		while(rs1.next())
	    		{
	    			System.out.println("##########List of ID's #########");
	    			System.out.println("Product ID ->"+rs1.getInt(1));//print value
		    		System.out.println("Product Name ->"+rs1.getString(2));
	    		}
	    		System.out.println("Enter the Delete ID");
	    		int id=s.nextInt();
	    		PreparedStatement ps2=(PreparedStatement)con.getConnection().prepareStatement("delete from addproduct where product_id = ?");//delete statement
	    		System.out.println("Product Removed");
	    		ps2.setInt(1,id);
	    		ps2.executeUpdate();
	    		con.getConnection().close();
	    		break;
	    	case 4:
	    		Statement st2=con.getConnection().createStatement();//callable statemnt to get some data
	    		ResultSet rs2=st2.executeQuery("select Product_id,Product_name from addproduct ");
	    		while(rs2.next())
	    		{
	    			System.out.println("##########List of ID's #########");
	    			System.out.println("Product ID ->"+rs2.getInt(1));//print value
		    		System.out.println("Product Name ->"+rs2.getString(2));
	    		}
	    		System.out.println("Enter the update id");
	    		int id1=s.nextInt();
	    		System.out.println("Enter the Add quantity:");
	    		int qnty1=s.nextInt();
	    		ResultSet rs3=st2.executeQuery("select * from addproduct");
	    		int q=0;
				while(rs3.next())
				{
					
					if(rs3.getInt(1)==id1)
					{
						q=rs3.getInt(3);
						break;
				    }
				}
				int total=qnty1+q;
	    		PreparedStatement ps3=(PreparedStatement)con.getConnection().prepareStatement("update addproduct set Minsellquantity=? where product_id=? ");
	    		ps3.setInt(1,total);
	    		ps3.setInt(2,id1);
			    ps3.executeUpdate();
			    con.getConnection().close();
			    System.out.println("Quantity update successfull");
			    break;
			    
	    	case 5:
	    		System.out.println("Admin account Logout");
	    		Shopping c=new Shopping();
	    		c.choice();
	    		
	    	}
	    	}while(ch!=0);
	   
	    }
	    else {
	    	System.out.println("Verification Failed");
	    	Shopping c=new Shopping();
			c.choice();
	         }
}
}

package shopping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Agent {
	Connectionmanager2 con=new Connectionmanager2();
	Scanner s=new Scanner(System.in);
	int t;int qnty;
	public void agentData() throws ClassNotFoundException, SQLException
	{
	Statement s1=con.getConnection().createStatement();
	System.out.println("Enter the username");
	String user1=s.next();
	System.out.println("Enter the password");
    String pass1=s.next();
    ResultSet r=s1.executeQuery("select * from agentlogin");
    int f=0;int cost=1;
    while(r.next())
    {
    String name1=r.getString(1);
    String pw1=r.getString(2);
    if(name1.equals(user1)&&pw1.equals(pass1))
    {
     System.out.println("Successfully Verified");
    f=1;
    } 
    }   
    if(f==1) 
    {
	    do 
	    {
	    	System.out.println("1)BuySell\n2)View Product\n3)Home Page");
	    	System.out.println("Enter the choice");
	    	t=s.nextInt();
	    	switch(t)	
	    	{
	    	case 1:
	    		System.out.println("Enter the id");
	    	    int id=s.nextInt();
	    	    System.out.println("Enter the quantity");
	    	    qnty=s.nextInt();
	    	    Statement st=con.getConnection().createStatement();//callable statemnt to get some data
	    		ResultSet rs=st.executeQuery("select price from addproduct where Product_id="+id);
	    		while(rs.next())
	    		{
	    		cost=rs.getInt(1)*qnty;
	    		System.out.println("The cost is:"+cost);
	    		}
	    	    
	    	    System.out.println("Enter 1 to confirm Booking");
	    	    int b=s.nextInt();
	    	    if(b==1) {
	    	    	System.out.println("Your Booking is Confirmed");
	    	        System.out.println("Thank you...!!!");
	    	             }
	    	        else {
	    	        	System.out.println("Please confirm your booking");
	    	             }
	    	        	break;
	    	    
	    	    
	    	case 2:
	        Statement st1=con.getConnection().createStatement();//callable statemnt to get some data
    		ResultSet rs1=st1.executeQuery("select * from addproduct ");//result set
    		while(rs1.next())
    		{
    		System.out.println("~~~~~List Of Product~~~~~");
    	    System.out.println("###########*******###########");
    		System.out.println("Product ID ->"+rs1.getInt(1));//print value
    		System.out.println("Product Name ->"+rs1.getString(2));
    		System.out.println("Quantity ->"+(rs1.getInt(3)-qnty));
    		System.out.println("Price ->"+rs1.getInt(4));
    		System.out.println("###########*******###########");
    		}
    		con.getConnection().close();
		    break;
	    	case 3:
	    		System.out.println("Agent Account Logout");
	    		Shopping c=new Shopping();
	    		c.choice();
	    		break;
	    	}
	    }while(t!=0);
    }else
    {
    	System.out.println("Verification Failed");
    	Shopping c=new Shopping();
		c.choice();
    }
    }	
}

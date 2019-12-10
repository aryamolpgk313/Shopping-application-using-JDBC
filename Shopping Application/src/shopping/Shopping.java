package shopping;

import java.sql.SQLException;
import java.util.Scanner;



public class Shopping {
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		Shopping c=new Shopping();
		c.choice();
	}
		public void choice()throws SQLException, ClassNotFoundException{
			int n;
			Scanner s=new Scanner(System.in);
		
		do
		{
			System.out.println("1)Admin Login\n2)Agent Login\n3)Exit");
			System.out.println("enter the choice");
			n=s.nextInt();	
		switch(n)
		{
		case 1:
			Admin admin=new Admin();
			admin.adminData();
			break;
		case 2:
			Agent agent=new Agent();
			agent.agentData();
			break;
		case 3:
			System.out.println("Process will be complete");
		}
		}while(n!=0);
	}
}

package ANP_D0453;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCUpdate {

	public static void main(String[] args) {
		try {
			//1.Register the Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");//oracle.jdbc.driver.OracleDriver
			
			//2.Create connection
			Connection con=null;
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/anudip","root","security");
			System.out.println(con);
			
			//3.create statment
			PreparedStatement ps=con.prepareStatement("update person set name=? where  person_id=?");
			ps.setString(1,"Aishwarya");
			ps.setInt(2, 1);
			
			//4.Execute queries
			int i=ps.executeUpdate();
			System.out.println(i+"record update sucessfully");
			
			//5.Close connection
			con.close();
		
		}catch(Exception e) {
		System.out.println(e);
		}
	}
}

/*

com.mysql.cj.jdbc.ConnectionImpl@2002fc1d
1record update sucessfully

mysql> select * from person;
+-----------+-----------+-----+
| person_id | name      | age |
+-----------+-----------+-----+
| 1         | Aishwarya |  21 |
| 3         | sita      |  22 |
| 4         | gita      |  20 |
| 5         | sonali    |  23 |
| 6         | sonakshi  |  21 |
+-----------+-----------+-----+
5 rows in set (0.00 sec)

*/
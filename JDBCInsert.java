package ANP_D0453;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCInsert {

	public static void main(String[] args) {

		try {
			//1.Register the Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");//oracle.jdbc.driver.OracleDriver
			
			//2.Create connection
			Connection con=null;
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/anudip","root","security");
			System.out.println(con);
			
			//3.create statment
			PreparedStatement ps=con.prepareStatement("insert into person values(?,?,?)");
			ps.setInt(1,1);
			ps.setString(2, "naina");
			ps.setInt(3,21);
			
			//4.Execute queries
			int i=ps.executeUpdate();
			System.out.println(i+"record inserted sucessfully");
			
			//5.Close connection
			con.close();
		
		}catch(Exception e) {
		System.out.println(e);
		}
	}
}

/*

com.mysql.cj.jdbc.ConnectionImpl@2002fc1d
1record inserted sucessfully

mysql> select * from person;
+-----------+----------+-----+
| person_id | name     | age |
+-----------+----------+-----+
| 1         | naina    |  21 |
| 3         | sita     |  22 |
| 4         | gita     |  20 |
| 5         | sonali   |  23 |
| 6         | sonakshi |  21 |
+-----------+----------+-----+
5 rows in set (0.00 sec)

*/
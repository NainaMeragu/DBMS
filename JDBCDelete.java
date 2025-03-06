package ANP_D0453;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCDelete {

	public static void main(String[] args) {
		try {

			//1.Register the Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");//oracle.jdbc.driver.OracleDriver
			
			//2.Create connection
			Connection con=null;
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/anudip","root","security");
			System.out.println(con);
			
			//3.create statment
			PreparedStatement ps=con.prepareStatement("delete from person where person_id=?");
			ps.setInt(1,1);
			
			//4.Execute queries
			int i=ps.executeUpdate();
			System.out.println(i+"record deleted  sucessfully");
			
			//5.Close connection
			con.close();
		
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}

/*

com.mysql.cj.jdbc.ConnectionImpl@2002fc1d
1record deleted  sucessfully

mysql> select * from person;
+-----------+----------+-----+
| person_id | name     | age |
+-----------+----------+-----+
| 3         | sita     |  22 |
| 4         | gita     |  20 |
| 5         | sonali   |  23 |
| 6         | sonakshi |  21 |
+-----------+----------+-----+
4 rows in set (0.00 sec)

*/
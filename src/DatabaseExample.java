import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.logging.Logger;



public class DatabaseExample {
	
//	Server name: 52.206.157.109
//	Database name: U03QIu
//	Username: U03QIu
//	Password: 53688051379
	
	public static void main(String[] args) {

        //Connection String
        //Server name:  52.206.157.109
        //Database name:  U03QIu
        //Username:  U03QIu
        //Password:  53688051379
        // JDBC driver name and database URL
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://52.206.157.109/U03QIu";

        //  Database credentials
        final String DBUSER = "U03QIu";
        final String DBPASS = "53688051379";

        Connection conn;
      

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, DBUSER, DBPASS);
            
            Statement stmt;

            ResultSet rs = null;
            try {

                stmt = conn.createStatement();
                String customerName = "Kyle";
                int addressID = 1;
                int active = 0;
                //String sqlTimestamp = LocalDateTime.now().toString();
                Timestamp sqlTimestamp = Timestamp.valueOf(LocalDateTime.now());
                String query = "INSERT INTO customer "
                + "(customerName,addressId,active,createDate,createdBy,lastUpdateBy) VALUES"
                + "('"+ customerName +"'," + addressID + "," + active + ",'" + sqlTimestamp + "','Kyle'" + ",'Kyle')";

                System.out.println(query);
                int res = stmt.executeUpdate(query);
                System.out.println(res);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
           
        } catch (ClassNotFoundException ex) {
           ex.printStackTrace();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
	}

}

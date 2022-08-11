import java.util.Scanner;
import java.sql.*;
public class DatabaseConnector {
    public DatabaseConnector(String stringSelectStatement){
        String selectStatement = stringSelectStatement;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/curriculum", "*******", "********");
            System.out.println("connection established");

            //create a Statement object for the connection
            Statement st = conn.createStatement();
            ResultSet results = st.executeQuery(selectStatement);
            while(results.next()){
                System.out.println(results.getString("Title"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

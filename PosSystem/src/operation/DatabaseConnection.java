package operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by bbk on 2/7/17.
 */
public class DatabaseConnection {

    private static final String USER_NAME = "root";
    private static final String PASSWORD = "toor";
    private static final String MYSQL_DATABASE = "jdbc:mysql://localhost:3306/db_pos";

    private Connection connection=null;

    public DatabaseConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(MYSQL_DATABASE,USER_NAME,PASSWORD);
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getLocalizedMessage());
            System.exit(0);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getLocalizedMessage());
            System.exit(0);
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public DatabaseConnection(boolean initPhase){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(MYSQL_DATABASE.replace("db_pos"," ").trim(),USER_NAME,PASSWORD);
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getLocalizedMessage());
            System.exit(0);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getLocalizedMessage());
            System.exit(0);
        }
    }
}

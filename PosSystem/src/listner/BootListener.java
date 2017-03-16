package listner; /**
 * Created by bbk on 2/8/17.
 */

import operation.DatabaseConnection;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BootListener implements ServletContextListener{

    // Public constructor is required by servlet spec
    public BootListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("From context Initialization");


        DatabaseConnection connection = new DatabaseConnection(true);
        Connection conne = connection.getConnection();

        String dbCreate="create database if not EXISTS db_pos";

        String tableStoke="create table if not EXISTS db_pos.tbl_stoke(" +
                "item_id varchar(50) PRIMARY KEY,item_name varchar(50),item_qty varchar(50)," +
                "item_purchaseprice NUMERIC," +
                "item_salesprice NUMERIC,item_addedby varchar(50),item_addeddate varchar(50) )";

        String tableSales="create table if not EXISTS db_pos.tbl_sales(" +
                "sale_id varchar(50),item_id varchar(50),sold_date varchar(50)," +
                "price NUMERIC," +
                "item_qty varchar(50),item_soldby varchar(50))";

        String tableSalesTemp="create table if not EXISTS db_pos.tbl_salesTemp(" +
                "sale_id varchar(50),item_id varchar(50),sold_date varchar(50)," +
                "price varchar(50)," +
                "item_qty varchar(50),item_soldby varchar(50))";

        //",FOREIGN KEY (item_id) REFERENCES tbl_stoke(item_id))";

        String tableLogin="create table if not EXISTS db_pos.tbl_login(username varchar(255) primary key," +
                "password varchar(255))";

        String insert ="INSERT INTO db_pos.tbl_login values('root','toor')";

        try {
            Statement statement =conne.createStatement();
            statement.execute(dbCreate);
            statement.execute(tableStoke);
            statement.execute(tableLogin);
            statement.execute(tableSales);
            statement.execute(tableSalesTemp);
            statement.executeUpdate(insert);
            System.out.println("Database Created Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

}

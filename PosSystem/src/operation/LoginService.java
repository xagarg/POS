package operation;

import operation.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by deepak on 2/2/2017.
 */
public class LoginService {
    public static boolean check(String user,String password){
        DatabaseConnection db=new DatabaseConnection();
        Connection connection=db.getConnection();
        boolean result=false;
        try {
            String sql= "SELECT * FROM tbl_login WHERE  username=? AND password=?";
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1,user);
            statement.setString(2,password);
            ResultSet resultSet= statement.executeQuery();
            if (resultSet.next()){
                result= true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
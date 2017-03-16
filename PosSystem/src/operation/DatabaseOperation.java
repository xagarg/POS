package operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bbk on 2/7/17.
 */
public class DatabaseOperation {

    DatabaseConnection db = new DatabaseConnection();
    PreparedStatement preparedStatement = null;
    Connection connection = db.getConnection();
    String sql = null;
    boolean result = true;

    public boolean insert(Stock stoke) {
        sql = "INSERT INTO tbl_stoke VALUES(?,?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, stoke.getItemId());
            preparedStatement.setString(2, stoke.getItemName());
            preparedStatement.setInt(3, stoke.getItemQny());
            preparedStatement.setFloat(4, stoke.getItemPurchase());
            preparedStatement.setFloat(5, stoke.getItemSale());
            preparedStatement.setString(6, stoke.getItemAddedby());
            preparedStatement.setString(7, stoke.getItemDate());
            result = preparedStatement.executeUpdate() == 1 ? true : false;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Stock> view() {

        List<Stock> stock = new ArrayList<>();

        sql = "SELECT * FROM tbl_stoke";
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String sid = resultSet.getString("item_id");
                String sname = resultSet.getString("item_name");
                int squantity = resultSet.getInt("item_qty");
                float pprice = resultSet.getFloat("item_purchaseprice");
                float sprice = resultSet.getFloat("item_salesprice");
                String added = resultSet.getString("item_addedby");
                String sdate = resultSet.getString("item_addeddate");

                Stock stock1 = new Stock();

                stock1.setItemId(sid);
                stock1.setItemName(sname);
                stock1.setItemQny(squantity);
                stock1.setItemPurchase(pprice);
                stock1.setItemSale(sprice);
                stock1.setItemAddedby(added);
                stock1.setItemDate(sdate);
                stock.add(stock1);
                System.out.println("I am from view DO:" + sname);
            }
            System.out.println("Total size of list:" + stock.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stock;
    }

    public Stock search(Stock stock) {
        Stock stk = new Stock();

        sql = "SELECT * FROM tbl_contact WHERE fname = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, stock.getItemId());
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            String sid = resultSet.getString("item_id");
            String sname = resultSet.getString("item_name");
            int squantity = resultSet.getInt("item_qty");
            float pprice = resultSet.getFloat("item_purchaseprice");
            float sprice = resultSet.getFloat("item_salesprice");
            String added = resultSet.getString("item_addedby");
            String sdate = resultSet.getString("item_addeddate");


            System.out.println("JHJHHJH" + sid + "  " + sname);
            stk.setItemId(sid);
            stk.setItemSale(sprice);
            stk.setItemQny(squantity);
            stk.setItemPurchase(pprice);
            stk.setItemAddedby(added);
            stk.setItemDate(sdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("From search " + stk.getItemId());
        return stk;
    }

    public boolean insertSale(Sales sales) {
        sql = "INSERT INTO tbl_sales VALUES(?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sales.getSaleId());
            preparedStatement.setString(2, sales.getItemId());
            preparedStatement.setString(3, sales.getSoldDate());
            preparedStatement.setFloat(4, sales.getPrice());
            preparedStatement.setInt(5, sales.getItemQty());
            preparedStatement.setString(6, sales.getSoldBy());
            result = preparedStatement.executeUpdate() == 1 ? true : false;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean insertSaleTemp(Sales sales) {
        sql = "INSERT INTO tbl_salesTemp VALUES(?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sales.getSaleId());
            preparedStatement.setString(2, sales.getItemId());
            preparedStatement.setString(3, sales.getSoldDate());
            preparedStatement.setFloat(4, sales.getPrice());
            preparedStatement.setInt(5, sales.getItemQty());
            preparedStatement.setString(6, sales.getSoldBy());
            result = preparedStatement.executeUpdate() == 1 ? true : false;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Sales> viewSearch() {
        List<Sales> sales = new ArrayList<>();

        sql = "SELECT * FROM tbl_salesTemp";
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String sid = resultSet.getString("sale_id");
                String iid = resultSet.getString("item_id");
                String sdate = resultSet.getString("sold_date");
                float price = resultSet.getFloat("price");
                int iqty = resultSet.getInt("item_qty");
                String soldBY = resultSet.getString("item_soldby");
                Sales sale = new Sales();
                sale.setSaleId(sid);
                sale.setItemId(iid);
                sale.setSoldDate(sdate);
                sale.setPrice(price);
                sale.setItemQty(iqty);
                sale.setSoldBy(soldBY);
                sales.add(sale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sales;
    }

    public void insertBulk() {
        String sql = "Insert into tbl_sales select * from tbl_salesTemp";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public void deleteTempSales() {
        String sql = "Delete from tbl_salesTemp";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public int selectQTY(String s) {

        int a = 0;
        String sql = "SELECT item_qty from tbl_stoke where item_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                a = resultSet.getInt("item_qty");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }


    public boolean updateAfterCheckOut(Stock stock) {

        boolean result = false;
        sql = "UPDATE tbl_stoke set item_qty=? WHERE item_id =?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, stock.getItemQny());
            preparedStatement.setString(2, stock.getItemId());
            result = preparedStatement.executeUpdate() == 1 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int countStock() {
        int f=0;
        sql = "SELECT COUNT(item_id) FROM tbl_stoke";

        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
            f = resultSet.getInt(1);
                System.out.println("From sum "+f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return f;
    }


    public float sumStock() {
        float f=0;
        sql = "SELECT SUM(item_purchaseprice) FROM tbl_stoke";

        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                f = resultSet.getInt(1);
                System.out.println("From sum "+f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return f;
    }

    public int countSales() {
        int f=0;
        sql = "SELECT COUNT(sale_id) FROM tbl_sales";

        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                f = resultSet.getInt(1);
                System.out.println("From sum "+f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return f;
    }

    public float sumSales() {
        float f=0;
        sql = "SELECT SUM (price) FROM tbl_sales";

        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                f = resultSet.getInt(1);
                System.out.println("From sum "+f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
       }
        return f;
    }
}

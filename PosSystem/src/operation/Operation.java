package operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by bbk on 2/8/17.
 */
public class Operation {

    DatabaseOperation databaseOperation=null;

    public Operation(){
        databaseOperation=new DatabaseOperation();
    }


    public boolean insert(String id, String name, int qty, float pprice,float sprice,String addedBy,String addedDate){
        Stock stoke=new Stock();
        stoke.setItemId(id);
        stoke.setItemName(name);
        stoke.setItemQny(qty);
        stoke.setItemPurchase(pprice);
        stoke.setItemSale(sprice);
        stoke.setItemAddedby(addedBy);
        stoke.setItemDate(addedDate);
        return databaseOperation.insert(stoke);
    }

    public List<Stock> view(){
        return databaseOperation.view();
    }

    public Stock search(String itemID){
        Stock stock =new Stock();
        stock.setItemId(itemID);
        return databaseOperation.search(stock);

    }

    public boolean insertSaleTemp(String id, String iid, String date, float prc,int qty,String saBy){

        Sales sales= new Sales();
        sales.setSaleId(id);
        sales.setItemId(iid);
        sales.setSoldDate(date);
        sales.setPrice(prc);
        sales.setItemQty(qty);
        sales.setSoldBy(saBy);
        return databaseOperation.insertSaleTemp(sales);

    }

    public List<Sales> viewStemp(){
        return databaseOperation.viewSearch();
    }

    public int viewQt(String s){
        return databaseOperation.selectQTY(s);
    }

    public void updateAfterCheckOut(int f, String s){
        Stock stock=new Stock();
        stock.setItemId(s);
        stock.setItemQny(f);
        databaseOperation.updateAfterCheckOut(stock);
    }
}

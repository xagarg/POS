package web;

import operation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bbk on 2/7/17.
 */
public class SalesServlet extends HttpServlet {
    Operation operation=new Operation();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session=request.getSession(false);
        if(null==session.getAttribute("username")){
            request.getRequestDispatcher("view/Login.jsp").forward(request, response);
        }

        String saleId=request.getParameter("sid");
        String itemId=request.getParameter("id");
        String soldDate=request.getParameter("date");
        float price= Float.parseFloat(request.getParameter("sprice"));
        int itemQty= Integer.parseInt(request.getParameter("qty"));
        String soldBy=request.getParameter("sby");

        Sales sale=new Sales();

        sale.setSaleId(saleId);
        sale.setItemId(itemId);
        sale.setSoldDate(soldDate);
        sale.setPrice(price);
        sale.setItemQty(itemQty);
        sale.setSoldBy(soldBy);


        //operation.cart(saleId,itemId,soldDate,price,itemQty,soldBy);
        operation.insertSaleTemp(saleId,itemId,soldDate,price,itemQty,soldBy);


        ArrayList<String> stringList=new ArrayList<>();
        ArrayList<Integer> ints =new ArrayList();
        ArrayList<Integer> itys=new ArrayList();
        ArrayList<Integer> fina=new ArrayList();

        ints.add(itemQty);

        stringList.add(itemId);

        for (int sa=0;sa<stringList.size();sa++) {
            int a=operation.viewQt(stringList.get(sa));
            itys.add(a);
        }

        for (int sa=0;sa<stringList.size();sa++){
            if (itys.get(sa)-ints.get(sa)<0){
                response.getWriter().println();
                request.setAttribute("cannotSale","Dont Have Sufficent Quantity");
                request.getRequestDispatcher("view/sales.jsp").forward(request,response);
            }else {

                fina.add(itys.get(sa) - ints.get(sa));
            }
        }

        for (int sa =0;sa<stringList.size();sa++){
            operation.updateAfterCheckOut(fina.get(sa),stringList.get(sa));
        }


        request.setAttribute("cartList",operation.viewStemp());
        request.getRequestDispatcher("view/sales.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* String saleId;
        String itemId;
        String soldDate;
        String price;
        String itemQty;
        String soldBy;
        Operation operation =new Operation();
        String name =request.getParameter("id");
        Stock stock= new Stock();
        stock=operation.search(name);
        String saleId;
        String itemId=stock.getItemName();
        String soldDate;
        String price=stock.getItemSale();
        String itemQty;
        String soldBy;

        request.setAttribute("ietmid",itemId);
        request.setAttribute("saleprc",price);
        request.getRequestDispatcher("view/sales.jsp").forward(request,response);
        */
    }
    public void destroy(){

        DatabaseOperation databaseOperation=new DatabaseOperation();
        databaseOperation.deleteTempSales();

    }
}

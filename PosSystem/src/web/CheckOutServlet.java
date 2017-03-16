package web;

import operation.DatabaseOperation;
import operation.Operation;
import operation.Sales;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bbk on 2/10/17.
 */
public class CheckOutServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession(false);
        if(null==session.getAttribute("username")){
            request.getRequestDispatcher("view/Login.jsp").forward(request, response);
        }
        DatabaseOperation databaseOperation=new DatabaseOperation();

        databaseOperation.insertBulk();
        databaseOperation.deleteTempSales();


        request.getRequestDispatcher("view/sales.jsp").forward(request,response);
    }



}

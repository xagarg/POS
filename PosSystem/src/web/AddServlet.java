package web;

import operation.Operation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by bbk on 2/7/17.
 */
public class AddServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession(false);
        if(null==session.getAttribute("username")){
            request.getRequestDispatcher("view/Login.jsp").forward(request, response);
        }

        Operation operation=new Operation();

        String id =request.getParameter("id");
        String name=request.getParameter("name");
        int quantity= Integer.parseInt(request.getParameter("quantity"));
        float pprice= Float.parseFloat(request.getParameter("pprice"));
        float sprice= Float.parseFloat(request.getParameter("sprice"));
        String addBy=request.getParameter("addedBy");
        String date=request.getParameter("addedDate");

        operation.insert(id,name,quantity,pprice,sprice,addBy,date);
        System.out.println("gfghhghg "+id+"   "+name+"   "+date+"   "+pprice+"   "+quantity+"   "+addBy);

        request.getRequestDispatcher("/stoke").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}

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
public class StokeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        HttpSession session=request.getSession(false);

        if(null==session.getAttribute("username")){
            request.getRequestDispatcher("view/Login.jsp").forward(request, response);
        }

        Operation operation=new Operation();

        request.setAttribute("view",operation.view());

        System.out.println("I am here");

        request.getRequestDispatcher("view/stoke.jsp").forward(request,response);


    }
}

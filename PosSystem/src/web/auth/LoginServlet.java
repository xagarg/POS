package web.auth;

import operation.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by deepak on 2/2/2017.
 */
//@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("uname");
        String password=request.getParameter("pword");
        LoginService loginService=new LoginService();

        System.out.println(loginService.check(username,password));
        if(loginService.check(username,password)){

            Cookie[] cookie=new Cookie[]{};
            cookie=request.getCookies();
            boolean cookiesFound=false;
            if(cookie!=null) {
                for (Cookie cook : cookie) {
                    if ("userVisit".equalsIgnoreCase(cook.getName())) {
                        cookiesFound = true;
                        break;
                    }
                }
            }
            if(cookiesFound){
                request.setAttribute("WelcomeMsg","Welcome Back");
            }else {
                response.addCookie(new Cookie("userVisit",""));
                request.setAttribute("WelcomeMsg","Welcome New user");
            }


            request.getSession(true).setAttribute("username",username);
                    /*HttpSession session =request.getSession(true);
                    session.setAttribute("username",username);*/
            request.getRequestDispatcher("view/index.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("view/Login.jsp").forward(request,response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }
}

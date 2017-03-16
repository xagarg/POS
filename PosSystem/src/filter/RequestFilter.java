package filter;

import javax.servlet.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by deepak on 2/3/2017.
 */
//@WebFilter(filterName = "RequestFilter")
public class RequestFilter implements Filter {
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {


        String cip=req.getRemoteAddr();
        if (!"127.0.0.1".equalsIgnoreCase(cip)){
            resp.getWriter().println("<h1>You are not allowed here </h1>");
           //chain.doFilter(req, resp);

        }else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

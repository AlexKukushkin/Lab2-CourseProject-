package servlets.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Admin Filter START");
        String role = (String) ((HttpServletRequest)request).getSession().getAttribute("role");
        if("admin".equals(role)){
            chain.doFilter(request, response);
//            ((HttpServletRequest)request).getSession().setAttribute("isAuth", "admin");
        }else{
            ((HttpServletResponse)response).sendRedirect("/web");
        }
    }

    @Override
    public void destroy() {

    }
}

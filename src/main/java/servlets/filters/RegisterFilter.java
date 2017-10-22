package servlets.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Boolean isSingUp = (Boolean)((HttpServletRequest)request)
                .getSession().getAttribute("isSingUp");
        if(isSingUp != null && isSingUp){
            chain.doFilter(request, response);
        }else{
            ((HttpServletResponse)response).sendRedirect("/web");
        }
    }

    @Override
    public void destroy() {

    }
}
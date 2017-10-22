package servlets.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PatientFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Patient Filter");

        String role = (String) ((HttpServletRequest)request)
                .getSession().getAttribute("role");

        if("patient".equals(role)){
            chain.doFilter(request, response);
        }else{
            ((HttpServletResponse)response).sendRedirect("/web");
        }
    }

    @Override
    public void destroy() {

    }
}

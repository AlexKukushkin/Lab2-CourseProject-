package servlets.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DoctorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        String showSchedule = request.getParameter("showSchedule");
//        String showPatients = request.getParameter("showPatients");

        System.out.println("Doctor filter");

        String role = (String) ((HttpServletRequest)request)
                .getSession().getAttribute("role");

//        if("showScheduleDoc".equals(showSchedule)){
//            ((HttpServletResponse)response).sendRedirect("/web/doctor_schedule");
//        } else if("showPatientList".equals(showPatients)){
//            ((HttpServletResponse)response).sendRedirect("/web/doctor_main");
//        } else

        if("doctor".equals(role)){
            chain.doFilter(request, response);
        }else{
            ((HttpServletResponse)response).sendRedirect("/web");
        }
    }

    @Override
    public void destroy() {

    }
}

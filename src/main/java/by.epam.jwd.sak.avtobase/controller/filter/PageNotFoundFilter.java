package by.epam.jwd.sak.avtobase.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.jwd.sak.avtobase.controller.mapping.CommandParameter.*;

@WebFilter("/*")
public class PageNotFoundFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (response.getStatus() == 404){
            response.sendRedirect(PAGE_ERROR);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}

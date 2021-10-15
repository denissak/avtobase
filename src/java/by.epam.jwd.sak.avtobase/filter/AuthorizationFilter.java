package by.epam.jwd.sak.avtobase.filter;

import by.epam.jwd.sak.avtobase.dto.UserDto;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Set;

import static by.epam.jwd.sak.avtobase.servlet.CommandParameter.*;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {

    private static final Set<String> PUBLIC_PATH = Set.of("/");
    private static final Set<String> USER_PATH = Set.of("command=gotoalluserrequestpage", "command=gotocreaterequest", "command=logout", "command=requesteditbyuser", "command=gotocreatecar");
    private static final Set<String> DRIVER_PATH = Set.of("command=gotoalluserrequestpage", "command=gotocreaterequest", "command=logout", "command=gotocreatecar");
    private static final Set<String> DISPATCHER_PATH = Set.of("command=gotoalluserrequestpage", "command=gotocreaterequest", "command=logout");
    private static final Set<String> ADMIN_PATH = Set.of("/", "/Controller", "/index", PATH_TO_REGISTRATION, PATH_TO_LOGIN, "/userRequest", "/createUserRequest", "command=gotoalluserpage", "command=usereditbyadmin");

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String uri = ((HttpServletRequest) servletRequest).getRequestURI();
        String queryString = ((HttpServletRequest) servletRequest).getQueryString();
        UserDto user = (UserDto) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
        if (isPublicPath(uri)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (queryString != null) {
            if (queryString.equals("command=login") || queryString.equals("command=registration")) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else if (user != null) {
                if (USER_PATH.contains(queryString) && user.getRole().equals("user")) {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
                if (DRIVER_PATH.contains(queryString) && user.getRole().equals("driver")) {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
                if (DISPATCHER_PATH.contains(queryString) && user.getRole().equals("dispatcher")) {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
                if ((USER_PATH.contains(queryString) || ADMIN_PATH.contains(queryString)) && user.getRole().equals("admin")) {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            }
        }
    }

//        if (user != null) {
//            filterChain.doFilter(servletRequest, servletResponse);
//        }
//        if(isPublicPath(uri) || isUserLoggedIn(servletRequest)){
//            filterChain.doFilter(servletRequest, servletResponse);
//        }else {
//            /*String prevPage = ((HttpServletRequest) servletRequest).getHeader("referer");*/
//            //((HttpServletResponse)servletResponse).sendRedirect(/*prevPage != null ? prevPage : */LOGIN);
//        }


    private boolean isUserLoggedIn(ServletRequest servletRequest) {
        UserDto user = (UserDto)((HttpServletRequest) servletRequest).getSession().getAttribute("user");
        //user.getRole();
        return user != null;
    }

    private boolean isPublicPath(String uri) {
        return PUBLIC_PATH.contains(uri);
        //return PUBLIC_PATH.stream().anyMatch(path -> uri.startsWith(path));
    }
}


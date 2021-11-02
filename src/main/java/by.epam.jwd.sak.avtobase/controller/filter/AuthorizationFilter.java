package by.epam.jwd.sak.avtobase.controller.filter;

import by.epam.jwd.sak.avtobase.dto.UserDto;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Set;

import static by.epam.jwd.sak.avtobase.controller.mapping.CommandParameter.*;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {



    private static final Set<String> PUBLIC_PATH = Set.of("/", ACCESS_LANGUAGE, ACCESS_LOGIN, ACCESS_REGISTRATION, ACCESS_ALL_COMMENT);
    private static final Set<String> USER_PATH = Set.of(ACCESS_ALL_USER_REQUEST, ACCESS_CREATE_REQUEST, ACCESS_LOGOUT, ACCESS_EDIT_REQUEST_BY_USER, ACCESS_CREATE_COMMENT, ACCESS_LANGUAGE, ACCESS_ALL_USER_COMMENT);
    private static final Set<String> DRIVER_PATH = Set.of(ACCESS_ALL_REQUESTBYDRIVER, ACCESS_EDIT_STATUS_CAR, ACCESS_LOGOUT, ACCESS_LANGUAGE);
    private static final Set<String> DISPATCHER_PATH = Set.of(ACCESS_LANGUAGE, ACCESS_LOGOUT, ACCESS_ALL_USER_REQUEST, ACCESS_CREATE_REQUEST, ACCESS_ALL_REQUEST, ACCESS_ALL_DRIVER, ACCESS_CREATE_CAR, ACCESS_EDIT_CAR, ACCESS_EDIT_REQUEST_BY_USER, ACCESS_EDIT_STATUS_REQUEST_BY_DRIVER, ACCESS_SET_DRIVER_ON_CAR, ACCESS_SET_DRIVER_ON_REQUEST, ACCESS_ALL_CAR);
    private static final Set<String> ADMIN_PATH = Set.of(ACCESS_LANGUAGE, ACCESS_LOGOUT, ACCESS_ALL_USER, ACCESS_EDIT_USER_BY_ADMIN);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String uri = ((HttpServletRequest) servletRequest).getRequestURI();
        String queryString = ((HttpServletRequest) servletRequest).getQueryString();
        if (queryString != null) {
            queryString = queryString.replaceAll("&page=\\d+", "");
        }
//        ((HttpServletRequest) servletRequest).getQueryString().replaceAll("&page=\\d", "")
        UserDto user = (UserDto) ((HttpServletRequest) servletRequest).getSession().getAttribute(USER);
//        if (isPublicPath(uri)) {
//            filterChain.doFilter(servletRequest, servletResponse);
//        } else if (queryString != null) {
            if (isPublicPath(uri) || isPublicPath(queryString) /*queryString.equals(ACCESS_LOGIN) || queryString.equals(ACCESS_REGISTRATION)*/) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else if (user != null) {
                if (USER_PATH.contains(queryString) && user.getRole().equals(USER)) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else if (DRIVER_PATH.contains(queryString) && user.getRole().equals(DRIVER)) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else if (DISPATCHER_PATH.contains(queryString) && user.getRole().equals(DISPATCHER)) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else if ((USER_PATH.contains(queryString) || ADMIN_PATH.contains(queryString)) && user.getRole().equals(ADMIN)) {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            }
//        }
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
        if (uri != null) {
            return PUBLIC_PATH.contains(uri);
        }
        return false;
        //return PUBLIC_PATH.stream().anyMatch(path -> uri.startsWith(path));
    }
}


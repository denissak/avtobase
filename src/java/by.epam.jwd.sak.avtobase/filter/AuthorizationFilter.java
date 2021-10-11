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

    private static final Set<String> PUBLIC_PATH = Set.of("/", "/Controller", "/index", PATH_TO_REGISTRATION, PATH_TO_LOGIN/*, "/userRequest", "/createUserRequest", "/allUser"*/);
    private static final Set<String> USER_PATH = Set.of("/userRequest", "/createUserRequest");
    private static final Set<String> ADMIN_PATH = Set.of("/allUser");


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String uri = ((HttpServletRequest)servletRequest).getRequestURI();
        if(isPublicPath(uri) || isUserLoggedInUser(servletRequest)){
            filterChain.doFilter(servletRequest, servletResponse);

        }else {
            /*String prevPage = ((HttpServletRequest) servletRequest).getHeader("referer");*/
            //((HttpServletResponse)servletResponse).sendRedirect(/*prevPage != null ? prevPage : */LOGIN);
        }
    }

    private boolean isUserLoggedInUser(ServletRequest servletRequest) {
        UserDto user = (UserDto)((HttpServletRequest) servletRequest).getSession().getAttribute("user");
        //user.getRole();
        return user != null;
    }

    private boolean isPublicPath(String uri) {
        return PUBLIC_PATH.contains(uri);
        //return PUBLIC_PATH.stream().anyMatch(path -> uri.startsWith(path));
    }
    private boolean isUserPath (String uri) {
        return USER_PATH.contains(uri);
    }
    private boolean isAdminPath (String uri) {
        return ADMIN_PATH.contains(uri);
    }
}

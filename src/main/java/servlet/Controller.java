package servlet;

import dao.AddressDao;
import dto.UserCreateDto;
import service.AddressService;
import service.RouteService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class Controller extends HttpServlet {

    private final CommandProvider provider = new CommandProvider();
    private final RouteService routeService = RouteService.getInstance();
    private final AddressService addressService = AddressService.getInstance();
    private final UserService userService = UserService.getInstance();

    public Controller() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req,resp);
        String[] times = new String[] { "summer", "autumn", "winter", "spring" };
        req.setAttribute("items", times);
        req.setAttribute("message", "qwerty");
        req.setAttribute("routes", addressService.findAll());
        req.getRequestDispatcher("/WEB-INF/jsp/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserCreateDto createUserDto =UserCreateDto.builder()
        .login(req.getParameter("login"))
        .password(req.getParameter("password"))
        //.role(req.getParameter("role"))
        .name(req.getParameter("name"))
        .surname(req.getParameter("surname"))
        .phoneNumber(req.getParameter("phoneNumber"))
                .build();

        userService.create(createUserDto);
        resp.sendRedirect("/login");






        //process(req,resp);
    }

    private void process (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name;
        Command command;
        try {
            name = req.getParameter("command");
            command = provider.takeCommand(name);
            command.execute (req, resp);
        }catch (RuntimeException e){
            //req.getRequestDispatcher("error404.html").forward(req,resp);
        }
    }
}

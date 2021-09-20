/*
package servlet;
package servlet;

import service.RouteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/routes")
public class RouteServlet extends HttpServlet {

    private final RouteService routeService = RouteService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try (PrintWriter printWriter = resp.getWriter()) {
            printWriter.write("<h1>Список маршрутов:</h1>");
            printWriter.write("<ul>");
            routeService.findAll().forEach(routeDto -> {

                printWriter.write(routeDto.getId());
                printWriter.write(routeDto.getStartPoint());
                printWriter.write(routeDto.getEndPoint());
                printWriter.write(routeDto.getKmSpent());
                printWriter.write(routeDto.getHourSpent());
printWriter.write("""
                        <li>
                            <a href="/addresses?routeId=%d">%s</a>
                        </li>
                        """.formatted(routeDto.getId(), routeDto.getStartPoint(), routeDto.getEndPoint(),
                        routeDto.getKmSpent(), routeDto.getHourSpent()));

            });
            printWriter.write("</ul>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
*/

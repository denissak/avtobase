package by.epam.jwd.sak.avtobase.servlet;

import by.epam.jwd.sak.avtobase.dto.CommentDto;
import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.FactoryService;
import by.epam.jwd.sak.avtobase.util.LocalDateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToCreateComment  implements Command{

    private final FactoryService factoryService = FactoryService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equals("POST")) {
            UserDto userDto = (UserDto) req.getSession().getAttribute("user");
            CommentDto commentDto = CommentDto.builder()
                    .userDto(userDto)
                    //.commentDate(LocalDateTimeFormatter.format(req.getParameter("commentDate")))
                    .mark(Integer.valueOf(req.getParameter("mark")))
                    .message(req.getParameter("message"))
                    .build();
            try {
                factoryService.getCommentService().create(commentDto);
            } catch (ServiceException e) {
                throw new ServletException();
            }
        }
        resp.sendRedirect("Controller?command=gotoalluserrequestpage");
    }
}


package by.epam.jwd.sak.avtobase.service.impl;

import by.epam.jwd.sak.avtobase.dao.CommentDao;
import by.epam.jwd.sak.avtobase.dto.CommentDto;
import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.entity.Comment;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.CommentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.powermock.reflect.internal.WhiteboxImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CommentServiceImplTest {

    private CommentDao commentDao;
    private CommentService commentService = new CommentServiceImpl();
    private CommentDto commentDto;
    private List<Comment> commentList = new ArrayList<>();

    @BeforeEach
    void prepare() {
        commentDao = Mockito.mock(CommentDao.class);
        WhiteboxImpl.setInternalState(commentService, "commentDao", commentDao);
        commentDto = CommentDto.builder()
                .id(1L)
                .userDto(UserDto.builder()
                        .id(1L)
                        .login("admin123")
                        .name("Denis")
                        .surname("Sak")
                        .password("Zz123")
                        .phoneNumber("+375294561221")
                        .build())
                .commentDate(LocalDateTime.now())
                .mark(3)
                .message("Wow!")
                .build();
        commentList.add(Comment.builder()
                .id(1L)
                .commentDate(LocalDateTime.now())
                .mark(5)
                .message("Best!")
                .build());
        commentList.add(Comment.builder()
                .id(3L)
                .commentDate(LocalDateTime.now())
                .mark(1)
                .message("Bad!")
                .build());
    }

    @Test
    void testDeleteComment() throws ServiceException, DAOException {
        Mockito.doReturn(true).when(commentDao).delete(Mockito.any());
        var deleteResult = commentService.delete(commentDto.getId());
        assertThat(deleteResult).isTrue();
    }

    @Test
    void testCreateCar() throws ServiceException, DAOException {
        Mockito.doReturn(true).when(commentDao).save(Mockito.any());
        var saveResult = commentService.create(commentDto);
        assertThat(saveResult).isTrue();
    }

    @Test
    void testShowAllCommentsByUser () throws ServiceException, DAOException {
        Mockito.doReturn(commentList).when(commentDao).findAllByUserId(Mockito.any());
        var allCommentsByUser = commentService.findAllCommentByUser(commentDto.getUserDto().getId());
        assertEquals(2, allCommentsByUser.size());
    }

    @Test
    void testShowAllComment () throws ServiceException, DAOException {
        Mockito.doReturn(commentList).when(commentDao).findAll();
        var allCarResult = commentService.findAllComment();
        assertEquals(2, allCarResult.size());
    }

}

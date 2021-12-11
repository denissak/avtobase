package by.epam.jwd.sak.avtobase.service.impl;

import by.epam.jwd.sak.avtobase.dao.UserDao;
import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.entity.Role;
import by.epam.jwd.sak.avtobase.entity.User;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.UserService;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.powermock.reflect.internal.WhiteboxImpl;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class UserServiceImplTest {

    private UserDao userDao;
    private UserService userService = new UserServiceImpl();

    private UserDto userDto;
    private List<User> userList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        userDao = Mockito.mock(UserDao.class);
        WhiteboxImpl.setInternalState(userService, "userDao", userDao);
        userDto = UserDto.builder()
                .id(1L)
                .login("admin123")
                .name("Denis")
                .surname("Sak")
                .password("Zz123")
                .phoneNumber("+375294561221")
                .build();
        userList.add(User.builder()
                .id(1L)
                .login("admin123")
                .name("Denis")
                .surname("Sak")
                .password("Zz123")
                .phoneNumber("+375294561221")
                .role(new Role(1L, "admin"))
                .build());
        userList.add(User.builder()
                .id(2L)
                .login("admin1234")
                .name("Ivan")
                .surname("Ivanov")
                .password("Zz123")
                .phoneNumber("+375294561221")
                .role(new Role(1L, "admin"))
                .build());

    }

    @Test
    void testDeleteAccount() throws ServiceException, DAOException {
        Mockito.doReturn(true).when(userDao).delete(Mockito.any());
        var deleteResult = userService.delete(userDto.getId());
        assertThat(deleteResult).isTrue();
    }

    @Test
    void testCreateAccount() throws ServiceException, DAOException {
        Mockito.doReturn(true).when(userDao).save(Mockito.any());
        var saveResult = userService.create(userDto);
        assertThat(saveResult).isTrue();
    }

    @Test
    void testRestoreAccount () throws ServiceException, DAOException {
        Mockito.doReturn(true).when(userDao).restore(Mockito.any());
        var restoreResult = userService.restore(userDto.getId());
        assertThat(restoreResult).isTrue();
    }

    @Test
    void testAll () throws ServiceException, DAOException {
        Mockito.doReturn(userList).when(userDao).findAll();
        var restoreResult = userService.findAllUser();
        Assertions.assertEquals(2, restoreResult.size());
    }
}

package by.epam.jwd.sak.avtobase.service.impl;

import by.epam.jwd.sak.avtobase.dao.RequestDao;
import by.epam.jwd.sak.avtobase.dto.RequestDto;
import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.entity.*;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.RequestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.powermock.reflect.internal.WhiteboxImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


class RequestServiceImplTest {

    private RequestDao requestDao;
    private RequestService requestService = new RequestServiceImpl();
    private RequestDto requestDto;
    private List<Request> requestList = new ArrayList<>();
    private Request request;

    @BeforeEach
    void prepare() {
        requestDao = Mockito.mock(RequestDao.class);
        WhiteboxImpl.setInternalState(requestService, "requestDao", requestDao);
        requestDto = RequestDto.builder()
                .id(1L)
                .userDto(UserDto.builder()
                        .id(1L)
                        .login("admin123")
                        .name("Denis")
                        .surname("Sak")
                        .password("Zz123")
                        .phoneNumber("+375294561221")
                        .build())
                .dateCreate(LocalDateTime.now())
                .startAddress("Minsk")
                .endAddress("Brest")
                .dateDeparture(LocalDate.now())
                .statusRequest(StatusRequest.CREATED)
                .typeTransport(TypeTransport.FREIGHT)
                .detailsRequest("nice!")
                .build();
        requestList.add(Request.builder()
                .id(1L)
                .dateCreate(LocalDateTime.now())
                .startAddress("Vitebsk")
                .endAddress("Minsk")
                .dateDeparture(LocalDate.now())
                .statusRequest(StatusRequest.CANCELED)
                .typeTransport(TypeTransport.PASSENGER)
                .detailsRequest("")
                .build());
        requestList.add(Request.builder()
                .id(2L)
                .dateCreate(LocalDateTime.now())
                .startAddress("Minsk")
                .endAddress("Gomel")
                .dateDeparture(LocalDate.now())
                .statusRequest(StatusRequest.COMPLETE)
                .typeTransport(TypeTransport.PASSENGER)
                .detailsRequest("")
                .build());
        request = Request.builder()
                .id(1L)
                .dateCreate(LocalDateTime.now())
                .startAddress("Minsk")
                .endAddress("Gomel")
                .dateDeparture(LocalDate.now())
                .statusRequest(StatusRequest.COMPLETE)
                .typeTransport(TypeTransport.PASSENGER)
                .detailsRequest("")
                .build();
    }

    @Test
    void testAddDriverOnRequest () throws ServiceException, DAOException{
        Mockito.doReturn(true).when(requestDao).addDriverOnRequest(Mockito.any(), Mockito.any());
        var addResult = requestService.addDriverOnRequest(requestDto.getId(), requestDto.getUserDto().getId());
        assertThat(addResult).isTrue();
    }

    @Test
    void testShowAllRequest () throws ServiceException, DAOException {
        Mockito.doReturn(requestList).when(requestDao).findAll();
        var allCarResult = requestService.findAllRequest();
        assertEquals(2, allCarResult.size());
    }

    @Test
    void testDeleteRequest() throws ServiceException, DAOException {
        Mockito.doReturn(true).when(requestDao).delete(Mockito.any());
        var deleteResult = requestService.delete(requestDto.getId());
        assertThat(deleteResult).isTrue();
    }

    @Test
    void testUpdateRequest () throws ServiceException, DAOException {
        Mockito.doReturn(true).when(requestDao).update(Mockito.any());
        var updateResult = requestService.update(requestDto);
        assertThat(updateResult).isTrue();
    }

    @Test
    void testUpdateStatusById () throws ServiceException, DAOException{
        Mockito.doReturn(true).when(requestDao).updateStatusById(Mockito.any(), Mockito.any());
        var updateStatusResult = requestService.updateStatusById(requestDto.getId(), requestDto.getStatusRequest().name());
        assertThat(updateStatusResult).isTrue();
    }

    @Test
    void testCreateCar() throws ServiceException, DAOException {
        Mockito.doReturn(true).when(requestDao).save(Mockito.any());
        var saveResult = requestService.create(requestDto);
        assertThat(saveResult).isTrue();
    }

    @Test
    void testShowAllRequestByUserId () throws ServiceException, DAOException {
        Mockito.doReturn(requestList).when(requestDao).findAllByCarId(Mockito.any());
        var allCommentsByUser = requestService.findAllByCarId(requestDto.getUserDto().getId());
        assertEquals(2, allCommentsByUser.size());
    }

}

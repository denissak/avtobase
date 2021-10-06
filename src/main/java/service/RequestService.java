package service;

import Mapper.RequestMapper;
import dao.RequestDao;
import dto.RequestDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RequestService {

    private static final RequestService INSTANCE = new RequestService();

    private final RequestDao requestDao = RequestDao.getInstance();
    private final RequestMapper requestMapper = RequestMapper.getInstance();


    public List<RequestDto> findAllRequestByUser (Integer userId){
        return requestDao.findAllByUserId(userId).stream()
                .map(requestMapper::mapFrom).collect(Collectors.toList());
    }

    public static RequestService getInstance() {
        return INSTANCE;
    }

}

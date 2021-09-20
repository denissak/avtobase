package service;

import dao.RouteDao;
import dto.RouteDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class RouteService {

    private static final RouteService INSTANCE = new RouteService();

    private final RouteDao routeDao = RouteDao.getInstance();

    private RouteService() {
    }

    public List<RouteDto> findAll() {

        return routeDao.findAll().stream()
                .map(route -> new RouteDto(
                        route.getId(),
                        route.getStartPoint(),
                        route.getEndPoint(),
                        route.getKmSpent(),
                        route.getHourSpent()
                ))
                .collect(toList());

    }

    public static RouteService getInstance() {
        return INSTANCE;
    }
}

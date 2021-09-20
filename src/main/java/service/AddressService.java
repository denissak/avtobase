package service;

import dao.AddressDao;
import dto.AddressDto;

import java.util.List;
import java.util.stream.Collectors;

public class AddressService {

    public static final AddressService INSTANCE = new AddressService();

    private final AddressDao addressDao = AddressDao.getInstance();

    private AddressService() {
    }

    public List<AddressDto> findAll() {
        return addressDao.findAll().stream().map(address -> new AddressDto(
                address.getId(),
                address.getCountry(),
                address.getCity(),
                address.getStreet(),
                address.getBuildingNumber()
        )).collect(Collectors.toList());
    }

    public static AddressService getInstance() {
        return INSTANCE;
    }
}

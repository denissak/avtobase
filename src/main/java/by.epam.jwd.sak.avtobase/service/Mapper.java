package by.epam.jwd.sak.avtobase.service;

import by.epam.jwd.sak.avtobase.bean.Request;
import by.epam.jwd.sak.avtobase.bean.User;
import by.epam.jwd.sak.avtobase.dto.RequestDto;
import by.epam.jwd.sak.avtobase.dto.UserDto;

public final class Mapper {

    public static UserDto convertToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .password(user.getPassword())
                .name(user.getName())
                .surname(user.getSurname())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

    public static User convertToUser(UserDto object) {
        return User.builder()
                .id(object.getId())
                .login(object.getLogin())
                .password(object.getPassword())
                .name(object.getName())
                .surname(object.getSurname())
                .phoneNumber(object.getPhoneNumber())
                .build();
    }

    public static RequestDto convertToRequestDto(Request request) {
        UserDto userDto = new UserDto();
        if (request.getUser() != null) {
            userDto = Mapper.convertToUserDto(request.getUser());
        }
        return RequestDto.builder()
                .id(request.getId())
                .userDto(userDto)
                .dateCreate(request.getDateCreate())
                .startAddress(request.getStartAddress())
                .endAddress(request.getEndAddress())
                .dateDeparture(request.getDateDeparture())
                .statusRequest(request.getStatusRequest())
                .typeTransport(request.getTypeTransport())
                .detailsRequest(request.getDetailsRequest())
                .build();
    }
}

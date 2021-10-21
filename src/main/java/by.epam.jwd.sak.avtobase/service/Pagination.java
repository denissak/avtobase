package by.epam.jwd.sak.avtobase.service;

import by.epam.jwd.sak.avtobase.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class Pagination {

    public static List<UserDto> process(List<UserDto> userDtoList, String page) {
        List<UserDto> userDtoDisplayList = new ArrayList<>();
        int pageInt = Integer.parseInt(page);
        int limit = (pageInt - 1) * 5;
        for (int i = limit; i < pageInt * 5; i++) {
            if (userDtoList.size() > i) {

                userDtoDisplayList.add(userDtoList.get(i));

            } else {
                break;
            }

        }
        return userDtoDisplayList;
    }
}

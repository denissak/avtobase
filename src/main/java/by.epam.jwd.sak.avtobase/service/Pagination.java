package by.epam.jwd.sak.avtobase.service;

import java.util.ArrayList;
import java.util.List;

public class Pagination {

    public static <T> T process(List<T> obj, String page) {
        List<T> displayList = new ArrayList<>();
        int pageInt = Integer.parseInt(page);
        int limit = (pageInt - 1) * 5;
        for (int i = limit; i < pageInt * 5; i++) {
            if (obj.size() > i) {
                displayList.add(obj.get(i));
            } else {
                break;
            }
        }
        return (T) displayList;
    }
}

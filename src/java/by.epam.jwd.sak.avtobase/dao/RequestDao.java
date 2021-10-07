package by.epam.jwd.sak.avtobase.dao;

import by.epam.jwd.sak.avtobase.bean.Request;
import java.util.List;

public interface RequestDao {

    List<Request> findAllByUserId(Integer userId);

}

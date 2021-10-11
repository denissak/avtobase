package by.epam.jwd.sak.avtobase.dao;

import by.epam.jwd.sak.avtobase.bean.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
//
   List<User> findAll();
//
//    Optional<User> findById(Integer id);

    Optional<User> findByLoginAndPassword(String login, String password);

  //  boolean delete(Integer id);

    User save(User entity);

    User update (User entity);
}

package by.epam.jwd.sak.avtobase.service;

import by.epam.jwd.sak.avtobase.exception.ServiceException;

public interface PasswordEncoder {

        String encrypt(String password) throws ServiceException;

        boolean isMatching(String password,String encodedPassword) throws ServiceException;

}

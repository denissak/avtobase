package by.epam.jwd.sak.avtobase.service;

public interface PasswordEncoder {

        String encrypt(String password);

        boolean isMatching(String password,String encodedPassword);

}

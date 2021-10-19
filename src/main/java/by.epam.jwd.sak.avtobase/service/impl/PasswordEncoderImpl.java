package by.epam.jwd.sak.avtobase.service.impl;

import by.epam.jwd.sak.avtobase.service.PasswordEncoder;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncoderImpl implements PasswordEncoder {

    public static final int SALT = 12;

    @Override
    public String encrypt(String password) {
        if (password == null){
            return null;
        }
        return BCrypt.hashpw(password,BCrypt.gensalt(SALT));
    }

    @Override
    public boolean isMatching(String password, String encodedPassword) {
        if (password == null || encodedPassword == null){
            return false;
        }
        return BCrypt.checkpw(password,encodedPassword);
    }
}

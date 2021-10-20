package by.epam.jwd.sak.avtobase.service;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncoder {

    public static final int SALT_ROUND = 10;

    private PasswordEncoder(){}

    private static class Singleton {
        public static final PasswordEncoder INSTANCE = new PasswordEncoder();
    }

    public static PasswordEncoder getInstance() {
        return Singleton.INSTANCE;
    }

    public String encrypt(String password) {
        if(password==null)return null;
        return BCrypt.hashpw(password, BCrypt.gensalt(SALT_ROUND));
    }

    public boolean isMatching(String password, String encodedPassword) {
        if(password == null || encodedPassword == null) return false;
        return BCrypt.checkpw(password, encodedPassword);
    }

}

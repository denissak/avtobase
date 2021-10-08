package by.epam.jwd.sak.avtobase.service;

public class PasswordEncoderProvider {

    private static PasswordEncoderProvider instance;
    private PasswordEncoder passwordEncoder;

    public static PasswordEncoderProvider newInstance() {
        PasswordEncoderProvider localInstance = instance;
        if(localInstance == null){
            synchronized (PasswordEncoderProvider.class){
                localInstance = instance;
                if (localInstance == null){
                    instance = localInstance = new PasswordEncoderProvider();
                }
            }
        }
        return localInstance;
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }
}

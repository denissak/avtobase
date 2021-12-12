package by.epam.jwd.sak.avtobase.exception;

/**
 * Realization of Exception-class for exceptions in Service-layer.
 *
 */

public class ServiceException extends Exception{

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}

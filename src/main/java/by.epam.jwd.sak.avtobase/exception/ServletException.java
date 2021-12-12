package by.epam.jwd.sak.avtobase.exception;

/**
 * Realization of Exception-class for exceptions in Servlet-layer.
 *
 */

public class ServletException extends Exception {
    public ServletException() {
        super();
    }

    public ServletException(String message) {
        super(message);
    }

    public ServletException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServletException(Throwable cause) {
        super(cause);
    }
}

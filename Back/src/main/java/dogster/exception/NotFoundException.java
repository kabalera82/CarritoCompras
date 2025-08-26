package dogster.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom expetion to indicate that a request resource was not found.
 * When throw in a controller, it returns a 404 Not Found HTTP status.
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    /**
     * Constrcts a new NotFoundException with the specified detail message.
     * @param message the datail message explaining the reason for the exception.
     */
    public NotFoundException(String message) {
        super(message);
    }
}

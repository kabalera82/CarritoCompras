package dogster.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class Notfound {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class NoEncontradoExcepcion extends RuntimeException {

        public NoEncontradoExcepcion(String mensaje) {
            super(mensaje);
        }
    }
}

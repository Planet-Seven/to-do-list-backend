package fit.bitjv.bitjvsvobov25semestralniprace.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TagNotFound extends EntityNotFound {
    public TagNotFound(String message) {
        super(message);
    }
}

package cz.fi.muni.PB138.rest.error;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Erik Macej 433744 , on 1.6.17.
 *
 * @author Erik Macej 433744
 */
@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    void handleException(HttpMessageConversionException x) { // otherwise it would get classified as RuntimeException
        throw x;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    void handleException(MethodArgumentTypeMismatchException x) { // otherwise it would get classified as RuntimeException
        throw x;
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ApiError handleException(RuntimeException x) {
        String error = "Internal Error occurred";
        ApiError apiError = new ApiError();
        List<String> errors = new ArrayList<>();
        if (x instanceof InvalidDataAccessApiUsageException) {
            error = String.format("%s: %s", error, x.getMessage());
        }
        x.printStackTrace();

        errors.add(error);

        apiError.setErrors(errors);
        return apiError;
    }
}

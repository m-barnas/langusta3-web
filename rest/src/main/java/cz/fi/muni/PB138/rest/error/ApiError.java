package cz.fi.muni.PB138.rest.error;

import java.util.List;

/**
 * Created by Erik Macej 433744 , on 1.6.17.
 *
 * @author Erik Macej 433744
 */
public class ApiError {

    private List<String> errors;

    public ApiError() {
    }

    public ApiError(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}

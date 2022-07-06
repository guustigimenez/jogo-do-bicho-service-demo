package ar.com.tecnoaccion.jdbServiceDemo.utils;

import ar.com.tecnoaccion.juego.library.utils.DefinedErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.Map;
import java.util.stream.Collectors;

public class CheckFieldErrors {
    public static ResponseEntity<?> map(BindingResult bindingResult) {
        Map<String, String> mapErrors = bindingResult.getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        x -> x.getField(),
                        y -> y.getDefaultMessage()
                ));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorFieldMessage(DefinedErrors.FIELD_ERRORS.getErrorCode(), mapErrors));
    }
}
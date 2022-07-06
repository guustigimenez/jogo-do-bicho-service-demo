package ar.com.tecnoaccion.jdbServiceDemo.exceptions;

import ar.com.tecnoaccion.jdbServiceDemo.utils.CustomLogger;
import ar.com.tecnoaccion.juego.library.models.dtos.StatusDTO;
import ar.com.tecnoaccion.juego.library.models.dtos.errores.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
public class GlobalExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidacionException.class)
    public ResponseEntity<Object> handleValidacionExceptions(ValidacionException exception, WebRequest request){
        loggerExepction(exception);
        ErrorMessage errorMessage = new ErrorMessage(exception.getCodigoError(), exception.getMessage());
        StatusDTO statusDTO = new StatusDTO(Arrays.asList(errorMessage));
       // HttpStatus httpStatus = (exception.getCodigoError() > HttpStatus.BAD_REQUEST.value()) ? HttpStatus.valueOf(exception.getCodigoError()) : HttpStatus.BAD_REQUEST;
        return  handleExceptionInternal(exception,statusDTO, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }


    private void loggerExepction (Exception exception){
        logger.error(CustomLogger.formatError(exception));
    }

}

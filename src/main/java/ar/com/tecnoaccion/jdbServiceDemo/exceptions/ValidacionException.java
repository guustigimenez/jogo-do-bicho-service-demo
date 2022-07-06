package ar.com.tecnoaccion.jdbServiceDemo.exceptions;

import ar.com.tecnoaccion.juego.library.utils.DefinedErrors;

import java.util.Collection;

public class ValidacionException extends RuntimeException{

        private Integer codigoError;

        public ValidacionException(Integer code, String message){
            super(message);
            this.codigoError = code;
        }

        public ValidacionException(String message) {
            super(message);
        }

        public ValidacionException(String message, Exception exception) {
            super(message, exception);
        }


        public ValidacionException(DefinedErrors error) {
            this(error.getErrorCode(), error.getErrorMessage());
        }

        public static void assertNotEmpty(Collection<?> objects, DefinedErrors error) {
            if (objects.isEmpty()) {
                throw new ValidacionException(error.getErrorCode(), error.getErrorMessage());
            }
        }
        public Integer getCodigoError() { return codigoError; }
    }



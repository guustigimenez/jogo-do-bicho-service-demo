package ar.com.tecnoaccion.jdbServiceDemo.utils;

public enum DefinedError {

    ERROR_SALDO {
        @Override
        public Integer getErrorCode(){
            return 100;
        }

        @Override
        public String getErrorMessage() {
            return "La jugada es menor al mínimo permitido";
        }
    },

    ERROR_JUGADA_MILLAR {
        @Override
        public Integer getErrorCode() { return 101; }

        @Override
        public String getErrorMessage(){ return "Numero elegido no es de 4 cifras " ;}
    },

    ERROR_JUGADA_CENTENA {
        @Override
        public Integer getErrorCode() { return 102; }

        @Override
        public String getErrorMessage(){ return "Numero elegido no es de 3 cifras " ;}
    },
    ERROR_JUGADA_DECENA {
        @Override
        public Integer getErrorCode() { return 103; }

        @Override
        public String getErrorMessage(){ return "Numero elegido no es de 2 cifras " ;}
    },

    ERROR_JUGADA_GRUPO {
        @Override
        public Integer getErrorCode() { return 104; }

        @Override
        public String getErrorMessage(){ return "Los Elementos del grupo no son de dos digitos" ;}
    },

    ERROR_VALORES_DUPLICADOS {
        @Override
        public Integer getErrorCode() { return 105; }

        @Override
        public String getErrorMessage(){ return "La linea de apuestas contiene valores duplicados" ;}
    },
    ERROR_TIPO_JUGADA{
        @Override
        public Integer getErrorCode() { return 106; }

        @Override
        public String getErrorMessage(){ return "El tipo de jugada no existe" ;}

    },
    ERROR_DIGITOS{
        @Override
        public Integer getErrorCode() { return 107; }

        @Override
        public String getErrorMessage(){ return "No cumple con los digitos minimos o maximos" ;}

    },
    ERROR_RANGO{
        @Override
        public Integer getErrorCode() { return 108; }

        @Override
        public String getErrorMessage(){ return "La distancia entre los numeros debe ser mayor a 0" ;}

    };


    public abstract Integer getErrorCode();

    public abstract String getErrorMessage();

}

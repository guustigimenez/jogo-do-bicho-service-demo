package ar.com.tecnoaccion.jdbServiceDemo.utils;

public class CustomLogger {

    public static String getFormat() {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        return "[" + methodName + "] IN: {} | OUT: {}";
    }

    public static String formatError(Exception e){
        return e.getClass().getName() + " [" + e.getStackTrace()[0].getMethodName() + "] [line " + e.getStackTrace()[0].getLineNumber() + "] >>> " + e.getMessage() + " <<<";
    }
}

package ar.com.tecnoaccion.jdbServiceDemo.utils;

public class ValidacionUtils {

    public static String decenaRegex ="[0-9][0-9]";
    public static String centenaRegex = "^\\d{3}$";
    public static String millarRegex = "[0-9][0-9][0-9][0-9]";
    public static int decena = 2;
    public static int centena = 3;
    public static int millar = 4;
    public static String tipoCentena = "C";
    public static String tipoMillar = "M";

    public static String tipoInvertida = "I";

    public static String tipoInvertidaConRepeticion = "IR";

    public static String tipoGrupo = "G";
    public static String tipoDecena = "D";

    public static String tipoRango = "ao";

    public static double importeMinimo = 0.01;
}

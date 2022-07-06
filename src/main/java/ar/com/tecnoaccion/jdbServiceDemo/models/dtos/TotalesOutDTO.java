package ar.com.tecnoaccion.jdbServiceDemo.models.dtos;

public class TotalesOutDTO {

    public double vendido;
    public double premiosPagados;
    public double retiros;
    public double totales;

    public TotalesOutDTO(double vendido, double premiosPagados, double retiros, double totales) {
        this.vendido = vendido;
        this.premiosPagados = premiosPagados;
        this.retiros = retiros;
        this.totales = totales;
    }

    public double getVendido() {
        return vendido;
    }

    public void setVendido(double vendido) {
        this.vendido = vendido;
    }

    public double getPremiosPagados() {
        return premiosPagados;
    }

    public void setPremiosPagados(double premiosPagados) {
        this.premiosPagados = premiosPagados;
    }

    public double getRetiros() {
        return retiros;
    }

    public void setRetiros(double retiros) {
        this.retiros = retiros;
    }

    public double getTotales() {
        return totales;
    }

    public void setTotales(double totales) {
        this.totales = totales;
    }
}

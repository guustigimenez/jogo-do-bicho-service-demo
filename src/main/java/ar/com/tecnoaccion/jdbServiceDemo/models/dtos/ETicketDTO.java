package ar.com.tecnoaccion.jdbServiceDemo.models.dtos;

import ar.com.tecnoaccion.jdbServiceDemo.models.dtos.validaciones.LineaApuestaInDTO;

import java.util.List;

public class ETicketDTO {

    private String logoJuego;
    private double saldo;
    private double importeTotal;
    private int nuc;
    private String logoOrganizacion;
    private List<SorteoSorteadoraDTO> sorteos;
    private String idCupon;
    private int juego;
    private String evento;
    private String fecSorteo;
    private String fecEmision;
    private String organizacion;
    private List<LineaApuestaInDTO> lineasApu;


    public ETicketDTO() {
    }


    public ETicketDTO(String logoJuego, double saldo, double importeTotal, int nuc, String logoOrganizacion, List<SorteoSorteadoraDTO> sorteos, String idCupon, int juego, String evento, String fecSorteo, String fecEmision, String organizacion, List<LineaApuestaInDTO> lineasApu) {
        this.logoJuego = logoJuego;
        this.saldo = saldo;
        this.importeTotal = importeTotal;
        this.nuc = nuc;
        this.logoOrganizacion = logoOrganizacion;
        this.sorteos = sorteos;
        this.idCupon = idCupon;
        this.juego = juego;
        this.evento = evento;
        this.fecSorteo = fecSorteo;
        this.fecEmision = fecEmision;
        this.organizacion = organizacion;
        this.lineasApu = lineasApu;
    }


    public List<SorteoSorteadoraDTO> getSorteos() {
        return sorteos;
    }

    public void setSorteos(List<SorteoSorteadoraDTO> sorteos) {
        this.sorteos = sorteos;
    }

    public String getLogoJuego() {
        return logoJuego;
    }

    public void setLogoJuego(String logoJuego) {
        this.logoJuego = logoJuego;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public int getNuc() {
        return nuc;
    }

    public void setNuc(int nuc) {
        this.nuc = nuc;
    }


    public String getLogoOrganizacion() {
        return logoOrganizacion;
    }

    public void setLogoOrganizacion(String logoOrganizacion) {
        this.logoOrganizacion = logoOrganizacion;
    }


    public String getIdCupon() {
        return idCupon;
    }

    public void setIdCupon(String idCupon) {
        this.idCupon = idCupon;
    }

    public int getJuego() {
        return juego;
    }

    public void setJuego(int juego) {
        this.juego = juego;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getFecSorteo() {
        return fecSorteo;
    }

    public void setFecSorteo(String fecSorteo) {
        this.fecSorteo = fecSorteo;
    }

    public String getFecEmision() {
        return fecEmision;
    }

    public void setFecEmision(String fecEmision) {
        this.fecEmision = fecEmision;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public List<LineaApuestaInDTO> getLineasApu() {
        return lineasApu;
    }

    public void setLineasApu(List<LineaApuestaInDTO> lineasApu) {
        this.lineasApu = lineasApu;
    }
}




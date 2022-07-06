package ar.com.tecnoaccion.jdbServiceDemo.models.dtos;

public class SorteoSorteadoraDTO {

    private int idSorteadora;
    private int idSorteo;
    private String sorteadora;
    private String horario;

    public SorteoSorteadoraDTO(String sorteadora, String horario) {
        this.sorteadora = sorteadora;
        this.horario = horario;
    }

    public int getIdSorteadora() {
        return idSorteadora;
    }

    public void setIdSorteadora(int idSorteadora) {
        this.idSorteadora = idSorteadora;
    }

    public int getIdSorteo() {
        return idSorteo;
    }

    public void setIdSorteo(int idSorteo) {
        this.idSorteo = idSorteo;
    }

    public String getSorteadora() {
        return sorteadora;
    }

    public void setSorteadora(String sorteadora) {
        this.sorteadora = sorteadora;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}

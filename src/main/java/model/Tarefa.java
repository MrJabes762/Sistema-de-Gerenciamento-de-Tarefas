package model;
import java.time.LocalDate;

public class Tarefa {
    private static int idGlobal = 0;

    private int idlocal;
    private String titulo;
    private String descricao;
    private String dataCriacao;
    private Prioridade prioridade;
    private boolean concluida;

    public Tarefa(String titulo, String descricao, Prioridade prioridade) {
        setTitulo(titulo);
        setDescricao(descricao);
        setPrioridade(prioridade);
        setData();
        idGlobal ++;
        setIdlocal(idGlobal);
        setConcluida(false);
    }

    public String getData() {
        return dataCriacao;
    }

    private void setData() {
        this.dataCriacao = LocalDate.now().toString();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIdlocal() {
        return idlocal;
    }

    private void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public static int getIdGlobal() {
        return idGlobal;
    }
    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
    public String getDataCriacao() {
        return dataCriacao;
    }
    @Override
    public String toString() {
        return "{" +
            " idlocal='" + getIdlocal() + "'" +
            ", titulo='" + getTitulo() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", dataCriacao='" + getDataCriacao() + "'" +
            ", concluida='" + isConcluida() + "'" +
            "}";
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }
}

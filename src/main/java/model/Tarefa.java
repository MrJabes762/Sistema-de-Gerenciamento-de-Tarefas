package model;

import java.time.LocalDate;

public class Tarefa {
    private static int idGlobal = 0;

    private int idlocal;
    private String titulo;
    private String descricao;
    private String dataCriacao;
    private Prioridade prioridade;
    private EstadoTarefa estadoTarefa;

    public Tarefa(String titulo, String descricao) {
        setTitulo(titulo);
        setDescricao(descricao);
        setData();
        idGlobal++;
        setIdlocal(idGlobal);
        setEstadoTarefa(EstadoTarefa.EMANDAMENTO);
    }

    public EstadoTarefa getEstadoTarefa() {
        return estadoTarefa;
    }

    public void setEstadoTarefa(EstadoTarefa estadoTarefa) {
        this.estadoTarefa = estadoTarefa;
        estadoTarefa.estadoAtual(this);
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

    public static int getIdGlobal() {
        return idGlobal;
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
            ", prioridade='" + getPrioridade() + "'" +
            ", estadoTarefa='" + getEstadoTarefa() + "'" +
            "}";
    }
   

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }
}

package data;

import java.util.HashMap;
import java.util.Map;

import model.Tarefa;

/**
 * Repositório de tarefas que atua como um singleton. Este repositório é
 * responsável por armazenar e gerenciar as tarefas.
 */
public class TarefasRepository implements Repository<Tarefa>{

    private static TarefasRepository instance;
    private Map<Integer, Tarefa> tarefas;

    private TarefasRepository() {
        setTarefas(new HashMap<>());
    }

    public static TarefasRepository getInstance() {
        if (instance == null) {
            synchronized (TarefasRepository.class) {
                if (instance == null) {
                    instance = new TarefasRepository();
                }
            }
        }
        return instance;
    }
    
    @Override
    public String adicionarTarefa(Tarefa tarefa) {
        getTarefas().put(tarefa.getIdlocal(), tarefa);
        return getTarefasCadastradas();
    }
    
    @Override
    public String getTarefasCadastradas() {
        StringBuilder sb = new StringBuilder("\n");
        for (Tarefa tarefa : getTarefas().values()) {
            sb.append("ID: ").append(tarefa.getIdlocal())
                    .append(", Data de Criação: ").append(tarefa.getDataCriacao())
                    .append(", Título: ").append(tarefa.getTitulo())
                    .append(", Descrição: ").append(tarefa.getDescricao())
                    .append(", Prioridade: ").append(tarefa.getPrioridade().toString())
                    .append(", Estado da Tarefa: ").append(tarefa.getEstadoTarefa().toString())
                    .append("\n");
        }
        return sb.toString();
    }
    
    public String removerTarefa(Tarefa tarefa) {
        getTarefas().remove(tarefa.getIdlocal());
        return getTarefasCadastradas();
    }
    
    public String atualizarTarefa(Tarefa tarefa) {
        adicionarTarefa(tarefa);
        return getTarefasCadastradas();
    }
    @Override
    public Tarefa getTarefaPorId(int id) {
        return getTarefas().get(id);
    }

    private Map<Integer, Tarefa> getTarefas() {
        return tarefas;
    }

    private void setTarefas(Map<Integer, Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    
}

package data;

public interface Repository<T> {
    String adicionarTarefa (T tarefa);
    String removerTarefa (T tarefa);
    String atualizarTarefa (T tarefa);
    T getTarefaPorId(int id);
    String getTarefasCadastradas();
}

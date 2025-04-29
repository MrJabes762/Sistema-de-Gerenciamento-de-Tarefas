package service;

public interface Service<T> {
    String adicionarTarefa (T tarefa);
    String removerTarefa (T tarefa);
    String atualizarTarefa (T tarefa);
    T getTarefaPorId(int id);
    String listarTarefas();
    String concluirTarefa(T tarefa);
}

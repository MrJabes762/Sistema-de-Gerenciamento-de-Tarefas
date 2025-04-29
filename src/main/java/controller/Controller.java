package controller;

public interface Controller<T> {
    String postTarefa(T tarefa);
    String deleteTarefa (T tarefa);
    String putTarefa (T tarefa);
    String getlistTarefas ();
    String concluirTarefa (T tarefa);
    T findById (int id);
}
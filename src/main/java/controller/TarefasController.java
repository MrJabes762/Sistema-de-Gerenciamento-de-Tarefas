package controller;

import model.Tarefa;
import service.TarefasService;


/**
 * Controlador de tarefas que atua como um front controller e singleton.
 * Este controlador é responsável por gerenciar as operações relacionadas às tarefas,
 * como adicionar, remover, atualizar e listar tarefas.
 */
public class TarefasController implements Controller<Tarefa> {
    private static TarefasController instance;
    private static TarefasService intanceService;

    private TarefasController() {
        setIntanceService(TarefasService.getInstance());
    }
    public static TarefasController getInstance() {
        if (instance == null) {
            synchronized (TarefasController.class) {
                if (instance == null) {
                    instance = new TarefasController();
                }
            }
        }
        return instance;
    }
    @Override
    public String postTarefa(Tarefa tarefa) throws IllegalArgumentException {
        return getIntanceService().adicionarTarefa(tarefa);
    }
    @Override
    public String deleteTarefa(Tarefa tarefa) throws IllegalArgumentException {
        return getIntanceService().removerTarefa(tarefa);
    }
    @Override
    public String putTarefa(Tarefa tarefa) throws IllegalArgumentException{
        return getIntanceService().atualizarTarefa(tarefa);
    }
    @Override
    public String getlistTarefas() {
        return getIntanceService().listarTarefas();
    }
    @Override
    public String concluirTarefa(Tarefa tarefa) throws IllegalArgumentException {
        return getIntanceService().concluirTarefa(tarefa);
    }
    @Override
    public Tarefa findById(int id) throws IllegalArgumentException {
        return getIntanceService().getTarefaPorId(id);
    }
    private static TarefasService getIntanceService() {
        return intanceService;
    }

    private static void setIntanceService(TarefasService intanceService) {
        TarefasController.intanceService = intanceService;
    }
}

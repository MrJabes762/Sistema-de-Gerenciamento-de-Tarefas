package controller;

import model.Prioridade;
import model.Tarefa;
import service.TarefasService;

/**
 * Controlador de tarefas que atua como um front controller e um façade com
 * singleton.
 * Este controlador é responsável por gerenciar as operações relacionadas às
 * tarefas,
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
    public String postTarefa(Tarefa tarefa) {
        try {
            return getIntanceService().adicionarTarefa(tarefa);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    @Override
    public String deleteTarefa(Tarefa tarefa) {
        try {
            return "A tarefa Foi removida com sucesso! " + getIntanceService().removerTarefa(tarefa);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    @Override
    public String putTarefa(Tarefa tarefa) {
        try {
            return getIntanceService().atualizarTarefa(tarefa);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    @Override
    public String getlistTarefas() {
        return getIntanceService().listarTarefas();
    }

    @Override
    public String concluirTarefa(Tarefa tarefa) {
        try {
            return getIntanceService().concluirTarefa(tarefa);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
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

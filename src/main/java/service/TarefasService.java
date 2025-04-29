package service;

import data.TarefasRepository;
import model.Tarefa;

/**
 * Serviço de tarefas que atua como um singleton e um Service Layer.
 * Este serviço é responsável por gerenciar as operações relacionadas às tarefas,
 * como adicionar, remover, atualizar e listar tarefas.
 */

public class TarefasService implements Service<Tarefa> {
    private static TarefasService instance;
    private static TarefasRepository instanceRepository;
    private static TarefaProxySecurityValidationService tarefaProxySecurityValidationService;

    private TarefasService() {
        setInstanceRepository(TarefasRepository.getInstance());
        setTarefaProxySecurityValidationService(TarefaProxySecurityValidationService.getInstance());
    }

    public static TarefasService getInstance() {
        if (instance == null) {
            synchronized (TarefasService.class) {
                if (instance == null) {
                    instance = new TarefasService();
                }
            }
        }
        return instance;
    }
    @Override
    public String adicionarTarefa(Tarefa tarefa) throws IllegalArgumentException {
        getTarefaProxySecurityValidationService().adicionarTarefa(tarefa);
        return getInstanceRepository().adicionarTarefa(tarefa);
    }
    @Override
    public String removerTarefa(Tarefa tarefa) throws IllegalArgumentException {
        getTarefaProxySecurityValidationService().removerTarefa(tarefa);
        return getInstanceRepository().removerTarefa(tarefa);
    }
    @Override
    public String atualizarTarefa(Tarefa tarefa) throws IllegalArgumentException {
        getTarefaProxySecurityValidationService().atualizarTarefa(tarefa);
        return getInstanceRepository().atualizarTarefa(tarefa);
    }
    @Override
    public String listarTarefas() {
        return getInstanceRepository().getTarefasCadastradas();
    }
    @Override
    public Tarefa getTarefaPorId(int id) throws IllegalArgumentException{
        getTarefaProxySecurityValidationService().getTarefaPorId(id);
        return getInstanceRepository().getTarefaPorId(id);
    }
    @Override
    public String concluirTarefa(Tarefa tarefa) throws IllegalArgumentException {
        getTarefaProxySecurityValidationService().concluirTarefa(tarefa);
        Tarefa tarefaExistente = getInstanceRepository().getTarefaPorId(tarefa.getIdlocal());
        tarefaExistente.setConcluida(true);
        return atualizarTarefa(tarefaExistente);
    }
    private static TarefasRepository getInstanceRepository() {
        return instanceRepository;
    }

    private static void setInstanceRepository(TarefasRepository instanceRepository) {
        TarefasService.instanceRepository = instanceRepository;
    }
    private static TarefaProxySecurityValidationService getTarefaProxySecurityValidationService() {
        return tarefaProxySecurityValidationService;
    }

    private static void setTarefaProxySecurityValidationService(TarefaProxySecurityValidationService tarefaProxySecurityValidationService) {
        TarefasService.tarefaProxySecurityValidationService = tarefaProxySecurityValidationService;
    }
}

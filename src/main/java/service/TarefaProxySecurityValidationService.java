package service;

import data.TarefasRepository;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import model.Tarefa;

/**
 * A classe TarefaProxySecurityValidationService é um exemplo da aplicação do padrão de projeto estrutural Proxy.
 * Ele é aplicado para que antes de realizar qualquer solicitação, passe por uma validação de segurança.
 * 
 * Tal Classe se comporta tambem como um serviço alem de um padrão de projeto.
 * 
 * O TarefasService passa a responsabilidade para ele, O controller que o instancia não sabe da existencia dele, 
 * 
 * E tambem há a aplicação o Singleton, isso garante que haja apenas 
 * uma instância do proxy no mesmo pacote.
 * Nessa casse terá apenas a lógica validação das requisições, assim como, 
 * demais validações antes de executar as operações.
 * 
 * Toda a logica operacional da solcitação é de responsabiidade da classe TarefasService.
 */

class TarefaProxySecurityValidationService {
    private static TarefaProxySecurityValidationService instance;
    private static TarefasRepository instanceRepository;

    private TarefaProxySecurityValidationService() {
        instanceRepository = TarefasRepository.getInstance();
    }

    static TarefaProxySecurityValidationService getInstance() {
        if (instance == null) {
            synchronized (TarefaProxySecurityValidationService.class) {
                if (instance == null) {
                    instance = new TarefaProxySecurityValidationService();
                }
            }
        }
        return instance;
    }
    
    private void validacaoDeCampos(Tarefa tarefa) throws IllegalArgumentException {
        if (tarefa.getTitulo() == null || tarefa.getTitulo().trim().isEmpty()) {
            throw new IllegalArgumentException("O título da tarefa não pode ser nulo ou vazio.");
        }
        if (tarefa.getDescricao() == null || tarefa.getDescricao().trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição da tarefa não pode ser nula ou vazia.");
        }
        if (tarefa.getDataCriacao() == null || tarefa.getDataCriacao().trim().isEmpty()) {
            throw new IllegalArgumentException("A data de criação da tarefa não pode ser nula ou vazia.");
        }
        try {
            LocalDate dataCriacao = LocalDate.parse(tarefa.getDataCriacao());
            if (dataCriacao.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("A data de criação não pode ser uma data futura.");
            }
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("A data de criação está em um formato inválido.");
        }
    }

    public void adicionarTarefa (Tarefa tarefa) throws IllegalArgumentException {
        validacaoDeCampos(tarefa);
    }

    public void removerTarefa(Tarefa tarefa) throws IllegalArgumentException {
        validacaoDeCampos(tarefa);
        if (tarefa == null || tarefa.getIdlocal() == 0) {
            throw new IllegalArgumentException("A tarefa ou o ID da tarefa não podem ser nulos ou vazios.");
        }
        if (getInstanceRepository().getTarefaPorId(tarefa.getIdlocal()) == null) {
            throw new IllegalArgumentException("A tarefa com o ID " + tarefa.getIdlocal() + " não existe.");
        }
    }

    public void atualizarTarefa(Tarefa tarefa) throws IllegalArgumentException {
        validacaoDeCampos(tarefa);
        if (getInstanceRepository().getTarefaPorId(tarefa.getIdlocal()) == null) {
            throw new IllegalArgumentException("A tarefa com o ID " + tarefa.getIdlocal() + " não está cadastrada.");
        }
    }

    public void concluirTarefa(Tarefa tarefa) throws IllegalArgumentException {
        validacaoDeCampos(tarefa);
        Tarefa tarefaExistente = getInstanceRepository().getTarefaPorId(tarefa.getIdlocal());
        if (tarefaExistente == null) {
            throw new IllegalArgumentException("A tarefa com o ID " + tarefa.getIdlocal() + " não existe.");
        }
        if (tarefaExistente.isConcluida()) {
            throw new IllegalArgumentException("A tarefa com o ID " + tarefa.getIdlocal() + " já está concluída.");
        }
    }

    public void getTarefaPorId(int id) throws IllegalArgumentException {
        if (id <= 0) {
            throw new IllegalArgumentException("O ID da tarefa deve ser um número positivo.");
        }
        if (getInstanceRepository().getTarefaPorId(id) == null) {
            throw new IllegalArgumentException("Tarefa não encontrada com o ID " + id);
        }
    }

    private static TarefasRepository getInstanceRepository() {
        return instanceRepository;
    }
}
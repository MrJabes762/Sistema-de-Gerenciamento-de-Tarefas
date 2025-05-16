package model;

public enum EstadoTarefa implements InterfaceEstadoTarefa {
    CONCLUIDA {
        @Override
        public String estadoAtual(Tarefa tarefa) {
            tarefa.setPrioridade(Prioridade.BAIXA);
            return tarefa.getTitulo() + " - Concluída";
        }
    }
    , PENDENTE {
        @Override
        public String estadoAtual(Tarefa tarefa) {
            tarefa.setPrioridade(Prioridade.ALTA);
            return tarefa.getTitulo() + " - Pendente";
        }
    }
    , ATRASADA {
        @Override
        public String estadoAtual(Tarefa tarefa) {
            tarefa.setPrioridade(Prioridade.ALTA);
            return tarefa.getTitulo() + " - Atrasada";
        }
    }
    , EMANDAMENTO {
        @Override
        public String estadoAtual(Tarefa tarefa) {
            tarefa.setPrioridade(Prioridade.MEDIA);
            return tarefa.getTitulo() + " - Em Andamento";
        }
    };

    @Override
    public String toString() {
        return this.name();
    }
}

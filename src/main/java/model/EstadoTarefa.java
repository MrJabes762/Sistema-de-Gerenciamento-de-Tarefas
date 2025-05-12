package model;

public enum EstadoTarefa implements InterfaceEstadoTarefa {
    CONCLUIDA {
        @Override
        public String estadoAtual(Tarefa tarefa) {
            tarefa.setPrioridade(Prioridade.BAIXA);
            tarefa.setTitulo(tarefa.getTitulo() + " - Concluída");
            return tarefa.getTitulo();
        }
    }
    , PENDENTE {
        @Override
        public String estadoAtual(Tarefa tarefa) {
            tarefa.setPrioridade(Prioridade.ALTA);
            tarefa.setTitulo(tarefa.getTitulo() + " - Pendente");
            return tarefa.getTitulo();
        }
    }
    , ATRASADA {
        @Override
        public String estadoAtual(Tarefa tarefa) {
            tarefa.setPrioridade(Prioridade.ALTA);
            tarefa.setTitulo(tarefa.getTitulo() + " - Atrasada");
            return tarefa.getTitulo();
        }
    }
    , EMANDAMENTO {
        @Override
        public String estadoAtual(Tarefa tarefa) {
            tarefa.setPrioridade(Prioridade.MEDIA);
            tarefa.setTitulo(tarefa.getTitulo() + " - Em Andamento");
            return tarefa.getTitulo();
        }
    };

    @Override
    public String toString() {
        return this.name();
    }
}

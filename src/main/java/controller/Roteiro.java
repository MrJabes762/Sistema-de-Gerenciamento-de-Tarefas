package controller;
import model.Tarefa;

public class Roteiro {
    public static void main(String[] args) {
        
        // Instancia o controlador de tarefas um front controller
        // e singleton
        TarefasController sistema =  TarefasController.getInstance();
        
        // Simulação de um Flyweight na criacao de tarefas 
        // com o mesmo tipo de tarefa
        try {
            String tipoPessoal = "Pessoal";
            Tarefa tarefa1 = new Tarefa("Andar de Bike", tipoPessoal);
            Tarefa tarefa2 = new Tarefa("Limpar a Casa", tipoPessoal);
            Tarefa tarefa3 = new Tarefa("Estudar Java", tipoPessoal);
            Tarefa tarefa4 = new Tarefa("Fazer Análise de Dados em Mysql", tipoPessoal);
            Tarefa tarefa5 = new Tarefa("", tipoPessoal);
            
            // Requisiçao ao frontController do tipo POST
            // para adicionar tarefas
            System.out.println(sistema.postTarefa(tarefa1));
            System.out.println(sistema.postTarefa(tarefa2));
            System.out.println(sistema.postTarefa(tarefa3));
            System.out.println(sistema.postTarefa(tarefa4));
            System.out.println(sistema.postTarefa(tarefa5));
    
            // Requisiçao ao frontController do tipo GET
            System.out.println(sistema.getlistTarefas());
    
            // Requisiçao ao frontController do tipo PUT
            tarefa1.setDescricao("Geral");
            System.out.println(sistema.putTarefa(tarefa1));
    
            System.out.println(sistema.concluirTarefa(tarefa1));
    
            // Requisiçao ao frontController do tipo delete
            System.out.println(sistema.deleteTarefa(tarefa3));
    
            // Requisiçao ao frontController do tipo GET
            // para listar tarefas
            System.out.println(sistema.getlistTarefas());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}


import static org.junit.Assert.*;

import controller.TarefasController;
import model.Prioridade;
import model.Tarefa;
import org.junit.Before;
import org.junit.Test;

public class TarefasControllerTest {

    private TarefasController controller;

    @Before
    public void setUp() {
        controller = TarefasController.getInstance();
    }

    @Test
    public void testPostTarefa() {
        Tarefa tarefa = new Tarefa("Tarefa1", "Teste", Prioridade.ALTA);
        controller.postTarefa(tarefa);
        assertEquals("Tarefa1", controller.findById(1).getTitulo());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPostTarefaFalha() {
        // Tenta criar uma tarefa com título e descrição inválidos
        Tarefa tarefa = new Tarefa("", "", Prioridade.ALTA);
        controller.postTarefa(tarefa);
    }

    @Test
    public void testConcluirTarefa() {
        Tarefa tarefa = new Tarefa("Tarefa", "Teste", Prioridade.ALTA);
        controller.postTarefa(tarefa);
        controller.concluirTarefa(tarefa);
        assertTrue(controller.findById(tarefa.getIdlocal()).isConcluida());
    }

    @Test
    public void testGetTarefas() {
        Tarefa tarefa1 = new Tarefa("Tarefa1", "Descrição1", Prioridade.ALTA);
        Tarefa tarefa2 = new Tarefa("Tarefa2", "Descrição2", Prioridade.BAIXA);

        controller.postTarefa(tarefa1);
        controller.postTarefa(tarefa2);

        // Verifica o tamanho da lista de tarefas
        String listaTarefas = controller.getlistTarefas();
        assertTrue(listaTarefas.contains("Tarefa1"));
        assertTrue(listaTarefas.contains("Tarefa2"));
    }

    @Test
    public void testGetTarefaById() {
        Tarefa tarefa = new Tarefa("Tarefa1", "Teste", Prioridade.ALTA);
        controller.postTarefa(tarefa);
        assertEquals(tarefa, controller.findById(tarefa.getIdlocal()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetTarefaByIdInvalido() {
        controller.findById(999);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoverTarefa() {
        Tarefa tarefa = new Tarefa("Tarefa1", "Teste", Prioridade.ALTA);
        controller.postTarefa(tarefa);
        controller.deleteTarefa(tarefa);
        assertNull(controller.findById(tarefa.getIdlocal())); // Verifica se a tarefa foi removida
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoverTarefaInvalida() {
        Tarefa tarefa = new Tarefa("Tarefa1", "Teste", Prioridade.ALTA);
        controller.deleteTarefa(tarefa);
    }

    @Test
    public void testAtualizarTarefa() {
        Tarefa tarefa = new Tarefa("Tarefa1", "Teste", Prioridade.ALTA);
        controller.postTarefa(tarefa);
        tarefa.setTitulo("Tarefa Atualizada");
        controller.putTarefa(tarefa);
        assertEquals("Tarefa Atualizada", controller.findById(tarefa.getIdlocal()).getTitulo());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAtualizarTarefaInvalida() {
        Tarefa tarefa = new Tarefa("Tarefa1", "Teste", Prioridade.ALTA);
        controller.putTarefa(tarefa);
    }
}

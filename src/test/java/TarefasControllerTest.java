
import static org.junit.Assert.*;

import controller.TarefasController;
import model.EstadoTarefa;
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
        Tarefa tarefa = new Tarefa("Tarefa1", "Teste");
        String resultado = controller.postTarefa(tarefa);

        // Verifica se a saída do método contém a tarefa recém cadastrada
        assertTrue(resultado.contains((tarefa.getTitulo())));

        // Busca pela tarefa e verifica se ela foi armazenada corretamente
        Tarefa tarefaSalva = controller.findById(tarefa.getIdlocal());
        assertNotNull(tarefaSalva); // Verifica se a tarefa existe
        assertEquals(tarefa.getTitulo(), tarefaSalva.getTitulo()); // Verifica se o título corresponde
    }

    @Test
    public void testPostTarefaFalha() {
        // Tenta criar uma tarefa com título e descrição inválidos
        Tarefa tarefa = new Tarefa("", "");
        // Espera-se que uma IllegalArgumentException seja lançada com a mensagem
        assertTrue("O título da tarefa não pode ser nulo ou vazio.", controller.postTarefa(tarefa)
                .contains("O título da tarefa não pode ser nulo ou vazio."));
    }

    @Test
    public void testConcluirTarefa() {
        Tarefa tarefa = new Tarefa("Tarefa", "Teste");
        controller.postTarefa(tarefa);
        controller.concluirTarefa(tarefa);
        assertEquals(controller.findById(tarefa.getIdlocal()).getEstadoTarefa(), EstadoTarefa.CONCLUIDA);
    }

    @Test
    public void testGetTarefas() {
        Tarefa tarefa1 = new Tarefa("Tarefa1", "Descrição1");
        Tarefa tarefa2 = new Tarefa("Tarefa2", "Descrição2");

        controller.postTarefa(tarefa1);
        controller.postTarefa(tarefa2);

        // Verifica o tamanho da lista de tarefas
        String listaTarefas = controller.getlistTarefas();
        assertTrue(listaTarefas.contains("Tarefa1"));
        assertTrue(listaTarefas.contains("Tarefa2"));
    }

    @Test
    public void testGetTarefaById() {
        Tarefa tarefa = new Tarefa("Tarefa1", "Teste");
        controller.postTarefa(tarefa);
        assertEquals(tarefa, controller.findById(tarefa.getIdlocal()));
    }

    @Test
    public void testGetTarefaByIdInvalido() {
        assertThrows("Tarefa não encontrada com o ID " + 999 , IllegalArgumentException.class, () -> {
            controller.findById(999);
        });
    }

    @Test
    public void testRemoverTarefa() {
        Tarefa tarefa = new Tarefa("Tarefa1", "Teste");
        controller.postTarefa(tarefa);
        controller.deleteTarefa(tarefa);
        assertThrows("Tarefa não encontrada com o ID " + tarefa.getIdlocal() , IllegalArgumentException.class, () -> {
            controller.findById(tarefa.getIdlocal());
        });
    }

    @Test
    public void testRemoverTarefaInvalida() {
        Tarefa tarefa = new Tarefa("Tarefa1", "Teste");
        assertTrue ("A tarefa com o ID " + tarefa.getIdlocal() + " não existe."
            ,controller.deleteTarefa(tarefa)
            .contains("A tarefa com o ID " + tarefa.getIdlocal() + " não existe.")); // Tenta deletar uma tarefa que não foi cadastrada
    }

    @Test
    public void testAtualizarTarefa() {
        Tarefa tarefa = new Tarefa("Tarefa1", "Teste");
        controller.postTarefa(tarefa);
        tarefa.setDescricao(tarefa.getDescricao() + "Tarefa Atualizada");
        controller.putTarefa(tarefa);
        assertEquals(tarefa.getDescricao(), controller.findById(tarefa.getIdlocal()).getDescricao());
    }

    @Test
    public void testAtualizarTarefaInvalida() {
        Tarefa tarefa = new Tarefa("Tarefa1", "Teste");
        controller.putTarefa(tarefa); // Tenta atualizar uma tarefa que não foi cadastrada
        assertTrue ("A tarefa com o ID "+ tarefa.getIdlocal() + " não está cadastrada.",
            controller.putTarefa(tarefa)
            .contains("A tarefa com o ID " + tarefa.getIdlocal() + " não está cadastrada."));
    }
}

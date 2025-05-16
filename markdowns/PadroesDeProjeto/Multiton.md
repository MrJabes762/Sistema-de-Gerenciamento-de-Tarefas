# Multiton (Não GOF)

## Intenção

[^K19]
Permitir a criação de uma quantidade limitada de instâncias de determinada classe e fornecer um modo para recuperá-las.

---

## Motivação 

Tendo em vista que, o Multiton é uma variação do Singleton e que o Enum do Java se comporta como um Multiton, no contexto do sistema, o padrão adquiriu uma aplicabilidade considerável , no sentido de que, além da representação de instâncias únicas da classe Prioridade (Alta, Média, Baixa e Urgente), ele também é usado em paralelo ao padrão State visando a atribuição de objetos para cada estado (EMANDAMENTO, ATRASADA, CONCLUIDA, PENDENTE) e o state define um comportamento para cada instancia. Os acessos são centralizados e consistentes, evitando duplicidade e facilitando a manutenção.

---

## Estruturas

**Uso na Prioridade**
![EstruturaMultiton](../../out/estruturasUmls/padrões/multiton/multiton/multiton.png)

**Uso no Estado Da Tarefa**

![EstruturaState](../../out/estruturasUmls/padrões/state/state/state.png)

---

### Código

**Código Prioridade**

[CodigoMultiton](../../src/main/java/model/Prioridade.java)

**Código EstadoTarefa**

[CodigoState](../../src/main/java/model/EstadoTarefa.java)

---

## Participantes

1. **Multiton:** `(Prioridade e Estado Tarefa)` -> mantém instâncias únicas para cada Prioridade e Estado das Tarefas;
2. **Client:** `(Roteiro e TarefaService)`
    - O Roteiro chama as instâncias em tempo de execução para atribuir as tarefas. A prioridade é mais dinâmica na criação da tarefa e o estado por natureza é EMANDAMENTO, sendo alterado pelo Tarefa Service efetivando a conclusão.

---

## Conclusão

Embora o Multiton não figure entre os padrões clássicos da Gang of Four, sua aplicação se revela extremamente valiosa em sistemas que demandam instâncias únicas, porém múltiplas e semanticamente distintas — como as prioridades de uma tarefa ou os estados comportamentais de seu ciclo de vida.

No contexto deste sistema, o uso de enum no Java como implementação natural do Multiton demonstra-se não apenas eficiente, mas também elegante: encapsula valores constantes com comportamento e identidade funcional, reduzindo acoplamento, eliminando redundância e conferindo à modelagem uma clareza conceitual rara. 

Essa abordagem favorece um design mais limpo, previsível e fácil de manter. Além disso, ao operar em harmonia com o padrão State, o Multiton reforça a coesão entre estado e comportamento, promovendo polimorfismo controlado e evitando condicionais desnecessárias que enfraqueceriam a robustez do domínio.


[Voltar Principal](../../README.md)

--- 

## Referências:

[^K19]: KASPCHUK, Alexandre; PLEIN, Tiago. K19 - Design Patterns em Java. São Paulo: K19 Treinamentos, 2012.

# Teste de Componentes - TarefasControllerTeste

## Sumário

- [Teste de Componentes - TarefasControllerTeste](#teste-de-componentes---tarefascontrollerteste)
  - [Sumário](#sumário)
  - [Considerações Técnicas](#considerações-técnicas)
  - [Pre-Condições para a execução dos testes](#pre-condições-para-a-execução-dos-testes)
  - [Casos de Teste](#casos-de-teste)
    - [CT1 - Teste de Cadastro de tarefas com sucesso `(testPostTarefa())`](#ct1---teste-de-cadastro-de-tarefas-com-sucesso-testposttarefa)
    - [CT2 - Teste de Cadastro de tarefa inválida `testPostTarefaFalha()`](#ct2---teste-de-cadastro-de-tarefa-inválida-testposttarefafalha)
    - [CT3 - Teste de conclusão de uma tarefa `testConcluirTarefa()`](#ct3---teste-de-conclusão-de-uma-tarefa-testconcluirtarefa)
    - [CT4 - Teste de listagem de tarefas `testGetTarefas()`](#ct4---teste-de-listagem-de-tarefas-testgettarefas)
    - [CT5 - Teste de busca de tarefa por ID `testGetTarefaById()`](#ct5---teste-de-busca-de-tarefa-por-id-testgettarefabyid)
    - [CT6 - Teste de busca de tarefa por ID inválido `testGetTarefaByIdInvalido()`](#ct6---teste-de-busca-de-tarefa-por-id-inválido-testgettarefabyidinvalido)
    - [CT7 - Teste de remoção de tarefa válida `testRemoverTarefa()`](#ct7---teste-de-remoção-de-tarefa-válida-testremovertarefa)
    - [CT8 - Teste de remoção de tarefa inexistente `testRemoverTarefaInvalida()`](#ct8---teste-de-remoção-de-tarefa-inexistente-testremovertarefainvalida)
    - [CT9 - Teste de atualização de tarefa válida `testAtualizarTarefa()`](#ct9---teste-de-atualização-de-tarefa-válida-testatualizartarefa)
    - [CT10 - Teste de atualização de tarefa inexistente `testAtualizarTarefaInvalida()`](#ct10---teste-de-atualização-de-tarefa-inexistente-testatualizartarefainvalida)
  - [Códigos dos testes:](#códigos-dos-testes)

## Considerações Técnicas 

Este documento explicita os casos de testes executados no componente **TarefasController** o qual simula a porta de entrada das requisições das aplicações web, nesse sentido, os Testes Unitários automatizados foram elaborados em concordância aos endpoints da classe.

Vale a pena ressaltar que, para a execução dos testes no geral, é necessário configurar minimamente o projeto para a execução dos testes, o qual pode ser feitas de várias estratégias:

1. Baixar a Lib do Junit .jar (no site oficial) e configurar as paths de Teste e de desenvolvimento do código para que o Java e a IDE (caso atual - VScode) estejam em harmonia e executar os testes manualmente, utilizando a biblioteca JUnit previamente adicionada ao repositório local.

2. Configurar o Projeto via Maven - estratégia aplicada no contexto atual, que consiste em: 

   1. Instalar o Maven na máquina
  
   2. Criar o `pom.xml` com toda a configuração do projeto e, além disso, as dependências **JUnit 4.13.2 e Hamcrest 1.3** para realizar os testes, demais configurações inerentes ao projeto (compilação e etc). Com isso, teremos algo semelhante a isso:
    ![pom.xml](/pom.xml)
  
   3. Configuração do patch ambiente do projeto no Vscode, se não houverão erros de estruturação de Repositório e identificação de bibliotecas. Isso é feito criando a pasta `.vscode` na raiz do projeto contendo o **`settings.json`** com as seguintes descrições:
    ![settings.json](/.vscode/settings.json)
  
   4. Após essas configurações iniciais, só executar uma compilação inicial executando o comando `mvnw compile` no terminal para garantir o download das libs, configuração dos targets com as versões binárias dos códigos, e toda a configuração do projeto explícita no `pom.xml`.

   5. Com tudo configurado e compilado, e as libs em pleno funcionamento, é só modelar os casos de testes.
 
## Pre-Condições para a execução dos testes 

Para a execução de cada teste, é necessário instanciar o controller de tarefas para a realização de cada teste, uma vez que, antes da execução, o Junit precisa saber sob qual componente será efetuado as validações. Sendo assim, o seguinte método será executado antes dos testes para instanciar o controller:

![Before](../../out/BeforeTest.png)

## Casos de Teste

### CT1 - Teste de Cadastro de tarefas com sucesso `(testPostTarefa())`

**Identificação Única**: CT1.

**Objetivo do Teste**: Validar se o cadastro de tarefa foi executado corretamente.

**Passos para Execução**:

1. Instanciar a tarefa.
2. Chamar o controller executando o método `postTarefa`.
3. Conferir o resultado da comparação através do título usando o método `findbyId(...)` do controller.
   
**Critérios de Aceitação:** A Tarefa deve ser cadastrada com sucesso, com todos os atributos válidos.

### CT2 - Teste de Cadastro de tarefa inválida `testPostTarefaFalha()`

**Identificação Única**: CT2.  
**Objetivo do Teste**: Verificar se o sistema lança exceção ao tentar cadastrar uma tarefa com título e descrição inválidos.  

**Passos para Execução**:
1. Instanciar uma tarefa com campos vazios.
2. Chamar o controller executando o método `postTarefa`.
3. Verificar se é lançada uma `IllegalArgumentException`.

**Critérios de Aceitação**:  
O sistema deve lançar uma exceção com **"O título da tarefa não pode ser nulo ou vazio."** impedindo o cadastro da tarefa inválida.
  
---

### CT3 - Teste de conclusão de uma tarefa `testConcluirTarefa()`

**Identificação Única**: CT3.  
**Objetivo do Teste**: Validar se uma tarefa é marcada como concluída com sucesso.  

**Passos para Execução**:
1. Instanciar uma tarefa.
2. Cadastrar a tarefa usando o método `postTarefa`.
3. Executar o método `concluirTarefa`.
4. Conferir o estado da tarefa com `isConcluida()`.

**Critérios de Aceitação**:  
A tarefa deve estar com status de concluída.

---

### CT4 - Teste de listagem de tarefas `testGetTarefas()`

**Identificação Única**: CT4.  
**Objetivo do Teste**: Validar se a listagem de tarefas está funcionando corretamente, retornando todas as cadastradas.  

**Passos para Execução**:
1. Cadastrar duas tarefas distintas.
2. Executar o método `getlistTarefas`.
3. Verificar se os títulos das tarefas aparecem na lista retornada.

**Critérios de Aceitação**:  
Os títulos das tarefas cadastradas devem estar presentes na string de retorno.

---

### CT5 - Teste de busca de tarefa por ID `testGetTarefaById()`

**Identificação Única**: CT5.  
**Objetivo do Teste**: Confirmar se a tarefa cadastrada pode ser localizada corretamente pelo ID.  

**Passos para Execução**:
1. Cadastrar uma nova tarefa.
2. Obter o ID da tarefa usando `getIdlocal()`.
3. Executar o método `findById` com esse ID.
4. Comparar se o objeto retornado é igual ao original.

**Critérios de Aceitação**:  
A tarefa retornada deve ser equivalente à tarefa cadastrada.

---

### CT6 - Teste de busca de tarefa por ID inválido `testGetTarefaByIdInvalido()`

**Identificação Única**: CT6.  
**Objetivo do Teste**: Validar se o sistema reage corretamente ao tentar buscar uma tarefa com ID inexistente.  

**Passos para Execução**:
1. Executar o método `findById` com um ID inexistente (ex: `999`).
2. Observar o lançamento de uma exceção.

**Critérios de Aceitação**:  
O sistema deve lançar uma exceção do tipo `IllegalArgumentException` com **"Tarefa não encontrada com o ID 999"**.

---

### CT7 - Teste de remoção de tarefa válida `testRemoverTarefa()`

**Identificação Única**: CT7.  
**Objetivo do Teste**: Validar se uma tarefa pode ser removida corretamente após ser cadastrada.  

**Passos para Execução**:
1. Instanciar uma tarefa.
2. Cadastrar a tarefa com `postTarefa`.
3. Executar `deleteTarefa` passando a tarefa como parâmetro.
4. Tentar buscar a tarefa removida usando `findById`.

**Critérios de Aceitação**:  
A tarefa deve ser removida com sucesso e não pode ser localizada posteriormente indicando que, **"Tarefa não encontrada com o ID 1"**.

---

### CT8 - Teste de remoção de tarefa inexistente `testRemoverTarefaInvalida()`

**Identificação Única**: CT8.  
**Objetivo do Teste**: Verificar se o sistema reage corretamente ao tentar remover uma tarefa que nunca foi cadastrada.  

**Passos para Execução**:
1. Instanciar uma tarefa (sem cadastrá-la).
2. Executar `deleteTarefa` com essa instância.

**Critérios de Aceitação**:  
O sistema deve lançar uma exceção `IllegalArgumentException` indicando que, **"A tarefa com o ID 1 não existe."**.

---

### CT9 - Teste de atualização de tarefa válida `testAtualizarTarefa()`

**Identificação Única**: CT9.  
**Objetivo do Teste**: Validar se os dados de uma tarefa existente podem ser atualizados corretamente.  

**Passos para Execução**:
1. Instanciar e cadastrar uma tarefa.
2. Alterar atributos da tarefa (ex: `titulo`).
3. Executar `putTarefa`.
4. Validar se os dados foram atualizados com sucesso via `findById`.

**Critérios de Aceitação**:  
A tarefa deve refletir os novos dados após a atualização.

---

### CT10 - Teste de atualização de tarefa inexistente `testAtualizarTarefaInvalida()`

**Identificação Única**: CT10.  
**Objetivo do Teste**: Verificar se o sistema lança exceção ao tentar atualizar uma tarefa que não foi previamente cadastrada.  

**Passos para Execução**:
1. Instanciar uma tarefa (sem cadastrá-la).
2. Executar o método `putTarefa`.

**Critérios de Aceitação**:  
O sistema deve lançar uma exceção `IllegalArgumentException` indicando que, **"A tarefa com o ID 1 não está cadastrada."**.

## Códigos dos testes:

[CódigosTest](../../src/test/java/TarefasControllerTest.java)

[Voltar Principal](../../README.md)
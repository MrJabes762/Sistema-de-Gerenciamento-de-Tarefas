---
export_on_save:
  html: true
---

# Sistema de Gerenciamento de Tarefas

Nesse exercicio simples, é possivel implementar alguns padrões de projeto, uma vez que, alem as funcionalidades descritas induzirem a modelagem imperativa dos padrões, e mesmo que, tal implementação pode ser aplicavel de forma mais enxuta, o objetivo é visualizar formas de aplica-los (quando justificaveis) de modo a conferir: Robustez, eficiencia, otimização de recurso e aderência aos principios SOLID - evidendiando principalmente o ERP (Principio da responsabilidade Única) . Nesse cenário, é requisito do sistema, gerir tarefas a partir das seguintes funcionalidades: 

## Funções: 

- Adicionar Tarefas
- Listar tarefas.
- Concluir Tarefas.
- Atualizar taferas
- Deletar Taredas 
  

## Arquitertura

### Layred Arquiteture

A arquitetura do sistema segue o padrão **Layered Architecture**, que é uma extensão do **MVC (Model-View-Controller)**. Nesse contexto, o sistema foi dividido em 4 camadas principais, cada uma com responsabilidades bem definidas:

- **Controller**:  
  Esta camada é a principal porta de entrada para a realização das funcionalidades. Ela é responsável por receber as requisições (considerando aplicações web ou outros tipos de interface) e direcioná-las para os processamentos específicos. No projeto, o `TarefasController` atua como um **Front Controller**, centralizando as operações e delegando a lógica de negócios para a camada de serviço.

- **Service (Service Layer)**:  
  Esta camada contém toda a lógica de negócios do sistema. É considerada a "alma" da regra de negócio, onde são descritas de forma imperativa todas as ações e funcionalidades. No projeto, o `TarefasService` centraliza operações como adicionar, atualizar, listar e concluir tarefas.  
  O uso do **Service Layer** desacopla a lógica de negócios da camada de controle, promovendo reutilização e manutenibilidade.

- **Data (Repository Pattern)**:  
  Camada responsável pelo contato direto com os dados. Ela gerencia a persistência e recuperação de informações, seja em memória, arquivos ou banco de dados. No projeto, isso é representado pelo `TarefasRepository`, que implementa o **Repository Pattern**.  
  Esse padrão abstrai os detalhes de acesso aos dados, permitindo que o restante do sistema interaja com os dados de forma desacoplada.

- **Model**:  
  Camada responsável pela gestão das entidades do sistema, sejam elas persistentes ou não. Além disso, o **Model** encapsula as regras de validação e garante a integridade dos dados. No projeto, a classe `Tarefa` é um exemplo dessa camada, contendo validações como título e descrição obrigatórios.

---

### **Interação entre as Camadas**

A interação entre as camadas segue os princípios do **MVC** e do **Layered Architecture**:
1. O **Controller** recebe as requisições e delega a lógica de negócios para o **Service**.
2. O **Service** utiliza o **Repository** para acessar ou persistir informações e o **Model** para manipular as entidades.
3. O **Repository** abstrai os detalhes de armazenamento, permitindo que o restante do sistema permaneça desacoplado da implementação específica de persistência.
  
## Padrões de Projetos aplicados 

De acordo as funcionalidades, a nivel granular, podemos enxergar um CRUD Simples do qual a maioria dos frameworks como Quarkus, Spring Boot e demais, aplicam de forma declarativa - ou seja, sem deixar transparente ao programador que tais passos podem ser executados. Sendo assim, de modo a abstrair de forma sucinta o funcionamento dos frameworks e aplica-los ao cenário, podemos visualizar os seguintes padrões de projeto. (front- controller (fachada - inpicito), singleton, Multiton, flyweight, Builder)

### Criacionais 

#### Singleton  


##### Intenção

[^GAMMA]

Garantir que uma classe tenha somente uma instância e fornecer um ponto global de acesso para a mesma.

##### Motivação 

Considerando a visualização aquiterural em Layred Arquiteture citada anteriormente, é preciso que em cada camada adjacente a atual, adquira UMA UNICA INSTANCIA da camada que será utilizada para realizar a sua responsabilidade. Em Frameworks comuns, isso é feito de forma declarativa usando a anotação **@Autowired** - apos a delaração da camada, essa anotação injeta uma instancia da qual foi solicitada, ou simplismente sendo instanciada a partir do construtor ou criando uma constante da camada (Spring Boot) e no Quarkus nós temos a utilizaçao do **@Singleton**. No cenário atual - simulando a visualização, o padrão singleton se adequaria perfeitamente, uma vez que, nós garantimos haja injeção de uma unica instancia a qual será acessada pelo repositorio atual. Assim tal logica é aplicada para as camadas adjacentes.


##### Estrutura

 


## Praticas Aplicadas 

-  Solid
-  Dry

## Referencias:

[^GAMMA]: GAMMA, Erich. et al. Padrões de projetos: Soluções reutilizáveis de software orientados a objetos Bookman editora, 2009.
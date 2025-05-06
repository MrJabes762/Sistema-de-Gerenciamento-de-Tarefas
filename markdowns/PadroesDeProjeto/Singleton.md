
# Singleton  


## Intenção

[^GAMMA]
Garantir que uma classe tenha somente uma instância e fornecer um ponto global de acesso para a mesma.

---

## Motivação 

Considerando a visualização arquitetural em Layered Architecture citada anteriormente, é preciso que às camada adjacentes à atual, adquira **UMA ÚNICA INSTÂNCIA** da camada que será utilizada para realizar a sua responsabilidade. 

Em Frameworks comuns, isso é feito de forma declarativa usando a anotação **@Autowired** - apos a declaração da camada, essa anotação injeta uma instancia correspondente ou simplesmente sendo instanciada a partir do construtor ou criando uma constante da camada **Spring Boot** e **@Service** - Para a declaração de um serviço injetável.

Já no **Quarkus** nós temos a utilização da anotação **@Singleton** com o **@Inject**.

No cenário atual — ao simular essa visualização arquitetural — o padrão Singleton se encaixa perfeitamente, pois garante que apenas uma única instância seja injetada e acessada pelo repositório correspondente - o Singleton é construído e a injeção no cenário atual, é realizada pelo método privado setInstance(). Assim tal logica é aplicada para às camada adjacentes, resultando em um **Singleton em cascata** ou uma **Árvore de Singletons** - uma camada instancia a outra.

---

## Estrutura

**Exemplo Tarefa Service**

![EstruturaSingletonService](/out/estruturasUmls/java/service/estruturaTarefaService/estruturaTarefaService.png)

---

### Código:

[CodigoTarefaService](/src/main/java/service/TarefasService.java)

---

## Participantes

- Os clientes / classe acessam uma única instancia pela operação `getInstance()` do Tarefa Service, assim como, nela também possui a instancia de outras camadas que gerenciam serviços.

---

## Conclusão

O padrão Singleton, quando bem empregado, não apenas evita instâncias redundantes como estrutura a comunicação entre camadas com previsibilidade e economia de recursos. Em sistemas onde o controle de instância é vital — como em arquiteturas em camadas — o Singleton atua como guardião da unicidade e da ordem.

[Voltar Principal](../../README.md)

## Referências:

[^GAMMA]: GAMMA, Erich. et al. Padrões de projetos: Soluções reutilizáveis de software orientados a objetos Bookman editora, 2009.

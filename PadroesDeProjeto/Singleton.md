# Singleton  


## Intenção

[^GAMMA]

Garantir que uma classe tenha somente uma instância e fornecer um ponto global de acesso para a mesma.

## Motivação 

Considerando a visualização aquiterural em Layred Arquiteture citada anteriormente, é preciso que em cada camada adjacente a atual, adquira **UMA UNICA INSTANCIA** da camada que será utilizada para realizar a sua responsabilidade. Em Frameworks comuns, isso é feito de forma declarativa usando a anotação **@Autowired** - apos a delaração da camada, essa anotação injeta uma instancia da qual foi solicitada, ou simplismente sendo instanciada a partir do construtor ou criando uma constante da camada **(Spring Boot)** e no **Quarkus** nós temos a utilizaçao da anotação **@Singleton**(no nosso caso com o getInstance()) com o **@Inject** (no nosso caso setInstance()) . No cenário atual - simulando a visualização, o padrão singleton se adequaria perfeitamente, uma vez que, nós garantimos haja injeção de uma unica instancia a qual será acessada pelo repositorio atual. Assim tal logica é aplicada para as camadas adjacentes, resultando em um "Sigleton em Cascata" ou uma "Àrvore de Singletons" - uma camada instancia a outra.


## Estrutura (exemplo)

## Referencias:

[^GAMMA]: GAMMA, Erich. et al. Padrões de projetos: Soluções reutilizáveis de software orientados a objetos Bookman editora, 2009.

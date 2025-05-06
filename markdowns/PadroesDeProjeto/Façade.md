
# Façade

## Intenção

[^GAMMA]

Fornecer uma interface unificada para um conjunto de interfaces em um subsistema.
Façade define uma interface de nível mais alto que torna o subsistema mais fácil de ser usado.

---

## Motivação

[^GAMMA]

Estruturar um sistema em subsistemas ajuda a reduzir a complexidade. Um objetivo comum de todos os projetos é minimizar a comunicação e as dependências entre subsistemas. Uma maneira de atingir esse objetivo é introduzir um objeto façade (fachada), o qual fornece **uma interface única e simplificada para os recursos e facilidades mais gerais de um subsistema.**

Nesse sentido, em aplicações web, a fachada principal por onde o sistema recebe as solicitações é o **Front-Controller**. No contexto em questão, A camada `TarefasController`se comporta como um façade ,uma vez que, ela recebe as solicitações e delega a camada de serviço para tratar melhor as diferentes requisições com validação, acesso ao banco e manipulações, os quais são subsistemas - com responsabilidades Únicas gerenciados pelo serviço.

---

## Estrutura

![EstruturaFacade](/out/estruturasUmls/padrões/façade/facade/facade.png)

### Código

![CodigoTarefaController](/src/main/java/controller/TarefasController.java)

---

## Participantes

[^GAMMA] (Adaptado)
- Façade (Tarefas Controller)
    - conhece quais as classes do subsistema que são responsáveis pelo atendimento de uma solicitação;
    - delega solicitações de clientes a objetos apropriados do subsistema.
- Classes de subsistema (TarefasService, TarefasProxySecurityValidationSevice, TarefasRepository)
    - implementam a funcionalidade do subsistema;
    - encarregam-se do trabalho atribuído a elas pelo objeto Façade;
    - não têm conhecimento da façade; isto é, não mantêm referências para a mesma.
  
---

## Conclusão

O padrão Façade atua como um centralizador entre o mundo externo e as complexidades internas de um sistema, promovendo clareza, desacoplamento e manutenibilidade. 

No domínio apresentado, o TarefasController se posiciona como essa interface estratégica: simplifica o acesso, organiza a entrada de requisições e reduz o atrito entre as camadas.

Ao delegar responsabilidades específicas para serviços e repositórios especializados, a fachada mantém o princípio da separação de interesses e possibilita uma arquitetura mais coesa e robusta.

A Implementação reforça o princípio de encapsulamento arquitetural, onde cada camada exerce seu papel com mínima dependência contextual. Isso torna o sistema escalável, testável.

[Voltar Principal](index.md)

---

## Referências:

[^GAMMA]: GAMMA, Erich. et al. Padrões de projetos: Soluções reutilizáveis de software orientados a objetos Bookman editora, 2009.
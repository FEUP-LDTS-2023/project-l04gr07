## LDTS_<04><07> - <Huge Ice Cream>

O nosso jogo tem o nome "Huge Ice Cream" e é baseado no conhecido e divertido jogo do friv "Bad Ice cream", porém iremos realizar diversas mudanças de modo a tornar o jogo mais complexo e desafiante. Este jogo irá ter 3 modos: "Easy", "Medium" e "Hard" para que o utilizador possa escolher o nível de dificuldade que pretende jogar. Este jogo é composto por dois jogadores que têm como objetivo matar o monstro sem que ele os apanhe primeiro. Para isso, os jogadores terão de colecionar todas as frutas(Fruits) presentes no mapa do jogo. Após completarem esta tarefa, irá aparecer no mapa um cubo de gelo (IceCube) que os jogadores devem apanhar podendo, deste modo, entrar em modo "Huge Ice Cream". Este modo faz com que os dois jogadores se fundam num só e tenham uma nova funcionalidade: atirar bloquinhos de gelo. Neste modo, um dos jogadores irá controlar o movimento da personagem Ice Cream e o outro irá controlar o disparo dos bloquinhos de gelo. O objetivo nesta fase do jogo é matarem o monstro com os bloquinhos de gelo que este novo modo "Huge Ice Cream" lhe permite disparar. Assim, este é um jogo de extrema cooperação entre os dois jogadores o que torna o jogo muito mais desafiante. Como já referido, este jogo possui 3 níveis distintos de dificulddade que diferirem no número de monstros e a velocidade da movimentação dos mesmos, no número de frutas para colecionar e no design do mapa.

Este projeto foi realizado por Beatriz Bernardo (up202206097@fe.up.pt), Diana Nunes (up202208247@fe.up.pt) e Marta Silva (up202208258@fe.up.pt) para LDTS 2023/2024.


IMPLEMENTED FEATURES

- Chocolate IceCream - personagem controlada pelas setas do teclado;
- Strawberry IceCream - personagem contralada pelas teclas "WASD" do teclado;
- Fruits - fruitas que as personagens Chocolate IceCream e Strawberry IceCream vão apanhar para avançar no jogo. As frutas são geradas de modo diferente no mapa, tendo em conta o nível de dificuldade escolhido (por enquanto temos apenas 1 nível definido)

PLANNED FEATURES

- Monster - monstros que se movem pelo mapa de forma aleatória e tentam apanhar as personagens ice creams;
- Ice Cube - bloco de gelo que os ice cream vão apanhar para entrar em modo "Huge Ice Cream";
- Ice Shot - quando estão em modo "Huge Ice Cream" ao clicar na tecla "espaço" o jogador irá lançar blocos de gelo usados para matar o monstro;
- Huge Ice cream - quando estão em modo "Huge Ice Cream" a personagem é controlada pelas teclas "WASD" ,  sendo que a direção do Throw Ice vai ser controlada pelas setas do teclado.
- Reprodução de sons - sons distintos irão ser reproduzidos quando um evento específico acontecer. Por exemplo, quando os jogadores apanham as frutas ou quando disparam os cubinhos de gelo.

DESIGN

AS AÇÕES DOS PLAYERS SÃO DIFERENTES DEPENDENDO DO SEU ESTADO

Tivemos algumas dúvidas e dificuldades em decidir o comportamento dos players visto que os seus comportamentos mudam quando entram em modo "Huge Ice Cream". Neste modo os dois players fundem-se apenas num e têm funcionalidades diferentes, nomeadamente atirar cubos de gelo que permitem matar o monstro. Isto é uma violação do "Single Responsibility Principle" (SRP). Uma solução para este problema seria colocar toda esta lógica no mesmo método mas continuaríamos a não cumprir o SRP. 
Para contornar este problema decidimos aplicar então o State Pattern. Este pattern permite-nos representar os dois estados do jogo em subclasses distintas. De facto, vamos poder mudar para o estado "Huge Ice Cream" do jogo apenas mudando para outra implementação. Assim, vamos conseguir solucionar o problema, uma vez que utilizando o state pattern vamos conseguir controlar o comportamento dos jogadores de forma mais eficiente.
As classes podem ser encontradas nos ficheiros seguintes apesar da implementação ainda não estar completa:
- [Player1] (https://github.com/FEUP-LDTS-2023/project-l04gr07/blob/c1b38505419adf164a52ed3fa3533fe7b3a724e5/src/main/java/l04gr07/model/Game/FieldElements/Player1.java)
- [Player2] (https://github.com/FEUP-LDTS-2023/project-l04gr07/blob/c1b38505419adf164a52ed3fa3533fe7b3a724e5/src/main/java/l04gr07/model/Game/FieldElements/Player2.java)
- [HugeIceCreamState] (https://github.com/FEUP-LDTS-2023/project-l04gr07/blob/c1b38505419adf164a52ed3fa3533fe7b3a724e5/src/main/java/l04gr07/model/Game/FieldElements/PlayerState/HugeIceCreamState.java)
- [NormalPlayerState] (https://github.com/FEUP-LDTS-2023/project-l04gr07/blob/c1b38505419adf164a52ed3fa3533fe7b3a724e5/src/main/java/l04gr07/model/Game/FieldElements/PlayerState/NormalPlayerState.java)
- [PlayerState] (https://github.com/FEUP-LDTS-2023/project-l04gr07/blob/c1b38505419adf164a52ed3fa3533fe7b3a724e5/src/main/java/l04gr07/model/Game/FieldElements/PlayerState/PlayerState.java)
A implementação deste pattern trouxe-nos alguns benefícios, nomeadamente os estados que temos no nosso jogo ficaram explícitos no nosso código, tornando mais fácil de manusear e entender. A possível adição de um novo estado torna-se mais fácil, não afetando as classes que já existem. Este pattern leva ao aumento do número de classes, no entanto, é possível serem bem gerenciadas visto que não é um número muito grande.



ICE CUBE SÓ APARECE NA ARENA QUANDO TODAS AS FRUTAS SÃO COLETADAS

Deparamo-nos também com alguns desafios no que toca à implementação da lógica em que o IceCube é notificado quando todas as frutas são colecionadas pelos jogadores podendo, deste modo, aparecer no jogo. Este problema poderia ser solucionado definindo um mesmo método com diferentes implementações e argumentos (ad-hoc polymorphism), mas iria levar a um código muito mais desorganizado e difícil de manter e poderíamos não estar a cumprir o "Single Responsibility Principle" (SRP), pois iríamos estar a misturar a lógica de notificação com outras partes do código.
Decidimos então que a aplicação do design pattern Observer seria uma melhor solução para este problema. Assim, o IceCube será um "observer" que aguarda notificação de quando todas as frutas forem colecionadas, ficando assim separadas as lógicas de coleção de frutas e notificação do IceCube.
Este design pattern ainda não está presente no nosso código visto que o IceCube é ainda uma feature planeada, não tendo ainda sido implementada no nosso projeto.
A aplicação deste pattern traz vários benefícios nomeadamente, separar a lógica de coletar frutas da lógica de notificar IceCube tornando o código mais eficiente e fácil de ler. A possível adição de novos observers torna-se também mais fácil. Porém, a aplicação deste padrão leva-nos a ter de ter um maior cuidado a gerenciar corretamente os observers, evitando notificações desnecessárias, o que não é díficil visto que o IceCube só será notificado uma vez.

DIFERENTES SONS SÃO REPRODUZIDOS COM BASE NAS AÇÕES DOS JOGADORES

O nosso jogo requer a reprodução de sons em vários momentos distintos, por exemplo quando os jogadores apanham frutas, apanham o IceCub, disparam, etc. Tal como no problema anterior poderíamos implementar esta lógica de forma ad-hoc, ou seja, ao definir um mesmo método, mas com diferentes implementações e parâmetros. Porém, como já referido anteriormente isto iria levar a violações do Single Responsibility Pattern e tornava o código desorganizado e difícil de manter.
Para resolver esta situação voltamos a recorrer ao Observer Pattern que será utilizado para notificar o objeto da reprodução de um certo som quando certos eventos ocorrem. Este objeto atuará então como observer que espera por informação dos eventos específicos para reproduzir o som associado.
Neste contexto, este pattern também ainda não foi aplicado, visto que a reprodução de sons é uma feature que ainda não foi implementada no nosso jogo.
Tal como referido anteriormente este pattern traz-nos vários benefícios tais como separar a lógica do jogo da lógica de reprodução de sons e a adição de sons a cada evento específico torna-se mais fácil. É necessário haver maior cuidado em gerir corretamente os observers para não haver notificações desnecessários, porém o número de eventos é razoável pelo que não se torna difícil fazer a gestão correta.

ORGANIZAÇÃO CÓDIGO

Deparamo-nos com alguns problemas a respeito da organização arquitetural do nosso código. Tivemos a necessidade de realizar separação de responsabilidades em componentes principais de modo a facilita a manutenção e leitura do nosso código. 
Para isso utilizamos o architectural pattern Model-View-Controller(MVC). Este pattern permite dividir o código do jogo em 3 componentes principais cada uma com a sua responsabilidade específica. Assim, "Model" lida com a lógica do jogo e representa os dados, "Viewer" gere a forma como os dados presentes em "Model" vão ser mostrados, ou seja, a representação gráfica do jogo e envia as ações do usuário para "Controller" que irá gerenciar e interpretar estas ações. Deste modo, ao dividir o código nestas partes, conseguimos contornar o nosso problema, visto que se torna mais fácil de fazer mudanças e atualizações no jogo sem afetar outras partes do sistema. Para além disso, facilita também a criação de testes unitários para cada uma das componentes e facilita também a nossa colaboração em equipa visto que cada parte tem a sua responsabilidade específica.
As implementação pode ser encontradas nos ficheiros dos diretórios seguintes:
- model (https://github.com/FEUP-LDTS-2023/project-l04gr07/tree/c1b38505419adf164a52ed3fa3533fe7b3a724e5/src/main/java/l04gr07/model)
- view (https://github.com/FEUP-LDTS-2023/project-l04gr07/tree/c1b38505419adf164a52ed3fa3533fe7b3a724e5/src/main/java/l04gr07/view)
- control (https://github.com/FEUP-LDTS-2023/project-l04gr07/tree/c1b38505419adf164a52ed3fa3533fe7b3a724e5/src/main/java/l04gr07/control)
De modo geral este architectural pattern trouxe-nos vários benefícios, uma vez que nos permite ter uma estrutura mais organizada, facilitando o desenvolvimento do projeto. Para além disso, como realizamos muitas mudanças e atualizações no jogo este pattern é também umas mais valia.

A figura que representa o diagrama UML está presente no ficheiro seguinte:
https://github.com/FEUP-LDTS-2023/project-l04gr07/blob/de1047b29a661b3ef1659d33c4613df84d97ed51/docs/UML.png

KNOWN CODE SMELLS

LONG SWITCH STATES 

Na classe GameController o método processKey apresenta uma série de cases no método switch. De facto, ao ter dois jogadores tivemos a necessidade de criar comandos diferentes na movimentação de cada um deles o que levou a que este método implementasse uma estrutura "switch" muito longa, o que pode levar a dificuldades em estender o código se necessário.


LARGE CLASS

A class ReadMap pode ser um code smell de uma large class por ter diversas responsabilidades. De facto, esta classe vai ler o mapa de um ficheiro e criar todos os elementos do mapa desde paredes, frutas , etc. O que faz com que esta classe fica mais extensa e com diversos métodos.

A classe Field implementa também diversos métodos apesar de serem mais pequenos e de fácil compreensão. No entanto, pode ser também um indício de code smell já que iremos ter a tendencia de adicionar ainda mais métodos nesta classe à medida que vamos desenvolvendo o nosso projeto.


LAZY CLASSES

FruitView, IceCubeView e IceShotView são classes que não fazem muito e irão implementar métodos semelhantes. Talvez uma forma mais eficaz de fazer esta abordagem seria mover os seus métodos para outra classe, recorrendo a refactoring tools. 


TESTAR
https://github.com/FEUP-LDTS-2023/project-l04gr07/blob/c1b38505419adf164a52ed3fa3533fe7b3a724e5/docs/TestCoverage.png



AUTO-AVALIAÇÃO

Beatriz Bernardo: 33%
Diana Nunes: 33%
Marta Silva: 33%

# Chess System Java
## ♟️ Jogo de Xadrez ♟️

## Introdução
Projeto assistido e desenvolvido durante o Curso de Java Completo da plataforma Udemy através do Linkedin Prof. Dr. Nelio Alves. O repositório das minhas atividades no curso podem ser acessados aqui.

Este projeto consolida os conhecimentos adquiridos até o momento do curso (cerca da metade), que incluí, mas não se limitando a:

Classes: construtores padrões, atributos, encapsulamento, getters e setters, métodos da instância e da classe (estático), sobrecargas, classes reais e abstratas, etc;
Programação orientada a projetos, lógica e organização: herança, polimorfismo, sobrescrita de métodos, injeção de dependência, associações, encapsulamento, enumeração, downcasting, upcasting, padrão de camadas, tratamento de exceções, listas, matrizes, estruturas sequenciais, repetitivas (for e while) e condicionais (if-else e ternários), diagrama UML, versionamento do código, código limpo, etc;

## Design do projeto

O projeto baseia-se em duas camadas: Board layer e Chess layer. O tabuleiro é uma matriz. Cada elemento da matriz contém ou não uma peça. Porém, a forma como acessamos esta matriz é diferente entre as camadas. Na camada Board layer temos todas as lógicas de controle do tabuleiro. Os índices da matriz são os números inteiros correspondentes aos índices das listas. Temos a classe Position que representa uma posição da matriz. A classe abstrata Piece representa a peça na matriz através da Position e os métodos abstratos de movimentos possíveis. A classe Board descreve o tabuleiro fisicamente e seu estado. Por fim, nesta camada temos a classe BoardException para tratar exceções do tabuleiro.

A camada Chess layer agrupa todos as peças do tabuleiro (King, Bishop, Knight, Pawn, Queen, Rook) que são entidades (classes) que estende da classe abstrata ChessPiece, e esta estende da classe Piece da outra camada. Logo, cada peça herda os atributos e métodos das super classes. Cada peça implementa suas regras de movimentos e jogadas especiais (se houver). A lógica de controle do jogo (check mate) está na classe ChessMatch desta camada que incluem, também, o tratamento das exceções através da classe ChessException o enum Color e a classe ChessPosition. Nesta camada, os índices da matriz são acessados com a regra amigável da UI, isto é, através de letras e números. As letras de a a h representam as colunas e os números de 1 a 8 as linhas do tabuleiro. Então se faz a necessidade conversão entre as coordenadas do tabuleiro.


A seguir, o diagrama UML do projeto (créditos do material do curso):
![chess-system-design](https://github.com/GbragaDev/chess-system-java/assets/80852288/c9a80ea0-341e-4233-82e3-64049137be01)

## Ambiente de desenvolvimento e execução

O projeto foi desenvolvido na IDE Intelijj versão 2022-14 (4.26.0), Linux Ubuntu 22.04 LTS e Java OpenJDK 21. Mas pode ser executado também em versões superiores.

O programa pode ser executado diretamente do console da IDE ou na linha de comando do terminal.

Para executar diretamente no terminal, utilize o arquivo exportado do projeto *chess-system-java.jar.* Da pasta raiz do repositório clonado, execute:

> java -cp exported/chess-system-java.jar application.Program

*Lembrando que é necessário ter o Java instalado na máquina na versão 11 ou superior.*

A tela do programa deve ser executado semelhante ao mostrado a seguir:
![tela](https://github.com/GbragaDev/chess-system-java/assets/80852288/5955149a-0550-478f-9bea-ddbe8315a3fb)

O turno começa com as peças Brancas (WHITE). A UI do programa solicita a entrada de origem da peça a mover (Source). Exemplo: "a2" seleciona o Peão Branco da posição A2. Confirme com ENTER e então o programa solicitará a o destino (Target) da nova posição da peça, exemplo "a4". Observe que o programa já mostra quais movimentos possíveis da peça e trata possíveis erros de movimentação. Depois de uma movimentação válida do atual jogador segue-se para o movimento do opositor, ou seja, da peça preta (BLACK). Concluída o turno, segue-se para o próximo repetindo-se a sequência. As peças capturadas são mostradas em todas a rodadas.

// Define o pacote ao qual a classe Board pertence.
package boardgame;

import chess.pieces.King;

// Declaração da classe Board, que representa o tabuleiro do jogo.
public class Board {
    // Variáveis privadas para armazenar o número de linhas e colunas do tabuleiro.
    private int rows;
    private int columns;

    // Matriz bidimensional para armazenar as peças do jogo.
    private Piece[][] pieces;

    // Construtor da classe Board. Inicializa o tabuleiro com o número especificado de linhas e colunas.
    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board : there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    // Método getter para retornar o número de linhas do tabuleiro.
    public int getRows() {
        return rows;
    }

    /* Metodo setter retirado para que a quantidade de linhas não seja alterada

    public void setRows(int rows) {
        this.rows = rows;

    }
*/
    // Método getter para retornar o número de colunas do tabuleiro.
    public int getColumns() {
        return columns;
    }


    /*
        Método setter retirado para nao alterar o número de colunas

        public void setColumns(int columns) {
        this.columns = columns;

    }
*/

    // Método para retornar uma peça do tabuleiro na posição dada pelas linhas e colunas.
    public Piece piece(int rows, int columns) {
        // Verifica se a posição está dentro dos limites do tabuleiro.
        if (!positionExists(rows, columns)) {
            // Lança uma exceção se a posição não estiver no tabuleiro.
            throw new BoardException("Position not on the board");
        }
        return pieces[rows][columns];
    }

    // Método sobrecarregado para retornar uma peça do tabuleiro dada uma posição.
    public Piece piece(Position position) {
        // Verifica se a posição está dentro dos limites do tabuleiro.
        if (!positionExists(position)) {
            // Lança uma exceção se a posição não estiver no tabuleiro.
            throw new BoardException("Position not on the board");
        }
        // Retorna a peça na posição especificada.
        return pieces[position.getRow()][position.getColumn()];
    }

    // Método para colocar uma peça em uma determinada posição no tabuleiro.


    // Método privado para verificar se uma posição existe no tabuleiro com base em suas coordenadas de linha e coluna.
    private boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    // Método público para verificar se uma posição existe no tabuleiro usando um objeto Position.
    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    // Método para verificar se há uma peça em uma determinada posição do tabuleiro.
    public boolean thereIsAPiece(Position position) {
        // testa se a posição existe e lança a exceção antes de retornar se há uma peça na position
        if (!positionExists(position)) {
            throw new BoardException("Theres already a piece on position" + position);
        }
        return piece(position) != null;
        // Verifica se a posição não é nula.

    }

    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("Theres already a piece on position" + position);

        }

        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }


}

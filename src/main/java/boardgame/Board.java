// Define o pacote ao qual a classe Board pertence.
package boardgame;

// Declaração da classe Board, que representa o tabuleiro do jogo.
public class Board {
    // Variáveis privadas para armazenar o número de linhas e colunas do tabuleiro.
    private int rows;
    private int columns;

    // Matriz bidimensional para armazenar as peças do jogo.
    private Piece[][] pieces;

    // Construtor da classe Board. Inicializa o tabuleiro com o número especificado de linhas e colunas.
    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }
    // Método getter para retornar o número de linhas do tabuleiro.
    public int getRows() {
        return rows;
    }

    // Método setter para definir o número de linhas do tabuleiro.
    public void setRows(int rows) {
        this.rows = rows;
    }

    // Método getter para retornar o número de colunas do tabuleiro.
    public int getColumns() {
        return columns;
    }

    // Método setter para definir o número de colunas do tabuleiro.
    public void setColumns(int columns) {
        this.columns = columns;
    }

    // Método para retornar uma peça do tabuleiro na posição dada pelas linhas e colunas.
    public Piece piece(int rows, int columns) {
        return pieces[rows][columns];
    }

    // Método sobrecarregado para retornar uma peça do tabuleiro dada uma posição.
    public Piece piece(Position position) {
        return pieces[position.getRow()][position.getColumn()];
    }

    // Método para colocar uma peça em uma determinada posição no tabuleiro.
    public void placePiece(Piece piece, Position position) {
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }
    // Método privado para verificar se uma posição existe no tabuleiro com base em suas coordenadas de linha e coluna.
    private boolean positionExists( int row, int column){
            return row >= 0 && row < rows && column >= 0 && column < columns;
        }

    // Método público para verificar se uma posição existe no tabuleiro usando um objeto Position.
        public boolean positionExists (Position position){
            return positionExists(position.getRow(),position.getColumn());
        }


    }


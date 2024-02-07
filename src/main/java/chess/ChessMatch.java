package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;


public class ChessMatch {
    // Declara uma variável privada do tipo Board para representar o tabuleiro de xadrez.
    private Board board;


    // Construtor da classe ChessMatch. É chamado ao criar uma nova partida de xadrez.
    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
        // Chama o método initialSetup para configurar as peças no tabuleiro no início do jogo.

    }
    // Método para retornar uma matriz bidimensional de peças de xadrez.
    public ChessPiece[][] getpieces() {
        // Cria uma nova matriz de objetos ChessPiece baseada nas dimensões do tabuleiro.
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        // Itera sobre todas as linhas do tabuleiro.
        for (int i = 0; i < board.getRows(); i++) {
            // Itera sobre todas as linhas do tabuleiro.
            for (int j = 0; j < board.getColumns(); j++) {
                // Armazena a peça de xadrez atual na matriz após fazer o downcast para ChessPiece.
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        // Retorna a matriz de peças de xadrez.
        return mat;

    }

    private void initialSetup(){
        //Cria as peças no Tabuleiro com Cor e Posição
        board.placePiece(new Rook(board,Color.WHITE),new Position(2,1));
        board.placePiece(new King(board,Color.BLACK),new Position(0,4));
        board.placePiece(new King(board,Color.WHITE),new Position(7,4));

    }

}


package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.ChessException;
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

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        Piece capturedPiece = makeMove(source,target);
        return (ChessPiece) capturedPiece;
    }

    private Piece makeMove(Position source ,Position target){
        Piece p = board.removePiece(source);
        Piece capturedPiece =board.removePiece(target);
        board.placePiece(p, target);
        return capturedPiece;
    }

    private void validateSourcePosition(Position position){
        if(!board.thereIsAPiece(position)){
            throw new ChessException("Theres is no piece on source position");
        }
    }

    private void placeNewPiece(char column ,int row ,ChessPiece piece){
        board.placePiece(piece,new ChessPosition(column, row).toPosition());
    }


    private void initialSetup(){
        //Cria as peças no Tabuleiro com Cor e Posição

        placeNewPiece('c',1, new Rook(board,Color.WHITE));
        placeNewPiece('c',2, new Rook(board,Color.WHITE));
        placeNewPiece('d',2, new Rook(board,Color.WHITE));
        placeNewPiece('e',2, new Rook(board,Color.WHITE));
        placeNewPiece('e',1, new Rook(board,Color.WHITE));
        placeNewPiece('d',1, new King(board,Color.WHITE));

        placeNewPiece('c',7, new Rook(board,Color.BLACK));
        placeNewPiece('c',8, new Rook(board,Color.BLACK));
        placeNewPiece('d',7, new Rook(board,Color.BLACK));
        placeNewPiece('e',7, new Rook(board,Color.BLACK));
        placeNewPiece('e',8, new Rook(board,Color.BLACK));
        placeNewPiece('d',8, new King(board,Color.BLACK));

            }

        }


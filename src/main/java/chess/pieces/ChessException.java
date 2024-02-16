package chess.pieces;

import java.io.Serial;

public class ChessException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -2475766435846487326L;

    public ChessException(String message) {
        super(message);
    }
}

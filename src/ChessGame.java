public class ChessGame {
    private ChessBoard board;
    private boolean whiteTurn;
    private Position selectedPosition;
    private boolean gameOver;

    public ChessGame() {
        board = new ChessBoard();
        whiteTurn = true;
        gameOver = false;
    }

    public ChessBoard getBoard() {
        return board;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public PieceColor getCurrentPlayerColor() {
        return whiteTurn ? PieceColor.WHITE : PieceColor.BLACK;
    }

    public void resetGame() {
        board = new ChessBoard();
        whiteTurn = true;
        selectedPosition = null;
        gameOver = false;
    }

    public boolean handleSquareSelection(int row, int col) {
        if (gameOver) return false;

        Piece piece = board.getPiece(row, col);
        if (selectedPosition == null) {
            if (piece != null && piece.getColor() == getCurrentPlayerColor()) {
                selectedPosition = new Position(row, col);
                return false;
            }
        } else {
            Position target = new Position(row, col);
            Piece selectedPiece = board.getPiece(selectedPosition.getRow(), selectedPosition.getColumn());
            Piece targetPiece = board.getPiece(target.getRow(), target.getColumn());

            if (selectedPiece != null && selectedPiece.isValidMove(target, board.getBoard())) {
                if (targetPiece instanceof King) {
                    gameOver = true;
                }

                board.movePiece(selectedPosition, target);
                whiteTurn = !whiteTurn;
                selectedPosition = null;
                return true;
            }
            selectedPosition = null;
        }
        return false;
    }
}

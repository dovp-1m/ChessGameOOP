import java.util.List;
import java.util.ArrayList;

public class ChessGame {
    private ChessBoard board;
    private Boolean whiteTurn = true;

    public ChessGame() {
        this.board = new ChessBoard();
    }

    public ChessBoard getBoard() {
        return this.board;
    }

    public void resetGame(){
        this.board = new ChessBoard();
        this.whiteTurn = true;
    }

    public PieceColor getCurrentPlayerColor() {
        return whiteTurn ? PieceColor.WHITE : PieceColor.BLACK;
    }

    private Position selectedPosition;

    public boolean isPieceSelected() {
        return selectedPosition != null;
    }

    public boolean handleSquareSelection(int row, int col){
        return false;
    }

    public boolean makeMove(Position start, Position end) {
        return false;
    }

    public boolean  isInCheck(PieceColor kingColor) {
        return false;
    }

    private Position findKingPosition(PieceColor color) {
        throw new RuntimeException("King not found.");
    }

    public boolean isCheckmate(PieceColor kingColor) {
        if (!isInCheck(kingColor)) {
            return false;
        }
        return true;
    }

    private boolean isPositionOnBoard(Position position) {
        return position.getRow() >= 0 && position.getRow() < board.getBoard().length &&
                position.getColumn() >= 0 && position.getColumn() < board.getBoard()[0].length;
    }

    private boolean wouldBeInCheckAfterMove(PieceColor kingColor, Position from, Position to) {
        return inCheck;
    }

    public List<Position> getLegalMovesForPieceAt(Position position) {
        return legalMoves;
    }

    private void addLineMoves(Position position, int[][] directions, List<Position> legalMoves) {
    }

    private void addSingleMoves(Position position, int[][] moves, List<Position> legalMoves){

    }

    private void addPawnMoves(Position position, PieceColor color, List<Position> legalMoves){

    }
}

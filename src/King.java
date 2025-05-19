public class King extends Piece {
    public King(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        int rowDiff = Math.abs(position.getRow() - newPosition.getRow());
        int colDiff = Math.abs(position.getColumn() - newPosition.getColumn());

        if (rowDiff <= 1 && colDiff <= 1) {
            Piece target = board[newPosition.getRow()][newPosition.getColumn()];
            return target == null || target.getColor() != color;
        }

        return false;
    }
}

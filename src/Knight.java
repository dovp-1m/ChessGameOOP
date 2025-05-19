public class Knight extends Piece {
    public Knight(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        int rowDiff = Math.abs(position.getRow() - newPosition.getRow());
        int colDiff = Math.abs(position.getColumn() - newPosition.getColumn());

        if ((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2)) {
            Piece target = board[newPosition.getRow()][newPosition.getColumn()];
            return target == null || target.getColor() != color;
        }

        return false;
    }
}

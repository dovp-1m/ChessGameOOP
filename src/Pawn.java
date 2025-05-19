public class Pawn extends Piece {
    public Pawn(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        int direction = (color == PieceColor.WHITE) ? -1 : 1;
        int startRow = (color == PieceColor.WHITE) ? 6 : 1;

        int rowDiff = newPosition.getRow() - position.getRow();
        int colDiff = Math.abs(newPosition.getColumn() - position.getColumn());

        // Standard move
        if (colDiff == 0) {
            if (rowDiff == direction && board[newPosition.getRow()][newPosition.getColumn()] == null) {
                return true;
            }
            // Double move from start
            if (position.getRow() == startRow && rowDiff == 2 * direction &&
                    board[position.getRow() + direction][position.getColumn()] == null &&
                    board[newPosition.getRow()][newPosition.getColumn()] == null) {
                return true;
            }
        }

        // Diagonal capture
        if (colDiff == 1 && rowDiff == direction) {
            Piece target = board[newPosition.getRow()][newPosition.getColumn()];
            return target != null && target.getColor() != color;
        }

        return false;
    }
}

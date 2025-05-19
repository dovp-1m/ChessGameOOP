public class Queen extends Piece {
    public Queen(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        int rowDiff = Math.abs(position.getRow() - newPosition.getRow());
        int colDiff = Math.abs(position.getColumn() - newPosition.getColumn());

        if (rowDiff == colDiff || position.getRow() == newPosition.getRow() || position.getColumn() == newPosition.getColumn()) {
            int rowStep = Integer.compare(newPosition.getRow(), position.getRow());
            int colStep = Integer.compare(newPosition.getColumn(), position.getColumn());

            int row = position.getRow() + rowStep;
            int col = position.getColumn() + colStep;

            while (row != newPosition.getRow() || col != newPosition.getColumn()) {
                if (board[row][col] != null) return false;
                row += rowStep;
                col += colStep;
            }

            Piece target = board[newPosition.getRow()][newPosition.getColumn()];
            return target == null || target.getColor() != color;
        }

        return false;
    }
}

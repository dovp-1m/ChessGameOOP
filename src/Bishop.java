public class Bishop extends Piece {
    public Bishop(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        int rowDiff = Math.abs(position.getRow() - newPosition.getRow());
        int colDiff = Math.abs(position.getColumn() - newPosition.getColumn());

        if (rowDiff != colDiff) return false;

        int rowStep = (newPosition.getRow() > position.getRow()) ? 1 : -1;
        int colStep = (newPosition.getColumn() > position.getColumn()) ? 1 : -1;

        for (int i = 1; i < rowDiff; i++) {
            int row = position.getRow() + i * rowStep;
            int col = position.getColumn() + i * colStep;
            if (board[row][col] != null) return false;
        }

        Piece target = board[newPosition.getRow()][newPosition.getColumn()];
        return target == null || target.getColor() != color;
    }
}

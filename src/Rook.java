public class Rook extends Piece {
    public Rook(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        int startRow = position.getRow();
        int startCol = position.getColumn();
        int endRow = newPosition.getRow();
        int endCol = newPosition.getColumn();

        if (startRow != endRow && startCol != endCol) return false;

        int rowStep = Integer.compare(endRow, startRow);
        int colStep = Integer.compare(endCol, startCol);

        int row = startRow + rowStep;
        int col = startCol + colStep;

        while (row != endRow || col != endCol) {
            if (board[row][col] != null) return false;
            row += rowStep;
            col += colStep;
        }

        Piece target = board[endRow][endCol];
        return target == null || target.getColor() != color;
    }
}

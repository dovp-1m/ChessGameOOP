public class ChessBoard {
    private Piece[][] board;

    public ChessBoard() {
        this.board = new Piece[8][8];
        setupPieces();
    }

    public Piece[][] getBoard() {
        return board;
    }

    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
        if (piece != null) {
            piece.setPosition(new Position(row, col));
        }
    }

    private void setupPieces() {
        // Black pieces
        board[0][0] = new Rook(PieceColor.BLACK, new Position(0, 0));
        board[0][1] = new Knight(PieceColor.BLACK, new Position(0, 1));
        board[0][2] = new Bishop(PieceColor.BLACK, new Position(0, 2));
        board[0][3] = new Queen(PieceColor.BLACK, new Position(0, 3));
        board[0][4] = new King(PieceColor.BLACK, new Position(0, 4));
        board[0][5] = new Bishop(PieceColor.BLACK, new Position(0, 5));
        board[0][6] = new Knight(PieceColor.BLACK, new Position(0, 6));
        board[0][7] = new Rook(PieceColor.BLACK, new Position(0, 7));
        for (int col = 0; col < 8; col++) {
            board[1][col] = new Pawn(PieceColor.BLACK, new Position(1, col));
        }

        // White pieces
        board[7][0] = new Rook(PieceColor.WHITE, new Position(7, 0));
        board[7][1] = new Knight(PieceColor.WHITE, new Position(7, 1));
        board[7][2] = new Bishop(PieceColor.WHITE, new Position(7, 2));
        board[7][3] = new Queen(PieceColor.WHITE, new Position(7, 3));
        board[7][4] = new King(PieceColor.WHITE, new Position(7, 4));
        board[7][5] = new Bishop(PieceColor.WHITE, new Position(7, 5));
        board[7][6] = new Knight(PieceColor.WHITE, new Position(7, 6));
        board[7][7] = new Rook(PieceColor.WHITE, new Position(7, 7));
        for (int col = 0; col < 8; col++) {
            board[6][col] = new Pawn(PieceColor.WHITE, new Position(6, col));
        }
    }

    public void movePiece(Position start, Position end) {
        Piece piece = getPiece(start.getRow(), start.getColumn());
        if (piece != null && piece.isValidMove(end, board)) {
            setPiece(end.getRow(), end.getColumn(), piece);
            setPiece(start.getRow(), start.getColumn(), null);
        }
    }
}

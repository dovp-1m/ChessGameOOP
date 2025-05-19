public abstract class Piece {
    protected PieceColor color;
    protected Position position;

    public Piece(PieceColor color, Position position) {
        this.color = color;
        this.position = position;
    }



    public PieceColor getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract boolean isValidMove(Position newPosition, Piece[][] board);

    public String getSymbol() {
        return switch (this.getClass().getSimpleName()) {
            case "Pawn" -> color == PieceColor.WHITE ? "♙" : "♟";
            case "Rook" -> color == PieceColor.WHITE ? "♖" : "♜";
            case "Knight" -> color == PieceColor.WHITE ? "♘" : "♞";
            case "Bishop" -> color == PieceColor.WHITE ? "♗" : "♝";
            case "Queen" -> color == PieceColor.WHITE ? "♕" : "♛";
            case "King" -> color == PieceColor.WHITE ? "♔" : "♚";
            default -> "?";
        };
    }
}

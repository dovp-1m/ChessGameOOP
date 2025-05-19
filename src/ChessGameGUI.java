import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChessGameGUI extends JFrame {
    private final ChessSquareComponent[][] squares = new ChessSquareComponent[8][8];
    private final ChessGame game = new ChessGame();
    private final List<Position> highlightedPositions = new ArrayList<>();

    public ChessGameGUI() {
        setTitle("Chess Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 8));
        initializeBoard();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                ChessSquareComponent square = new ChessSquareComponent(row, col);
                int finalRow = row;
                int finalCol = col;

                square.addActionListener(e -> {
                    if (!game.isGameOver()) {
                        if (game.handleSquareSelection(finalRow, finalCol)) {
                            clearHighlights();
                            refreshBoard();

                            if (game.isGameOver()) {
                                String winner = (game.getCurrentPlayerColor() == PieceColor.WHITE ? "Black" : "White");
                                int option = JOptionPane.showConfirmDialog(
                                        ChessGameGUI.this,
                                        winner + " wins! Play again?",
                                        "Game Over",
                                        JOptionPane.YES_NO_OPTION
                                );

                                if (option == JOptionPane.YES_OPTION) {
                                    restartGame();
                                } else {
                                    System.exit(0);
                                }
                            }
                        } else {
                            highlightValidMoves(finalRow, finalCol);
                        }
                    }
                });

                squares[row][col] = square;
                add(square);
            }
        }
        refreshBoard();
    }

    private void highlightValidMoves(int row, int col) {
        clearHighlights();
        Piece piece = game.getBoard().getPiece(row, col);
        if (piece != null && piece.getColor() == game.getCurrentPlayerColor()) {
            Piece[][] boardState = game.getBoard().getBoard();
            for (int r = 0; r < 8; r++) {
                for (int c = 0; c < 8; c++) {
                    Position target = new Position(r, c);
                    if (piece.isValidMove(target, boardState)) {
                        squares[r][c].highlight();
                        highlightedPositions.add(target);
                    }
                }
            }
        }
    }

    private void clearHighlights() {
        for (Position pos : highlightedPositions) {
            squares[pos.getRow()][pos.getColumn()].clearHighlight();
        }
        highlightedPositions.clear();
    }

    private void restartGame() {
        game.resetGame();
        clearHighlights();
        refreshBoard();
    }

    private void refreshBoard() {
        Piece[][] boardState = game.getBoard().getBoard();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = boardState[row][col];
                if (piece != null) {
                    String symbol = piece.getSymbol();
                    Color pieceColor = piece.getColor() == PieceColor.WHITE ? Color.WHITE : Color.BLACK;
                    squares[row][col].setPieceSymbol(symbol, pieceColor);
                } else {
                    squares[row][col].clearPieceSymbol();
                }
                squares[row][col].clearHighlight();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChessGameGUI::new);
    }
}

import javax.swing.*;
import java.awt.*;

public class ChessSquareComponent extends JButton {
    private final int row;
    private final int col;
    private boolean isHighlighted = false;

    public ChessSquareComponent(int row, int col) {
        this.row = row;
        this.col = col;
        initButton();
    }

    private void initButton() {
        setPreferredSize(new Dimension(80, 80));
        updateColor();
        setFont(new Font("Serif", Font.BOLD, 36));
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void setPieceSymbol(String symbol, Color color) {
        setText(symbol);
        setForeground(color);
    }

    public void clearPieceSymbol() {
        setText("");
    }

    public void highlight() {
        isHighlighted = true;
        updateColor();
    }

    public void clearHighlight() {
        isHighlighted = false;
        updateColor();
    }

    private void updateColor() {
        if (isHighlighted) {
            setBackground(Color.YELLOW);
        } else {
            setBackground((row + col) % 2 == 0 ? Color.LIGHT_GRAY : new Color(205, 133, 63));
        }
    }
}

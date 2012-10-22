import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Cell extends JPanel
{
    private static final long serialVersionUID = 1L;
    private static final int B_W = 416; // Board Width
    private static final int B_H = 416; // Board Height
    private Image img;
    private int row=1;
    private int col=1;

    Cell(int r, int c) {
        row = r; col = c;
        cell.setPreferredSize(new Dimension(B_W/8, B_H/8));
        ChessPiece
        for (Map.Entry<String, String> entry : pieceToImageName.entrySet()) {
            String path = piecePath + entry.getValue();;
            ImageIcon icon = new ImageIcon(path);
            // System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
            imageMap.put(entry.getKey(), icon);
        }
    }
}

class Board extends JPanel
{
    // to prevent compiler warning
    private static final long serialVersionUID = 1L;
    private static final int B_W = 416; // Board Width
    private static final int B_H = 416; // Board Height
    private final int S_X = 100; // Start X
    private final int S_Y = 100;
    private final int DIM = 8;
    Board(JPanel pnl) {
        super();
        JPanel board = new JPanel(new GridLayout(8,8));
        board.setPreferredSize(new Dimension(B_W, B_H));
        board.setBorder(BorderFactory.createLineBorder (Color.black, 2));
        JPanel [][] cell = new JPanel[DIM][DIM];
        for(int row=0; row < DIM; row++) {
            int alt = (row % 2);
            for(int col = 0; col < DIM; col++) {
                alt++;
                cell[row][col] = new Cell(row, col);
                if((alt % 2) == 0) {
                    cell[row][col].setBackground(new Color(139, 69, 29));
                }
                else {
                    // White
                    cell[row][col].setBackground(new Color(230, 230, 230));
                }
                cell[row][col].revalidate();
                cell[row][col].repaint();
                board.add(cell[row][col]);
            }
        }
        pnl.add(board);
    }
}

class ChessBoard extends JFrame
{
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static final int B_W = 416; // Board Width
    private static final int B_H = 416; // Board Height
    private Container c;
    ChessBoard() {
        super();
        c = getContentPane();
        setBounds(0, 0, WIDTH+200, HEIGHT+200);
        setBackground(new Color(204, 204, 204));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("DeepChess");
        setResizable(false);
        // Create a new JPanel.
        JPanel pnl = new JPanel();
        pnl.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        pnl.setBackground(new Color(255, 255, 255));
        Board board = new Board(pnl);
        pnl.add(board);
        c.add(pnl);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        // Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ChessBoard();
            }
        });

    }
}
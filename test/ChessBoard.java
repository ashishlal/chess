import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
 
class Cell extends JPanel
{
    private static final long serialVersionUID = 1L;
    private static final int B_W = 416; // Board Width
    private static final int B_H = 416; // Board Height
    private Image img;
    private int row=1;
    private int col=1;
    private String name;
    private Map<String, JLabel> piece = new HashMap<String, JLabel>();

    Cell(int r, int c) {
        row = r+1; col = c+1;
        name = Global.getCellName(row, col);
        setPreferredSize(new Dimension(B_W/8, B_H/8));

        for (Map.Entry<String, ImageIcon> entry : Global.getImageMap().entrySet()) {
            JLabel imgLbl = new JLabel(Global.getImageIcon(entry.getKey()));
            piece.put(entry.getKey(), imgLbl);
            add(imgLbl);
            piece.get(entry.getKey()).setVisible(false);
        }
    }
    public String getCellName() { return name; }
    public void drawPiece(String n)
    {
        for (Map.Entry<String, JLabel> entry : piece.entrySet()) {
            entry.getValue().setVisible(false);
            //System.out.println("Key : " + entry.getKey() + " n : " + n);
            if(entry.getKey().equals(n)) {
                piece.get(entry.getKey()).setVisible(true);
            }
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
    private final int WHITE=0;
    private final int BLACK=1;
    private final int COLORS=2; // WHITE AND BLACK
    private final int NUM_PIECES=16; // total pieces of a color
    Cell [][] cell;
    Board(JPanel pnl) {
        super();
        JPanel board = new JPanel(new GridLayout(8,8));
        board.setPreferredSize(new Dimension(B_W, B_H));
        board.setBorder(BorderFactory.createLineBorder (Color.black, 2));
        //ChessPiece [][] chessPiece = new ChessPiece[COLORS][NUM_PIECES];
        cell = new Cell[DIM][DIM];
        allocateChessPieces();
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
        drawChessPieces();
        pnl.add(board);
    }
    public void allocateChessPieces()
    {
        Global.setImageMap();
        Global.setCellRowColToName();
        Global.setPieceInitialPositions();
    }
    public void drawChessPieces()
    {
        for(int row=0; row < DIM; row++) {
            for(int col = 0; col < DIM; col++) {
                String cellName = cell[row][col].getCellName();
                System.out.println("CellName : " + cellName + " global name : " + Global.getPiecePositionByRowCol(row, col));
                if(Global.getPiecePositionByRowCol(row+1, col+1).equals(cellName)) {
                    cell[row][col].drawPiece(Global.getPieceNameByPosition(cellName));
                }
            }
        }
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
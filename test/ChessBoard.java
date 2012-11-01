import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

class Cell extends JPanel
{
    private static final long serialVersionUID = 1L;
    private static final int C_W = 52; // Board Width
    private static final int C_H = 52; // Board Height
    private Image img;
    private int row=1;
    private int col=1;
    private String name;
    private Map<String, JLabel> piece = new HashMap<String, JLabel>();
    private Point locationOnScreen;

    Cell(int r, int c) {
        row = 8-r; col = c+1;
        name = Global.getCellName(row, col);
        setPreferredSize(new Dimension(C_W, C_H));

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
    public void hidePiece(String n)
    {
        for (Map.Entry<String, JLabel> entry : piece.entrySet()) {
            //System.out.println("Key : " + entry.getKey() + " n : " + n);
            if(entry.getKey().equals(n)) {
                piece.get(entry.getKey()).setVisible(false);
            }
        }
    }
    public void hideAllPieces()
    {
        for (Map.Entry<String, JLabel> entry : piece.entrySet()) {
            //System.out.println("Key : " + entry.getKey() + " n : " + n);
            piece.get(entry.getKey()).setVisible(false);
        }
    }
    public void setScreenLocation()
    {
        locationOnScreen = getLocationOnScreen();
        //System.out.println("[" + row + "]" + "[" + col + "]" + " X : " + locationOnScreen.x + " ptY : " + locationOnScreen.y);
    }
    public Point getScreenLocation()
    {
        return locationOnScreen;
    }
    public int doesPointBelongToCell(int x1, int y1)
    {
        if(
              (x1 >= locationOnScreen.x) 
           && (y1 >= locationOnScreen.y) 
           && (x1 < (locationOnScreen.x + 51))
           && (y1 < (locationOnScreen.y + 51))
        ) {
            return 1;
        }
        return 0;
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
    private int [] underCheck = new int[2];
    private int colorToMove = WHITE;
    private int checkMate = 0;

    Cell [][] cell;
    Board(JPanel pnl) {
        super();
        underCheck[WHITE] = 0; underCheck[BLACK]=0;
        JPanel board = new JPanel(new GridLayout(8,8));
        board.setPreferredSize(new Dimension(B_W, B_H));
        //board.setBounds(0, 0, B_W, B_H);
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
                cell[row][col].hideAllPieces();
                String cellName = cell[row][col].getCellName();
                //System.out.println("CellName : " + cellName + " global name : " + Global.getPiecePositionByRowCol(row, col));
                if(Global.getPiecePositionByRowCol(8-row, col+1).equals(cellName)) {
                    cell[row][col].drawPiece(Global.getPieceNameByPosition(cellName));
                }
            }
        }
    }
    public void setCellLocations()
    {
        for(int row=0; row < DIM; row++) {
            for(int col = 0; col < DIM; col++) {
                cell[row][col].setScreenLocation();
            }
        }
    }
    public String getCellNameByScreenLocation(int x1, int y1)
    {
        for(int row=0; row < DIM; row++) {
            for(int col = 0; col < DIM; col++) {
                if(cell[row][col].doesPointBelongToCell(x1, y1) == 1) {
                    return cell[row][col].getCellName();
                }
            }
        }
        return "";
    }
    public void movePiece(String fromCell, String toCell)
    {
        System.out.println("movePiece: Move from : " + fromCell + " to : " + toCell);
        // if already checkmate all moves are invalid
        if(checkMate == 1) {
            System.out.println("movePiece: CheckMate");
            return;
        }

        // See if a chess piece is found in fromCell
        String piece = Global.getPieceNameByPosition(fromCell);
        if(piece.equals("")) {
            System.out.println("movePiece: No piece at" + fromCell);
            return;
        }
        int index = Global.getPieceIndexByPosition(fromCell);
        if(index == -1) {
            System.out.println("movePiece: Invalid Index");
            return;
        }
        // If the king of this piece is under check you cannot
        // move any other piece
        int pieceColor = Global.getPieceColorAtPosition(fromCell);
        if(colorToMove != pieceColor) {
            System.out.println("movePiece from " + fromCell + " to " + toCell + ": Moving wrong color: " + pieceColor);
            return;
        }

        // Check if move to toCell is legal
        int isLegalMove = Global.checkIfLegalMove(piece, fromCell, toCell);

        // Move the piece
        int moveSucceeded =0;
        if(isLegalMove == 1) {
            
            moveSucceeded = Global.movePieceToPosition(piece, fromCell, toCell);
            if(moveSucceeded == 1) {
                if(Global.isKingUnderCheck(pieceColor) == 1) {
                    // My king will be under check if I move this piece
                    // move the piece back
                    Global.undoLastMove(piece, fromCell, toCell);
                    return;
                }
                // is opponent king under check?
                int oppColor = (pieceColor == WHITE)?BLACK:WHITE;
                underCheck[oppColor] = Global.isKingUnderCheck(oppColor);
                // is this checkmate?
                if(underCheck[oppColor] == 1) {
                    checkMate = Global.isCheckMate(oppColor);
                }
                colorToMove = (pieceColor == WHITE)?BLACK:WHITE;
                drawChessPieces();
            }
        }
    }
}

class ChessBoard extends JFrame implements
                           MouseListener, // pressing/releasing a mouse button
                           MouseMotionListener
{
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static final int B_W = 416; // Board Width
    private static final int B_H = 416; // Board Height
    private Container c;
    private int x1, y1, x2, y2;
    private Board board;
    private JPanel mainPnl;
    ChessBoard() {
        super();
        c = getContentPane();
        c.setLayout(null);
        setBounds(0, 0, WIDTH+200, HEIGHT+200);
        setBackground(new Color(204, 204, 204));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("DeepChess");
        setResizable(false);

        // Create a new JPanel.
        mainPnl = new JPanel();
        mainPnl.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        mainPnl.setBounds(0, 0, WIDTH, HEIGHT);
        mainPnl.setBackground(new Color(255, 255, 255));
        board = new Board(mainPnl);
        board.setBounds(0, 0, B_W, B_H);
        
        //mainPnl.add(board);
        //set up listeners
        addMouseMotionListener(this);
        addMouseListener(this);
        c.add(mainPnl);
        setVisible(true);
        board.setCellLocations();
    }
    // MouseListener methods
    public void mouseDragged(MouseEvent event)
    // capture coordinates of new mouse position as it is
    // dragged across the screen
    {
        //Graphics g = getGraphics();
        
        //g.drawString(".",x2,y2);
        //System.out.println("Inside mouseDragged, X : " + x2 + " Y : " + y2);
    }

    //----------------------------------------------------------------

    public void mouseMoved(MouseEvent event)
    {
    }

    //----------------------------------------------------------------
    // implemented blank methods
    public void mouseClicked(MouseEvent event){}
    public void mouseEntered(MouseEvent event){}
    public void mouseExited(MouseEvent event){}

    //----------------------------------------------------------------
    public void mousePressed(MouseEvent event)
    // capture initial coordinates of mouse
    {
        x1=event.getX();
        y1=event.getY();

        //Graphics g = getGraphics();

        // display reference point of coordinates (x1,y1)
        //g.drawString(".",x1,y1);
    }

    public void mouseReleased(MouseEvent event)
    // draw the appropriate shape when mouse button released;
    // shape will be drawn between the coordinates (x1,y1) and (x2,y2)
    {
        x2=event.getX();
        y2=event.getY();
        System.out.println("Scrren Locn1 : " + x1 + " " + y1);
        System.out.println("Scrren Locn2 : " + x2 + " " + y2);
        String cell1 = board.getCellNameByScreenLocation(x1, y1);
        String cell2 = board.getCellNameByScreenLocation(x2, y2);
        System.out.println("Move from : " + cell1 + " to : " + cell2);
        board.movePiece(cell1, cell2);
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
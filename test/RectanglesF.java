import java.awt.*;
import java.awt.event.*;

public class RectanglesF extends Frame implements
              MouseListener,  // pressing/releasing a mouse button
              WindowListener  // closing a window
{
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static final int B_W = 416; // Board Width
    private static final int B_H = 416; // Board Height
    private final int S_X = 100; // Start X
    private final int S_Y = 100;
    private final int DIM = 8;
    int x1,y1,x2,y2;
    Frame about = new Frame("About DeepChess");
    public void mouseDragged(MouseEvent event)
    // capture coordinates of new mouse position as it is
    // dragged across the screen
    {
        Graphics g = getGraphics();
        x2=event.getX();
        y2=event.getY();
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

        Graphics g = getGraphics();

        // display reference point of coordinates (x1,y1)
        g.drawString(".",x1,y1);
    }

    public void mouseReleased(MouseEvent event)
    // draw the appropriate shape when mouse button released;
    // shape will be drawn between the coordinates (x1,y1) and (x2,y2)
    {
        Graphics g = getGraphics();
    }

    //------------------------------------------------------------------
    //      implemented blank methods
    public void windowClosed(WindowEvent event){}
    public void windowDeiconified(WindowEvent event){}
    public void windowIconified(WindowEvent event){}
    public void windowActivated(WindowEvent event){}
    public void windowDeactivated(WindowEvent event){}
    public void windowOpened(WindowEvent event){}

        //------------------------------------------------------------------

        public void windowClosing(WindowEvent event)
        // method to check which window was closing
        {
                if (event.getWindow() == about)
                {
                        about.dispose();
                        return;
                }
                else
                {
                        System.exit(0);
                }
        }
    public void drawChessBoard(Graphics g)
    {
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(S_X, S_Y, B_W, B_H);
        for(int row=0; row < DIM; row++) {
            int alt = (row % 2);
            for(int col=0; col < DIM; col++) {
                alt++;
                g.drawRect(S_X + (row * (B_H/8)), S_Y + (col * (B_W/8)), B_W/8, B_H/8);
                if((alt % 2) == 0) {
                    g.setColor(new Color(139, 69, 29));
                }
                else {
                    // White
                    g.setColor(new Color(230, 230, 230));
                }
                g.fillRect(S_X + (row * (B_H/8)), S_Y + (col * (B_W/8)), B_W/8, B_H/8);
             }
        }
    }
    public void run() {
        repaint();
    }
    public static void main(String args[]) {
        RectanglesF screen = new RectanglesF();
        Xpm xpm = new Xpm();
        Image bishopBlack = xpm.XpmToImage("../third-party/pixmaps/merida/sandstone/bdl52.xpm");
        screen.setSize(new Dimension(WIDTH,HEIGHT));
        screen.setTitle("DeepChess");
        screen.setVisible(true);
    }
}

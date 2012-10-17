import java.awt.*;
import java.applet.*;
/*
<applet code="Rectangles" width=300 height=200>
</applet>
*/
public class RectanglesF extends Frame implements
              ActionListener, // menu item
              MouseListener,  // pressing/releasing a mouse button
              WindowListener  // closing a window
{
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static final int B_W = 400; // Board Width
    private static final int B_H = 400; // Board Height
    private final int S_X = 100; // Start X
    private final int S_Y = 100;
    private final int DIM = 8;
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
        screen.setSize(new Dimension(WIDTH,HEIGHT));
        screen.setTitle("An Example App");
        screen.setVisible(true);
    }
}

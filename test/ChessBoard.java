import java.awt.*;
import java.awt.event.*;

class Board extends Frame implements 
                ActionListener,         // menu item
                ItemListener,           // radio buttons
                MouseListener,          // pressing/releasing a mouse button
                MouseMotionListener,    // dragging or moving a mouse
                WindowListener          // closing a window
{
    // to prevent compiler warning
    private static final long serialVersionUID = 1L;
    // size of Sketchpad area
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    setLayout(new GridLayout(4,8,8,8); //3 rows, 2 columns, 5 pixel gaps
    //align LEFT-justify, with 10 vertical & 10 horizontal pixels between components
    for (int counter=1; counter <= 7; counter++)
        add(new Button(String.valueOf(counter)));
            1    2    3    4    5    6    7    8
            9    10   11    12    13    14    15    16
            17    18    19    20    21    22    23    24 
            25    26    27    28    29    30    31    32
}

class ChessBoard
{
        public static void main(String[] args)
        {
                Board screen = new Board("DeepChess");
                screen.setSize(Sketchpad.WIDTH, Sketchpad.HEIGHT);
                screen.setVisible(true);
        }
}
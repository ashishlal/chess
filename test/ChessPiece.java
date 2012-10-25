import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ChessPiece 
{
    private static final long serialVersionUID = 1L;
    private String symbol;  // P for pawn etc.
    private String cellName; // eg. c3
    private int color; // 0 ==> WHITE, 1 ==> BLACK
    private int index; // 1 for 1st pawn, 2 for 2nd pawn etc

    public ChessPiece(int c, String s, int i, String cell) 
    {
        if(!imageMapIsSet) {
            setImageMap();
            imageMapIsSet = 1;
        }
        color = c;
        symbol = s;
        index = i;
        cellName = cell;
    }
    public ChessPiece() 
    {
        if(!imageMapIsSet) {
            setImageMap();
            imageMapIsSet = 1;
        }
    }
    public void setColor(int c)
    {
        color = c;
    }
    public void setSymbol(String s)
    {
        symbol = s;
    }
    public void setIndex(int i)
    {
        index = i;
    }
    public void setPosition(String cell)
    {
        cellName = cell;
    }
    public void setPositionFromRowCol(int row, int col)
    {
        cellName = Global.getCellName(row, col);
    }
}

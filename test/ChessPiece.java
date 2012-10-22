import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ChessPiece 
{
    private static final long serialVersionUID = 1L;
    private String name;
    private String cellName;

    public ImageIcon getChessPieceIcon() { return Global.getImageMap().get(name); }
    public ChessPiece(String n, String cell) 
    {
        if(!imageMapIsSet) {
            setImageMap();
            imageMapIsSet = 1;
        }
        name = n;
        cellName = n;
    }
}

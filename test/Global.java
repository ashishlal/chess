import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Tuple<X, Y> { 
  public final X x; 
  public final Y y; 
  public Tuple(X x, Y y) { 
    this.x = x; 
    this.y = y; 
  } 
} 

public class Global
{
    private static char imageMapIsSet = 0;
    private static Map<String,String> pieceToImageName = new HashMap<String,String>();
    private static Map<String,String> pieceToSymbol = new HashMap<String,String>();
    private static Map<String, ImageIcon> imageMap = new HashMap<String, ImageIcon>();
    private static Map<Tuple<int, int>, String> cellRowColToName = new HashMap<Tuple<int, int>, String>();

    private static String piecePath = 
        String path = System.getProperty("user.dir") + "/../third-party/images";
    private static void setImageMap() {
        pieceToImageName.put("WP", "PW.gif"); // white pawn
        pieceToImageName.put("WR", "RW.gif");
        pieceToImageName.put("WN", "NW.gif");
        pieceToImageName.put("WB", "BW.gif");
        pieceToImageName.put("WQ", "QW.gif");
        pieceToImageName.put("WK", "KW.gif");
        pieceToImageName.put("BP", "PB.gif"); // Black pawn
        pieceToImageName.put("BR", "RB.gif");
        pieceToImageName.put("BK", "NB.gif");
        pieceToImageName.put("BB", "BB.gif");
        pieceToImageName.put("BQ", "QB.gif");
        pieceToImageName.put("BK", "KB.gif");

        pieceToSymbol.put("WP", "P"); // white pawn
        pieceToSymbol.put("WR", "R");
        pieceToSymbol.put("WN", "N");
        pieceToSymbol.put("WB", "B");
        pieceToSymbol.put("WQ", "Q");
        pieceToSymbol.put("WK", "K");
        pieceToSymbol.put("BP", "P"); // Black pawn
        pieceToSymbol.put("BR", "R");
        pieceToSymbol.put("BK", "N");
        pieceToSymbol.put("BB", "B");
        pieceToSymbol.put("BQ", "Q");
        pieceToSymbol.put("BK", "K");
        for (Map.Entry<String, String> entry : pieceToImageName.entrySet()) {
            String path = piecePath + entry.getValue();;
            ImageIcon icon = new ImageIcon(path);
            // System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
            imageMap.put(entry.getKey(), icon);
        }
    }
    public void setCellRowColToName() 
    {
        for(int row=1; row <=8; row++) {
            for(int col=1; col <= 8; col++) {
            }
        }
        cellRowColToName.put(Tuple(1, 1), "a1"); // white pawn
        cellRowColToName.put(Tuple(1, 1), "RW.gif");
        cellRowColToName.put(Tuple(1, 1), "NW.gif");
        cellRowColToName.put(Tuple(1, 1), "BW.gif");
        cellRowColToName.put(Tuple(1, 1), "QW.gif");
        cellRowColToName.put(Tuple(1, 1), "KW.gif");
        cellRowColToName.put(Tuple(1, 1), "PB.gif"); // Black pawn
        cellRowColToName.put(Tuple(1, 1), "RB.gif");
        cellRowColToName.put(Tuple(1, 1), "NB.gif");
        cellRowColToName.put(Tuple(1, 1), "BB.gif");
        cellRowColToName.put(Tuple(1, 1), "QB.gif");
        cellRowColToName.put(Tuple(1, 1), "KB.gif");
    }
    public Map<String, ImageIcon> getImageMap() { return imageMap; }
    
    private Global() {};
}
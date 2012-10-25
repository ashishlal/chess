import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("unchecked")
class Tuple <T, U>
{
   private final T first;
   private final U second;
   private transient final int hash;

   public Tuple( T f, U s )
   {
    this.first = f;
    this.second = s;
    hash = (first == null? 0 : first.hashCode() * 31)
          +(second == null? 0 : second.hashCode());
   }

   public T getFirst()
   {
    return first;
   }
   public U getSecond()
   {
    return second;
   }

   @Override
   public int hashCode()
   {
    return hash;
   }

   @Override
   public boolean equals( Object oth )
   {
    if ( this == oth )
    {
      return true;
    }
    if ( oth == null || !(getClass().isInstance( oth )) )
    {
      return false;
    }
    Tuple<T, U> other = getClass().cast( oth );
    return (first == null? other.first == null : first.equals( other.first ))
     && (second == null? other.second == null : second.equals( other.second ));
   }

}

class Tuple3<X, Y, Z> { 
  public final X x; 
  public final Y y;
  public final Z z; 
  public Tuple3(X x, Y y, Z z) { 
    this.x = x; 
    this.y = y; 
    this.z = z;
  }
  public X getX() { return x; }
  public Y getY() { return y; }
  public Z getZ() { return z; }
}

public class Global
{
    private static char imageMapIsSet = 0;
    private static Map<String,String> pieceToImageName = new HashMap<String,String>();
    private static Map<String,String> pieceToSymbol = new HashMap<String,String>();
    private static Map<String, ImageIcon> imageMap = new HashMap<String, ImageIcon>();
    private static Map<Tuple<Integer, Integer>, String> cellRowColToName = new HashMap<Tuple<Integer, Integer>, String>();
    private static int WHITE=0;
    private static int BLACK=1;
    private static Map<Tuple<String, Integer>, String> piecePositions = 
        new HashMap<Tuple<String, Integer>, String>();
    public static void setPiecePosition(String symbol, int index, String position)
    {
        Tuple<String, Integer> t = new Tuple<String, Integer>(symbol, index);
        piecePositions.put(t, position);
    }
    public static String getPiecePosition(String symbol, int index)
    {
        Tuple<String, Integer> t = new Tuple<String, Integer>(symbol, index);
        return piecePositions.get(t);
    }
    public static String getPiecePositionByRowCol(int row, int col)
    {
        String position = getCellName(row, col);
        for (Map.Entry<Tuple<String, Integer>, String>  entry : piecePositions.entrySet()) {
            //System.out.println("position : " + position + " Value : " + entry.getValue());
            if(entry.getValue().equals(position)) {
                return entry.getValue();
            }
        }
        position = "";
        return position;
    }
    public static String getPieceNameByPosition(String position)
    {
        String piece = "";
        for (Map.Entry<Tuple<String, Integer>, String>  entry : piecePositions.entrySet()) {

            if(entry.getValue().equals(position)) {
                return entry.getKey().getFirst();
            }
        }
        return piece;
    }
    public static void setPieceInitialPositions() 
    {
        piecePositions.put(new Tuple<String, Integer>("WR", 1), "a1");
        piecePositions.put(new Tuple<String, Integer>("WN", 1), "b1");
        piecePositions.put(new Tuple<String, Integer>("WB", 1), "c1");
        piecePositions.put(new Tuple<String, Integer>("WQ", 1), "d1");
        piecePositions.put(new Tuple<String, Integer>("WK", 1), "e1");
        piecePositions.put(new Tuple<String, Integer>("WB", 2), "f1");
        piecePositions.put(new Tuple<String, Integer>("WN", 2), "g1");
        piecePositions.put(new Tuple<String, Integer>("WR", 2), "h1");
        piecePositions.put(new Tuple<String, Integer>("WP", 1), "a2");
        piecePositions.put(new Tuple<String, Integer>("WP", 2), "b2");
        piecePositions.put(new Tuple<String, Integer>("WP", 3), "c2");
        piecePositions.put(new Tuple<String, Integer>("WP", 4), "d2");
        piecePositions.put(new Tuple<String, Integer>("WP", 5), "e2");
        piecePositions.put(new Tuple<String, Integer>("WP", 6), "f2");
        piecePositions.put(new Tuple<String, Integer>("WP", 7), "g2");
        piecePositions.put(new Tuple<String, Integer>("WP", 8), "h2");

        piecePositions.put(new Tuple<String, Integer>("BR", 1), "a8");
        piecePositions.put(new Tuple<String, Integer>("BN", 1), "b8");
        piecePositions.put(new Tuple<String, Integer>("BB", 1), "c8");
        piecePositions.put(new Tuple<String, Integer>("BQ", 1), "d8");
        piecePositions.put(new Tuple<String, Integer>("BK", 1), "e8");
        piecePositions.put(new Tuple<String, Integer>("BB", 2), "f8");
        piecePositions.put(new Tuple<String, Integer>("BN", 2), "g8");
        piecePositions.put(new Tuple<String, Integer>("BR", 2), "h8");
        piecePositions.put(new Tuple<String, Integer>("BP", 1), "a7");
        piecePositions.put(new Tuple<String, Integer>("BP", 2), "b7");
        piecePositions.put(new Tuple<String, Integer>("BP", 3), "c7");
        piecePositions.put(new Tuple<String, Integer>("BP", 4), "d7");
        piecePositions.put(new Tuple<String, Integer>("BP", 5), "e7");
        piecePositions.put(new Tuple<String, Integer>("BP", 6), "f7");
        piecePositions.put(new Tuple<String, Integer>("BP", 7), "g7");
        piecePositions.put(new Tuple<String, Integer>("BP", 8), "h7");
    }
    private static String piecePath = System.getProperty("user.dir") + "/../third-party/images/";
    public static void setImageMap() {
        pieceToImageName.put("WP", "PW.gif"); // white pawn
        pieceToImageName.put("WR", "RW.gif");
        pieceToImageName.put("WN", "NW.gif");
        pieceToImageName.put("WB", "BW.gif");
        pieceToImageName.put("WQ", "QW.gif");
        pieceToImageName.put("WK", "KW.gif");
        pieceToImageName.put("BP", "PB.gif"); // Black pawn
        pieceToImageName.put("BR", "RB.gif");
        pieceToImageName.put("BN", "NB.gif");
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
        pieceToSymbol.put("BN", "N");
        pieceToSymbol.put("BB", "B");
        pieceToSymbol.put("BQ", "Q");
        pieceToSymbol.put("BK", "K");
        for (Map.Entry<String, String> entry : pieceToImageName.entrySet()) {
            String path = piecePath + entry.getValue();;
            ImageIcon icon = new ImageIcon(path);
            //System.out.println("Key : " + entry.getKey() + " Value : " + path);
            imageMap.put(entry.getKey(), icon);
        }
    }
    public static void setCellRowColToName() 
    {
        Map<Integer, String> colToChar = new HashMap<Integer, String>();
        colToChar.put(1, "a");
        colToChar.put(2, "b");
        colToChar.put(3, "c");
        colToChar.put(4, "d");
        colToChar.put(5, "e");
        colToChar.put(6, "f");
        colToChar.put(7, "g");
        colToChar.put(8, "h");

        for(int row=1; row <=8; row++) {
            for(int col=1; col <= 8; col++) {
                String cellName = colToChar.get(col) + Integer.toString(row);
                cellRowColToName.put(new Tuple<Integer, Integer>(row, col), cellName);
            }
        }
    }
    public static Map<String, String> getPieceToImageName() { return pieceToImageName; }
    public static Map<String, ImageIcon> getImageMap() { return imageMap; }
    public static ImageIcon getImageIcon(String name) { return imageMap.get(name); }
    public static String getCellName(int row, int col) {
       Tuple <Integer, Integer> t = new Tuple<Integer, Integer>(row, col);
       for (Map.Entry<Tuple<Integer, Integer>, String> entry : cellRowColToName.entrySet()) {
           if(t.equals(entry.getKey())) {
               return entry.getValue();
           }
       }
       return ""; }
    
    private Global() {};
}
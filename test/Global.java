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

@SuppressWarnings ( "unchecked" )
class Tuple7 <A, B, C, D, E, F, G>
{
   private final A first;
   private final B second;
   private final C third;
   private final D fourth;
   private final E fifth;
   private final F sixth;
   private final G seventh;
   private transient final int hash;

   public Tuple7( A a, B b, C c, D d, E e, F f, G g )
   {
    this.first = a;
    this.second = b;
    this.third = c;
    this.fourth = d;
    this.fifth = e;
    this.sixth = f;
    this.seventh = g;
    hash = ((first == null? 0 : first.hashCode() * 31)
          +(second == null? 0 : second.hashCode() * 41)
          +(third == null? 0 : second.hashCode() * 53)
          +(fourth == null? 0 : second.hashCode() * 61)
          +(fifth == null? 0 : second.hashCode() * 71)
          +(sixth == null? 0 : second.hashCode() * 83)
          +(seventh == null? 0 : second.hashCode() * 23)
           );
   }

   public A getFirst()
   {
    return first;
   }
   public B getSecond()
   {
    return second;
   }
   public C getThird()
   {
    return third;
   }
   public D getFourth()
   {
    return fourth;
   }
   public E getFifth()
   {
    return fifth;
   }
   public F getSixth()
   {
    return sixth;
   }
   public G getSeventh()
   {
    return seventh;
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
    Tuple7<A, B, C, D, E, F, G> other = getClass().cast( oth );
    return (first == null? other.first == null : first.equals( other.first ))
     && (second == null? other.second == null : second.equals( other.second ))
     && (third == null? other.third == null : third.equals( other.third ))
     && (fourth == null? other.fourth == null : fourth.equals( other.fourth ))
     && (fifth == null? other.fifth == null : fifth.equals( other.fifth ))
     && (sixth == null? other.sixth == null : sixth.equals( other.sixth ))
     && (seventh == null? other.seventh == null : seventh.equals( other.seventh ));
   }
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
    private static List<Tuple7<Integer, String, Integer, String, String, String, Integer>> moves = 
        new ArrayList<Tuple7<Integer, String, Integer, String, String, String, Integer>>();
    private static int captureEnPassant = 0;
    private static Tuple<String, Integer>captureEnPassantPiece;
    private static int [] kingHasMoved = new int[2];
    private static int [] doCastling = new int[2];

    @SuppressWarnings("unchecked") 
    public static int movePieceToPosition(String piece, String fromPos, String toPos)
    {
        String pieceBeingKilled = getPieceNameByPosition(toPos);
        int pieceKilledIndex = -1;
        if(!pieceBeingKilled.equals("")) {
            pieceKilledIndex = getPieceIndexByPosition(toPos);
        }
        int index = -1;
        int color = -1;
        if(piece.charAt(0) == 'W') {
            color = WHITE;
        }
        else if(piece.charAt(0) == 'B') {
            color = BLACK;
        }
        if((piece.equals("WK")) && (doCastling[WHITE] == 1)) {
            doCastling[WHITE]=0;
            return doKingRookCastling(WHITE, fromPos, toPos);
        }
        else if((piece.equals("BK")) && (doCastling[BLACK] == 1)) {
            doCastling[BLACK]=0;
            return doKingRookCastling(BLACK, fromPos, toPos);
        }
        for(Iterator<Map.Entry<Tuple<String,Integer>, String>>it=piecePositions.entrySet().iterator();
            it.hasNext();) {

            Map.Entry<Tuple<String, Integer>, String> entry = it.next();

            if((entry.getValue().equals(fromPos)) && (entry.getKey().getFirst().equals(piece))) {
                index = entry.getKey().getSecond();
                Tuple7<Integer, String, Integer, String, String, String, Integer> t7 = 
                    new Tuple7<Integer, String, Integer, String, String, String, Integer>(
                        (Integer)(moves.size()), piece, index, fromPos, toPos, pieceBeingKilled, 
                         pieceKilledIndex);
                moves.add(t7);
                if(pieceBeingKilled.equals("")) {
                    it.remove();
                    piecePositions.put(new Tuple<String, Integer>(piece, index), toPos);
                    return 1;
                }
                it.remove();
                break;
            }
        }
        if(index == -1) return 0;
        // remove piece being killed and insert the piece in new position
        for(Iterator<Map.Entry<Tuple<String,Integer>, String>>it=piecePositions.entrySet().iterator();it.hasNext();) {

            Map.Entry<Tuple<String, Integer>, String> entry = it.next();
            if((entry.getValue().equals(toPos)) && (entry.getKey().getFirst().equals(pieceBeingKilled))) {

                it.remove();
                piecePositions.put(new Tuple<String, Integer>(piece, index), toPos);
                return 1;
            }
        }
        // if it is enpassant do it here
        if(captureEnPassant == 1) {
            String epPiece = captureEnPassantPiece.getFirst();
            int epPieceIndex = captureEnPassantPiece.getSecond();
            for(Iterator<Map.Entry<Tuple<String,Integer>, String>>it=piecePositions.entrySet().iterator();it.hasNext();) {

                 Map.Entry<Tuple<String, Integer>, String> entry = it.next();
                 if((entry.getKey().getFirst().equals(epPiece)) && 
                     (entry.getKey().getSecond() == epPieceIndex)) {
                
                    it.remove();
                    // make the index as 0xff meaning it is continuation of previous move
                    Tuple7<Integer, String, Integer, String, String, String, Integer> t7 = 
                    new Tuple7<Integer, String, Integer, String, String, String, Integer>(
                        (Integer)(0xff), "", -1, entry.getValue(), "", epPiece, epPieceIndex);
                    moves.add(t7);
                    captureEnPassant = 0;
                    return 1;
                }
            }
            captureEnPassant = 0;
        }
        return 0;
    }
    public static void undoLastMove(String piece, String fromPos, String toPos)
    {
        for(Iterator<Map.Entry<Tuple<String,Integer>, String>>it=piecePositions.entrySet().iterator();it.hasNext();) {

            Map.Entry<Tuple<String, Integer>, String> entry = it.next();

            if((entry.getValue().equals(toPos)) && (entry.getKey().getFirst().equals(piece))) {
                int index = entry.getKey().getSecond();

                piecePositions.remove(entry.getKey());
                piecePositions.put(new Tuple<String, Integer>(piece, index), fromPos);
                if(moves.size() > 0) {
                    Tuple7<Integer, String, Integer, String, String, String, Integer> t7 = moves.get(moves.size() -1);
                    if(!t7.getSixth().equals("")) {
                        piecePositions.put(new Tuple<String, Integer>(t7.getSixth(), t7.getSeventh()), toPos);
                    }
                    moves.remove(moves.size() - 1);
                }
                return;
            }
        }
    }
    public static Tuple7<Integer, String, Integer, String, String, String, Integer> getLastMove()
    {
        if(moves.size() == 0) 
            return new Tuple7<Integer, String, Integer, String, String, String, Integer>(-1,"",-1,"","","",-1);
        Tuple7<Integer, String, Integer, String, String, String, Integer> t7 = moves.get(moves.size() -1);
        return t7;
    }
    public static void setPiecePosition(String piece, int index, String position)
    {
        Tuple<String, Integer> t = new Tuple<String, Integer>(piece, index);
        piecePositions.put(t, position);
    }
    public static String getPiecePosition(String piece, int index)
    {
        Tuple<String, Integer> t = new Tuple<String, Integer>(piece, index);
        return piecePositions.get(t);
    }
    public static int getPieceIndexByPosition(String pos)
    {
        int index = -1;
        for (Map.Entry<Tuple<String, Integer>, String>  entry : piecePositions.entrySet()) {
            //System.out.println("position : " + position + " Value : " + entry.getValue());
            if(entry.getValue().equals(pos)) {
                return (int)(entry.getKey().getSecond());
            }
        }
        return index;
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
    public static int getPieceColorAtPosition(String position)
    {
        String piece = "";
        for (Map.Entry<Tuple<String, Integer>, String>  entry : piecePositions.entrySet()) {

            if(entry.getValue().equals(position)) {
                String pieceName = entry.getKey().getFirst();
                if(pieceName.charAt(0) == 'W') {
                    return WHITE;
                }
                else if(pieceName.charAt(0) == 'B') {
                    return BLACK;
                }
            }
        }
        return -1;
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
       return ""; 
    }
    public static int checkIfLegalMove(String piece, String fromPos, String toPos) 
    {
        int color = -1;
        if(piece.charAt(0) == 'W') {
            color = WHITE;
        }
        else if(piece.charAt(0) == 'B') {
            color = BLACK;
        }
        if(color == -1) return 0; // illegal
        String pieceAtToPos = getPieceNameByPosition(toPos);
        if(!pieceAtToPos.equals("")) {
            // get color
            int col = getPieceColorAtPosition(toPos);
            if(col == color) {
                // cant move to toPos if it has a piece of same color.
                return 0; // illegal
            }
        }
        if((piece.equals("BB")) || (piece.equals("WB"))) {
            return checkIfLegalForBishop(color, fromPos, toPos);
        }
        else if((piece.equals("BN")) || (piece.equals("WN"))) {
            return checkIfLegalForKnight(color, fromPos, toPos);
        }
        else if((piece.equals("BR")) || (piece.equals("WR"))) {
            return checkIfLegalForRook(color, fromPos, toPos);
        }
        else if((piece.equals("BQ")) || (piece.equals("WQ"))) {
            return checkIfLegalForQueen(color, fromPos, toPos);
        }
        else if((piece.equals("BK")) || (piece.equals("WK"))) {
            return checkIfLegalForKing(color, fromPos, toPos);
        }
        else if((piece.equals("BP")) || (piece.equals("WP"))) {
            return checkIfLegalForPawn(color, fromPos, toPos);
        }
        return 0; // illegal
    }
    public static int checkIfLegalForBishop(int color, String fromPos, String toPos)
    {
        int fromCol = (int)(fromPos.charAt(0)); // convert char to ascii
        int fromRow = (int)(fromPos.charAt(1)); // convert char to ascii
        int toCol = (int)(toPos.charAt(0));
        int toRow = (int)(toPos.charAt(1));
        if((fromCol == toCol) || (fromRow == toRow)) {
            return 0; // illegal for bishop
        }
        int rowDist = (fromRow > toRow) ? (fromRow - toRow) : (toRow - fromRow);
        int colDist = (fromCol > toCol) ? (fromCol - toCol) : (toCol - fromCol);
        if(rowDist != colDist) {
            return 0; // illegal for bishop
        }
        if((fromCol > toCol) && (fromRow > toRow)) { // bishop moves to left, bottom
            for(int i=1, j=1; j < colDist; j++, i++) {     
                char col = (char)(toCol+j);
                char row = (char)(toRow+i);
                // check if another piece in the way
                String newPos = "" + col + row;
                String pieceInTheWay = getPieceNameByPosition(newPos);
                if(!pieceInTheWay.equals("")) {
                    return 0; // illegal
                }
            }
            return 1; //legal
        }
        else if((fromCol > toCol) && (fromRow < toRow)) { //bishop moves to left, top
            for(int i=1, j=1; j < colDist; j++, i++) {     
                char col = (char)(toCol+j);
                char row = (char)(toRow-i);
                // check if another piece in the way
                String newPos = "" + col + row;
                String pieceInTheWay = getPieceNameByPosition(newPos);
                if(!pieceInTheWay.equals("")) {
                    return 0; // illegal
                }
            }
            return 1; //legal
        }
        else if((fromCol < toCol) && (fromRow < toRow)) { // right, top
            for(int i=1, j=1; j < colDist; j++, i++) {     
                char col = (char)(fromCol+j);
                char row = (char)(fromRow+i);
                // check if another piece in the way
                String newPos = "" + col + row;
                String pieceInTheWay = getPieceNameByPosition(newPos);
                if(!pieceInTheWay.equals("")) {
                    return 0; // illegal
                }
            }
            return 1; //legal
        }
        else if((fromCol < toCol) && (fromRow > toRow)) { // right, bottom
            for(int i=1, j=1; j < colDist; j++, i++) {     
                char col = (char)(fromCol+j);
                char row = (char)(fromRow-i);
                // check if another piece in the way
                String newPos = "" + col + row;
                String pieceInTheWay = getPieceNameByPosition(newPos);
                if(!pieceInTheWay.equals("")) {
                    return 0; // illegal
                }
            }
            return 1; //legal
        }
        return 0; // illegal
    }
    public static int checkIfLegalForKnight(int color, String fromPos, String toPos)
    {
        int fromCol = (int)(fromPos.charAt(0)); // convert char to ascii
        int fromRow = (int)(fromPos.charAt(1)); // convert char to ascii
        int toCol = (int)(toPos.charAt(0));
        int toRow = (int)(toPos.charAt(1));
        if((fromCol == toCol) || (fromRow == toRow)) {
            return 0; // illegal for knight
        }
        int rowDist = (fromRow > toRow) ? (fromRow - toRow) : (toRow - fromRow);
        int colDist = (fromCol > toCol) ? (fromCol - toCol) : (toCol - fromCol);
        // knight jumps 1 row and 2 cols OR 2 rows and 1 col in either direction 
        // ie. (left, right, top, bottom)
        if(!(((rowDist == 1) && (colDist == 2)) || 
            ((rowDist == 2) && (colDist == 1)))) {
            return 0; // illegal for knight
        }
        // analyze the to position
        if((fromCol > toCol) && (fromRow > toRow)) { // knight moves to left->down or down->left
            // bit repetetive but easy to understand and follow.
            if((rowDist == 1) && (colDist == 2)) {  // left->down
                // left down position (2 cols left and 1 row down)
                char col = (char)(fromCol-colDist);
                char row = (char)(fromRow-rowDist);
                String newPos = "" + col + row;
                if(toPos.equals(newPos)) {
                    return 1; // legal
                }
                return 0; // illegal
            }
            else if ((rowDist == 2) && (colDist == 1)) { // down->left position
                // 2 rows down and 1 col left
                char col = (char)(fromCol-colDist);
                char row = (char)(fromRow-rowDist);
                String newPos = "" + col + row;
                if(toPos.equals(newPos)) {
                    return 1; //legal
                }
                return 0; // illegal
            }
            return 0; // illegal
        }
        else if((fromCol > toCol) && (fromRow < toRow)) { //knight moves to left->top or top->left
            // bit repetetive but easy to understand and follow.
            if((rowDist == 1) && (colDist == 2)) {  // left->top
                // left up position (2 cols left and 1 row top)
                char col = (char)(fromCol-colDist);
                char row = (char)(fromRow+rowDist);
                String newPos = "" + col + row;
                if(toPos.equals(newPos)) {
                    return 1; // legal
                }
                return 0; // illegal
            }
            else if ((rowDist == 2) && (colDist == 1)) { // top->left position
                // 2 rows top and 1 col left
                char col = (char)(fromCol-colDist);
                char row = (char)(fromRow+rowDist);
                String newPos = "" + col + row;
                if(toPos.equals(newPos)) {
                    return 1; //legal
                }
                return 0; // illegal
            }
            return 0; // illegal
        }
        else if((fromCol < toCol) && (fromRow < toRow)) { // right->top or top->right
            // bit repetetive but easy to understand and follow.
            if((rowDist == 1) && (colDist == 2)) {  // left->top
                // left up position (2 cols left and 1 row top)
                char col = (char)(fromCol+colDist);
                char row = (char)(fromRow+rowDist);
                String newPos = "" + col + row;
                if(toPos.equals(newPos)) {
                    return 1; // legal
                }
                return 0; // illegal
            }
            else if ((rowDist == 2) && (colDist == 1)) { // top->left position
                // 2 rows top and 1 col left
                char col = (char)(fromCol+colDist);
                char row = (char)(fromRow+rowDist);
                String newPos = "" + col + row;
                if(toPos.equals(newPos)) {
                    return 1; //legal
                }
                return 0; // illegal
            }
            return 0; // illegal
        }
        else if((fromCol < toCol) && (fromRow > toRow)) { // right->bottom or bottom->right
            // bit repetetive but easy to understand and follow.
            if((rowDist == 1) && (colDist == 2)) {  // left->top
                // left up position (2 cols left and 1 row top)
                char col = (char)(fromCol+colDist);
                char row = (char)(fromRow-rowDist);
                String newPos = "" + col + row;
                if(toPos.equals(newPos)) {
                    return 1; // legal
                }
                return 0; // illegal
            }
            else if ((rowDist == 2) && (colDist == 1)) { // top->left position
                // 2 rows top and 1 col left
                char col = (char)(fromCol+colDist);
                char row = (char)(fromRow-rowDist);
                String newPos = "" + col + row;
                if(toPos.equals(newPos)) {
                    return 1; //legal
                }
                return 0; // illegal
            }
            return 0; // illegal
        }
        return 0; // illegal
    }
    public static int checkIfLegalForRook(int color, String fromPos, String toPos)
    {
        int fromCol = (int)(fromPos.charAt(0)); // convert char to ascii
        int fromRow = (int)(fromPos.charAt(1)); // convert char to ascii
        int toCol = (int)(toPos.charAt(0));
        int toRow = (int)(toPos.charAt(1));
        if((fromCol != toCol) && (fromRow != toRow)) {
            return 0; // illegal for rook
        }
        int rowDist = (fromRow > toRow) ? (fromRow - toRow) : (toRow - fromRow);
        int colDist = (fromCol > toCol) ? (fromCol - toCol) : (toCol - fromCol);

        // rook moves on same row or same col
        if(!(((rowDist == 0) && (colDist != 0)) || 
            ((rowDist != 0) && (colDist == 0)))) {
            return 0; // illegal for rook
        }
        int i=0, j=0;
        if(rowDist == 0) {
            char col = (char)((fromCol > toCol) ? (fromCol-colDist) : (fromCol+colDist));
            char row = (char)(fromRow-rowDist);
            String newPos = "" + col + row;
            if(toPos.equals(newPos)) {
                // check if a piece is in between
                for(i=1, j=1; j < colDist; j++, i++) {     
                    char col1 = (char)((fromCol > toCol) ? (fromCol-j) : (fromCol+j));
                    char row1 = (char)(fromRow-rowDist);
                    // check if another piece in the way
                    String newPos1 = "" + col1 + row1;
                    String pieceInTheWay = getPieceNameByPosition(newPos1);
                    if(!pieceInTheWay.equals("")) {
                        System.out.println("checkIfLegalForRook: 1" + newPos1);
                        return 0; // illegal
                    }
                }
                //System.out.println("checkIfLegalForRook: 3");
                return 1; //legal
            }
            //System.out.println("checkIfLegalForRook: 2");
            return 0; // illegal
        }
        else if(colDist == 0) { // rook moves along row
            char row = (char)((fromRow > toRow) ? (fromRow-rowDist) : (fromRow+rowDist));
            char col = (char)(fromCol-colDist);
            String newPos = "" + col + row;
            if(toPos.equals(newPos)) {
                // check if a piece is in between
                for(i=1, j=1; j < rowDist; j++, i++) {     
                    char row1 = (char)((fromRow > toRow) ? (fromRow-j) : (fromRow+j));
                    char col1 = (char)(fromCol-colDist);
                    // check if another piece in the way
                    String newPos1 = "" + col1 + row1;
                    String pieceInTheWay = getPieceNameByPosition(newPos1);
                    if(!pieceInTheWay.equals("")) {
                        return 0; // illegal
                    }
                }
                return 1; //legal
            }
            return 0; // illegal
        }
        return 0; // illegal
    }
    public static int checkIfLegalForQueen(int color, String fromPos, String toPos)
    {
        int fromCol = (int)(fromPos.charAt(0)); // convert char to ascii
        int fromRow = (int)(fromPos.charAt(1)); // convert char to ascii
        int toCol = (int)(toPos.charAt(0));
        int toRow = (int)(toPos.charAt(1));
        if((fromCol != toCol) && (fromRow != toRow)) {
            return 0; // illegal for rook
        }
        int rowDist = (fromRow > toRow) ? (fromRow - toRow) : (toRow - fromRow);
        int colDist = (fromCol > toCol) ? (fromCol - toCol) : (toCol - fromCol);

        // queen moves as rook or as bishop
        if((rowDist == 0) || (colDist == 0)) { // queen moves as rook
            return checkIfLegalForRook(color, fromPos, toPos);
        }
        return checkIfLegalForBishop(color, fromPos, toPos);
    }
    public static int checkIfLegalForKing(int color, String fromPos, String toPos)
    {
        int fromCol = (int)(fromPos.charAt(0)); // convert char to ascii
        int fromRow = (int)(fromPos.charAt(1)); // convert char to ascii
        int toCol = (int)(toPos.charAt(0));
        int toRow = (int)(toPos.charAt(1));

        int rowDist = (fromRow > toRow) ? (fromRow - toRow) : (toRow - fromRow);
        int colDist = (fromCol > toCol) ? (fromCol - toCol) : (toCol - fromCol);

        // king cannot move to put opposite king in check
        doCastling[color] = 0;
        String posOfOppKing = "";
        if(color == WHITE) {
            posOfOppKing = getPiecePosition("BK", 1);
        }
        else if(color == BLACK) {
            posOfOppKing = getPiecePosition("WK", 1);
        }
        int posOfOppKingCol = (int)(posOfOppKing.charAt(0));
        int posOfOppKingRow = (int)(posOfOppKing.charAt(1));
        int colDistFromToPos =
            (posOfOppKingCol > toCol) ? (posOfOppKingCol - toCol) : (toCol - posOfOppKingCol);
        int rowDistFromToPos =
            (posOfOppKingRow > toRow) ? (posOfOppKingRow - toRow) : (toRow - posOfOppKingRow);

        // the king cannot move to 1 distance of the opposing king
        if((colDistFromToPos == 0) && (rowDistFromToPos == 0)) return 0;
        if((colDistFromToPos == 0) && (rowDistFromToPos == 1)) return 0;
        if((colDistFromToPos == 1) && (rowDistFromToPos == 1)) return 0;
        if((colDistFromToPos == 1) && (rowDistFromToPos == 0)) return 0;

        // if king wants to move by 2 col, check for castling
        if((colDist == 2) && (rowDist == 0)) {
            doCastling[color] = checkIfLegalCastling(color, fromPos, toPos);
            if(doCastling[color] == 1) return 1;
        }
        // king moves as rook or as bishop by 1 position
        if(!(((rowDist == 1) && (colDist == 0)) || 
             ((rowDist == 0) && (colDist == 1)) ||
             ((rowDist == 1) && (colDist == 1))
             )) {
            return 0;
        }
        if((rowDist == 0) && (colDist == 1)) { // move as rook 1 col to the right or left on same row
            return checkIfLegalForRook(color, fromPos, toPos);
        }
        if((rowDist == 1) && (colDist == 0)) { // move as rook 1 row to the top or bottom on same col
            return checkIfLegalForRook(color, fromPos, toPos);
        }
        if((rowDist == 1) && (colDist == 1)) {  // move as bishop 1 row + 1 col diagonally
            return checkIfLegalForBishop(color, fromPos, toPos);
        }
        return 0; // illegal
    }
    public static int checkIfLegalForPawn(int color, String fromPos, String toPos)
    {
        int fromCol = (int)(fromPos.charAt(0)); // convert char to ascii
        int fromRow = (int)(fromPos.charAt(1)); // convert char to ascii
        int toCol = (int)(toPos.charAt(0));
        int toRow = (int)(toPos.charAt(1));
        
        int rowDist = (fromRow > toRow) ? (fromRow - toRow) : (toRow - fromRow);
        int colDist = (fromCol > toCol) ? (fromCol - toCol) : (toCol - fromCol);
        int isFirstMove=0;
        if((color == WHITE) && (fromPos.charAt(1) == '2')) {
            isFirstMove = 1;
        }
        else if((color == BLACK) && (fromPos.charAt(1) == '7')) {
            isFirstMove = 1;
        }

        System.out.println("checkIfLegalForPawn: fC: " + fromCol + " fR: " +fromRow + " tC: " + toCol + " tR: " + toRow);
        // pawn cant move more that 2 positions along a row
        if(rowDist > 2) {
            System.out.println("checkIfLegalForPawn: Pawn moving more than 2 rows");
            return 0; // illegal
        }

        // pawn cannot move more than 1 position diagonally
        if(colDist > 1) {
            System.out.println("checkIfLegalForPawn: Pawn moving more than 1 col");
            return 0; // illegal
        }

        // cant move 2 rows or more if not first move
        if((isFirstMove == 0) && (rowDist >= 2)) {
            System.out.println("checkIfLegalForPawn: Pawn moving 2 rows or more in non-first move");
            return 0;
        }

        // cant move along the row
        if(rowDist == 0) {
            System.out.println("checkIfLegalForPawn: Pawn moving along row");
            return 0;
        }

        // pawn moves forward by 1 (2 positions 1st move) or diagonally by 1 position
        if(!(((rowDist == 1) && (colDist == 0)) || 
             ((rowDist == 1) && (colDist == 1)) ||
             ((isFirstMove == 1) && (rowDist == 2) && (colDist == 0))
             )) {
            System.out.println("checkIfLegalForPawn: Illegal move, rowDist: " + rowDist + " colDist: " + colDist);
            return 0; // illegal
        }
        // pawn cannot move backward on the same col
        if(colDist == 0) {
            if((color == WHITE) && (fromRow > toRow)) {
                System.out.println("checkIfLegalForPawn: white pawn moving backwards");
                return 0;
            }
            else if ((color == BLACK) && (fromRow < toRow)) {
                System.out.println("checkIfLegalForPawn: black pawn moving backwards");
                return 0;
            }
        }
        // pawn cannot move backward diagonally
        if((rowDist == 1) && (colDist == 1)) {
            if((color == WHITE) && (fromRow > toRow)) {
                System.out.println("checkIfLegalForPawn: white pawn moving backwards diagonally");
                return 0;
            }
            else if ((color == BLACK) && (fromRow < toRow)) {
                System.out.println("checkIfLegalForPawn: black pawn moving backwards diagonally");
                return 0;
            }
        }
        // pawn can move forward diagonally only if there is a piece in the
        // toCell position or it is enpassant
        if((rowDist == 1) && (colDist == 1)) {
            String pieceKilled = getPieceNameByPosition(toPos);
            if(pieceKilled.equals("")) {
                // check for en passant
                // get last move
                Tuple7<Integer, String, Integer, String, String, String, Integer> t7 = getLastMove();
                // check if the last piece moved was a pawn
                String lastPieceMoved = t7.getSecond();
                if(((color == WHITE) && (lastPieceMoved.equals("BP")))
                   || ((color == BLACK) && (lastPieceMoved.equals("WP")))) {
                    // see if the last piece is 1 row below toCell
                    String lastPiecePos = t7.getFifth();
                    int lastPiecePosRow = (int)(lastPiecePos.charAt(1));
                    int rowDistWithLastPiece = 
                        (toRow > lastPiecePosRow)?(toRow - lastPiecePosRow):(lastPiecePosRow - toRow);
                    if(rowDistWithLastPiece == 1) {
                        captureEnPassant = 1;
                        captureEnPassantPiece = new Tuple<String, Integer>(t7.getSecond(), t7.getThird());
                        return 1; // en passant
                    }
                    return 0; // cant move diagonally
                }
                return 0; // cant move diagonally
            }
            return 1; // piece exists in toCell position
        }
        return 1; //legal
    }
    public static int isKingUnderCheckAtPos(int color, String kingPos)
    {
        int underCheck = 0;
        if(color == WHITE) {
            // see if any black piece has put the king under check
            for (Map.Entry<Tuple<String, Integer>, String>  entry : piecePositions.entrySet()) {
                //System.out.println("position : " + position + " Value : " + entry.getValue());
                if(entry.getKey().getFirst().equals("BB")) {
                    underCheck = checkIfLegalForBishop(BLACK, entry.getValue(), kingPos);
                }
                else if(entry.getKey().getFirst().equals("BN")) {
                    underCheck = checkIfLegalForKnight(BLACK, entry.getValue(), kingPos);
                }
                else if(entry.getKey().getFirst().equals("BR")) {
                    underCheck = checkIfLegalForRook(BLACK, entry.getValue(), kingPos);
                }
                else if(entry.getKey().getFirst().equals("BQ")) {
                    underCheck = checkIfLegalForQueen(BLACK, entry.getValue(), kingPos);
                }
                else if(entry.getKey().getFirst().equals("BP")) {
                    underCheck = checkIfLegalForPawn(BLACK, entry.getValue(), kingPos);
                }
                if(underCheck == 1)
                    return 1;
            }
        }
        else if(color == BLACK) {

            // see if any white piece has put the king under check
            for (Map.Entry<Tuple<String, Integer>, String>  entry : piecePositions.entrySet()) {
                //System.out.println("position : " + position + " Value : " + entry.getValue());
                if(entry.getKey().getFirst().equals("WB")) {
                    underCheck = checkIfLegalForBishop(WHITE, entry.getValue(), kingPos);
                }
                else if(entry.getKey().getFirst().equals("WN")) {
                    underCheck = checkIfLegalForKnight(WHITE, entry.getValue(), kingPos);
                }
                else if(entry.getKey().getFirst().equals("WR")) {
                    underCheck = checkIfLegalForRook(WHITE, entry.getValue(), kingPos);
                }
                else if(entry.getKey().getFirst().equals("WQ")) {
                    underCheck = checkIfLegalForQueen(WHITE, entry.getValue(), kingPos);
                }
                else if(entry.getKey().getFirst().equals("WP")) {
                    underCheck = checkIfLegalForPawn(WHITE, entry.getValue(), kingPos);
                }
                if(underCheck == 1)
                    return 1;
            }
        }
        return 0;
    }
    public static int isKingUnderCheck(int color)
    {
        // The king is under check if any opposing piece can reach king's 
        // position in the next move.
        String kingPos = "";
        if(color == WHITE) {
            kingPos = getPiecePosition("WK", 1);
        }
        else if(color == BLACK) {
            kingPos = getPiecePosition("BK", 1);
        }
        return isKingUnderCheckAtPos(color, kingPos);
    }
    public static int isCheckMate(int color)
    {
        // This function is called only after knowing that the 
        // king is already under check
        // Check Mate if there is no valid position for the king
        // or the king is in check in each valid position that he might
        // move to

        String kingPos = "";
        int checkMate = 1;
        if(color == WHITE) {
            kingPos = getPiecePosition("WK", 1);
        }
        else if(color == BLACK) {
            kingPos = getPiecePosition("BK", 1);
        }
        // generate all possible positions for the king
        int kingCol = (int)(kingPos.charAt(0));
        int kingRow = (int)(kingPos.charAt(1));

        // move to left for WHITE
        // move to right for BLACK
        if(((char)kingCol) != 'a') {
            char col = (char)(kingCol - 1);
            char row = (char)kingRow;
            String pos = "" + col + row;
            int underCheck = isKingUnderCheckAtPos(color, pos);
            if(underCheck == 0) return 0;
        }
        // move diagonally to left and forward for WHITE
        // move diagonally to right and 1 row below for BLACK
        if((((char)kingCol) != 'a') && (((char)kingRow) != '8')) {
            char col = (char)(kingCol - 1);
            char row = (char)(kingRow + 1);
            String pos = "" + col + row;
            int underCheck = isKingUnderCheckAtPos(color, pos);
            if(underCheck == 0) return 0;
        }
        // move 1 row forward for WHITE
        // move 1 row below for BLACK
        if(((char)kingRow) != '8') {
            char col = (char)(kingCol);
            char row = (char)(kingRow + 1);
            String pos = "" + col + row;
            int underCheck = isKingUnderCheckAtPos(color, pos);
            if(underCheck == 0) return 0;
        }
        // move diagonally to right and forward for WHITE
        // move diagonally to left and back for BLACK
        if((((char)kingCol) != 'h') && (((char)kingRow) != '8')) {
            char col = (char)(kingCol + 1);
            char row = (char)(kingRow + 1);
            String pos = "" + col + row;
            int underCheck = isKingUnderCheckAtPos(color, pos);
            if(underCheck == 0) return 0;
        }
        // move to right for WHITE
        // move to left for BLACK
        if(((char)kingCol) != 'h') {
            char col = (char)(kingCol + 1);
            char row = (char)(kingRow);
            String pos = "" + col + row;
            int underCheck = isKingUnderCheckAtPos(color, pos);
            if(underCheck == 0) return 0;
        }
        // move to right and back for WHITE
        // move diagonally to left and forward for BLACK
        if((((char)kingCol) != 'h') && (((char)kingRow) != '1')) {
            char col = (char)(kingCol + 1);
            char row = (char)(kingRow - 1);
            String pos = "" + col + row;
            int underCheck = isKingUnderCheckAtPos(color, pos);
            if(underCheck == 0) return 0;
        }
        // move 1 row BACK
        // move 1 row FORWARD
        if(((char)kingRow) != '1') {
            char col = (char)(kingCol);
            char row = (char)(kingRow - 1);
            String pos = "" + col + row;
            int underCheck = isKingUnderCheckAtPos(color, pos);
            if(underCheck == 0) return 0;
        }
        // move diagonally to left and back for WHITE
        // move diagonally to right and forward for BLACK
        if((((char)kingCol) != 'a') && (((char)kingRow) != '1')) {
            char col = (char)(kingCol + 1);
            char row = (char)(kingRow - 1);
            String pos = "" + col + row;
            int underCheck = isKingUnderCheckAtPos(color, pos);
            if(underCheck == 0) return 0;
        }
        return checkMate;
    }

    public static int checkIfLegalCastling(int color, String fromPos, String toPos)
    {
        int fromCol = (int)(fromPos.charAt(0)); // convert char to ascii
        int fromRow = (int)(fromPos.charAt(1)); // convert char to ascii
        int toCol = (int)(toPos.charAt(0));
        int toRow = (int)(toPos.charAt(1));
        
        int rowDist = (fromRow > toRow) ? (fromRow - toRow) : (toRow - fromRow);
        int colDist = (fromCol > toCol) ? (fromCol - toCol) : (toCol - fromCol);

        // castling is done along same row
        if(rowDist > 0) return 0;
        if(colDist != 2) return 0;

        if((color == WHITE) && ((char)(fromRow) != '1') && ((char)(toRow) != '1')) return 0;
        if((color == BLACK) && ((char)(fromRow) != '8') && ((char)(toRow) != '8')) return 0;
        if((color == WHITE) && (!fromPos.equals("e1"))) return 0;
        if((color == WHITE) && (!toPos.equals("g1")) && (!toPos.equals("c1"))) return 0;
        if((color == BLACK) && (!fromPos.equals("e8"))) return 0;
        if((color == BLACK) && (!toPos.equals("g8")) && (!toPos.equals("c8"))) return 0;

        // if the king is under check, castling cannot be done
        if(isKingUnderCheckAtPos(color, fromPos) == 1) return 0;
        if(isKingUnderCheckAtPos(color, toPos) == 1) return 0;
        // get the rook closest to toPos that is in its initial position
        String rookPos = "";
        String rookToPos = "";
        String rookName = "";
        String piece = "";
        String rookPiece = "";
        if(color == WHITE) {
            piece = "WK";
            rookPiece = "WR";
            if(toPos.equals("g1")) { // castling to the right
                rookPos = "h1";
                rookToPos = "f1";
            }
            else if(toPos.equals("c1")) { // castling to the left
                rookPos = "a1";
                rookToPos = "d1";
            }
            rookName = "WR";
        }
        else if(color == BLACK) {
            piece = "BK";
            rookPiece = "BR";
            // rook is in a8 or h8
            if(toPos.equals("g8")) { // castling to the left
                rookPos = "h8";
                rookToPos = "f8";
            }
            else if(toPos.equals("c8")) { // castling to the right
                rookPos = "a8";
                rookToPos = "d8";
            }
            rookName = "BR";
        }
        // if the king has moved no castling can be done
        if(kingHasMoved[color] == 1) return 0;
        if(piece.equals("")) return 0;
        for (Tuple7 t7 : moves) {
            if(t7.getSecond().equals(piece)) {
                // king has moved
                return 0;
            }
        }
        // if the rook has moved, no castling can be done
        if((rookPos.equals("")) || (rookName.equals(""))) return 0;
        if(rookName.equals(getPieceNameByPosition(rookPos))) {
            int rookIndex = getPieceIndexByPosition(rookPos);
            for (Tuple7<Integer, String, Integer, String, String, String, Integer> t7 : moves) {
                if((t7.getSecond().equals(rookName)) && (t7.getThird() == rookIndex)) {
                    // rook has moved
                    return 0;
                }
            }
        }
     
        // check there are no pieces between rook and king
        int col1 = (fromCol < toCol)?fromCol:toCol;
        int col2 = (col1 == fromCol)?toCol:fromCol;
        for(int i=col1; i < colDist; i++) {
            char col = (char)i;
            char row = (char)(toRow);
            String pieceInTheWayPos = "" + col + row;
            String pieceInTheWay = getPieceNameByPosition(pieceInTheWayPos);
            if(!pieceInTheWay.equals("")) {
                return 0; // illegal
            }
        }
        return 1;
     }

     public static int doKingRookCastling(int color, String fromPos, String toPos)
     {
        String rookPos = "";
        String rookToPos = "";
        String rookName = "";
        String piece = "";
        String rookPiece = "";
        if(color == WHITE) {
            piece = "WK";
            rookPiece = "WR";
            if(toPos.equals("g1")) { // castling to the right
                rookPos = "h1";
                rookToPos = "f1";
            }
            else if(toPos.equals("c1")) { // castling to the left
                rookPos = "a1";
                rookToPos = "d1";
            }
            rookName = "WR";
        }
        else if(color == BLACK) {
            piece = "BK";
            rookPiece = "BR";
            // rook is in a8 or h8
            if(toPos.equals("g8")) { // castling to the left
                rookPos = "h8";
                rookToPos = "f8";
            }
            else if(toPos.equals("c8")) { // castling to the right
                rookPos = "a8";
                rookToPos = "d8";
            }
            rookName = "BR";
        }
        // do the castling
        kingHasMoved[color] = movePieceToPosition(piece, fromPos, toPos);
        if(kingHasMoved[color] == 1) {
            // move the rook
            for(Iterator<Map.Entry<Tuple<String,Integer>, String>>it=piecePositions.entrySet().iterator();
                it.hasNext();) {

                Map.Entry<Tuple<String, Integer>, String> entry = it.next();
            
                if((entry.getValue().equals(rookPos)) && (entry.getKey().getFirst().equals(rookPiece))) {
                    int index = entry.getKey().getSecond();
                    Tuple7<Integer, String, Integer, String, String, String, Integer> t7 = 
                        new Tuple7<Integer, String, Integer, String, String, String, Integer>(
                            (Integer)(0xff), rookPiece, index, rookPos, rookToPos, "", -1);
                    moves.add(t7);
                    it.remove();
                    piecePositions.put(new Tuple<String, Integer>(rookPiece, index), rookToPos);
                    return 1;
                }
            }
        }
        return 0;
    }
    private Global() {};
}
package ChessModel;

import java.io.IOException;
import java.util.Arrays;

public class Chess {

    public static ChessBoard board;
    
    public static void main( String[] args ) throws IOException {
    	
    	board = new ChessBoard();
    	board.printChessBoardEmpty();
    	board.printInitialChessBoard();
    	int[] coordinate = ChessHelper.stringToCoordinate("H8");
    	System.out.println("\n " + coordinate[0] + "" + coordinate[1] );
    	
    	System.out.println("\n\n---------------Piece in Path Tests--------------");
    	System.out.println("Diagonal Move tests");
    	System.out.println("Upper Right tests");
    	System.out.println("A2 to G8 Expected: Piece in Path ");
    	System.out.print("Actual: ");
    	if(board.pieceInPath("a2", "g8")) System.out.print("Piece in path");
    	else System.out.print("No piece in path");
    	System.out.println("B2 to E5 Expected: No Piece in Path ");
    	System.out.print("Actual: ");
    	if(board.pieceInPath("b2", "e5")) System.out.print("Piece in path");
    	else System.out.print("No piece in path");
    	
    	System.out.println("Upper Left Test");
    	System.out.println("G2 to A8 Expected: Piece in Path ");
    	System.out.print("Actual: ");
    	if(board.pieceInPath("g2", "a8")) System.out.print("Piece in path");
    	else System.out.print("No piece in path");
    	
    	System.out.println("e2 to c4 Expected: No Piece in Path ");
    	System.out.print("Actual: ");
    	if(board.pieceInPath("e2", "c4")) System.out.print("Piece in path");
    	else System.out.print("No piece in path");
    	
    	System.out.println("Lower Left Tests")
        
    }

}

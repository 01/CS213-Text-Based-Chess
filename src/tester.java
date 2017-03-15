import java.io.IOException;

import ChessModel.ChessBoard;
import ChessModel.ChessHelper;

public class tester {
    public static ChessBoard board;
    
    public static void main( String[] args ) throws IOException {
    	
    	board = new ChessBoard();
    	board.printChessBoardEmpty();
    	board.printInitialChessBoard();
    	pieceInPathTest();
    }
    
    public static void pieceInPathTest() {
    	System.out.println("\n\n---------------Piece in Path Tests--------------");
    	System.out.println("Diagonal Move tests");
    	System.out.println("Upper Right tests");
    	System.out.print("A2 to G8 Expected: Piece in Path ");
    	System.out.print("Actual: ");
    	if(board.pieceInPath("a2", "g8")) System.out.print("Piece in path\n");
    	else System.out.print("No piece in path\n");
    	System.out.println("B2 to E5 Expected: No Piece in Path ");
    	System.out.print("Actual: ");
    	if(board.pieceInPath("b2", "e5")) System.out.print("Piece in path\n");
    	else System.out.print("No piece in path\n");
    	
    	System.out.println("Upper Left Test");
    	System.out.print("G2 to A8 Expected: Piece in Path ");
    	System.out.print("Actual: ");
    	if(board.pieceInPath("g2", "a8")) System.out.print("Piece in path\n");
    	else System.out.print("No piece in path\n");
    	
    	System.out.print("e2 to c4 Expected: No Piece in Path ");
    	System.out.print("Actual: ");
    	if(board.pieceInPath("e2", "c4")) System.out.print("Piece in path\n");
    	else System.out.print("No piece in path\n");
    	
    	System.out.println("\nLower Left Tests");
    	System.out.println("E8 To C6 Expected: Piece in Path ");
    	System.out.print("Actual: ");
    	if(board.pieceInPath("e8", "c6")) System.out.print("Piece in path");
    	else System.out.print("No piece in path");
    	System.out.println("e7 to A3 Expected: No Piece in Path ");
    	System.out.print("Actual: ");
    	if(board.pieceInPath("e7", "a3")) System.out.print("Piece in path");
    	else System.out.print("No piece in path");
    	
    	System.out.println("\n Lower Right Tests");
    	System.out.println("c8 to G4 Expected: Piece in Path ");
    	System.out.print("Actual: ");
    	if(board.pieceInPath("c8", "g4")) System.out.print("Piece in path");
    	else System.out.print("No piece in path");
    	System.out.println("b3 to d1 Expected: Piece in Path ");
    	System.out.print("Actual: ");
    	if(board.pieceInPath("b3", "d1")) System.out.print("Piece in path");
    	else System.out.print("No piece in path");
    	
    	
 
}

}

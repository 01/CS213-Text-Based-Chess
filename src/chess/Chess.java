package chess;
import java.io.IOException;
import java.util.Arrays;

public class Chess {

    public static ChessBoard board;
    
    public static void main( String[] args ) throws IOException {
    	
    	board = new ChessBoard();
    	board.printChessBoardEmpty();
    	board.printInitialChessBoard();
        
    }

}

package ChessModel.ChessPieces;

import ChessModel.ChessHelper;

/**
 * Create Queen object with functionality of ChessPiece
 * and properties of GamePiece
 *
 * @author Sagar Patel, Andrew Khaz
 */
public class Queen extends ChessPiece {

	private static String name = "Queen";

    public Queen(char color) {
        super(name, color);
    }
    
    // Assumes check for something in path
    public boolean isValidMove(String move, boolean isCapturing) {
    	if(!super.isValidMove(move, isCapturing)) return false;
    	if(ChessHelper.moveDirection(move) == 6) return false;
    	return true;
    }

}

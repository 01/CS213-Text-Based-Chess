package ChessModel.ChessPieces;

import ChessModel.ChessHelper;

/**
 * Create King object with functionality of ChessPiece
 * and properties of GamePiece
 *
 * @author Sagar Patel, Andrew Khaz
 */
public class King extends ChessPiece {
	public static String name = "King";
    private boolean firstMove = true;

    public King(char color) {
        super(name, color);
    }
    
    public boolean isFirstMove() {
    	return this.firstMove;
    }
    
    public void setFirstMove() {
    	this.firstMove = false;
    }
    
    public boolean isValidMove(String move, boolean isCapturing) {
    	if(!super.isValidMove(move, isCapturing)) return false;
    	if(!ChessHelper.isAdjacent(move)) return false;
    	return true;
    }
 
}

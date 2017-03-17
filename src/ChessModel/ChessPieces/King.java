package ChessModel.ChessPieces;

import ChessModel.ChessHelper;

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
    
    public boolean isValidMove(String start, String end, boolean isCapturing) {
    	if(!super.isValidMove(start, end, isCapturing)) return false;
    	if(!ChessHelper.isAdjacent(start, end)) return false;
    	return true;
    }
 
}

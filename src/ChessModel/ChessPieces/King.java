package ChessModel.ChessPieces;

import ChessModel.ChessHelper;

public class King extends ChessPiece {
	public static String name = "King";
    int castled;
    char color;

    public King(char color) {
        super(name, color);
    }
    
    public boolean isValidMove(String start, String end, boolean isCapturing) {
    	if(!super.isValidMove(start, end, isCapturing)) return false;
    	if(!ChessHelper.isAdjacent(start, end)) return false;
    	return true;
    }
    public int getCastled() {
        return castled;
    }

    public void setCastled(int castled) {
        this.castled = castled;
    }

}

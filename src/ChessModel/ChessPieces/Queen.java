package ChessModel.ChessPieces;

import ChessModel.ChessHelper;

/**
 * Created by xbbl7mk on 3/3/2017.
 */
public class Queen extends ChessPiece {

	private static String name = "Queen";

    public Queen(char color) {
        super(name, color);
    }
    
    // Assumes check for something in path
    public boolean isValidMove(String start, String end, boolean isCapturing) {
    	if(!super.isValidMove(start, end, isCapturing)) return false;
    	if(ChessHelper.moveDirection(start, end) == 4) return false;
    	return true;
    }

}

package ChessModel.ChessPieces;

import ChessModel.ChessHelper;

/**
 * Created by xbbl7mk on 3/3/2017.
 */
public class Bishop extends ChessPiece {

	private static String name = "Bishop";

    public Bishop(char color) {
        super(name, color);
    }
    
    /* Bishop can travel any distance diagonally 
     * Bishop can not jump over pieces
     */
    public boolean isValidMove(String start, String end, boolean isCapturing) {
    	if(!super.isValidMove(start, end, isCapturing)) return false;
    	if(!(ChessHelper.isDiagonal(start, end))) return false;
    	return true;
    }
}

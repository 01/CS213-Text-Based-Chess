package ChessModel.ChessPieces;

import ChessModel.ChessHelper;

/**
 * Create Bishop object with functionality of ChessPiece
 * and properties of GamePiece
 *
 * @author Sagar Patel, Andrew Khaz
 */
public class Bishop extends ChessPiece {

	private static String name = "Bishop";

    public Bishop(char color) {
        super(name, color);
    }
    
    /* Bishop can travel any distance diagonally 
     * Bishop can not jump over pieces
     */
    public boolean isValidMove(String move, boolean isCapturing) {
    	if(!super.isValidMove(move, isCapturing)) return false;
    	if(!(ChessHelper.isDiagonal(move))) return false;
    	return true;
    }
}

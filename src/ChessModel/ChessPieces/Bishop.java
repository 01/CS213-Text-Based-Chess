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
    public boolean isValidMove(String RankandFile0, String RankandFile1) {
    	if(!(ChessHelper.isValidCoordinates(RankandFile0) || !(ChessHelper.isValidCoordinates(RankandFile1)))) return false;
    }
}

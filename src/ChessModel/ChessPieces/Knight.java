package ChessModel.ChessPieces;

/**
 * Created by xbbl7mk on 3/3/2017.
 */
public class Knight extends ChessPiece {
	private static String name = "Knight";

    public Knight(char color) {
        super(name, color);
    }
    
    public char getName() {
    	return 'N';
    }
    
    /* Knight can move to square 2 squres horizontally and one square vertically or 2 squares vertically 1 square horizontally
     * Knight can jump over other pieces
     */
    public boolean isValidMove(String RankandFile0, String RankandFile1) {
    	if(!(ChessHelper.isValidCoordinates(RankandFile0) || !(ChessHelper.isValidCoordinates(RankandFile1)))) return false;
    }
}

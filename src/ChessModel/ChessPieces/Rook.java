package ChessModel.ChessPieces;

/**
 * Created by xbbl7mk on 3/3/2017.
 */
public class Rook extends ChessPiece {

	private static String name = "Rook";

    public Rook(char color) {
        super(name, color);
    }
    
    // Assumes check is already made for pieces in path
    public boolean isValidMove(String start, String end, boolean isCapturing) {
    	char startRank = start.charAt(1);
    	char endRank = end.charAt(1);
    	char startFile = start.charAt(0);
    	char endFile = end.charAt(0);
    	
    	if(!super.isValidMove(start, end, isCapturing)) return false;
    	
    	if(!((startRank == endRank)|| (startFile == endFile))) return false; // If not a horizontal or vertical move
    	
    	return true;
    	
    	
    }
}

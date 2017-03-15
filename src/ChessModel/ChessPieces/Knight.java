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
    public boolean isValidMove(String start, String end, boolean isCapturing) {
    	char startRank = start.charAt(1);
    	char endRank = end.charAt(1);
    	char startFile = start.charAt(0);
    	char endFile = end.charAt(0);
    	if(!(super.isValidMove(start, end, isCapturing))) return false;
    	
    	if(!((Math.abs(startRank-endRank)<= 2) || (Math.abs(startFile - endFile) <= 2))) return false; 		// Either horizontal move or Vertical move is greater than 2 spaces
    	if(Math.abs(startRank - endRank) + Math.abs(startFile - endFile) != 3) return false;				// Horizontal plus veritcal moves != to 3 
    	
    	return true;
    }
}

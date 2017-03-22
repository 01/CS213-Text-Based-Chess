package ChessModel.ChessPieces;

/**
 * Created by xbbl7mk on 3/3/2017.
 */
public class Knight extends ChessPiece {
	private static String name = "Knight";
	private static boolean isFirstMove = true;

    public Knight(char color) {
        super(name, color);
    }
    
    public char getName() {
    	return 'N';
    }
    
    /* Knight can move to square 2 squres horizontally and one square vertically or 2 squares vertically 1 square horizontally
     * Knight can jump over other pieces
     */
    public boolean isValidMove(String move, boolean isCapturing) {
    	char startRank = move.charAt(1);
    	char endRank = move.charAt(4);
    	char startFile = move.charAt(0);
    	char endFile = move.charAt(3);
    	if(!(super.isValidMove(move, isCapturing))) return false;
    	
    	if(!((Math.abs(startRank-endRank)<= 2) || (Math.abs(startFile - endFile) <= 2))) return false; 		// Either horizontal move or Vertical move is greater than 2 spaces
    	if(Math.abs(startRank - endRank) + Math.abs(startFile - endFile) != 3) return false;				// Horizontal plus veritcal moves != to 3 
    	
    	return true;
    }
}

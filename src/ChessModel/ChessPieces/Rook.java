package ChessModel.ChessPieces;

/**
 * Create Rook object with functionality of ChessPiece
 * and properties of GamePiece
 *
 * @author Sagar Patel, Andrew Khaz
 */
public class Rook extends ChessPiece {

	private static String name = "Rook";
	private boolean firstMove = true;

    public Rook(char color) {
        super(name, color);
    }
    
    public boolean isFirstMove() {
    	return this.firstMove;
    }
    
    public void setFirstMove() {
    	this.firstMove = false;
    }
    
    // Assumes check is already made for pieces in path
    public boolean isValidMove(String move, boolean isCapturing) {
    	char startRank = move.charAt(1);
    	char endRank = move.charAt(3);
    	char startFile = move.charAt(0);
    	char endFile = move.charAt(4);
    	
    	if(!super.isValidMove(move, isCapturing)) return false;
    	
    	if(!((startRank == endRank)|| (startFile == endFile))) return false; // If not a horizontal or vertical move
    	
    	return true;
    	
    	
    }
}

package ChessModel.ChessPieces;

import ChessModel.ChessHelper;

public class Pawn extends ChessPiece {
	private static final String name = "Pawn";
	private boolean enPassable, isPromotable;

    public Pawn(char color) {
        super(name, color);
        this.enPassable = false;
        this.isPromotable = false;
    }
    
    public boolean getEnPassable(){
    	return this.enPassable;
    }
    
    /* Pawn can move only forward, Pawn can move two spaces only on first turn 
	 * Pawn can not jump over pieces on initial double move
	 * Pawn can only attack diagonally.  
	 * Pawn can not move if any piece friend/foe is in front of it
	 * Enpasse: if enemy pawn moves two places, and pawn is in position to attack "where it would have been" it counts  	
	 * Promotion: If pawn moves all the way to other end then it is "promoted" to players choosing.
	 */
    
    public boolean isValidMove(String RankandFile0, String RankandFile1, boolean isCapturing) {
    	char Rank0 = RankandFile0.charAt(1);
    	char Rank1 = RankandFile1.charAt(1);
    	char File0 = RankandFile0.charAt(0);
    	char File1 =  RankandFile1.charAt(0);
    	
    	if(!super.isValidMove(RankandFile0, RankandFile1, isCapturing)) return false;
    	
    	// Pawn can only move forward so File should be same for start and finish unless attacking, but should always be forward
    	if(Math.abs((File0 - File1)) > 1) return false;
    	if(Math.abs(File0-File1) > 0 && !isCapturing) return false;			// Can only move diagonal if capturing
    	if((File0 == File1) && isCapturing) return false;					// Pawn can not capture on vertical move
    	// Check to see what player
    	if(this.color == 'w') {
    		if((Rank0-Rank1) > 1) return false;

    		if(Rank0 == '2') {
    			if(Rank1 == '4')this.enPassable = true;
    			return true;
    		}
    		if(Rank1 == '8') {
    			this.isPromotable = true;
    			return true;
    		}
    	}
    	else {
    		if((Rank0-Rank1) < 1) return false;
    	
    		if(Rank0 == '7') {
    			//Its first move
    			if(Rank1 == '5') this.enPassable = true;					// Sets enPassable if the pawn is being moved two spaces
    			return true;
    		}
    		if(Rank1 == '1') {
    			this.isPromotable = true;
    		}
    	}
		this.enPassable = false;
    	return true;
    }
}




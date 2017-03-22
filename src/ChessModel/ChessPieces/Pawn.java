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
    
    public boolean getPromotable() {
    	return this.isPromotable;
    }
    /* Pawn can move only forward, Pawn can move two spaces only on first turn 
	 * Pawn can not jump over pieces on initial double move
	 * Pawn can only attack diagonally.  
	 * Pawn can not move if any piece friend/foe is in front of it
	 * Enpasse: if enemy pawn moves two places, and pawn is in position to attack "where it would have been" it counts  	
	 * Promotion: If pawn moves all the way to other end then it is "promoted" to players choosing.
	 */
    
    public boolean isValidMove(String move, boolean isCapturing) {
    	System.out.println("isValidMove: " + move);
    	char startRank = move.charAt(1);
    	char endRank = move.charAt(4);
    	char startFile = move.charAt(0);
    	char endFile = move.charAt(3);
    	
    	if(!super.isValidMove(move, isCapturing)) return false;
    	// Pawn can only move forward so File should be same for start and finish unless attacking, but should always be forward
    	if(Math.abs(startFile - endFile) > 1) return false;
    	if(Math.abs(startFile-endFile) > 1 && !isCapturing) return false;
    	
    	if((startFile == endFile) && isCapturing) return false;					// Pawn can not capture on vertical move
    
    	// Check to see what player
    	if(this.color == 'w') {
    		if((startRank-endRank) > 0) return false;

    		if(startRank == '2') {
    			if(endRank == '4')this.enPassable = true;
    			return true;
    		}
    		if(endRank == '8') {
    			this.isPromotable = true;
    			return true;
    		}
    	}
    	else {
    		//System.out.println("Start "+ RankandFile0 + "makes it here1");
    		if((startRank-endRank) < 1) return false;
    	
    		if(startRank == '7') {
    			//Its first move
    			if(endRank == '5') {
    				this.enPassable = true;	
    				return true;				// Sets enPassable if the pawn is being moved two spaces
    			}
    			//System.out.println("Start "+ RankandFile0 + "makes it here");
    			
    		}
    		if(endRank == '1') {
    			this.isPromotable = true;
    			return true;
    		}
    	}
		this.enPassable = false;		// If moved for any non enPassable set no longer enPassable
    	this.isPromotable=false;
		return true;
    }
}




package ChessModel.ChessPieces;

import GameModel.GamePiece;

/**
 * Created by xbbl7mk on 3/3/2017.
 */
public abstract class ChessPiece extends GamePiece {

    public ChessPiece(String name, char color) {
        super(name, color);
    }

    public char getColor() {
        return this.color;
    }

    public char getName() {
    	return this.name.charAt(0);
    }
    
    public boolean isValidMove(String move, boolean isCapture) {
    	String [] moveParse = move.split(" ");
    	
    	char Rank0 = moveParse[0].toLowerCase().charAt(1);
    	char File0 = moveParse[0].toLowerCase().charAt(0);
    	char Rank1 = moveParse[1].toLowerCase().charAt(1);
    	char File1 = moveParse[1].toLowerCase().charAt(0);
    	
    	if(Rank0 < '1' || Rank1 < '1' || Rank1 >'8' || Rank0 > '8') return false;
    	if(File0 < 'a' || File1 < 'a' || File1 > 'h' || File0 > 'h') return false;
    	return true;	
    }

	public boolean getEnPassable() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean getPromotable() {
		return false;
	}

	public boolean isFirstMove() {
		// TODO Auto-generated method stub
		return false;
	}
    
  
}

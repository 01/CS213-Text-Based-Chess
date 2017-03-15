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

    public char getNameI() {
    	return this.name.charAt(0);
    }
    
    public boolean isValidMove(String start, String end, boolean isCapture) {
    	char Rank0 = start.toLowerCase().charAt(1);
    	char File0 = end.toLowerCase().charAt(0);
    	
    	if(Rank0 < '1' || Rank0 > '8') return false;
    	if(File0 < 'a' || File0> 'f') return false;
    	return true;	
    }

	public boolean getEnPassable() {
		// TODO Auto-generated method stub
		return false;
	}
    
  
}

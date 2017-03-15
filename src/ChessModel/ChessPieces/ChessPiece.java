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
    
    public boolean isValidMove(String RankandFile) {
    	char Rank = RankandFile.toLowerCase().charAt(0);
    	char File = RankandFile.toLowerCase().charAt(1);
    	
    	if(Rank < '1' || Rank > '8') return false;
    	if(File < 'a' || File > 'f') return false;
    	return true;	
    }
    
  
}

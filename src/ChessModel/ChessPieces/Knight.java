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
}

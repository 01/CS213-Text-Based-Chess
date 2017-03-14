package chess;

/**
 * Created by xbbl7mk on 3/3/2017.
 */
public abstract class ChessPiece extends GamePiece {

    private String name;
    private char color;

    public ChessPiece(String name, char color) {
        this.name = name;
        this.color = color;
    }

    public char getColor() {
        return this.color;
    }

    public char getName() {
    	return this.name.charAt(0);
    }

}

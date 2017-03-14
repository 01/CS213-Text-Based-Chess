package ChessModel.ChessPieces;

public class King extends ChessPiece {
	public static String name = "King";
    int castled;
    char color;

    public King(char color) {
        super(name, color);
       
    }

    public int getCastled() {
        return castled;
    }

    public void setCastled(int castled) {
        this.castled = castled;
    }

}

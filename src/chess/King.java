package chess;

public class King extends ChessPiece {

    int castled;

    public King(String name, int row, int col) {
        super(name, row, col);
        castled =0;
    }

    public int getCastled() {
        return castled;
    }

    public void setCastled(int castled) {
        this.castled = castled;
    }

}

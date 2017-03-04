package chess;

/**
 * Created by xbbl7mk on 3/3/2017.
 */
public class WhitePawn extends ChessPiece {

    int firstMove;

    public WhitePawn(String name, int row, int col) {
        super(name, row, col);
        int firstMove =0;
    }

    public int getFirstMove() {
        return firstMove;
    }

    public void setFirstMove(int firstMove) {
        this.firstMove = firstMove;
    }

}

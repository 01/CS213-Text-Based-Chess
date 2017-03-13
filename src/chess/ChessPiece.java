package chess;

/**
 * Created by xbbl7mk on 3/3/2017.
 */
public abstract class ChessPiece {

    private String name;
    private int row;
    private int col;

    public ChessPiece(String name, int row, int col) {
        this.name = name;
        this.row = row;
        this.col = col;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }



}
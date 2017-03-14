package GameModel;

public class BoardSquare{
	public GamePiece piece;
	public int row, column;
	
	public BoardSquare(int row, int column, GamePiece piece) {
		this.row = row;
		this.column = column;
		this.piece = piece;
	}
}
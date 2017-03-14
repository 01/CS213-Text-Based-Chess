package chess;

public class ChessBoardSquare extends BoardSquare {
	public char color;
	public char rank, file;
	
	public ChessBoardSquare(int row, int column, GamePiece piece, char color) {
		super(row, column, piece);
		this.rank = Character.forDigit((8 -row), 10);
		this.file = (char) (column + 'a');
	}

}

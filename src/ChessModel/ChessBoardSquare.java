package ChessModel;

import ChessModel.ChessPieces.ChessPiece;
import GameModel.BoardSquare;

public class ChessBoardSquare extends BoardSquare {
	public char color;
	public char rank, file;
	
	public ChessBoardSquare(int row, int column, ChessPiece piece, char color) {
		super(row, column, piece);
		this.piece = (ChessPiece)this.piece;
		this.rank = Character.forDigit((8 -row), 10);
		this.file = (char) (column + 'a');
		this.color = color;
	}

}

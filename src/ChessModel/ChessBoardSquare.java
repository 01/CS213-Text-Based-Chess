package ChessModel;

import ChessModel.ChessPieces.ChessPiece;
import GameModel.BoardSquare;

/**
 * Holds a piece at a specific square on the 8x8 board
 *
 *@author Sagar Patel, Andrew Khaz
 */
public class ChessBoardSquare extends BoardSquare {
	public char color;
	public char rank, file;
	public ChessPiece piece;
	
	public ChessBoardSquare(int row, int column, ChessPiece piece, char color) {
		super(row, column);
		this.piece = piece;
		this.rank = Character.forDigit((8 -row), 10);
		this.file = (char) (column + 'a');
		this.color = color;
	}

}

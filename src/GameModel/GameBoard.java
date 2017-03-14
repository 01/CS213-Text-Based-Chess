package GameModel;

public abstract class GameBoard {
	public BoardSquare [][] GameBoard;
	public int columns;
	public int rows;
	
	public GameBoard(int columns, int rows) {
		this.columns = columns;
		this.rows = rows;
		initializeEmptyBoard();
	}
	
	public void initializeEmptyBoard() {
		this.GameBoard = new BoardSquare[rows][columns];
		for(int i = 0; i < rows; i++) {
			for(int k =0; k < columns; k++) {
				this.GameBoard[i][k] = new BoardSquare(i, k, null);
			}
		}
	}
	
	  public boolean isPieceInPath(int [] start, int [] end) {
		  return false;
	    }
}

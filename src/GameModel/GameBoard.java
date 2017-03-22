package GameModel;

public abstract class GameBoard {
	public int columns;
	public int rows;
	
	public GameBoard(int columns, int rows) {
		this.columns = columns;
		this.rows = rows;
	}
}

package GameModel;

public abstract class  BoardSquare{
	public int row, column;
	
	public BoardSquare(int row, int column) {
		this.row = row;
		this.column = column;
	}
}
package GameModel;

/**
 * Parameters for all singular square on board
 *
 * @author Sagar Patel, Andrew Khaz
 */
public abstract class  BoardSquare{
	public int row, column;
	
	public BoardSquare(int row, int column) {
		this.row = row;
		this.column = column;
	}
}
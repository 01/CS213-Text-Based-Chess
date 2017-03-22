package GameModel;

/**
 * Parameters for all game pieces
 *
 * @author Sagar Patel, Andrew Khaz
 */
public abstract class GamePiece {
	public String name;
	public char color;
	
	public GamePiece(String name, char color) {
		this.name = name;
		this.color = color;
	}
	
	public char getColor() {
		return this.color;
	}
	
	public char getNameI() {
		return this.name.charAt(0);
	}
	
	

}

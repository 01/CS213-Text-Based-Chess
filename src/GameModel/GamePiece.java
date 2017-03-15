package GameModel;

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

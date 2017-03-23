package ChessModel;

/**
 * Helper methods invoked during movement
 * of a piece
 *
 * @author Sagar Patel, Andrew Khaz
 */
public class ChessHelper {

	/**
	 * convert alpha numerical pair to Int x Int position
	 * ex. a1 -> 01
	 *
	 * @param position 	the position desired to be converted
	 * @return 			coordinates of position
	 *
	 */
	public static int[] stringToCoordinate(String position) {
		int[] coordinates = new int[2];
		coordinates[0] = '8'-position.toLowerCase().charAt(1);
		coordinates[1] =  position.toLowerCase().charAt(0) - 'a';
		return coordinates;
	}

	/**
	 * ensures validity of coordinates within 8x8 board
	 *
	 * @param move 	position of piece
	 * @return 		boolean valid or not
	 */
	public static boolean isValidCoordinates(String move) {
		int [] coordinates = ChessHelper.stringToCoordinate(move);
    	if(coordinates[0] > 7 || coordinates[0] < 0) return false;
    	if(coordinates[1] > 7 || coordinates[1] < 0) return false;
    	return true;
	}

	/**
	 * determine direction of movement
	 *
	 * @param move	position of start and end
	 * @return 		direction of movement
	 */
	public static int moveDirection (String move) {
		String [] moveParse = move.split(" ");
		String start = moveParse[0];
		String end = moveParse[1];
		// 1 = HoriztonalLeft, 2 = HorizontalRight, 3 = VerticalUp, 4 = VerticalDown, 5 = Diagonal , 6= Not normal
		int [] startCoords = ChessHelper.stringToCoordinate(start);
		int [] endCoords = ChessHelper.stringToCoordinate(end);
		
		if(startCoords[0] == endCoords[0]) {
			return (startCoords[1] > endCoords[1]) ? 1: 2;
		}
		else if(startCoords[1] == endCoords[1]) {
			return (startCoords[0] > endCoords[0]) ? 3: 4;
		}
		else if (isDiagonal(move)) return 5;
		else return 6;
	}

	/**
	 * determine up or down the board then subsequently
	 * left or right movement
	 *
	 * @param move position of start and end
	 * @return 		boolean left or right
	 */
	public static int verticalMoveDirection(String move) {
		// 1 = UR, 2 = UL, 3 = LR, 4= LL
		String[] moveParse = move.split(" ");
		String start = moveParse[0];
		String end = moveParse[1];
		int [] startCoords = ChessHelper.stringToCoordinate(start);
		int [] endCoords = ChessHelper.stringToCoordinate(end);
		if(startCoords[0] < endCoords[0]) { 						  	// Moving down board
			if(startCoords[1] < endCoords[1]) return 3;				 	// Moving to the right of Board
			else return 4;												// Moving to the left of Board
		}
		else {															// Moving up board
			if(startCoords[1] < endCoords[1]) return 1;  				// Moving to the right of Board
			else return 2;												// Moving to the left of Board
		}
	}

	/**
	 * determine if diagonal movement
	 *
	 * @param move position of start and end
	 * @return 		boolean is or not
	 */
	public static boolean isDiagonal(String move) {
		if(move.charAt(1)-move.charAt(4) == 0) return false;
		return (Math.abs((move.charAt(0) - move.charAt(3))/(move.charAt(1)-move.charAt(4))) == 1);
	}

	/**
	 * determine if the move is one move away
	 *
	 * @param move position of start and end
	 * @return 		boolean is or not
	 */
	public static boolean isAdjacent(String move) {
		char startRank = move.charAt(1);
		char endRank = move.charAt(4);
		char startFile = move.charAt(0);
		char endFile = move.charAt(3);
		
		return ((Math.abs(startRank-endRank)+ Math.abs(startFile-endFile)) ==1);
	}

}

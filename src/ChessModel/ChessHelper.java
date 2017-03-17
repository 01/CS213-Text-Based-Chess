package ChessModel;

public class ChessHelper {
	
	public static int[] stringToCoordinate(String position) {
		int[] coordinates = new int[2];
		coordinates[0] = '8'-position.toLowerCase().charAt(1);
		coordinates[1] =  position.toLowerCase().charAt(0) - 'a';
		return coordinates;
	}
	
	public static boolean isValidCoordinates(String move) {
		int [] coordinates = ChessHelper.stringToCoordinate(move);
    	if(coordinates[0] > 7 || coordinates[0] < 0) return false;
    	if(coordinates[1] > 7 || coordinates[1] < 0) return false;
    	return true;
	}
	
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
			return (startCoords[0] > endCoords[0]) ? 3: 5;
		}
		else if (isDiagonal(start, end)) return 5;
		else return 6;
	}
	
	public static int verticalMoveDirection(String start, String end) {
		// 1 = UR, 2 = UL, 3 = LR, 4= LL
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
	
	public static boolean isDiagonal(String start, String end) {
		return (Math.abs((start.charAt(0) - end.charAt(0))/(start.charAt(1)-end.charAt(1))) == 1);
	}
	
	public static boolean isAdjacent(String start, String end) {
		char startRank = start.charAt(1);
		char endRank = end.charAt(1);
		char startFile = start.charAt(0);
		char endFile = end.charAt(0);
		
		return ((Math.abs(startRank-endRank)+ Math.abs(startFile-endFile)) == 1);
	}

}

package ChessModel;

public class ChessHelper {
	
	public static int[] stringToCoordinate(String RankandFile) {
		int[] coordinates = new int[2];
		coordinates[0] = '8'-RankandFile.toLowerCase().charAt(1);
		coordinates[1] =  RankandFile.toLowerCase().charAt(0) - 'a';
		return coordinates;
	}
	
	public static boolean isValidCoordinates(String RankandFile) {
		int [] coordinates = ChessHelper.stringToCoordinate(RankandFile);
    	if(coordinates[0] > 7 || coordinates[0] < 0) return false;
    	if(coordinates[1] > 7 || coordinates[1] < 0) return false;
    	return true;
	}
	
	public static int moveDirection (String start, String end) {
		// 1 = Horiztonal, 2 = Vertical, 3 = Diagonal 
		int [] startCoords = ChessHelper.stringToCoordinate(start);
		int [] endCoords = ChessHelper.stringToCoordinate(end);
		
		if(startCoords[0] == endCoords[0]) return 1;
		else if(startCoords[1] == endCoords[1]) return 2;
		else return 3;
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

}

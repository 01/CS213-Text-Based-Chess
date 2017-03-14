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

}

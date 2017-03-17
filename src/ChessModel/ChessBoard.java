package ChessModel;

import ChessModel.ChessPieces.*;
import GameModel.GameBoard;

public class ChessBoard extends GameBoard{
	public static final int numRanks = 8;
	public static final int numFiles = 8;

	public static final char WHITE = 'w';
	public static final char BLACK = 'b';
	
	public ChessBoardSquare[][] chessBoard;
	
	public ChessBoard() {
		super(numRanks, numFiles);
		this.chessBoard = new ChessBoardSquare[numRanks][numFiles];
		initializeEmptyBoard();
		initializeChessBoard();
	}
	
	public void initializeEmptyBoard()  {
		int colorTrack = 1;
		for(int i = 0; i < rows; i++) {
			colorTrack--;
			for(int k =0; k < columns; k++) {
				if(colorTrack%2==0) {
					this.chessBoard[i][k] = new ChessBoardSquare(i, k, null, 'W');
					colorTrack++;
					//System.out.println(((ChessBoardSquare)GameBoard[i][k]).file);
				}
				else {
					this.chessBoard[i][k] = new ChessBoardSquare(i, k, null, 'B');
					//System.out.println(((ChessBoardSquare)GameBoard[i][k]).file);
					colorTrack++;
					
				}
			}
		}
	}
	
	public void initializeChessBoard() {
		// Initialize Pawns
		for(int i = 0; i < numRanks; i++ ) {
			this.chessBoard[1][i].piece = (Pawn)(new Pawn(BLACK));
			this.chessBoard[6][i].piece = (Pawn)(new Pawn(WHITE));
		}
		
		// Initiaze Rooks
		this.chessBoard[0][0].piece = (Rook) (new Rook(BLACK));
		this.chessBoard[0][7].piece = (Rook) (new Rook(BLACK));
		this.chessBoard[7][0].piece = (Rook) (new Rook(WHITE));
		this.chessBoard[7][7].piece = new Rook(WHITE);
		
		//Initialize Knights
		this.chessBoard[0][1].piece = new Knight(BLACK);
		this.chessBoard[0][6].piece = new Knight(BLACK);
		this.chessBoard[7][1].piece = new Knight(WHITE);
		this.chessBoard[7][6].piece = new Knight(WHITE);
		
		//Initialize Bishops
		this.chessBoard[0][2].piece = new Bishop(BLACK);
		this.chessBoard[0][5].piece = new Bishop(BLACK);
		this.chessBoard[7][2].piece = new Bishop(WHITE);
		this.chessBoard[7][5].piece = new Bishop(WHITE);
		
		//Initialize Kings
		this.chessBoard[0][4].piece = new King(BLACK);
		this.chessBoard[7][4].piece = new King(WHITE);
		
		//Initialize Queens 
		this.chessBoard[0][3].piece =  new Queen(BLACK);
		this.chessBoard[7][3].piece = new Queen(WHITE);

	}
	
	
	public void printChessBoardEmpty() {
		for(int i = 0; i < rows; i++) {
			System.out.println("");
			for(int k =0; k < columns; k++) {
				System.out.print(this.chessBoard[i][k].file +""+ this.chessBoard[i][k].rank + " ");
	
			}
		}
	}
	/* pieceInPath assumes valid move for ChessPiece type */
	public boolean pieceInPath(String start, String end) {
		int moveType = ChessHelper.moveDirection(start + " " + end);
		int [] startCoordinates = ChessHelper.stringToCoordinate(start);
		int [] endCoordinates = ChessHelper.stringToCoordinate(end);
		
		switch (moveType) {
			case 1 :										// Moving Horizontally
				if(startCoordinates[1] < endCoordinates[1]) {
						for(int k = (startCoordinates[1]+1); k < endCoordinates[1]; k++) {
							if(this.chessBoard[startCoordinates[0]][k].piece != null) return true;
						}
						return false;
				}
				else {
					for(int k = (endCoordinates[1] + 1); k < startCoordinates[1]; k++){
						if(this.chessBoard[startCoordinates[0]][k].piece != null) return true;
					}
					return false;
				}
				
			case 2 :									// Moving Vertically
				if(startCoordinates[0] < endCoordinates[0]) {
					for(int i = (startCoordinates[0] + 1); i < endCoordinates[0]; i++ ) {
						if(this.chessBoard[i][startCoordinates[1]].piece != null) return true;
					}
					return false;
				}
				else {
					for(int i = (endCoordinates[0] + 1); i < startCoordinates[0]; i++) {
						if(this.chessBoard[i][endCoordinates[0]].piece != null) return true;
					}
					return false;
				}
			
			case 3 :								// Moving Diagonal
				switch(ChessHelper.verticalMoveDirection(start, end)) {
					case 1 :						// Moving Upper Right Direction
						for(int i = 0; i < (startCoordinates[0]-endCoordinates[0]-1); i++) {
							if(this.chessBoard[endCoordinates[0]+1+i][endCoordinates[1]-1-i].piece != null) return true;
						}
						return false;
	
					case 2:							// Moving Upper Left
						for(int i = 0; i < (startCoordinates[0]-endCoordinates[0]-1); i++) {
							if(this.chessBoard[endCoordinates[0]+1+i][endCoordinates[1]+1+i].piece != null) return true;
						}
						return false;
						
					case 3:							// Moving Lower Right
						for(int i = 0; i < (endCoordinates[0]-startCoordinates[0]-1); i++) {
							if(this.chessBoard[startCoordinates[0]+1+i][startCoordinates[1] + 1 + i].piece != null) return true;
						}
						
						return false;
						
					
					case 4: 						// Moving Lower Left
						for(int i = 0; i < (endCoordinates[0] - startCoordinates[0]-1); i++) {
							if(this.chessBoard[startCoordinates[0] + 1 + i][startCoordinates[1]-1-i].piece != null) return true;
						}
						return false;
					
					
					default: 
						return false;
						
				}
			default:
				return false;
				
		}
	}
	
	public void printChessBoard() {
		System.out.println("\n-----------------------------");
		System.out.println("Initial Positions");
		for(int i = 0; i < rows; i++) {
			
			System.out.println("");
			for(int k =0; k < columns; k++) {
				if(this.chessBoard[i][k].piece!=null)System.out.print(this.chessBoard[i][k].piece.getColor() +""+ this.chessBoard[i][k].piece.getName() + " ");
				else if(this.chessBoard[i][k].color == 'B')System.out.print("## ");
				else System.out.print("   ");
			}
			System.out.print(8-i);
		}
		System.out.println("\n a  b  c  d  e  f  g  h");
		
	}
	
	public boolean attemptMove(String start, String end, char playersTurnColor) {
		int [] startPiece = ChessHelper.stringToCoordinate(start);
		int [] endPiece = ChessHelper.stringToCoordinate(end);
		boolean isCapturing = false;
		
		System.out.println("\nAttempting move: " + start + " " + end + " " + endPiece[0]);
		//if(this.chessBoard[endPiece[0]-1][endPiece[1]].piece != null)System.out.println(this.chessBoard[endPiece[0]-1][endPiece[1]].piece.getEnPassable());
		
		if(this.chessBoard[startPiece[0]][startPiece[1]].piece == null || this.chessBoard[startPiece[0]][startPiece[1]].piece.getColor() != playersTurnColor) return false;
		if(this.chessBoard[endPiece[0]][endPiece[1]].piece != null) {
			if(this.chessBoard[endPiece[0]][endPiece[1]].piece.getColor() == playersTurnColor) return false; 
			if(this.chessBoard[endPiece[0]][endPiece[1]].piece.getColor() != playersTurnColor) isCapturing = true;
		}
		//enPasse Check
		else if(this.chessBoard[startPiece[0]][startPiece[1]].piece.getName() == 'P' && (endPiece[0] == 2 || endPiece[0] == 5) && ChessHelper.isDiagonal(start, end)) {
				if(startPiece[0] > endPiece[0]) {
					if(this.chessBoard[endPiece[0] + 1][endPiece[1]].piece.getEnPassable()) return true;
				}
				else {
					if(this.chessBoard[endPiece[0] -1][endPiece[1]].piece.getEnPassable()) return true;
				}
		}
		else if(isCastling(startPiece, endPiece, start+ " " +end)) {
			if(startPiece[1] > endPiece[1]) {
				this.chessBoard[startPiece[0]][startPiece[1]-1].piece = this.chessBoard[endPiece[0]][endPiece[1]-2].piece;
				this.chessBoard[endPiece[0]][endPiece[1]-2].piece = null;
			}
			else {
				this.chessBoard[startPiece[0]][startPiece[1]+1].piece = this.chessBoard[endPiece[0]][endPiece[1] + 1].piece;
				this.chessBoard[endPiece[0]][endPiece[1]+1].piece = null;
			}
			return true;
			
		}
		if(this.pieceInPath(start, end) && (this.chessBoard[startPiece[0]][startPiece[1]].piece.getName() != 'N')) return false;
		//System.out.println("Makes it past pieceInPath Check");
		if(!(this.chessBoard[startPiece[0]][startPiece[1]].piece.isValidMove(start, end, isCapturing))) return false;
		
		return true;
		
	}
	
	public void makeMove(String move, char playersTurnColor) {
		String [] moveParse = move.split(" ");
		String special = null;
		if(moveParse.length == 3) special = moveParse[2];
		String start = moveParse[0];
		String end = moveParse[1];
		
		if(!this.attemptMove(start, end, playersTurnColor)) {
			System.out.println("\nInvalid Move " + start + " " + end);
			return;
		}
		int [] startPiece = ChessHelper.stringToCoordinate(start);
		int [] endPiece = ChessHelper.stringToCoordinate(end);
		
		// EnPasse
		if(this.chessBoard[startPiece[0]][startPiece[1]].piece.getName() == 'P') {
			if(ChessHelper.isDiagonal(start, end) && this.chessBoard[endPiece[0]][endPiece[1]].piece == null) {
				if(startPiece[0] > endPiece[0]) {
					this.chessBoard[endPiece[0] + 1][endPiece[1]].piece = null;
				}
				else {
					this.chessBoard[endPiece[0] -1][endPiece[1]].piece = null;
				}
			}
		}
		
		this.chessBoard[endPiece[0]][endPiece[1]].piece = this.chessBoard[startPiece[0]][startPiece[1]].piece;
		this.chessBoard[startPiece[0]][startPiece[1]].piece = null;
		if(this.chessBoard[endPiece[0]][endPiece[1]].piece.getName() == 'P' && this.chessBoard[endPiece[0]][endPiece[1]].piece.getPromotable()) {
			this.chessBoard[endPiece[0]][endPiece[1]].piece = getPromotion(special, playersTurnColor);
		}
	}
	
	public boolean isCastling(int[] startPiece, int[] endPiece, String move) {
		int moveDirection = ChessHelper.moveDirection(move);
		String [] moveParse = move.split(" ");
		String start = moveParse[0];
		String end = moveParse[1];
		if(!(this.chessBoard[startPiece[0]][startPiece[1]].piece.getName() == 'K') || !this.chessBoard[startPiece[0]][startPiece[1]].piece.isFirstMove()) return false;
		if(moveDirection == 1 || moveDirection != 2) return false;
		if(Math.abs(startPiece[1]-endPiece[1])!= 2) return false;
		if(moveDirection == 1) {
			if(!(this.chessBoard[endPiece[0]][endPiece[1] - 2].piece.getName() == 'R') || !this.chessBoard[endPiece[0]][endPiece[1] - 2].piece.isFirstMove()) return false;

		}
		if(moveDirection == 2) {
			if(!(this.chessBoard[endPiece[0]][endPiece[1] + 1].piece.getName() == 'R') || !this.chessBoard[endPiece[0]][endPiece[1] + 1].piece.isFirstMove()) return false;
		}
		if(pieceInPath(start, end) || this.chessBoard[endPiece[0]][endPiece[1]].piece != null) return false;
		
		return true;
		
		
	}
	
	public boolean isCastableFirstMoves(int [] firstPiece, int[] endPiece) {
		if()
	}
	public ChessPiece getPromotion(String special, char playersTurnColor) {
		if(special == null) special = "Q";
		switch(special.toLowerCase().charAt(0)) {
			case 'r' :
				return new Rook(playersTurnColor);
			case 'n' : 
				return new Knight(playersTurnColor);
			case 'b' :
				return new Bishop(playersTurnColor);
			case 'q' : 
				return new Queen(playersTurnColor);
			case 'p' :
				return new Pawn(playersTurnColor);
			default :
				return new Queen(playersTurnColor);
		}
	}
}

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
		this.chessBoard = (ChessBoardSquare[][]) this.GameBoard;
		initializeChessBoard();
	}
	
	public void initializeEmptyBoard()  {
		this.GameBoard = new ChessBoardSquare[numRanks][numFiles];
		int colorTrack = 1;
		for(int i = 0; i < rows; i++) {
			colorTrack--;
			for(int k =0; k < columns; k++) {
				if(colorTrack%2==0) {
					GameBoard[i][k] = new ChessBoardSquare(i, k, null, 'W');
					colorTrack++;
					//System.out.println(((ChessBoardSquare)GameBoard[i][k]).file);
				}
				else {
					GameBoard[i][k] = new ChessBoardSquare(i, k, null, 'B');
					//System.out.println(((ChessBoardSquare)GameBoard[i][k]).file);
					colorTrack++;
					
				}
			}
		}
	}
	
	public void initializeChessBoard() {
		// Initialize Pawns
		for(int i = 0; i < numRanks; i++ ) {
			this.chessBoard[1][i].piece = new Pawn(BLACK);
			this.chessBoard[numFiles-2][i].piece = new Pawn(WHITE);
		}
		
		// Initiaze Rooks
		this.chessBoard[0][0].piece = new Rook(BLACK);
		this.chessBoard[7][0].piece = new Rook(BLACK);
		this.chessBoard[0][7].piece = new Rook(WHITE);
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
	public boolean pieceInPath(String start, String end, char pieceType) {
		int moveType = ChessHelper.moveDirection(start, end);
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
					for(int k = (endCoordinates[1] + 1; k < startCoordinates[1]; k++){
						if(this.chessBoard[startCoordinates[0]][k].piece != null) return true;
					}
					return false;
				}
				break;
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
				break;
			case 3 :								// Moving Diagonal
				switch(ChessHelper.verticalMoveDirection(start, end)) {
					case 1 :						// Moving Upper Right Direction
						for(int i = 0; i < (startCoordinates[0]-endCoordinates[0]-1); i++) {
							if(this.chessBoard[endCoordinates[0]+1+i][endCoordinates[1]-1-i].piece != null) return true;
						}
						return false;
						break;
					case 2:							// Moving Upper Left
						for(int i = 0; i < (startCoordinates[0]-endCoordinates[0]-1); i++) {
							if(this.chessBoard[endCoordinates[0]+1+i][endCoordinates[1]+1+i].piece != null) return true;
						}
						return false;
						break;
					case 3:							// Moving Lower Right
						for(int i = 0; i < (endCoordinates[0]-startCoordinates[0]-1); i++) {
							if(this.chessBoard[startCoordinates[0]+1+i][startCoordinates[1] + 1 + i].piece != null) return true;
						}
						
						return false;
						break;
					
					case 4: 						// Moving Lower Left
						for(int i = 0; i < (endCoordinates[0] - startCoordinates[0]-1); i++) {
							if(this.chessBoard[startCoordinates[0] + 1 + i][startCoordinates[0]-1-i].piece != null) return true;
						}
						return false;
						break;
					
					default: 
						return false;
						
				}
				
		}
	}
	
	public void printInitialChessBoard() {
		System.out.println("\n-----------------------------");
		System.out.println("Initial Positions");
		for(int i = 0; i < rows; i++) {
			System.out.println("");
			for(int k =0; k < columns; k++) {
				if(this.chessBoard[i][k].piece!=null)System.out.print(this.chessBoard[i][k].piece.getColor() +""+ this.chessBoard[i][k].piece.getNameI() + " ");
				else if(this.chessBoard[i][k].color == 'B')System.out.print("## ");
				else System.out.print("   ");
			}
		}
		
	}
	
}

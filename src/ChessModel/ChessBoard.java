package ChessModel;

import ChessModel.ChessPieces.*;
import GameModel.GameBoard;

public class ChessBoard extends GameBoard{
	public static final int numRanks = 8;
	public static final int numFiles = 8;
		;
	public static final String BLACK_SQUARE = "##";
	public static final String WHITE_SQUARE = "  ";
	public static final String FILE_ROW = " a  b  c  d  e  f  g  h";
	public static final char WHITE = 'w';
	public static final char BLACK = 'b';
	
	ChessBoardSquare whiteKingSquare, blackKingSquare;
	
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
					this.chessBoard[i][k] = new ChessBoardSquare(i, k, null, WHITE);
					colorTrack++;
					//System.out.println(((ChessBoardSquare)GameBoard[i][k]).file);
				}
				else {
					this.chessBoard[i][k] = new ChessBoardSquare(i, k, null, BLACK);
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
			this.chessBoard[6][i].piece = new Pawn(WHITE);
		}
		
		// Initiaze Rooks
		this.chessBoard[0][0].piece = new Rook(BLACK);
		this.chessBoard[0][7].piece = new Rook(BLACK);
		this.chessBoard[7][0].piece = new Rook(WHITE);
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
		this.whiteKingSquare = this.chessBoard[7][4];
		this.blackKingSquare = this.chessBoard[0][4];
		
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
	public boolean pieceInPath(String move) {
		int moveType = ChessHelper.moveDirection(move);
		String [] moveParse = move.split(" ");
		int [] startCoordinates = ChessHelper.stringToCoordinate(moveParse[0]);
		int [] endCoordinates = ChessHelper.stringToCoordinate(moveParse[1]);
		
		switch (moveType) {
			case 1 :										// Moving Horizontally Left
				for(int k = (endCoordinates[1] + 1); k < startCoordinates[1]; k++){
					if(this.chessBoard[startCoordinates[0]][k].piece != null) return true;
				}
				return false;
				
			case 2 :
				for(int k = (startCoordinates[1]+1); k < endCoordinates[1]; k++) {
					if(this.chessBoard[startCoordinates[0]][k].piece != null) return true;
				}
				return false;
				
			case 3:
				for(int i = (endCoordinates[0] + 1); i < startCoordinates[0]; i++) {
					if(this.chessBoard[i][endCoordinates[0]].piece != null) return true;
				}
				return false;
				
			case 4: 
					for(int i = (startCoordinates[0] + 1); i < endCoordinates[0]; i++ ) {
						if(this.chessBoard[i][startCoordinates[1]].piece != null) return true;
					}
					return false;		
					
			case 5 :								// Moving Diagonal
				switch(ChessHelper.verticalMoveDirection(move)) {
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
		//System.out.println("\n-----------------------------");
		//System.out.println("Initial Positions");
		for(int i = 0; i < rows; i++) {
			for(int k =0; k < columns; k++) {
				if(this.chessBoard[i][k].piece!=null)System.out.print(this.chessBoard[i][k].piece.getColor() +""+ this.chessBoard[i][k].piece.getName());
				else if(this.chessBoard[i][k].color == BLACK)System.out.print(BLACK_SQUARE);
				else System.out.print(WHITE_SQUARE);
				System.out.print(" ");
			}
			System.out.print(8-i + "\n");
		}
		System.out.println(FILE_ROW);
		
	}
	
	public boolean attemptMove(String move, char playersTurnColor) {
		String [] moveParse = move.split(" ");
		int [] startPiece = ChessHelper.stringToCoordinate(moveParse[0]);
		int [] endPiece = ChessHelper.stringToCoordinate(moveParse[1]);
		boolean isCapturing = false;
		int moveType = ChessHelper.moveDirection(move);
		
		//System.out.println("\nAttempting move: " + move);
		//if(this.chessBoard[endPiece[0]-1][endPiece[1]].piece != null)System.out.println(this.chessBoard[endPiece[0]-1][endPiece[1]].piece.getEnPassable());
		ChessBoardSquare startSquare = this.chessBoard[startPiece[0]][startPiece[1]];
		ChessBoardSquare endSquare = this.chessBoard[endPiece[0]][endPiece[1]];
		if(startSquare.piece == null) return false; 
		if(startSquare.piece.getColor() != playersTurnColor) return false;
		if(endSquare.piece != null) {
			if(endSquare.piece.getColor() == playersTurnColor) return false; 
			if(endSquare.piece.getColor() != playersTurnColor) isCapturing = true;
		}
		//enPasse Check
		else if(startSquare.piece.getName() == 'P' && (endPiece[1] == 3 || endPiece[1] == 6) && ChessHelper.isDiagonal(move)) {
				if(startPiece[1] > endPiece[1]) {
					if(this.chessBoard[endPiece[0]-1][endPiece[1]].piece.getEnPassable()) return true;
				}
				else {
					if(this.chessBoard[endPiece[0] + 1][endPiece[1]].piece.getEnPassable()) return true;
				}
		}
		// Castling check, should refactor to make the Rook placement part of makeMove
		else if(isCastling(move)) {
			if(moveType == 1) {
				this.chessBoard[startPiece[0]][startPiece[1]-1].piece = this.chessBoard[endPiece[0]][endPiece[1]-2].piece;
				this.chessBoard[endPiece[0]][endPiece[1]-2].piece = null;
			}
			else {
				this.chessBoard[startPiece[0]][startPiece[1]+1].piece = this.chessBoard[endPiece[0]][endPiece[1] + 1].piece;
				this.chessBoard[endPiece[0]][endPiece[1]+1].piece = null;
			}
			return true;
			
		}
		if(this.pieceInPath(move) && (startSquare.piece.getName() != 'N')) return false;
		//System.out.println("Makes it past piece: " + isCapturing);
		if(!(startSquare.piece.isValidMove(move, isCapturing))) return false;
		
		return true;
		
	}
	
	public boolean makeMove(String move, char playersTurnColor) {
		String [] moveParse = move.split(" ");
		String special = null;
		special = (moveParse.length == 3) ? moveParse[2] : null;
		String start = moveParse[0];
		String end = moveParse[1];
		
		int [] startPiece = ChessHelper.stringToCoordinate(start);
		int [] endPiece = ChessHelper.stringToCoordinate(end);
		
		ChessBoardSquare startSquare = this.chessBoard[startPiece[0]][startPiece[1]];
		ChessBoardSquare endSquare = this.chessBoard[endPiece[0]][endPiece[1]];
		
		
		
		if(!this.attemptMove(move, playersTurnColor)) {
			return false;
		}
	
		
		// EnPasse
		if(startSquare.piece.getName() == 'P') {
			if(ChessHelper.isDiagonal(move) && endSquare.piece == null) {
				if(startPiece[0] > endPiece[0]) {
					this.chessBoard[endPiece[0] + 1][endPiece[1]].piece = null;
				}
				else {
					this.chessBoard[endPiece[0] -1][endPiece[1]].piece = null;
				}
			}
		}
		
		this.chessBoard[endPiece[0]][endPiece[1]].piece = startSquare.piece;
		this.chessBoard[startPiece[0]][startPiece[1]].piece = null;
		if(this.chessBoard[endPiece[0]][endPiece[1]].piece == null)System.out.println("Has Piece");
		if(this.chessBoard[endPiece[0]][endPiece[1]].piece.getName() == 'P' && this.chessBoard[endPiece[0]][endPiece[1]].piece.getPromotable()) {
			this.chessBoard[endPiece[0]][endPiece[1]].piece = getPromotion(special, playersTurnColor);
		}
		
		if(this.chessBoard[endPiece[0]][endPiece[1]].piece instanceof King) {
			if(this.chessBoard[endPiece[0]][endPiece[1]].piece.getColor() == 'b')this.blackKingSquare = this.chessBoard[endPiece[0]][endPiece[1]];
			else this.whiteKingSquare = this.chessBoard[endPiece[0]][endPiece[1]];
		}
		return true;
	}


	public boolean ifCheck(char playersTurnColor){
		char oppositeTurnColor = ' ';
		if (playersTurnColor =='w') oppositeTurnColor = 'b';
		else if (playersTurnColor == 'b') oppositeTurnColor = 'w';

		ChessBoardSquare OppositeKingSquare=this.chessBoard[0][0];

		for(int i = 0; i < rows; i++) {
			for(int k =0; k < columns; k++) {
				if(this.chessBoard[i][k].piece!=null && this.chessBoard[i][k].piece.getName() == 'K' && this.chessBoard[i][k].piece.getColor() == oppositeTurnColor){
					OppositeKingSquare = this.chessBoard[i][k];
					System.out.println("HERE IS OPPOSITE KING at "+i+" "+k);
					break;
				}
			}
		}

		//vertical forward
		for (int k = OppositeKingSquare.column;k<columns;k++){
			if(this.chessBoard[OppositeKingSquare.row][k].piece!=null) {
				if (this.chessBoard[OppositeKingSquare.row][k].piece.getColor() == playersTurnColor)
					if (this.chessBoard[OppositeKingSquare.row][k].piece.getName() == 'Q' || this.chessBoard[OppositeKingSquare.row][k].piece.getName() == 'R')
						return true;
			}
			else break;

		}

		//vertical backward
		for (int k = OppositeKingSquare.column;0<k;k--){
			if(this.chessBoard[OppositeKingSquare.row][k].piece!=null) {
				if (this.chessBoard[OppositeKingSquare.row][k].piece.getColor() == playersTurnColor)
					if (this.chessBoard[OppositeKingSquare.row][k].piece.getName() == 'Q' || this.chessBoard[OppositeKingSquare.row][k].piece.getName() == 'R')
						return true;
			}
			else break;
		}

		//horizontal right
		for (int i = OppositeKingSquare.row;i<rows;i++){
			if(this.chessBoard[i][OppositeKingSquare.column].piece!=null){
				if (this.chessBoard[i][OppositeKingSquare.column].piece.getColor() == playersTurnColor)
					if (this.chessBoard[i][OppositeKingSquare.column].piece.getName() == 'Q' || this.chessBoard[i][OppositeKingSquare.column].piece.getName() == 'R' )
						return true;
			}
			else break;
		}

		//horizontal left
		for (int i = OppositeKingSquare.row;0<i;i--){
			if(this.chessBoard[i][OppositeKingSquare.column].piece!=null){
				if (this.chessBoard[i][OppositeKingSquare.column].piece.getColor() == playersTurnColor)
					if (this.chessBoard[i][OppositeKingSquare.column].piece.getName() == 'Q' || this.chessBoard[i][OppositeKingSquare.column].piece.getName() == 'R' )
						return true;
			}
			else break;
		}


		//Check black King attacked by White Pawn
		if(OppositeKingSquare.piece.getColor() == 'b') {
			int row = OppositeKingSquare.row;
			int col = OppositeKingSquare.column;

			while (true) {
				row++;
				col--;
				if (0 < col || row < rows) break;

				if (this.chessBoard[row][col].piece.getColor() == 'w' || this.chessBoard[row][col].piece.getName() == 'P')
					return true;

				row = row - 2;
				if (0 < row) break;

				if (this.chessBoard[row][col].piece.getColor() == 'w' || this.chessBoard[row][col].piece.getName() == 'P')
					return true;

				break;
			}
		}

		//Check white King attacked by black Pawn
		if(OppositeKingSquare.piece.getColor() == 'w'){
			int row = OppositeKingSquare.row;
			int col = OppositeKingSquare.column;

			while (true) {
				row++;
				col++;
				if (col < columns || row < rows)
					break;

				if (this.chessBoard[row][col].piece.getColor() == 'b' || this.chessBoard[row][col].piece.getName() == 'P')
					return true;

				row = row - 2;
				if (0 < row)
					break;

				if (this.chessBoard[row][col].piece.getColor() == 'b' || this.chessBoard[row][col].piece.getName() == 'P')
					return true;

				break;
			}
		}


		//upper right diagonal
		while (true){
			int row = OppositeKingSquare.row;
			int col = OppositeKingSquare.column;
			row++; col++;
			if (row<rows || col <columns)
				break;

			if(this.chessBoard[row][col].piece!=null){
				if (this.chessBoard[row][col].piece.getColor() == playersTurnColor)
					if (this.chessBoard[row][col].piece.getName() == 'Q' || this.chessBoard[row][col].piece.getName() == 'B' )
						return true;
			}
			else break;
		}

		//upper left diagonal
		while (true){
			int row = OppositeKingSquare.row;
			int col = OppositeKingSquare.column;
			row--; col++;
			if (row<0 || col <columns)
				break;

			if(this.chessBoard[row][col].piece!=null){
				if (this.chessBoard[row][col].piece.getColor() == playersTurnColor)
					if (this.chessBoard[row][col].piece.getName() == 'Q' || this.chessBoard[row][col].piece.getName() == 'B' )
						return true;
			}
			else break;
		}

		//lower right diagonal
		while (true){
			int row = OppositeKingSquare.row;
			int col = OppositeKingSquare.column;
			row++; col--;
			if (row<rows || 0<col )
				break;

			if(this.chessBoard[row][col].piece!=null){
				if (this.chessBoard[row][col].piece.getColor() == playersTurnColor)
					if (this.chessBoard[row][col].piece.getName() == 'Q' || this.chessBoard[row][col].piece.getName() == 'B' )
						return true;
			}
			else break;
		}

		//lower left diagonal
		while (true){
			int row = OppositeKingSquare.row;
			int col = OppositeKingSquare.column;
			row--; col--;
			if (0<row || 0<col)
				break;

			if(this.chessBoard[row][col].piece!=null){
				if (this.chessBoard[row][col].piece.getColor() == playersTurnColor)
					if (this.chessBoard[row][col].piece.getName() == 'Q' || this.chessBoard[row][col].piece.getName() == 'B' )
						return true;
			}
			else break;
		}

		//System.out.println(OppositeKingSquare.piece.getName()+" "+OppositeKingSquare.piece.getColor());

		return false;
	}


	public boolean isCastling(String move) {
		int moveDirection = ChessHelper.moveDirection(move);
		String [] moveParse = move.split(" ");
		int [] startPiece = ChessHelper.stringToCoordinate(moveParse[0]);
		int [] endPiece = ChessHelper.stringToCoordinate(moveParse[1]);
		if(!(this.chessBoard[startPiece[0]][startPiece[1]].piece.getName() == 'K') || !this.chessBoard[startPiece[0]][startPiece[1]].piece.isFirstMove()) return false;
		if(Math.abs(startPiece[1]-endPiece[1])!= 2) return false;
		if(moveDirection == 1) {
			if(!(this.chessBoard[endPiece[0]][endPiece[1] - 2].piece.getName() == 'R') || !this.chessBoard[endPiece[0]][endPiece[1] - 2].piece.isFirstMove()) return false;

		}
		else if(moveDirection == 2) {
			if(!(this.chessBoard[endPiece[0]][endPiece[1] + 1].piece.getName() == 'R') || !this.chessBoard[endPiece[0]][endPiece[1] + 1].piece.isFirstMove()) return false;
		}
		else{
			if(pieceInPath(move) || this.chessBoard[endPiece[0]][endPiece[1]].piece != null) return false;
		}
		
		return true;
		
		
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

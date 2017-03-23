package ChessModel;

import java.util.ArrayList;

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
       // System.out.println("Attempt: " +move);
    	String [] moveParse = move.split(" ");
        int [] startPiece = ChessHelper.stringToCoordinate(moveParse[0]);
        int [] endPiece = ChessHelper.stringToCoordinate(moveParse[1]);
        boolean isCapturing = false;
        int moveType = ChessHelper.moveDirection(move);

        ChessBoardSquare startSquare = this.chessBoard[startPiece[0]][startPiece[1]];
        ChessBoardSquare endSquare = this.chessBoard[endPiece[0]][endPiece[1]];
        if(startSquare.piece == null) return false;
        if(startSquare.piece.getColor() != playersTurnColor) return false;
        if(endSquare.piece != null) {
            if(endSquare.piece.getColor() == playersTurnColor) return false;
            if(endSquare.piece.getColor() != playersTurnColor) isCapturing = true;
        }
        if(startSquare.piece instanceof King && !isSafe(moveParse[1], playersTurnColor)) return false;

        //enPasse Check
        if(startSquare.piece instanceof Pawn) {
        	if(endPiece[0] == 3  && ChessHelper.isDiagonal(move) && startSquare.piece.getColor() == 'b') {
        		if(this.chessBoard[endPiece[0]-1][endPiece[1]].piece instanceof Pawn) {
        			if(this.chessBoard[endPiece[0]-1][endPiece[1]].piece.getEnPassable()) return true;
        		}
        	}
           
            if(endPiece[0] == 6  && ChessHelper.isDiagonal(move) && startSquare.piece.getColor() == 'w') {
            	System.out.println("EndPiece: " + endPiece[1]);
                if(this.chessBoard[endPiece[0] + 1][endPiece[1]].piece instanceof Pawn) {
                	if(this.chessBoard[endPiece[0] + 1][endPiece[1]].piece.getEnPassable()) return true;
                }
            }
        }
        
        
        // Castling check, should refactor to make the Rook placement part of makeMove
        if(isCastling(move)) {
            if(moveType == 1) {
                this.chessBoard[startPiece[0]][startPiece[1]-1].piece = this.chessBoard[endPiece[0]][endPiece[1]-2].piece;
                this.chessBoard[endPiece[0]][endPiece[1]-2].piece = null;
                System.out.println("MoveType 1 Castling");
            }
            else {
                this.chessBoard[startPiece[0]][startPiece[1]+1].piece = this.chessBoard[endPiece[0]][endPiece[1] + 1].piece;
                this.chessBoard[endPiece[0]][endPiece[1]+1].piece = null;
                System.out.println("MoveType 2 Castling");
            }
            return true;

        }
        if(this.pieceInPath(move) && (startSquare.piece.getName() != 'N')) return false;
        //System.out.println("Makes it past piece: " + move);
        if(!(startSquare.piece.isValidMove(move, isCapturing))) return false;
       // System.out.println("Isvalid: " + move);
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

        System.out.println("Make move1: " + move);

        if(!this.attemptMove(move, playersTurnColor)) {
        	 //System.out.println("Attempt2222: " + move + " ");
        	return false;
        }
        //System.out.println("Attemp: " + move + " "  );


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

   
        if(isCheck(moveParse[1], playersTurnColor)) System.out.println("Check");
        this.chessBoard[endPiece[0]][endPiece[1]].piece.setFirstMove();
        return true;
    }
    
    public boolean isCheck(String location, char playersTurnColor) {
    	int [] startPiece = ChessHelper.stringToCoordinate(location); 
    	ChessBoardSquare opponentKingSquare = (playersTurnColor == 'b') ? this.whiteKingSquare: this.blackKingSquare;
    	ChessPiece Piece = this.chessBoard[startPiece[0]][startPiece[1]].piece;
        if(Piece == null) return false;
        if(attemptMove(location + " " + opponentKingSquare.file + opponentKingSquare.rank, playersTurnColor)) {
        	this.chessBoard[opponentKingSquare.row][opponentKingSquare.column].piece.setChecked(true);
        	return true;
        }
        
        return false;
    }
    
    public boolean isCheckMate(char playersTurnColor) {
    	ChessBoardSquare checkedKingSquare = (playersTurnColor == 'b') ? blackKingSquare : whiteKingSquare;
    	if(!checkedKingSquare.piece.getIsChecked()) return false;
    	// Check possible moves
    	String possibleLocation = checkedKingSquare.file + "" + checkedKingSquare.rank;
    	System.out.println("Testing0: " + possibleLocation);
    	// Check moving vertical up
    	possibleLocation = checkedKingSquare.file +  "" + (char)(checkedKingSquare.rank +1);
    	System.out.println("Testing1: " + possibleLocation);
		if(ChessHelper.isValidCoordinates(possibleLocation) && isSafe(possibleLocation, playersTurnColor)) return false;
		System.out.println("Testing2: " + possibleLocation);
		// Check moving vertical down
		possibleLocation = checkedKingSquare.file +  "" + (char)(checkedKingSquare.rank - 1);
		if(ChessHelper.isValidCoordinates(possibleLocation) && isSafe(possibleLocation, playersTurnColor)) return false;
		System.out.println("Testing: " + possibleLocation);
		// Checking moving horiztonal right
		possibleLocation = (char)(checkedKingSquare.file +1) +  "" + checkedKingSquare.rank;
		if(ChessHelper.isValidCoordinates(possibleLocation) && isSafe(possibleLocation, playersTurnColor)) return false;
		System.out.println("Testing: " + possibleLocation);
		//Check moving horiztonal left
		possibleLocation = (char)(checkedKingSquare.file -1) +  "" + checkedKingSquare.rank;
		if(ChessHelper.isValidCoordinates(possibleLocation) && isSafe(possibleLocation, playersTurnColor)) return false;
		System.out.println("Testing: " + possibleLocation);
		//Check moving diagonal top right
		possibleLocation = (char)(checkedKingSquare.file +1) +  "" + (char)(checkedKingSquare.rank+1);
		if(ChessHelper.isValidCoordinates(possibleLocation) && isSafe(possibleLocation, playersTurnColor)) return false;
		System.out.println("Testing: " + possibleLocation);
		//Check moving diagonal top left
		possibleLocation = (char)(checkedKingSquare.file -1) +  "" + (char)(checkedKingSquare.rank+1);
		if(ChessHelper.isValidCoordinates(possibleLocation) && isSafe(possibleLocation, playersTurnColor)) return false;
		System.out.println("Testing: " + possibleLocation);
		//Check moving diagonal bottom right
		possibleLocation = (char)(checkedKingSquare.file +1) +  "" + (char)(checkedKingSquare.rank-1);
		if(ChessHelper.isValidCoordinates(possibleLocation) && isSafe(possibleLocation, playersTurnColor)) return false;
		System.out.println("Testing: " + possibleLocation);	
		//Check moving diagonal bottom left
		possibleLocation = (char)(checkedKingSquare.file -1) +  "" + (char)(checkedKingSquare.rank -1);
		if(ChessHelper.isValidCoordinates(possibleLocation) && isSafe(possibleLocation, playersTurnColor)) return false;
		
		// If King cant move, find pieces putting it in check and see if they can be attacked
		int checkedByPieces = 0;
		String checkedByPieceLoc = null;
		
		ChessBoardSquare current, checkedByPieceSquare = null;
		String kingLoc = checkedKingSquare.file + "" + checkedKingSquare.rank;
		String start;
		for(int i = 0; i < columns; i++) {
			  for(int k = 0; k < rows; k++) {
				   current = this.chessBoard[k][i];
				   if(current.piece != null) {
					   if(current.piece.getColor() != playersTurnColor) {
						   start = current.file + "" + current.rank;
						   if(current.piece.isValidMove(start + " " + kingLoc, true)) {
							   checkedByPieceLoc = start;
							   checkedByPieceSquare = current;
							   checkedByPieces++;
						   }
					
						   if(checkedByPieces > 1) return true;
					   }
				   }			   
			  }
		 }
	
		if(checkedByPieceSquare.piece != null && checkedByPieceLoc != null) {
			if(!isSafe(checkedByPieceLoc, playersTurnColor)) return true;
		}
		
		return false;
		
    	
    }
    
   

    public boolean isSafe(String kingLoc, char playersTurnColor) {
	  System.out.println("IsSafe: " + kingLoc + " " + playersTurnColor);
      ChessBoardSquare current;
	  String start;
	  for(int i = 0; i < rows; i++) {
		  for(int k = 0; k < columns; k++) {
			   current = this.chessBoard[i][k];
			   if(current.piece != null) {
				   if(current.piece.getColor() != playersTurnColor) {
					   start = current.file + "" + current.rank;
					 // System.out.println("Attempt move :" + start + " " + kingLoc);
					   if(attemptMove(start + " " + kingLoc, (playersTurnColor == 'b') ? 'w' : 'b')) return false;
				   }
			   }			   
		  }
	  }
	  //System.out.println("Makes it here");
	  return true;  
  }

  

	public boolean isCastling(String move) {
	    int moveDirection = ChessHelper.moveDirection(move);
	  //  System.out.println("isCastling");
	    String [] moveParse = move.split(" ");
	    int [] startPiece = ChessHelper.stringToCoordinate(moveParse[0]);
	    int [] endPiece = ChessHelper.stringToCoordinate(moveParse[1]);
	    if(!(this.chessBoard[startPiece[0]][startPiece[1]].piece instanceof King) || !this.chessBoard[startPiece[0]][startPiece[1]].piece.isFirstMove()) return false;
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

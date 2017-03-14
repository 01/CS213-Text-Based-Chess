package chess;

public class ChessBoard extends GameBoard{
	public static final int numRanks = 8;
	public static final int numFiles = 8;

	public static final char WHITE = 'W';
	public static final char BLACK = 'B';
	
	public ChessBoardSquare[][] chessBoard;
	
	public ChessBoard() {
		super(numRanks, numFiles);
		this.chessBoard = (ChessBoardSquare[][]) this.GameBoard;
		//initializeChessBoard();
	}
	
	public void initializeEmptyBoard()  {
		this.GameBoard = new ChessBoardSquare[numRanks][numFiles];
		int colorTrack = 0;
		for(int i = 0; i < rows; i++) {
			for(int k =0; k < columns; k++) {
				if(colorTrack%2==0) {
					GameBoard[i][k] = new ChessBoardSquare(i, k, null, 'B');
					colorTrack++;
					System.out.println(((ChessBoardSquare)GameBoard[i][k]).file);
				}
				else {
					GameBoard[i][k] = new ChessBoardSquare(i, k, null, 'W');
					System.out.println(((ChessBoardSquare)GameBoard[i][k]).file);
					colorTrack++;
					
				}
			}
		}
	}
	
	public void initializeChessBoard() {
		// Initialize Pawns
		for(int i = 0; i < numRanks; i++ ) {
			this.chessBoard[i][1].piece = new PAWN(WHITE);
			this.chessBoard[i][numFiles-2] = new PAWN(BLACK);
		}
		
		// Initiaze Rooks
		this.chessBoard[0][0].piece = new Rook(WHITE);
		this.chessBoard[7][0].piece = new Rook(WHITE);
		this.chessBoard[0][7].piece = new Rook(BLACK);
		this.chessBoard[7][7].piece = new Rook(BLACK);
		
		//Initialize Knights
		this.chessBoard[1][0].piece = new Knight(WHITE);
		this.chessBoard[6][0].piece = new Knight(WHITE);
		this.chessBoard[1][7].piece = new Knight(BLACK);
		this.chessBoard[6][7].piece = new Knight(BLACK);
		
		//Initialize Bishops
		this.chessBoard[2][0].piece = new Bishop(WHITE);
		this.chessBoard[5][0].piece = new Bishop(WHITE);
		this.chessBoard[2][7].piece = new Bishop(BLACK)
		this.chessBoard[5][7].piece = new Bishop(BLACK);
		
		//Initialize Kings
		this.chessBoard[3][0].piece = new King(WHITE);
		this.chessBoard[3][7].piece = new King(BLACK);
		
		//Initialize Queens 
		this.chessBoard[4][0] =  new Queen(WHITE);
		this.chessBoard[4][7] = new Queen(BLACK);

	}
	
	public void printChessBoardEmpty() {
		for(int i = 0; i < rows; i++) {
			System.out.println("");
			for(int k =0; k < columns; k++) {
				System.out.print(this.chessBoard[i][k].file +""+ this.chessBoard[i][k].rank + " ");
	
			}
		}
		
	}
	
}

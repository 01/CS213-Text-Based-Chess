package chess;

public class ChessBoard extends Board {
	public static final int numRanks = 8;
	public static final int numFiles = 8;

	public static final char WHITE = 'W';
	public static final char BLACK = 'B';
	
	public BoardSquare[][] chessBoard;
	
	public ChessBoard() {
		super(numRanks, numFiles);
		this.chessBoard = this.board;
		initializeBoard();
	}
	
	
	
	@Override
	public void initializeBoard() {
		// Initialize Pawns
		for(int i = 0; i < numRanks; i++ ) {
			this.chessBoard[i][1].piece = new PAWN(WHITE);
			this.chessBoard[i][numFiles-2] = new PAWN(BLACK);
		}
		
		// Initiaze Rooks
		this.chessBoard[0][0] = new Rook(WHITE);
		this.chessBoard[7][0] = new Rook(WHITE);
		this.chessBoard[0][7] = new Rook(BLACK);
		this.chessBoard[7][7] = new Rook(BLACK);
		
		//Initialize Knights
		this.chessBoard[1][0] = new Knight(WHITE);
		this.chessBoard[6][0] = new Kinight(WHITE);
		this.chessBoard[1][7] = new Knight(BLACK);
		this.chessBoard[6][7] = new Knight(BLACK);
		
		//Initialize Bishops
		this.chessBoard[2][0] = new ChessPiece(BISHOP, WHITE);
		this.chessBoard[5][0] = new ChessPiece(BISHOP, WHITE);
		this.chessBoard[2][7] = new ChessPiece(BISHOP, BLACK);
		this.chessBoard[5][7] = new ChessPiece(BISHOP, BLACK);
		
		//Initialize Kings
		this.chessBoard[3][0] = new ChessPiece(KING, WHITE);
		this.chessBoard[3][7] = new ChessPiece(KING, BLACK);
		
		//Initialize Queens 
		this.chessBoard[4][0] =  new ChessPiece(QUEEN, WHITE);
		this.chessBoard[4][7] = new ChessPiece(QUEEN, BLACK);

	}
	
	
}

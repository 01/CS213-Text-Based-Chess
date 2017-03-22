package main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import ChessModel.*;
import controller.ChessController;


public class tester {
    public static ChessBoard board;
    
    public static void main( String[] args ) throws IOException {
    	
    	ChessController game = new ChessController();
    	boolean previousPlayer = false;
    	Scanner input = new Scanner(System.in);
    	String testFile = input.nextLine();
  
    	try (BufferedReader br = new BufferedReader(new FileReader(testFile))) {
				while (!game.gameOver) {
			
				if(previousPlayer != game.isWhiteTurn()) {
					game.printBoard();
					previousPlayer = game.isWhiteTurn();	
				}
				game.printPrompt();
				String command = br.readLine();
				if(command==null) {
					command = input.nextLine();
				}
				System.out.print(command + "\n");
				game.giveCommand(command);
				
			}
    	}
    }
   
    public static void testCastling() {
    	// Test Castling to File H Rook
    	// White 
    	board.makeMove("f2 f4", 'w');
    	board.makeMove("e2 e4", 'w');
    	board.makeMove("f1 c4", 'w');
    	board.printChessBoard();
    	board.makeMove("g1 h3", 'w');
    	board.printChessBoard();
    	board.makeMove("e1 g1", 'w');
    	board.printChessBoard();
    	//Black
    	board.makeMove("f7 f5", 'b');
    	board.makeMove("e7 e5", 'b');
    	board.makeMove("f8 c5", 'b');
    	board.printChessBoard();
    	board.makeMove("g8 h6", 'b');
    	board.printChessBoard();
    	board.makeMove("e8 g8", 'b');
    	board.printChessBoard();
    	
    	board = new ChessBoard();
    	board.printChessBoard();
    	
    	//Testing Castling to A File Rook
    	// White 
    	board.makeMove("c2 c4", 'w');
    	board.makeMove("b2 b4", 'w');
    	board.makeMove("d1 a4", 'w');
    	board.printChessBoard();
    	board.makeMove("c1 b2", 'w');
    	board.printChessBoard();
    	board.makeMove("b1 c3", 'w');
    	board.printChessBoard();
    	board.makeMove("e1 c1", 'w');
    	board.printChessBoard();
    	
      	board = new ChessBoard();
    	board.printChessBoard();
    	//Black
    	board.makeMove("f7 f5", 'b');
    	board.makeMove("e7 e5", 'b');
    	board.makeMove("f8 c5", 'b');
    	board.printChessBoard();
    	board.makeMove("g8 h6", 'b');
    	board.printChessBoard();
    	board.makeMove("e8 g8", 'b');
    	board.printChessBoard();
      	board = new ChessBoard();
    	board.printChessBoard();
    	
    }
    
    public static void testPromotion() {
    	board.makeMove("b2 b4", 'w');
    	board.printChessBoard();
    	board.makeMove("b4 b5", 'w');
    	board.printChessBoard();
    	board.makeMove("b5 b6", 'w');
    	board.printChessBoard();
    	board.makeMove("b6 c7", 'w');
    	board.printChessBoard();
    	board.makeMove("c7 d8 N", 'w');
    	board.printChessBoard();
    	
    	board.makeMove("d7 d5", 'b');
    	board.makeMove("d5 d4", 'b');
    	board.makeMove("d4 d3", 'b');
    	board.makeMove("d3 e2", 'b');
    	board.makeMove("e2 f1", 'b');
    	board.printChessBoard();
    	
      	board = new ChessBoard();
    	board.printChessBoard();
    	
    }
    
    public static void testEnPasse() {
    	board.printChessBoard();

    	board.makeMove("b2 b4", 'w');
    	board.printChessBoard();
    	board.makeMove("b4 b5", 'w');
    	board.printChessBoard();
    	board.makeMove("b4 b5", 'w');
    	board.makeMove("a7 a5", 'b');
    	board.printChessBoard();
    	board.makeMove("b5 a6", 'w');
    	board.printChessBoard();
    	board.makeMove("h2 h4", 'w');
    	board.printChessBoard();
    	board.makeMove("g7 g5", 'b');
    	board.printChessBoard();
    	board.makeMove("g5 g4", 'b');
    	board.printChessBoard();
    	board.makeMove("g4 h3", 'b');
    	board.printChessBoard();
      	board = new ChessBoard();
    	board.printChessBoard();

    }
    
    public static void testQueenMoves() {
    	System.out.println("\n\n-----------------Testing Queen Moves------------------");
    	if(board.attemptMove("D1 D4", 'w')) System.out.println("\n\nMove valid from A1 to A3");
    	else System.out.print("Illegal Move");
      	board = new ChessBoard();
    	board.printChessBoard();
    }
    public static void testIsDiagonal() {
    	System.out.println("\n Testing isDiagonal Chess Helper Method\n");
    	System.out.println("Testing Upper Right Direction");
    	System.out.print("A1 to C3  Expected: isDiagonal   Actual: ");
    	if(ChessHelper.isDiagonal("a1 c3")) System.out.print("isDiagonal\n");
    	else System.out.print("not Diagonal\n");
    	System.out.print("C5 to E7  Expected: isDiagonal   Actual: ");
    	if(ChessHelper.isDiagonal("c5 e7")) System.out.print("isDiagonal\n");
    	else System.out.print("not Diagonal\n");
    	System.out.println("Testing Upper Left Direction");
    	System.out.print("C5 to A7  Expected: isDiagonal   Actual: ");
    	if(ChessHelper.isDiagonal("c5 a7")) System.out.print("isDiagonal\n");
    	else System.out.print("not Diagonal\n");
    	System.out.print("E5 to B8  Expected: isDiagonal   Actual: ");
    	if(ChessHelper.isDiagonal("a1 c3")) System.out.print("isDiagonal\n");
    	else System.out.print("not Diagonal\n");
    	System.out.print("Testing Lower Left Direction");
    	System.out.print("C5 to A3  Expected: isDiagonal   Actual: ");
    	if(ChessHelper.isDiagonal("c5 a3")) System.out.print("isDiagonal\n");
    	else System.out.print("not Diagonal\n");
    	System.out.print("E5 to c3  Expected: isDiagonal   Actual: ");
    	if(ChessHelper.isDiagonal("e5 c3"))System.out.print("isDiagonal\n");
    	else System.out.print("not Diagonal\n");
    	System.out.println("Testing Lower Right Direction");
    	System.out.print("C5 to E3  Expected: isDiagonal   Actual: ");
    	if(ChessHelper.isDiagonal("c5 e3")) System.out.print("isDiagonal\n");
    	else System.out.print("not Diagonal\n");
    	System.out.print("E5 to g3  Expected: isDiagonal   Actual: ");
    	if(ChessHelper.isDiagonal("e5 g3")) System.out.print("isDiagonal\n");
    	else System.out.print("not Diagonal\n");
    	System.out.println("Testing Not Diagonal Direction");
    	System.out.print("C5 to C3  Expected: not Diagonal   Actual: ");
    	if(ChessHelper.isDiagonal("c5 c3")) System.out.print("isDiagonal\n");
    	else System.out.print("not Diagonal\n");
    	System.out.print("E5 to E1  Expected: not Diagonal   Actual: ");
    	if(ChessHelper.isDiagonal("e5 e1")) System.out.print("isDiagonal\n");
    	else System.out.print("not Diagonal\n");
    	
      	board = new ChessBoard();
    	board.printChessBoard();
    }
    
    public static void testPawnMoves() {
    	board = new ChessBoard();
    	System.out.println("\n\n---------------------Test Pawn Moves-------------------\n");
    	System.out.println("Moving White Pawns 1 and 2 spaces or more Forward start");
    	System.out.print("Moving Pawn from A2 to A4  Expect: Valid Move  Actual: ");
    	if(board.chessBoard[6][0].piece.isValidMove("a2 a4", false)) System.out.print("Valid Move\n");
    	else System.out.print("Invalid Move\n");
    	System.out.print("Moving Pawn from A2 to A3  Expect: Valid Move  Actual: ");
    	if(board.chessBoard[6][0].piece.isValidMove("a2 a3", false)) System.out.print("Valid Move\n");
    	else System.out.print("Invalid Move\n");
    	System.out.print("Moving Pawn from C2 to C3  Expect: Valid Move  Actual: ");
    	if(board.chessBoard[6][0].piece.isValidMove("c2 c3", false)) System.out.print("Valid Move\n");
    	else System.out.print("Invalid Move\n");
    	System.out.print("Moving Pawn from C2 to C5  Expect: InValid Move  Actual: ");
    	if(board.chessBoard[6][0].piece.isValidMove("c2 c5", false)) System.out.print("Valid Move\n");
    	else System.out.print("Invalid Move\n");
    	System.out.println("Moving White Pawns 1 and 2 spaces or more Backwards from start");
    	System.out.print("Moving Pawn from C2 to C1  Expect: InValid Move  Actual: ");
    	if(board.chessBoard[6][0].piece.isValidMove("c2 c1", false)) System.out.print("Valid Move\n");
    	else System.out.print("Invalid Move\n");
    	System.out.print("Moving Pawn from D2 to D1  Expect: InValid Move  Actual: ");
    	if(board.chessBoard[6][0].piece.isValidMove("d2 c1", false)) System.out.print("Valid Move\n");
    	else System.out.print("Invalid Move\n");
    	
    	System.out.println("Moving Black Pawns 1 and 2 spaces or more Forward start");
    	System.out.print("Moving Pawn from A7 to A5  Expect: Valid Move  Actual: ");
    	if(board.chessBoard[6][0].piece.isValidMove("a7 a5", false)) System.out.print("Valid Move\n");
    	else System.out.print("Invalid Move\n");
    	System.out.print("Moving Pawn from A7 to A6  Expect: Valid Move  Actual: ");
    	if(board.chessBoard[6][0].piece.isValidMove("a7 a6", false)) System.out.print("Valid Move\n");
    	else System.out.print("Invalid Move\n");
    	System.out.print("Moving Pawn from C7 to C6  Expect: Valid Move  Actual: ");
    	if(board.chessBoard[6][0].piece.isValidMove("c7 c6", false)) System.out.print("Valid Move\n");
    	else System.out.print("Invalid Move\n");
    	System.out.print("Moving Pawn from C7 to C4  Expect: InValid Move  Actual: ");
    	if(board.chessBoard[6][0].piece.isValidMove("c7 c4", false)) System.out.print("Valid Move\n");
    	else System.out.print("Invalid Move\n");
    	System.out.println("Moving Black Pawns 1 and 2 spaces or more Backwards from start");
    	System.out.print("Moving Pawn from C7 to C8  Expect: InValid Move  Actual: ");
    	if(board.chessBoard[6][0].piece.isValidMove("c7 c8", false)) System.out.print("Valid Move\n");
    	else System.out.print("Invalid Move\n");
    	System.out.print("Moving Pawn from D7 to D8  Expect: InValid Move  Actual: ");
    	if(board.chessBoard[6][0].piece.isValidMove("d7 d8", false)) System.out.print("Valid Move\n");
    	else System.out.print("Invalid Move\n");
      	board = new ChessBoard();
    	board.printChessBoard();
    	
    	
    }
    
    public static void pieceInPathTest() {
    	System.out.println("\n\n---------------Piece in Path Tests--------------");
    	System.out.println("Diagonal Move tests");
    	System.out.println("Upper Right tests");
    	System.out.print("A2 to G8 Expected: Piece in Path ");
    	System.out.print("Actual: ");
    	if(board.pieceInPath("a2 g8")) System.out.print("Piece in path\n");
    	else System.out.print("No piece in path\n");
    	System.out.println("B2 to E5 Expected: No Piece in Path ");
    	System.out.print("Actual: ");
    	if(board.pieceInPath("b2 e5")) System.out.print("Piece in path\n");
    	else System.out.print("No piece in path\n");
    	
    	System.out.println("Upper Left Test");
    	System.out.print("G2 to A8 Expected: Piece in Path ");
    	System.out.print("Actual: ");
    	if(board.pieceInPath("g2 a8")) System.out.print("Piece in path\n");
    	else System.out.print("No piece in path\n");
    	
    	System.out.print("e2 to c4 Expected: No Piece in Path ");
    	System.out.print("Actual: ");
    	if(board.pieceInPath("e2 c4")) System.out.print("Piece in path\n");
    	else System.out.print("No piece in path\n");
    	
    	System.out.println("\nLower Left Tests");
    	System.out.println("E8 To C6 Expected: Piece in Path ");
    	System.out.print("Actual: ");
    	if(board.pieceInPath("e8 c6")) System.out.print("Piece in path");
    	else System.out.print("No piece in path");
    	System.out.println("e7 to A3 Expected: No Piece in Path ");
    	System.out.print("Actual: ");
    	if(board.pieceInPath("e7 a3")) System.out.print("Piece in path");
    	else System.out.print("No piece in path");
    	
    	System.out.println("\n Lower Right Tests");
    	System.out.println("c8 to G4 Expected: Piece in Path ");
    	System.out.print("Actual: ");
    	if(board.pieceInPath("c8 g4")) System.out.print("Piece in path");
    	else System.out.print("No piece in path");
    	System.out.println("b3 to d1 Expected: Piece in Path ");
    	System.out.print("Actual: ");
    	if(board.pieceInPath("b3 d1")) System.out.print("Piece in path");
    	else System.out.print("No piece in path");
      	board = new ChessBoard();
    	board.printChessBoard();
    	
 
}

}

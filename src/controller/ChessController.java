package controller;

import ChessModel.*;

public class ChessController {
	private ChessBoard board;
	public boolean gameOver, drawOffered;
	private char playersColor;
	String resign = "resign";
	
	public ChessController() {
		this.board = new ChessBoard();
		this.playersColor = 'w';
	}
	
	public boolean isWhiteTurn() {
		return (this.playersColor == 'w') ? true: false;
	}

	public void resign() {
		this.gameOver = true;
	}
	
	public boolean makeMove(String move) {
		return this.board.makeMove(move, this.playersColor);
	}
	
	public void giveCommand(String command) {
		String [] commandParse = command.split(" ");
		int commandInt = commandParse.length;
		switch(commandInt) {
			case 1:
				if(commandParse[0].compareTo(resign) == 0) {
					System.out.println(isWhiteTurn() ? "Black wins!" : "White wins!");
					this.gameOver = true;
				}
				else if(commandParse[0].compareTo("draw") == 0 && this.drawOffered) {
					System.out.println("Draw");
					this.gameOver = true;
				}
				else {
					printIllegalMove();
				}
				break;
			
			case 2:
				if(makeMove(command)) {
					this.playersColor = isWhiteTurn() ? 'b': 'w';
				}
				else {
					printIllegalMove();
				}
				break;
			
			case 3:
				if(commandParse[2].compareTo("draw?") == 0 && makeMove(command)) {
					this.drawOffered = true;
					this.playersColor = isWhiteTurn() ? 'b': 'w';
				}
				else if(makeMove(command) && isPromotion(commandParse[2])) {
					this.playersColor = isWhiteTurn() ? 'b': 'w';
				}
				else {
					printIllegalMove();
				}
				break;		
		}
	}
		
	
	
	public void printBoard() {
		this.board.printChessBoard();
	}
	
	public boolean isPromotion(String promotion) {
		if(promotion.length() > 1) return false;
		switch(promotion.toUpperCase().charAt(0)) {
			case 'P':
			case 'K':
			case 'N':
			case 'Q':
			case 'R':
				return true;
			default:
				return false;
		}
	}
	
	public void printIllegalMove() {
		System.out.println("Illegal move, try again");
	}
	
	public void printPrompt() {
		System.out.println(this.isWhiteTurn() ? "White's turn: " : "Black's turn: ");
	}
	
}

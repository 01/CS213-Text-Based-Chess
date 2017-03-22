package main;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import ChessModel.ChessBoard;
import controller.ChessController;

public class Chess {

    public static ChessBoard board;
    
    public static void main( String[] args ) throws IOException {
    	ChessController game = new ChessController();
    	boolean previousPlayer = false;
    	Scanner input = new Scanner(System.in);
		
		while (!game.gameOver) {
			if(previousPlayer != game.isWhiteTurn()) {
				game.printBoard();
				previousPlayer = game.isWhiteTurn();	
			}
			game.printPrompt();
			String command = input.nextLine();
			game.giveCommand(command);
			
		}
   
        
    }

}

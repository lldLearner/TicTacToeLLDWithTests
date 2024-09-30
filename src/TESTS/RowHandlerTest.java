package TESTS;

import HANDLERS.RowwHandler;
import MODELS.Board;

public class RowHandlerTest {

	public static void main(String[] args) {
		RowwHandler rowwHandler = new RowwHandler();
		Board board = new Board(3);
		
		board.setCell(2, 1, 'X');
		board.setCell(2, 2, 'X');
		board.setCell(2, 0, 'X');
		assert rowwHandler.checkWinRequest(board, 'X', 2, 0) == true : "x wins";
		System.out.println("Test passed : x wins the game!");
		
		
	}
}

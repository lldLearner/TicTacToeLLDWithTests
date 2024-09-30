package TESTS;

import HANDLERS.CollHandler;
import MODELS.Board;

public class CollHandlerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CollHandler collHandler = new CollHandler();

		Board board = new Board(3);

		board.setCell(0, 1, 'X');
		board.setCell(1, 1, 'X');
		board.setCell(2, 1, 'X');
		assert collHandler.checkWinRequest(board, 'X', 2, 1) == true : "x wins";
		System.out.println("Test passed : x wins the game!");
	}

}

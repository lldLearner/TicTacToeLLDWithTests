package TESTS;

import HANDLERS.AntiDiagonalHandler;
import MODELS.Board;

public class AntiDiagonalHandlerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AntiDiagonalHandler antiDiagonalHandler = new AntiDiagonalHandler();
		Board board = new Board(3);

		board.setCell(0, 2, 'X');
		board.setCell(1, 1, 'X');
		board.setCell(2, 0, 'X');
		assert antiDiagonalHandler.checkWinRequest(board, 'X', 2, 1) == true : "x wins";
		System.out.println("Test passed : x wins the game!");
	}

}

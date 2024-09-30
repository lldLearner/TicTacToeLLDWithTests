package TESTS;

import HANDLERS.DiagonalHandler;
import MODELS.Board;

public class DiagonalHandlerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DiagonalHandler diagonalHandler = new DiagonalHandler();
		Board board = new Board(3);

		board.setCell(0, 0, 'X');
		board.setCell(1, 1, 'X');
		board.setCell(2, 2, 'X');
		assert diagonalHandler.checkWinRequest(board, 'X', 2, 1) == true : "x wins";
		System.out.println("Test passed : x wins the game!");
	}

}

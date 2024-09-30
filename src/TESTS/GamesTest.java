package TESTS;

import java.util.Arrays;
import java.util.List;

import MODELS.Board;
import MODELS.Game;
import MODELS.Players;
import STATE.WinState;

public class GamesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] inputs = { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 0, 2 } };//'x', 'o', 'x', 'o', 'x'
		MockInput mockInput = new MockInput(inputs);
		
		
		Board board = new Board(3);
		
		List<Players> players = Arrays.asList(new Players('X'), new Players('O'));
		Game g = new Game(board , players , mockInput);
		
		assert g.getCurrentPlayer().getSymbol() == 'X' : "the current player is 'X'.";
		System.out.println("Test passed : the current player is 'X'.");
		
		g.getCurrentState().makeMove(g, inputs[0][0], inputs[0][1]);
		assert g.getBoard().getCell(inputs[0][0], inputs[0][1]) == 'X' : "the cell (0,0) should be filled with 'X'.";
		System.out.println("Test passed : the player's turn is correct");
		
		assert g.getCurrentPlayer().getSymbol() == 'O' : "the current player is 'O'.";
		System.out.println("Test passed : The turn is switched after 'X turn to 'O'.");
		
		mockInput.advaceInput();
		
		for(int r = 1; r < inputs.length; r++) {
			g.getCurrentState().makeMove(g, mockInput.getRows(), mockInput.getCols());
			mockInput.advaceInput();
		}
		
		assert g.getCurrentState() instanceof WinState : "current state is win state";
		System.out.println("Test passed : current state is win state");
	}

}

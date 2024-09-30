package STATE;

import MODELS.Game;

public class WinState implements GameState {

	@Override
	public void makeMove(Game game, int r, int c) {
		// TODO Auto-generated method stub

		System.out.println(game.getCurrentPlayer() + " has won the game, game is finished");
	}

}

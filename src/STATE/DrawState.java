package STATE;

import MODELS.Game;

public class DrawState implements GameState {

	@Override
	public void makeMove(Game game, int r, int c) {
		// TODO Auto-generated method stub
		System.out.println("Game is draw, please start a new Game!");
	}

}

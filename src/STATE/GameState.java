package STATE;

import MODELS.Game;

public interface GameState {

	void makeMove(Game game, int r, int c);
}

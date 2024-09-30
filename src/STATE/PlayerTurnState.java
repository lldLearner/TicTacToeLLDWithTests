package STATE;

import MODELS.Game;
import MODELS.Players;

public class PlayerTurnState implements GameState {

	private Players currentPlayer;

	public PlayerTurnState(Players currentPlayer) {
		// TODO Auto-generated constructor stub
		this.currentPlayer = currentPlayer;
	}

	@Override
	public void makeMove(Game game, int r, int c) {
		// TODO Auto-generated method stub
		char symbol = currentPlayer.getSymbol();
		if (game.getBoard().getCell(r, c) == '\0') {
			game.getBoard().setCell(r, c, symbol);
			if (game.isWon(r, c, symbol)) {
				game.setCurrentState(game.getWinState());
				game.getCurrentState().makeMove(game, r, c);
			} else if (game.isDraw(r, c, symbol)) {
				game.setCurrentState(game.getDrawState());
				game.getCurrentState().makeMove(game, r, c);
			} else {
				game.setCurrentState(game.getNextPlayerTurnState());
			}
		} else {
			this.currentPlayer.unsetUndo();
			System.out.println("The chosen cell is already filled, you lost your turn");
		}
	}

}

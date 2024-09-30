package MODELS;

import java.util.List;

import HANDLERS.AntiDiagonalHandler;
import HANDLERS.CollHandler;
import HANDLERS.DiagonalHandler;
import HANDLERS.RowwHandler;
import HANDLERS.WinnHandler;
import INPUT.InputMethod;
import STATE.DrawState;
import STATE.GameState;
import STATE.PlayerTurnState;
import STATE.WinState;

public class Game {

	private Board board;
	private int currentPlayerIndex;
	private List<Players> players;
	private WinState winState;
	private DrawState drawState;
	private GameState currentState;
	private InputMethod inputMethod;
	private WinnHandler winHandlerChain;
	private int prevPlayerIndex;

	public Game(Board board, List<Players> players, InputMethod inputMethod) {
		// TODO Auto-generated constructor stub
		this.board = board;
		this.currentPlayerIndex = 0;
		this.players = players;
		this.drawState = new DrawState();
		this.winState = new WinState();
		this.currentState = new PlayerTurnState(this.getCurrentPlayer());
		this.inputMethod = inputMethod;
		this.setWinHandlers();
	}

	public void setWinHandlers() {
		WinnHandler rowHandler = new RowwHandler();
		WinnHandler colHandler = new CollHandler();
		WinnHandler diagonalHandler = new DiagonalHandler();
		WinnHandler antiDiagonalHandler = new AntiDiagonalHandler();
		rowHandler.setNextHandler(colHandler);
		colHandler.setNextHandler(diagonalHandler);
		diagonalHandler.setNextHandler(antiDiagonalHandler);
		this.winHandlerChain = rowHandler;
	}

	public boolean isWon(int r, int c, char symbol) {
		return this.winHandlerChain.checkWinRequest(board, symbol, r, c);
	}

	public void addPlayer(Players player) {
		this.players.add(player);
	}

	public Board getBoard() {
		return board;
	}

	public Players getCurrentPlayer() {
		// TODO Auto-generated method stub
		return this.players.get(currentPlayerIndex);
	}

	public void setCurrentState(GameState currentState) {
		this.currentState = currentState;
	}

	public WinState getWinState() {
		return winState;
	}

	public DrawState getDrawState() {
		return drawState;
	}

	public boolean isDraw(int r, int c, char symbol) {
		// TODO Auto-generated method stub
		return !(currentState instanceof WinState) && board.isFilled();
	}

	public PlayerTurnState getNextPlayerTurnState() {
		// TODO Auto-generated method stub
		this.currentPlayerIndex = (currentPlayerIndex + 1) % this.players.size();
		return new PlayerTurnState(this.getCurrentPlayer());
	}

	public GameState getCurrentState() {
		return currentState;
	}

	public Players getPrevPlayer() {
		return this.players.get(prevPlayerIndex);
	}

	public void play() {

		while (true) {
			this.prevPlayerIndex = this.currentPlayerIndex;
			System.out.println(this.getCurrentPlayer() + "'s turn");
			int row = this.inputMethod.getRows();
			int col = this.inputMethod.getCols();

			if (!this.inputMethod.validateInput(row, col)) {
				System.out.println("Either row or either column is incorrect, you lost the turn!");
				this.currentState = this.getNextPlayerTurnState();
				continue;
			}

			this.currentState.makeMove(this, row, col);
			board.display();

			if ((this.currentState instanceof WinState || this.currentState instanceof DrawState)) {
				break;
			}
			System.out.println("do wish to undo your move?");
			if (this.inputMethod.validateInput(row, col) && this.inputMethod.isUndo()) {
				if(!this.getPrevPlayer().getUndo()) {
					System.out.println("you cannot undo the same move twice!");
					this.getCurrentPlayer().resetUndo();
					continue;
				}
				undoPrevMove(row, col);
				board.display();
			}
		}
	}

	public void undoPrevMove(int row, int col) {
		board.resetCell(row, col);
		this.currentPlayerIndex = this.prevPlayerIndex;
		this.currentState = new PlayerTurnState(getCurrentPlayer());
		this.getCurrentPlayer().unsetUndo();
	}
}

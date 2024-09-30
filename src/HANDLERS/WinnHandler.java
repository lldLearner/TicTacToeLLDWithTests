package HANDLERS;

import MODELS.Board;

public interface WinnHandler {

	public void setNextHandler(WinnHandler winHandler);
	public boolean checkWinRequest(Board board, char currentSymbol, int currRow, int currCol);
}

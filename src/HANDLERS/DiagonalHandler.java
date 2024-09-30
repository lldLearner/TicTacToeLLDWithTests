package HANDLERS;

import MODELS.Board;

public class DiagonalHandler implements WinnHandler {

	private WinnHandler nextWinHandler;

	@Override
	public void setNextHandler(WinnHandler winHandler) {
		// TODO Auto-generated method stub
		this.nextWinHandler = winHandler;
	}

	@Override
	public boolean checkWinRequest(Board board, char currentSymbol, int currRow, int currCol) {
		// TODO Auto-generated method stub
		for(int r = 0; r < board.getSize(); r++) {
			if(board.getCell(r, r) != currentSymbol) {
				if(this.nextWinHandler != null) {
					return this.nextWinHandler.checkWinRequest(board, currentSymbol, currRow, currCol);
				}
			}
		}
		
		return true;
	}

}

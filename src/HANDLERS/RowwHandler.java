package HANDLERS;

import MODELS.Board;

public class RowwHandler implements WinnHandler {

	private WinnHandler nextWinHandler;
	
	@Override
	public void setNextHandler(WinnHandler winHandler) {
		// TODO Auto-generated method stub
		this.nextWinHandler = winHandler;
	}

	@Override
	public boolean checkWinRequest(Board board, char currentSymbol, int currRow, int currCol) {
		// TODO Auto-generated method stub

		
		for(int c = 0; c < board.getSize(); c++) {
			if(board.getCell(currRow, c) != currentSymbol) {
				if(this.nextWinHandler != null) {
					return this.nextWinHandler.checkWinRequest(board, currentSymbol, currRow, currCol);
				}
			}
		}
		
		return true;
	}

}

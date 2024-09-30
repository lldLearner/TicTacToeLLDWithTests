package INPUT;

import java.util.Scanner;

public class CliInput implements InputMethod {

	private Scanner scanner;
	private int boardSize;
	public CliInput(int boardSize) {
		// TODO Auto-generated constructor stub
		this.scanner = new Scanner(System.in);
		this.boardSize = boardSize;
	}
	
	@Override
	public int getRows() {
		// TODO Auto-generated method stub

		int row = scanner.nextInt();
		return row;
		
	}

	@Override
	public int getCols() {
		// TODO Auto-generated method stub
		
		int col = scanner.nextInt();
		return col;
	}

	@Override
	public boolean validateInput(int row, int col) {
		// TODO Auto-generated method stub
		return row >= 0 && row < this.boardSize && col >= 0 && col < this.boardSize;
	}
	
	public boolean isUndo() {
		return scanner.nextBoolean();
	}
}

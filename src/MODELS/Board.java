package MODELS;

public class Board {

	private char[][] board;
	private int numCellsFilled;
	private int size;
	public Board(int size) {
		// TODO Auto-generated constructor stub
		
		this.size = size;
		this.board = new char[size][size];
		this.numCellsFilled = 0;
	}
	
	public char getCell(int r, int c) {
		// TODO Auto-generated method stub
		return board[r][c];
	}
	
	public void setCell(int r, int c, char symbol) {
		// TODO Auto-generated method stub
		incrementNumCellsFilled(r, c);
		board[r][c] = symbol;
	}
	
	public void incrementNumCellsFilled(int r, int c) {
		if(board[r][c] == '\0') {
			this.numCellsFilled++;
		}
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public void display() {
		for(int r = 0; r < this.size; r++) {
			for(int c = 0; c < this.size; c++) {
				System.out.print(board[r][c] + " ");
			}
			
			System.out.println();
		}
	}
	
	public boolean isFilled() {
		// TODO Auto-generated method stub
		return this.numCellsFilled == this.size * this.size;
	}
	
	public void resetCell(int r, int c) {
		// TODO Auto-generated method stub
		board[r][c] = '\0';
		this.numCellsFilled--;
	}
}

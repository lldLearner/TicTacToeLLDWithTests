package MODELS;

public class Players {
	private char symbol;
	private boolean canUndo;
	public Players(char symbol) {
		// TODO Auto-generated constructor stub
		this.symbol = symbol;
		this.canUndo = true;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + this.getSymbol();
	}
	
	public void resetUndo() {
		this.canUndo = true;
	}
	
	public void unsetUndo() {
		this.canUndo = false;
	}
	
	public boolean getUndo() {
		return canUndo;
	}
}

package INPUT;

public interface InputMethod {

	public int getRows();
	public int getCols();
	public boolean validateInput(int row, int col);
	
	public boolean isUndo();
}


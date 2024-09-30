package TESTS;

import INPUT.InputMethod;

public class MockInput implements InputMethod {

	private int[][] inputs;
	private int currIndex;

	public MockInput(int[][] inputs) {
		// TODO Auto-generated constructor stub
		this.inputs = inputs;
		this.currIndex = 0;
	}

	@Override
	public int getRows() {
		// TODO Auto-generated method stub
		return inputs[currIndex][0];
	}

	@Override
	public int getCols() {
		// TODO Auto-generated method stub
		return inputs[currIndex][1];
	}

	@Override
	public boolean validateInput(int row, int col) {
		// TODO Auto-generated method stub
		return row >= 0 && col >= 0 && row < 3 && col < 3;
	}

	@Override
	public boolean isUndo() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void advaceInput() {
		currIndex = (currIndex + 1) % inputs.length;
	}
}

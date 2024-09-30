package TESTS;

import MODELS.Board;

public class BoardTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Board b = new Board(3);
		
		assert b.getSize() == 3 : "The size should be returned as 3";
	    System.out.println("Test passed: Size is 3.");

		assert b.isFilled() == false : "the board should not be completely filled";
		System.out.println("Test passed: the board is empty.");
		
		b.setCell(0, 0, 'X');
		assert b.getCell(0, 0) == 'X' : "the cell (0,0) should be filled with value 'X'";
		System.out.println("Test passed: the cell (0,0) == 'X'.");

		assert b.getCell(1, 1) == '\0' : "the cell (1,1) should be empty hence '\0'";
		System.out.println("Test passed: the cell (1,1) == '\0'.");

		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 3; c++) {
				b.setCell(r, c, 'X');
			}
		}
				
		assert b.isFilled() == true : "the board should be completely filled!";
		System.out.println("Test passed: the board is filled.");

		b.resetCell(0, 0);
		assert b.getCell(0, 0) == '\0' : "the cell (0,0) should be reset to '\0'";
		System.out.println("Test passed: the cell (0,0) is reset to '\0'.");
		
		assert b.isFilled() == false : "the board is not completely filled after reset!";
		System.out.println("Test passed: the board is not completely filled after reset!");
	}

}

package TESTS;

import MODELS.Players;

public class PlayersTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Players p1 = new Players('X');
		assert p1.getSymbol() == 'X' : "the symbol assigned should be equal to 'X'";
		System.out.println("Test passed : Player created has symbol 'X'.");
		
		assert p1.getUndo() == true : "player should be able to undo";
		System.out.println("Test passed : Player is able to undo the last move");
		
		p1.unsetUndo();
		
		assert p1.getUndo() == true : "player should not be able to undo";
		System.out.println("Test passed : Player is not able to undo the last move");
	}

}

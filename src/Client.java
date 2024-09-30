import java.util.Arrays;
import java.util.List;

import INPUT.CliInput;
import MODELS.Board;
import MODELS.Game;
import MODELS.Players;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Board b = new Board(3);
		List<Players> playerList = Arrays.asList(new Players('X'), new Players('O'));
		Game g1 = new Game(b, playerList, new CliInput(3));
		
		g1.play();
	}

}

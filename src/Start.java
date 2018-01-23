import java.io.IOException;

public class Start {
	
	private static GameTest dGame;

	public static void main(String[] args) {
		try {
			dGame = new GameTest("Game Test", 1024, 768);
		} catch (IOException e) {	//This is terrible!
			e.printStackTrace();
		}
		(new Thread(dGame)).start();
	}

}

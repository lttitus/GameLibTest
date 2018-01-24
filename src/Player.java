import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

import com.greenslimy.gamelib.display.graphics.sprites.Sprite;
import com.greenslimy.gamelib.display.graphics.text.Text;

public class Player extends Sprite {
	
	private Text name = new Text(Color.GREEN, "Player", 0, 0);

	public Player(int x, int y, int w, int h) throws IOException {
		super("res/player.png", x, y, w, h);
		
	}

	public void update() {
		name.x = x;
		name.y = y-5;
	}
	
	public void draw(Graphics g) {
		super.draw(g);
		name.draw(g);
	}

}

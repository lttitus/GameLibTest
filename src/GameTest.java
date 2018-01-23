import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.IOException;

import com.greenslimy.gamelib.GUIGame;
import com.greenslimy.gamelib.display.graphics.shapes.Rectangle;
import com.greenslimy.gamelib.display.graphics.text.Text;
import com.greenslimy.gamelib.display.graphics.text.TimedText;

/**
 * A test game to help code and show the power of the GameLib.
 * @author Green
 *
 */
public class GameTest extends GUIGame {
	
	private Player player;
	
	private final Rectangle borderSelector = new Rectangle(Color.GREEN, 0, 0, 0, 0) {
		public void updateRectangle() {
			destroy = !mLeftPressed;
		}
		public void removed() {
			destroy = false;
		}
	};
	private final Rectangle filledSelector = new Rectangle(Color.GREEN, 0, 0, 0, 0, true) {
		public void updateRectangle() {
			destroy = !mRightPressed;
		}
		public void removed() {
			destroy = false;
		}
	};
	private Rectangle selector;
	
	public GameTest(String title, int w, int h) throws IOException {
		super(title, w, h);
		this.player = new Player(w/2, h/2, 32, 32);	//Instantiate the player
		addDrawable(player);
		addDrawable(new Text("FPS: ", 0, 10) {
			public void update() {
				text = "FPS: "+fps;
			}
		});
		addDrawable(new Text(Color.CYAN, "Mouse", mcx, mcy) {
			public void update() {
				x = mcx;
				y = mcy;
				text = "Mouse: "+x+", "+y;
			}
		});
		addDrawable(new Text(Color.RED, "Player", player.x, player.y) {
			public void update() {
				x = player.x;
				y = player.y-10;	//Offset
			}
		});
		addDrawable(new TimedText("This is a test", 0, h/2, 5) {
			public void updateText() {
				y--;
			}
		});
	}
	
	protected void logicUpdate() {
		if(mPressed) {
			selector.changePoints(mpx, mpy, mcx-mpx, mcy-mpy);
		}
		if(keysPressed[KeyEvent.VK_DOWN]) {	//If we have the down arrow pressed
			player.y++;
		}if(keysPressed[KeyEvent.VK_UP]) {	//If we have the up arrow pressed
			player.y--;
		}if(keysPressed[KeyEvent.VK_RIGHT]) {	//If we have the right arrow pressed
			player.x++;
		}if(keysPressed[KeyEvent.VK_LEFT]) {	//If we have the left arrow pressed
			player.x--;
		}
	}

	protected void leftClicked() {
		selector = borderSelector;
	}

	protected void rightClicked() {
		selector = filledSelector;
	}

	protected void mouseClicked() {
		addDrawable(selector);
	}

}

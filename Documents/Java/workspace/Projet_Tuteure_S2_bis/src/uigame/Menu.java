package uigame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState {
	
	private int yMousePos = Mouse.getY();
	private int xMousePos = Mouse.getX();
	private Image playNow;
	private Image exitGame;
	private Image fond;
	private Music music;
	
	
	public Menu(int state){
		
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		playNow = new Image("ressources/uiMenu/playNow.png");
		exitGame = new Image("ressources/uiMenu/exit.png");
		fond = new Image("ressources/uiMenu/fond.jpg");
		music = new Music("ressources/music/musicIntro.ogg");
		music.setVolume(0.5f);
		music.loop();
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		fond.draw(0,0);
		AfficheMousePos(g);
		playNow.draw(186,300);
		exitGame.draw(186,450);
		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		
		/** comportement souris **/
		
		if (input.isMousePressed(0)){
			if (mouseZoneInput(new Point(248,454),new  Point(1144,423))) {
				music.stop();
				sbg.enterState(1);
			}
			if (mouseZoneInput(new Point(248,305),new  Point(1144,271))) {
				gc.exit();
			}
		}
		
	}

	public int getID() {
		return 0;
	}
	
	
	/** METHODS **/
	
	/** récupérer la position de la souris **/
	
	public void AfficheMousePos(Graphics g) {
		String mouse;
		yMousePos = Mouse.getY();
		xMousePos = Mouse.getX();
		
		mouse = "mouse position x : " + xMousePos + " y : " + yMousePos;
		g.drawString(mouse, 10, 30);
	}
	
	/** renvoi true si la souris est dans la zone, sinon false **/
	
	public boolean mouseZoneInput(Point a, Point b) {
		if (xMousePos > a.getX() && xMousePos < b.getX() && yMousePos > b.getY() && yMousePos < a.getY()){
			return true;
		}
		return false;
	}
}

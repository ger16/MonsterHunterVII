package uigame;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Hud {
	private Image bar;
	private Image buttonNord;
	private Image buttonSud;
	private Image buttonEst;
	private Image buttonOuest;
	private Image fond;
	private Image attack;
	
	private static final int BAR_X = -60;
	private static final int BAR_Y = -120;
	
	private static final int FOND_X = 10;
	private static final int FOND_Y = 500;
	
	private static final int NORD_X = 30;
	private static final int NORD_Y = 520;
	
	private static final int EST_X = 30;
	private static final int EST_Y = 570;
	
	private static final int OUEST_X = 30;
	private static final int OUEST_Y = 620;
	
	private static final int SUD_X = 30;
	private static final int SUD_Y = 670;
	
	private static final int ATTACK_X = 250;
	private static final int ATTACK_Y = 550;
	
	public Hud(){
		
	}
	
	public void init() throws SlickException {
	    this.bar = new Image("ressources/uiGame/bar.png");
	    this.buttonNord = new Image("ressources/uiGame/nord.png");
	    this.buttonSud = new Image("ressources/uiGame/sud.png");
	    this.buttonEst = new Image("ressources/uiGame/est.png");
	    this.buttonOuest = new Image("ressources/uiGame/ouest.png");
	    this.fond = new Image("ressources/uiGame/fond.png");
	    this.attack = new Image("ressources/uiGame/attack.png");
	  }
	
	public void render(Graphics g){
		g.resetTransform();
		g.drawImage(bar, BAR_X, BAR_Y);
		g.drawImage(fond, FOND_X, FOND_Y);
		g.drawImage(buttonNord, NORD_X, NORD_Y);
		g.drawImage(buttonEst, EST_X, EST_Y);
		g.drawImage(buttonOuest, OUEST_X, OUEST_Y);
		g.drawImage(buttonSud, SUD_X, SUD_Y);
		g.drawImage(attack, ATTACK_X, ATTACK_Y);
	}
	
	
}

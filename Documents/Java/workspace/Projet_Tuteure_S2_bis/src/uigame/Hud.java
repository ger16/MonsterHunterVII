package uigame;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import personnage.PJ;

public class Hud {
	private Image bar;
	private Image buttonNord;
	private Image buttonSud;
	private Image buttonEst;
	private Image buttonOuest;
	private Image fond;
	private Image attack;
	private PJ player;
	private Image force;
	private Image adresse;
	private Image resistance;
	boolean bool;
	
	private static final int BAR_X = -60;
	private static final int BAR_Y = -120;
	private static final int BAR_WIDTH = 160;
	private static final int BAR_HEIGHT = 14;
	
	private static final int FOND_X = 10;
	private static final int FOND_Y = 510;
	
	private static final int NORD_X = 110;
	private static final int NORD_Y = 540;
	
	private static final int EST_X = 200;
	private static final int EST_Y = 610;
	
	private static final int OUEST_X = 30;
	private static final int OUEST_Y = 610;
	
	private static final int SUD_X = 110;
	private static final int SUD_Y = 680;
	
	private static final int ATTACK_X = 270;
	private static final int ATTACK_Y = 654;
	
	private static final Color LIFE_COLOR = new Color(255, 0, 0, 0.5f);
	private static final Color MANA_COLOR = new Color(0, 0, 255, 0.5f);
	private static final Color XP_COLOR = new Color(0, 255, 0, 0.5f);

	
	
	public Hud(PJ player){
		this.player = player;
	}
	
	public void init() throws SlickException {
	    this.bar = new Image("ressources/uiGame/bar.png");
	    this.buttonNord = new Image("ressources/uiGame/nord.png");
	    this.buttonSud = new Image("ressources/uiGame/sud.png");
	    this.buttonEst = new Image("ressources/uiGame/est.png");
	    this.buttonOuest = new Image("ressources/uiGame/ouest.png");
	    this.fond = new Image("ressources/uiGame/fond.png");
	    this.attack = new Image("ressources/uiGame/attack.png");
	    this.force = new Image("ressources/uiGame/force.png");
	    this.adresse = new Image("ressources/uiGame/adresse.png");
	    this.resistance = new Image("ressources/uiGame/resistance.png");
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
		
			g.drawImage(force, NORD_X+300, NORD_Y-20);
			g.setColor(new Color(Color.red));
			g.drawString(""+player.getForce(),NORD_X+345, NORD_Y+25);
			
			g.drawImage(adresse, NORD_X+300, NORD_Y+60);
			g.setColor(new Color(Color.orange));
			g.drawString(""+player.getAdresse(),NORD_X+345, NORD_Y+105);
			
			g.drawImage(resistance, NORD_X+300, NORD_Y+140);
			g.setColor(new Color(Color.pink));
			g.drawString(""+player.getResistance(),NORD_X+345, NORD_Y+185);
		
		g.setColor(LIFE_COLOR);
		g.fillRect(BAR_X+188, BAR_Y+166, ((float)player.getPV()/100) * BAR_WIDTH, BAR_HEIGHT);
		g.setColor(MANA_COLOR);
		g.fillRect(BAR_X+188, BAR_Y+187, ((float)player.getPA()/(float)player.getPA_MAX()) * BAR_WIDTH, BAR_HEIGHT);
		g.setColor(XP_COLOR);
		g.fillRect(BAR_X+188, BAR_Y+207, (((float)player.getPX()%100)/100) * BAR_WIDTH, BAR_HEIGHT);
		
		
	}
	
	
}

package uigame;

import java.util.ArrayList;

import objets.Objets;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.tiled.TiledMap;

import personnage.Monstre;
import personnage.Niveaux;
import personnage.PJ;
import personnage.PNJ;

public class Play extends BasicGameState {
	
	private int xMousePos;
	private int yMousePos;
	private Niveaux n = new Niveaux();
	private Map map = new Map();
	private PJ joueur = new PJ();
	private Monstre monster = new Monstre();
	private boolean musicOFF;
	private Music music2;
	private Camera camera = new Camera(joueur);
	private PlayerController controller;
	private Hud hud = new Hud();
	
	public Play(int state){
		
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		musicOFF = true;
		music2 = new Music("ressources/music/music2.ogg");
		map.init();
		this.joueur.init();
		this.monster.init();
		controller = new PlayerController(joueur,monster,gc);
		hud.init();
		
		//monsterSS = new SpriteSheet("ressources/sprite/monsters/bat.png",64,64);
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		camera.affichage(gc, g);
		if (musicOFF) {music2.loop(); musicOFF = false;}
		map.renderBackground();
		joueur.render(g);
		monster.render(g);
		map.renderForeground();
		//drawCase(g,gc);
		//camera.affichage(gc, g);
		//map.render(gc.getWidth() / 2 - (int) this.joueur.getPosX(), gc.getHeight() / 2 - (int)this.joueur.getPosY());
		//map.render(this.joueur.getX(),this.joueur.getY());
		//map.render(joueur.getPosX(),joueur.getPosY());
		g.drawString("Pos du PJ x : " + joueur.getX() + " Pos du PJ en y : " + joueur.getY(), joueur.getX(), joueur.getY());
		AfficheMousePos(g);
		
		hud.render(g);
		//g.drawAnimation(joueurAnimation[2],joueur.getPjPosX(),joueur.getPjPosY());
	}

	public void update(GameContainer gc, StateBasedGame sbg, int g) throws SlickException {
		camera.update(gc);
		controller.mousePressed(0,Mouse.getX(),Mouse.getY());
		joueur.update();
		monster.update();
	}

	public int getID() {
		return 1;
	}
	
	public void AfficheMousePos(Graphics g) {
		String mouse;
		yMousePos = Mouse.getY();
		xMousePos = Mouse.getX();
		
		mouse = "mouse position x : " + xMousePos + " y : " + yMousePos;
		g.drawString(mouse, joueur.getX(), joueur.getY()+200);
		g.drawString(camera.getxCamera() + "  " + camera.getyCamera(), joueur.getX(), joueur.getY());
	}
	
	private void drawCase(Graphics g, GameContainer gc){
		g.resetTransform();
		for (int i = -632; i < 4000; i = i + 64) {
			g.drawLine(-630, i, 4000, i);
			g.drawLine(i, -640, i, 4000);
		}
	}
}

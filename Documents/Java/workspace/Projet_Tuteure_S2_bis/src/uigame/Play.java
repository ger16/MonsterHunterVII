package uigame;

import java.util.ArrayList;
import java.util.Random;

import objets.Equipement;
import objets.MainDroite;
import objets.Objets;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.tiled.TiledMap;

import personnage.Monstre;
import personnage.Niveaux;
import personnage.PJ;
import personnage.PNJ;
import personnage.Personnage;

public class Play extends BasicGameState {
	
	public static final int TIMER_X = 1250;
	public static final int TIMER_Y = 40;
	private int xMousePos;
	private int yMousePos;
	private Niveaux n = new Niveaux();
	private Map map = new Map();
	private PJ joueur = new PJ(map);
	private MyTimer timer;
	
	private Monstre monsterTab[] = {new Monstre("Batman",1,map),new Monstre("Batman2",1,map),new Monstre("Batman3",1,map),
									new Monstre("Batman4",1,map),new Monstre("Batman5",1,map),new Monstre("Slime",1,map),
									new Monstre("Slime2",1,map),new Monstre("Slime3",1,map),new Monstre("Snake",2,map),
									new Monstre("Eyeball",3,map)};
	private boolean musicOFF;
	private Music music2;
	private Camera camera = new Camera(joueur,map);
	private PlayerController controller;
	private Hud hud = new Hud(joueur);
	private Equipement equipement = new Equipement();
	private MainDroite md = new MainDroite();
	
	public Play(int state){
		
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		timer = new MyTimer();
		timer.time();
		musicOFF = true;
		music2 = new Music("ressources/music/music2.ogg");
		map.init();
		this.joueur.init();
		this.monsterTabInit(monsterTab);
		controller = new PlayerController(joueur,monsterTab,gc);
		hud.init();
		this.joueur.setX(64f);
		this.joueur.setY(64f);
		this.joueur.setPA(100);
		
		this.joueur.setEquipement(equipement);
		this.equipement.setMainD(md);
		this.md.setPortee(1);
		
		//monsterSS = new SpriteSheet("ressources/sprite/monsters/bat.png",64,64);
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		camera.affichage(gc, g);
		if (musicOFF) {music2.loop(); musicOFF = false;}
		map.renderBackground();
		joueur.render(g);
		monsterTabUpdate2(monsterTab,g);
		monsterTabrender2(g,monsterTab);
		map.renderForeground();
		//drawCase(g,gc);
		//camera.affichage(gc, g);
		//map.render(gc.getWidth() / 2 - (int) this.joueur.getPosX(), gc.getHeight() / 2 - (int)this.joueur.getPosY());
		//map.render(this.joueur.getX(),this.joueur.getY());
		//map.render(joueur.getPosX(),joueur.getPosY());
		g.setColor(new Color(0,0,0,.5f));
		g.drawString("Pos du PJ x : " + joueur.getX() + " Pos du PJ en y : " + joueur.getY(), joueur.getX(), joueur.getY());
		AfficheMousePos(g);
		
		hud.render(g);
		joueur.renderStatic(g);
		
		g.setColor(new Color(Color.red));
		g.drawString("Time : " + timer.getS(), TIMER_X, TIMER_Y);
		
		//g.drawAnimation(joueurAnimation[2],joueur.getPjPosX(),joueur.getPjPosY());
	}

	public void update(GameContainer gc, StateBasedGame sbg, int g) throws SlickException {
		camera.update(gc);
		controller.mousePressed(0,Mouse.getX(),Mouse.getY());
		monsterTabUpdate(monsterTab,timer);
		
		calcDLA(timer,joueur);
		joueur.update();
		joueur.isUP();
	}

	public int getID() {
		return 1;
	}
	
	public void AfficheMousePos(Graphics g) {
		String mouse;
		yMousePos = Mouse.getY();
		xMousePos = Mouse.getX();
		
		mouse = "mouse position x : " + xMousePos + " y : " + yMousePos + " yPlacement : " + (768-yMousePos);
		g.drawString(mouse, joueur.getX(), joueur.getY()+200);
		g.drawString("CoordX : " + joueur.getxCoord() + " CoordY : " + joueur.getyCoord(), joueur.getX(), joueur.getY()+300);
		//g.drawString(camera.getxCamera() + "  " + camera.getyCamera(), joueur.getX(), joueur.getY());
	}
	
	public void monsterTabInit(Monstre monsterTab[]) throws SlickException{
		int x,y;
		int wh = map.getTiledMap().getHeight();
		Random rand = new Random();
		for (int i = 0; i< monsterTab.length; i++){
			x=rand.nextInt(20);
			y=rand.nextInt(20);
			monsterTab[i].setPA(100);
			
			if (i<6){
				monsterTab[i].setX(x*wh);
				monsterTab[i].setY(y*wh);
				monsterTab[i].setSkin("ressources/sprite/monsters/bat.png");
				
				SpriteSheet spriteSheet = new SpriteSheet(monsterTab[i].getSkin(),32,32);
				//x1 y1 x2 y2 horizontaleScan duration autoUpdate
				monsterTab[i].setAnimations( new Animation(spriteSheet, 0,0,2,1,true,100,true),
											  new Animation(spriteSheet, 0,1,2,1,true,100,true),
											  new Animation(spriteSheet, 0,2,2,1,true,100,true),
											  new Animation(spriteSheet, 0,3,2,1,true,100,true));
			}
			else if(i<9){
				monsterTab[i].setX(x*wh);
				monsterTab[i].setY(y*wh);
				monsterTab[i].setSkin("ressources/sprite/monsters/slime.png");
				
				SpriteSheet spriteSheet = new SpriteSheet(monsterTab[i].getSkin(),32,32);
				monsterTab[i].setAnimations( new Animation(spriteSheet, 0,0,2,1,true,100,true),
						  new Animation(spriteSheet, 0,1,2,1,true,100,true),
						  new Animation(spriteSheet, 0,2,2,1,true,100,true),
						  new Animation(spriteSheet, 0,3,2,1,true,100,true));
			}
			else if(i<10){
				monsterTab[i].setX(x*wh);
				monsterTab[i].setY(y*wh);
				monsterTab[i].setSkin("ressources/sprite/monsters/snake.png");
				
				SpriteSheet spriteSheet = new SpriteSheet(monsterTab[i].getSkin(),32,32);
				monsterTab[i].setAnimations( new Animation(spriteSheet, 0,0,2,1,true,100,true),
						  new Animation(spriteSheet, 0,1,2,1,true,100,true),
						  new Animation(spriteSheet, 0,2,2,1,true,100,true),
						  new Animation(spriteSheet, 0,3,2,1,true,100,true));
			}
			else if(i<11){
				monsterTab[i].setX(x*wh);
				monsterTab[i].setY(y*wh);
				monsterTab[i].setSkin("ressources/sprite/monsters/eyeball.png");
				
				SpriteSheet spriteSheet = new SpriteSheet(monsterTab[i].getSkin(),32,32);
				monsterTab[i].setAnimations( new Animation(spriteSheet, 0,0,2,1,true,100,true),
						  new Animation(spriteSheet, 0,1,2,1,true,100,true),
						  new Animation(spriteSheet, 0,2,2,1,true,100,true),
						  new Animation(spriteSheet, 0,3,2,1,true,100,true));
			}
		}
	}
	
	/*public void monsterTabrender(Graphics g, Monstre monsterTab[]) throws SlickException {
		for (int i = 0; i<monsterTab.length;i++){
		if (monsterTab[i].isDead() == false){
		g.drawAnimation(monsterTab[i].getAnimations()[monsterTab[i].getDirection()],monsterTab[i].getX()-16,monsterTab[i].getY()-32);
		}
		else{
			g.setColor(new Color(0,0,0,1f));
			g.drawString("DEAD", monsterTab[i].getX()-16, monsterTab[i].getY()-32);
		}
		}
	}*/
	
	public void monsterTabUpdate(Monstre monsterTab[], MyTimer time){
		for (int i = 0; i<monsterTab.length; i++){
		monsterTab[i].updateCoord();
		calcDLA(timer,monsterTab[i]);
		boolean collision;
		monsterTab[i].isDead();
		float futurX = monsterTab[i].getX();
		float futurY = monsterTab[i].getY();
		
		if (monsterTab[i].isMoving()){
			switch (monsterTab[i].getDirection()){
				case 4: futurY = futurY ;//+ mvt; //haut
				case 5: futurX = futurX ;//- mvt; //gauche
				case 6: futurY = futurY ;//- mvt; //bas
				case 7: futurX = futurX ;//+ mvt; //droite
				monsterTab[i].setMoving(false);
			}
		}
		
		//collision = this.map.isCollision(futurX, futurY);
		collision = false;
		
		if (collision){
			monsterTab[i].setX(futurX);
			monsterTab[i].setY(futurY);
		}
		}
	}
	
	public void monsterTabUpdate2(Monstre monsterTab[], Graphics g){
		for(int i = 0; i<monsterTab.length;i++){
			//g.resetTransform();
			if (!monsterTab[i].isDead()){
			g.setColor(new Color(Color.green));
			g.drawString("EXP : " + monsterTab[i].getPX(), monsterTab[i].getX(), monsterTab[i].getY());
			}
		}
	
	}
	
	public void calcDLA(MyTimer tempsJeu, Personnage p){
		
		if(tempsJeu.getS() == p.getDLA()){
			//this.DLA += uigame.MyTimer.PERIODE;
			if (p.getPA() <= 66 ){
			p.setPA(p.getPA()/2 + p.getPA()+1);//+ (this.initiative.getDegres()/PA_INI);
			p.setDLA(p.getDLA() + 10);
			}
			else {
				p.setPA(100);
				p.setDLA(p.getDLA()+10);
			}
		}
		
		
	}
	
	public void monsterTabrender2(Graphics g, Monstre monsterTab[]) throws SlickException {
		
		for (int i = 0; i<monsterTab.length;i++){
			monsterTab[i].setBarPV(new Image("ressources/uiGame/barPNJ.png"));
		if (monsterTab[i].isDead() == false){
		g.drawAnimation(monsterTab[i].getAnimations(monsterTab[i].getDirection()),monsterTab[i].getX(),monsterTab[i].getY());
		g.drawImage(monsterTab[i].getBarPV(),monsterTab[i].getX()-24,monsterTab[i].getY()-30);
		g.setColor(new Color(5,0,0,0.5f));
		g.fillRect(monsterTab[i].getX()-10, monsterTab[i].getY()-21, ((float)monsterTab[i].getPV()/100) * 56, 14);
		}
		else{
			g.setColor(new Color(0,0,0,1f));
			g.drawString("DEAD", monsterTab[i].getX()-16, monsterTab[i].getY()-32);
		}
		}
	}
}

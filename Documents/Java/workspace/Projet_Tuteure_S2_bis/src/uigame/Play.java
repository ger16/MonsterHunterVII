package uigame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.tiled.TiledMap;

import personnage.PJ;
import personnage.PNJ;

public class Play extends BasicGameState {
	
	private PJ joueur;
	private PNJ monster;
	private SpriteSheet joueurSS;
	private SpriteSheet monsterSS;
	private Animation joueurAnimation[];
	private Animation monsterAnimation[];
	private TiledMap map;
	private boolean musicOFF;
	private Music music2;
	
	
	public Play(int state){
		
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		musicOFF = true;
		music2 = new Music("ressources/music/music2.ogg");
		map = new TiledMap("ressources/map/map.tmx");
		System.out.println(map.getObjectName(1, 1));
		joueur = new PJ();
		joueur.setX(0);
		joueur.setY(0);
		monster = new PNJ();
		joueurAnimation = new Animation[8];
		joueurSS = new SpriteSheet(joueur.getSkin1(),64,64);
		monsterSS = new SpriteSheet(monster.getSkin(),64,64);
		//x1 y1 x2 y2 horizontaleScan duration autoUpdate
		joueurAnimation[0] = new Animation(joueurSS, 0,0,0,0,true,100,true); //dos
		joueurAnimation[1] = new Animation(joueurSS, 0,1,0,1,true,100,true); //gauche
		joueurAnimation[2] = new Animation(joueurSS, 0,2,0,2,true,100,true); //face
		joueurAnimation[3] = new Animation(joueurSS, 0,3,0,3,true,100,true); //droite
		joueurAnimation[4] = new Animation(joueurSS, 1,0,8,0,true,100,true); //mvt dos
		joueurAnimation[5] = new Animation(joueurSS, 1,1,8,1,true,100,true); //mvt gauche
		joueurAnimation[6] = new Animation(joueurSS, 1,2,8,2,true,100,true); //mvt face
		joueurAnimation[7] = new Animation(joueurSS, 1,3,8,3,true,100,true); //mvt droite
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		if (musicOFF) {music2.loop(); musicOFF = false;}
		g.translate(gc.getWidth() / 2 - (int) 20, gc.getHeight() / 2
				- (int) 20);

		this.map.render(0, 0);
		//map.render(gc.getWidth() / 2 - (int) this.joueur.getPosX(), gc.getHeight() / 2 - (int)this.joueur.getPosY());
		//map.render(this.joueur.getPosX(),this.joueur.getPosY());
		//map.render(joueur.getPosX(),joueur.getPosY());
		g.drawString("Pos du PJ x : " + joueur.getX() + " Pos du PJ en y : " + joueur.getY(), 100, 100);
		
		joueurAnimation[6].draw(joueur.getX(), joueur.getY());
		//g.drawAnimation(joueurAnimation[2],joueur.getPjPosX(),joueur.getPjPosY());
	}

	public void update(GameContainer gc, StateBasedGame sbg, int g) throws SlickException {
		//joueur.setPosX(joueur.getPosX()+1);
		//joueur.setPosY(joueur.getPosY()+1);
	}

	public int getID() {
		return 1;
	}
	
	private Animation loadAnimation(SpriteSheet ss, int startX, int endX, int y) {
		Animation animation = new Animation();
		for (int i=startX; i<endX; i++){
			animation.addFrame(ss.getSprite(i, y), 100);
		}
		return animation;
	}
}

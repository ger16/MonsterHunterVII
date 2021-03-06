package personnage;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import uigame.Map;



public class Monstre extends PNJ{
	
	String skin;
	Image barPV;
	
	public static final int CATEGORIE_1 = 1;
	public static final int CATEGORIE_2 = 2;
	public static final int CATEGORIE_3 = 3;
	public static final int CATEGORIE_4 = 4;
	public static final int CATEGORIE_5 = 5;
	public static final int CATEGORIE_6 = 6;
	public static final int CATEGORIE_7 = 7;
	public static final int CATEGORIE_8 = 8;
	public static final int CATEGORIE_9 = 9;
	public static final int CATEGORIE_10 = 10;
	
	public static final Niveaux NIVEAUX_CATEGORIE_1 = new Niveaux(6);
	public static final Niveaux NIVEAUX_CATEGORIE_2 = new Niveaux(12);
	public static final Niveaux NIVEAUX_CATEGORIE_3 = new Niveaux(18);
	public static final Niveaux NIVEAUX_CATEGORIE_4 = new Niveaux(24);
	public static final Niveaux NIVEAUX_CATEGORIE_5 = new Niveaux(30);
	public static final Niveaux NIVEAUX_CATEGORIE_6 = new Niveaux(36);
	public static final Niveaux NIVEAUX_CATEGORIE_7 = new Niveaux(42);
	public static final Niveaux NIVEAUX_CATEGORIE_8 = new Niveaux(48);
	public static final Niveaux NIVEAUX_CATEGORIE_9 = new Niveaux(54);
	public static final Niveaux NIVEAUX_CATEGORIE_10 = new Niveaux(60);
	
	public Monstre(Map map) {
		super(map);

	}
	
	public Monstre (float x, float y, int direction, boolean moving,String nom, int PV, int PX, Niveaux initiative, Niveaux attaque, Niveaux esquive, Niveaux defense, Niveaux degats, Map map){
		super(x,y,direction,moving,nom, PV, PX, initiative, attaque, esquive, defense, degats, map);
	}

	public Monstre(String nom, int categorie, Map map) {
		super(map);
		this.PV = 100;
		this.skin = "ressources/sprite/monsters/bat.png";
		switch (categorie){
		case 1 :
			this.PX = 100;
			this.initiative = NIVEAUX_CATEGORIE_1;
			this.attaque = NIVEAUX_CATEGORIE_1;
			this.esquive = NIVEAUX_CATEGORIE_1;
			this.defense = NIVEAUX_CATEGORIE_1;
			this.degats = NIVEAUX_CATEGORIE_1;break;
		case 2 :
			this.PX = 200;
			this.initiative = NIVEAUX_CATEGORIE_2;
			this.attaque = NIVEAUX_CATEGORIE_2;
			this.esquive = NIVEAUX_CATEGORIE_2;
			this.defense = NIVEAUX_CATEGORIE_2;
			this.degats = NIVEAUX_CATEGORIE_2;break;
		case 3 :
			this.PX = 300;
			this.initiative = NIVEAUX_CATEGORIE_3;
			this.attaque = NIVEAUX_CATEGORIE_3;
			this.esquive = NIVEAUX_CATEGORIE_3;
			this.defense = NIVEAUX_CATEGORIE_3;
			this.degats = NIVEAUX_CATEGORIE_3;break;
		case 4 :
			this.PX = 400;
			this.initiative = NIVEAUX_CATEGORIE_4;
			this.attaque = NIVEAUX_CATEGORIE_4;
			this.esquive = NIVEAUX_CATEGORIE_4;
			this.defense = NIVEAUX_CATEGORIE_4;
			this.degats = NIVEAUX_CATEGORIE_4;break;
		case 5 :
			this.PX = 500;
			this.initiative = NIVEAUX_CATEGORIE_5;
			this.attaque = NIVEAUX_CATEGORIE_5;
			this.esquive = NIVEAUX_CATEGORIE_5;
			this.defense = NIVEAUX_CATEGORIE_5;
			this.degats = NIVEAUX_CATEGORIE_5;break;
		case 6 :
			this.PX = 600;
			this.initiative = NIVEAUX_CATEGORIE_6;
			this.attaque = NIVEAUX_CATEGORIE_6;
			this.esquive = NIVEAUX_CATEGORIE_6;
			this.defense = NIVEAUX_CATEGORIE_6;
			this.degats = NIVEAUX_CATEGORIE_6;break;
		case 7 :
			this.PX = 700;
			this.initiative = NIVEAUX_CATEGORIE_7;
			this.attaque = NIVEAUX_CATEGORIE_7;
			this.esquive = NIVEAUX_CATEGORIE_7;
			this.defense = NIVEAUX_CATEGORIE_7;
			this.degats = NIVEAUX_CATEGORIE_7;break;
		case 8 :
			this.PX = 800;
			this.initiative = NIVEAUX_CATEGORIE_8;
			this.attaque = NIVEAUX_CATEGORIE_8;
			this.esquive = NIVEAUX_CATEGORIE_8;
			this.defense = NIVEAUX_CATEGORIE_8;
			this.degats = NIVEAUX_CATEGORIE_8;break;
		case 9 :
			this.PX = 900;
			this.initiative = NIVEAUX_CATEGORIE_9;
			this.attaque = NIVEAUX_CATEGORIE_9;
			this.esquive = NIVEAUX_CATEGORIE_9;
			this.defense = NIVEAUX_CATEGORIE_9;
			this.degats = NIVEAUX_CATEGORIE_9;break;
		case 10 :
			this.PX = 1000;
			this.initiative = NIVEAUX_CATEGORIE_10;
			this.attaque = NIVEAUX_CATEGORIE_10;
			this.esquive = NIVEAUX_CATEGORIE_10;
			this.defense = NIVEAUX_CATEGORIE_10;
			this.degats = NIVEAUX_CATEGORIE_10;break;
		default :
			this.PX = 0;
			this.initiative = null;
			this.attaque = null;
			this.esquive = null;
			this.defense = null;
			this.degats = null;			
		}
	}
	
	public void init() throws SlickException {
		SpriteSheet spriteSheet = new SpriteSheet(skin,32,32);
		//x1 y1 x2 y2 horizontaleScan duration autoUpdate
		this.x = 128;
		this.y = 0;
		animations[0] = new Animation(spriteSheet, 0,0,2,1,true,100,true); //nord
		animations[1] = new Animation(spriteSheet, 0,1,2,1,true,100,true); //ouest
		animations[2] = new Animation(spriteSheet, 0,2,2,1,true,100,true); //sud
		animations[3] = new Animation(spriteSheet, 0,3,2,1,true,100,true); //est
	}
	
	public void update() throws SlickException {
		this.updateCoord();
		boolean collision;
		this.isDead();
		float futurX = this.x;
		float futurY = this.y;
		
		if (this.moving){
			switch (this.direction){
				case 4: futurY = futurY ;//+ mvt; //haut
				case 5: futurX = futurX ;//- mvt; //gauche
				case 6: futurY = futurY ;//- mvt; //bas
				case 7: futurX = futurX ;//+ mvt; //droite
				this.moving = false;
			}
		}
		
		//collision = this.map.isCollision(futurX, futurY);
		collision = false;
		
		if (collision){
			this.x = futurX;
			this.y = futurY;
		}
	}

	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	public void setAnimations(Animation animation, Animation animation2, Animation animation3, Animation animation4) {
		this.animations[0] = animation;
		this.animations[1] = animation2;
		this.animations[2] = animation3;
		this.animations[3] = animation4;
		
	}

	public Image getBarPV() {
		return barPV;
	}

	public void setBarPV(Image barPV) {
		this.barPV = barPV;
	}
}

package personnage;

import org.newdawn.slick.Animation;

import uigame.Map;

public class PNJ extends Personnage{
	
	public PNJ(){
		super();
	}
	
	
	public PNJ(float x, float y, int direction, boolean moving, String nom, double PV, double PX, Niveaux initiative, Niveaux attaque, Niveaux esquive, Niveaux defense, Niveaux degats, Map map){
		super(x,y,direction,moving,nom, PV, PX, initiative, attaque, esquive, defense, degats, map);
		
	}
	
	public void attaquer(Personnage adversaire){
		if(adversaire.esquive.score() < this.attaque.score()){
			if(adversaire.defense.score() < this.degats.score()){
				int diff = this.degats.score() - this.defense.score();
				diff /= 3;
				adversaire.PV -= 100/6*diff;
			}
		}
	}
	
	public void deplacement(int x, int y){
		
	}
}

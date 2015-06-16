package personnage;

import org.newdawn.slick.Animation;

import uigame.Map;

public class PNJ extends Personnage{
	
	
	public PNJ(Map map){
		super(map);
	}
	
	
	public PNJ(float x, float y, int direction, boolean moving, String nom, double PV, double PX, Niveaux initiative, Niveaux attaque, Niveaux esquive, Niveaux defense, Niveaux degats, Map map){
		super(x,y,direction,moving,nom, PV, PX, initiative, attaque, esquive, defense, degats, map);
		
	}
	
	public void attaquer(Personnage adversaire){
		if(adversaire.esquive.score() < this.attaque.score()){
			if(adversaire.defense.score() < this.degats.score()){
				int diff = this.degats.score() - adversaire.defense.score();
				diff /= 3;
				for(int i=0;i<diff;i++){
					adversaire.PV -= 100.0/6.0;
				}
			}
		}
	}
	
	public void deplacement(int x, int y){
		
	}
}

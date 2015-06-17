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
		if (this.PA > 2 && !(adversaire.isDead()) && aPortee(adversaire)) {
		this.PA -= 3;
		if(adversaire.esquive.score() < this.attaque.score()){
			if(adversaire.defense.score() < this.degats.score()){
				this.PX += 1;
				int diff = this.degats.score() - adversaire.defense.score();
				diff /= 3;
				for(int i=0;i<diff;i++){
					adversaire.PV -= 100.0/6.0;
				}
				adversaire.PV -= 100/6*diff;
			}
		}
		if(adversaire.PV == 0){
			double ratio = adversaire.PX/this.PX;
			this.PX += 5 * ratio;
		}
		}
	}
	
	public boolean aPortee(Personnage adversaire){
		int portee = 1;
		if (this.xCoord <= adversaire.xCoord + portee && this.xCoord >= adversaire.xCoord && this.yCoord <= adversaire.yCoord && this.yCoord >= adversaire.yCoord){
			return true;
		}
		return false;
	}
	
	public void deplacement(int x, int y){
		
	}
}

package personnage;

public class PNJ extends Personnage{
	
	public PNJ(){
		super();
	}
	
	
	public PNJ(String nom, double PV, double PX, Niveaux initiative, Niveaux attaque, Niveaux esquive, Niveaux defense, Niveaux degats){
		super(nom, PV, PX, initiative, attaque, esquive, defense, degats);
		
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

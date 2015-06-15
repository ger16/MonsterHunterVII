package personnage;

import java.util.Random;

public class Niveaux {
	private int degres;
	private int UA;
	private int D;
	private int nbD;
	
	public Niveaux(){
		this.degres = 0;
		this.UA = 0;
		this.D = 0;
		this.nbD = 0;
	}
	
	public Niveaux(int degres){
		this.degres = degres;
		this.nbD = degres/3;
		this.UA = degres%3;
	}
	
	public Niveaux(int nbD, int UA){
		this.nbD = nbD;
		this.UA = UA;
		this.degres = 3*this.nbD + this.UA;
	}
	public int score(){
		int score = 0;
		Random rand = new Random();
		this.D = rand.nextInt(6)+1;
		for (int i=0; i<this.nbD-1; i++){
			this.D += rand.nextInt(6)+1;
		}
		score = this.D + this.UA;
		return score;
	}
	
	public void setDegres(int degres){
		this.degres = degres;
	}
	public void setUA(int UA){
		this.UA = UA;
	}	
	public void setD(int D){
		this.D = D;
	}
	public void setNbD(int nbD){
		this.nbD = nbD;
	}
	
	public int getDegres(){
		return this.degres;
	}
	public int getUA(){
		return this.UA;
	}
	public int getD(){
		return this.D;
	}
	public int getNbD(){
		return this.nbD;
	}
	
	public String toString(){
		return "\nNiveau : " + this.nbD + "D " + "+ " + this.UA +"\nDegres : " + this.degres;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + D;
		result = prime * result + UA;
		result = prime * result + degres;
		result = prime * result + nbD;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Niveaux))
			return false;
		Niveaux other = (Niveaux) obj;
		if (D != other.D)
			return false;
		if (UA != other.UA)
			return false;
		if (degres != other.degres)
			return false;
		if (nbD != other.nbD)
			return false;
		return true;
	}
}

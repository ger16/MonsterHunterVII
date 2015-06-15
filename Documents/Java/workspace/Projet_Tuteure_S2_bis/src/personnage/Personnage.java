package personnage;

public abstract class Personnage {
	
	protected String nom;
	protected double PV;
	protected double PX;
	
	
	protected Niveaux initiative;
	protected Niveaux attaque;
	protected Niveaux esquive;
	protected Niveaux defense;
	protected Niveaux degats;
	
	public Personnage(){
		this.nom = "Innomé";
		this.PV = 100;
		this.PX = 0;
		this.initiative = new Niveaux();
		this.attaque = new Niveaux();
		this.esquive = new Niveaux();
		this.defense = new Niveaux();
		this.degats = new Niveaux();
	}
	
	public Personnage(String nom, double PV, double PX, Niveaux initiative, Niveaux attaque, Niveaux esquive, Niveaux defense, Niveaux degats){
		this.nom = nom;
		this.PV = PV;
		this.PX = PX;
		this.initiative = initiative;
		this.esquive = esquive;
		this.attaque = esquive;
		this.defense = defense;
		this.degats = degats;
	}
	
	public abstract void attaquer(Personnage adversaire);
	public abstract void deplacement(int x, int y);
	
	public void setNom(String nom){
		this.nom = nom;
	}
	public void setPV(int PV){
		this.PV = PV;
	}
	public void setPX(int PX){
		this.PX = PX;
	}
	public void setInitiative(Niveaux initiative){
		this.initiative = initiative;
	}
	public void setAttaque(Niveaux attaque){
		this.attaque = attaque;
	}
	public void setDefense(Niveaux defense){
		this.defense = defense;
	}
	public void setDegats(Niveaux degats){
		this.degats = degats;
	}
	
	public String getNom(){
		return this.nom;
	}
	public double getPV(){
		return this.PV;
	}
	public double getPX(){
		return this.PX;
	}
	public Niveaux getInitiative(){
		return this.initiative;
	}
	public Niveaux getEsquive(){
		return this.esquive;
	}
	public Niveaux getAttaque(){
		return this.attaque;
	}
	public Niveaux getDefense(){
		return this.defense;
	}
	public Niveaux getDegats(){
		return this.degats;
	}
	
	public String toString(){
		return "Nom : " + this.nom + "\n\nPV : " + this.PV + "\n\nPX : " + this.PX +"\n\nInitiative : " + this.initiative + "\n\nAttaque : " + this.attaque + "\n\nEsquive : " + this.esquive + "\n\nDefense : " + this.defense + "\n\nDegats : " + this.degats;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(PV);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(PX);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((attaque == null) ? 0 : attaque.hashCode());
		result = prime * result + ((defense == null) ? 0 : defense.hashCode());
		result = prime * result + ((degats == null) ? 0 : degats.hashCode());
		result = prime * result + ((esquive == null) ? 0 : esquive.hashCode());
		result = prime * result
				+ ((initiative == null) ? 0 : initiative.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Personnage))
			return false;
		Personnage other = (Personnage) obj;
		if (Double.doubleToLongBits(PV) != Double.doubleToLongBits(other.PV))
			return false;
		if (Double.doubleToLongBits(PX) != Double.doubleToLongBits(other.PX))
			return false;
		if (attaque == null) {
			if (other.attaque != null)
				return false;
		} else if (!attaque.equals(other.attaque))
			return false;
		if (defense == null) {
			if (other.defense != null)
				return false;
		} else if (!defense.equals(other.defense))
			return false;
		if (degats == null) {
			if (other.degats != null)
				return false;
		} else if (!degats.equals(other.degats))
			return false;
		if (esquive == null) {
			if (other.esquive != null)
				return false;
		} else if (!esquive.equals(other.esquive))
			return false;
		if (initiative == null) {
			if (other.initiative != null)
				return false;
		} else if (!initiative.equals(other.initiative))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
}

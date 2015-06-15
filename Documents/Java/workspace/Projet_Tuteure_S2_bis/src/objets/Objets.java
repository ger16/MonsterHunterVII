package objets;

import personnage.PJ;

public abstract class Objets {
	protected String nom;
	
	public Objets(){
		this.nom = "Aucun";
	}
	
	public Objets(String nom){
		this.nom = nom;
	}
	
	public abstract void utiliser(PJ p);
	public void ramasserObjet(PJ p){
		
	}
	
	public void setNom(String nom){
		this.nom = nom;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public String toString(){
		return "Nom : " + this.nom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Objets))
			return false;
		Objets other = (Objets) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
}

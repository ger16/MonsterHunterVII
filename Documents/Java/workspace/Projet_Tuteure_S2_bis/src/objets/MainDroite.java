package objets;

import personnage.Niveaux;
import personnage.PJ;

public class MainDroite extends Objets {
	private String type;
	private Niveaux maniabiliteArme;
	private Niveaux impactArme;
	private int portee;
		
	public MainDroite(){
		this.type = "Aucun";
		this.maniabiliteArme = new Niveaux();
		this.impactArme = new Niveaux();
		this.portee = 0;
	}
	
	public MainDroite(String nom, String type, Niveaux maniabiliteArme, Niveaux impactArme){
		super(nom);
		this.type = type;
		this.maniabiliteArme = maniabiliteArme;
		this.impactArme = impactArme;
	}
	
	public void utiliserMainD(PJ p){
		MainDroite vide = new MainDroite();
		if(p.getMainD().type == "Aucun" && p.getInventaire().contains(this)){
			p.setMainD(this);
			p.getInventaire().remove(this);
		}
		else if(p.getMainD().type != "Aucun" && p.getInventaire().contains(this)){
			p.getInventaire().add(p.getEquipement().getMainD());
			p.setMainD(this);
			p.getInventaire().remove(this);
		}
		else if(this.equals(p.getMainD())){
			p.setUnObjet(p.getEquipement().getMainD());
			p.setMainD(vide);
		}
		else{
			System.out.println("Vous ne pouvez pas utiliser cet objet");
		}
	}
	
	public void utiliser(PJ p){
		switch(this.type){
		case "Épée" :
			this.utiliserMainD(p);break;
		case "Arc" :
			this.utiliserMainD(p);break;
		}
		p.calcCapacites();
	}
	
	public void setType(String type){
		this.type = type;
	}
	public void setManiabiliteArme(Niveaux maniabiliteArme){
		this.maniabiliteArme = maniabiliteArme;
	}
	public void setImpactArme(Niveaux impactArme){
		this.impactArme = impactArme;
	}
	public void setPortee(int portee){
		this.portee = portee;
	}
	
	public String getType(){
		return this.type;
	}
	public Niveaux getManiabiliteArme(){
		return this.maniabiliteArme;
	}
	public Niveaux getImpactArme(){
		return this.impactArme;
	}
	public int getPortee(){
		return this.portee;
	}
	
	public String toString(){
		return super.toString() + "\nType : " + this.type + "\nManiabilité : " + this.maniabiliteArme + "\nImpact : " + this.impactArme + "\n Portee : " + this.portee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((impactArme == null) ? 0 : impactArme.hashCode());
		result = prime * result
				+ ((maniabiliteArme == null) ? 0 : maniabiliteArme.hashCode());
		result = prime * result + portee;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof MainDroite))
			return false;
		MainDroite other = (MainDroite) obj;
		if (impactArme == null) {
			if (other.impactArme != null)
				return false;
		} else if (!impactArme.equals(other.impactArme))
			return false;
		if (maniabiliteArme == null) {
			if (other.maniabiliteArme != null)
				return false;
		} else if (!maniabiliteArme.equals(other.maniabiliteArme))
			return false;
		if (portee != other.portee)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
}

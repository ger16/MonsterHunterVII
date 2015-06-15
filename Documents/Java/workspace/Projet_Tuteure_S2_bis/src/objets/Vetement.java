package objets;

import personnage.Niveaux;
import personnage.PJ;

public class Vetement extends Objets{
	public static final int CASQUE = 0;
	public static final int TORSE = 1;
	public static final int GANTS = 2;
	public static final int JAMBIERES = 3;
	public static final int BOTTES = 4;
	
	private String type;
	private Niveaux encombrement;
	private Niveaux armure;
	
	public Vetement(){
		super();
		this.type = "Aucun";
		this.encombrement = new Niveaux();
		this.armure = new Niveaux();
	}
	
	public Vetement(String nom, String type, Niveaux encombrement, Niveaux armure){
		super(nom);
		this.type = type;
		this.encombrement = encombrement;
		this.armure = armure;
	}
	
	
	public void utiliserUnV(PJ p, int position){
		Vetement vide = new Vetement();
		if(p.getUnV(position).getType() == "Aucun" && p.getInventaire().contains(this)){
			p.setUnV(this, position);
			p.getInventaire().remove(this);
		}
		else if(p.getUnV(position).type != "Aucun" && p.getInventaire().contains(this)){
			p.getInventaire().add(p.getEquipement().getUnV(position));
			p.setUnV(this,position);
			p.getInventaire().remove(this);
		}
		else if(this.equals(p.getEquipement().getUnV(position))){
			p.setUnObjet(p.getEquipement().getUnV(position));
			p.setUnV(vide, position);
		}
		else{
			System.out.println("Vous ne pouvez pas utiliser cet objet");
		}
	}
	public void utiliser(PJ p){
		switch(this.type){
		case "Casque" :
			this.utiliserUnV(p, CASQUE);break;
		case "Torse" :
			this.utiliserUnV(p, TORSE);break;
		case "Gants" :
			this.utiliserUnV(p, GANTS);break;
		case "Jambières" :
			this.utiliserUnV(p, JAMBIERES);break;
		case "Bottes" :
			this.utiliserUnV(p, BOTTES);break;
		}
		p.calcCapacites();
	}
	
	public void setType(String type){
		this.type = type;
	}
	public void setEncombrement(Niveaux encombrement){
		this.encombrement = encombrement;
	}
	public void setArmure(Niveaux armure){
		this.armure = armure;
	}
	
	public String getType(){
		return this.type;
	}
	public Niveaux getEncombrement(){
		return this.encombrement;
	}
	public Niveaux getArmure(){
		return this.armure;
	}
	
	public String toString(){
		return super.toString() + "\nType : " + this.type + "\nEncombrement : " + this.encombrement + "\nArmure : " + this.armure;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((armure == null) ? 0 : armure.hashCode());
		result = prime * result
				+ ((encombrement == null) ? 0 : encombrement.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Vetement))
			return false;
		Vetement other = (Vetement) obj;
		if (armure == null) {
			if (other.armure != null)
				return false;
		} else if (!armure.equals(other.armure))
			return false;
		if (encombrement == null) {
			if (other.encombrement != null)
				return false;
		} else if (!encombrement.equals(other.encombrement))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
}

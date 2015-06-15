package objets;

import personnage.PJ;

public class MainGauche extends Objets{
	private String type;
	
	public MainGauche(){
		super();
		this.type = "Aucun";
	}
	
	public MainGauche(String nom, String type){
		super(nom);
		this.type = type;
	}
	public void utiliser(PJ p) {
		MainGauche vide = new MainGauche();
		if(p.getMainG().type == "Aucun" && p.getInventaire().contains(this)){
			p.setMainG(this);
			p.getInventaire().remove(this);
		}
		else if(p.getMainG().type != "Aucun" && p.getInventaire().contains(this)){
			p.getInventaire().add(p.getEquipement().getMainG());
			p.setMainG(this);
			p.getInventaire().remove(this);
		}
		else if(this.equals(p.getMainG())){
			p.setUnObjet(p.getEquipement().getMainD());
			p.setMainG(vide);
		}
		else{
			System.out.println("Vous ne pouvez pas utiliser cet objet");
		}
	}
	
	public String getType(){
		return this.type;
	}
	
	public void setType(String type){
		this.type = type;
	}
	public String toString(){
		return super.toString() + "\nType : " + this.type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof MainGauche))
			return false;
		MainGauche other = (MainGauche) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
}

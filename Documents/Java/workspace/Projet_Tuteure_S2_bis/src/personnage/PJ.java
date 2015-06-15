package personnage;

import java.util.ArrayList;
import java.util.List;

import objets.MainDroite;
import objets.Equipement;
import objets.MainGauche;
import objets.Objets;
import objets.Vetement;

public class PJ extends Personnage {

	private int force ;
	private int adresse;
	private int resistance;
	private List<Objets> inventaire;
	private Equipement equipement;
	private int PA;
	
	public PJ() {
		super();
		this.force = 0;
		this.adresse = 0;
		this.resistance = 0;
		this.inventaire = new ArrayList<Objets>();
		this.equipement = new Equipement();
		this.PA = 6;
	}
	
	public PJ(String nom,double PV, double PX, int force, int adresse, int resistance, Niveaux initiative, Niveaux attaque, Niveaux esquive, Niveaux defense, Niveaux degats, List<Objets> inventaire, Equipement equipement){
		super(nom, PV, PX,initiative, attaque, esquive, defense, degats);
		this.force = force;
		this.adresse = adresse;
		this.resistance = resistance;
		this.inventaire = inventaire;
		this.equipement = equipement;
		this.PA = 6;
	}
	
	public Niveaux calcEncombrementTotal(){
		Niveaux encombrementTotal = new Niveaux();
		int x, y;
		for(int i=0; i<this.equipement.getV().length; i++){
			x = encombrementTotal.getNbD();
			y = encombrementTotal.getUA();
			encombrementTotal.setNbD(x + this.equipement.getUnV(i).getEncombrement().getNbD());
			encombrementTotal.setUA(y + this.equipement.getUnV(i).getEncombrement().getUA());
		}
		return encombrementTotal;
	}
	
	public Niveaux calcArmureTotal(){
		Niveaux armureTotal = new Niveaux();
		int x, y;
		for(int i=0; i<this.equipement.getV().length; i++){
			x = armureTotal.getNbD();
			y = armureTotal.getUA();
			armureTotal.setNbD(x + this.equipement.getUnV(i).getArmure().getNbD());
			armureTotal.setUA(y + this.equipement.getUnV(i).getArmure().getUA());
		}
		return armureTotal;
	}
	
	public void calcCapacites(){
		Niveaux forceN = new Niveaux(this.force);
		Niveaux adresseN = new Niveaux(this.adresse);
		Niveaux resistanceN = new Niveaux(this.resistance);
		this.initiative.setNbD(adresseN.getNbD() - this.calcEncombrementTotal().getNbD());
		this.initiative.setUA(adresseN.getUA() - this.calcEncombrementTotal().getUA());
		this.attaque.setNbD(adresseN.getNbD() + this.equipement.getMainD().getManiabiliteArme().getNbD());
		this.attaque.setUA(adresseN.getUA() + this.equipement.getMainD().getManiabiliteArme().getUA());
		this.esquive.setNbD(adresseN.getNbD() - this.calcEncombrementTotal().getNbD());
		this.esquive.setUA(adresseN.getUA() - this.calcEncombrementTotal().getUA());
		this.defense.setNbD(resistanceN.getNbD() + this.calcArmureTotal().getNbD());
		this.defense.setUA(resistanceN.getUA() + this.calcArmureTotal().getUA());
		this.degats.setNbD(forceN.getNbD() + this.equipement.getMainD().getImpactArme().getNbD());
		this.degats.setUA(forceN.getUA() + this.equipement.getMainD().getImpactArme().getUA());
	}
	
	public void attaquer(Personnage adversaire){
		this.PA -= 3;
		if(adversaire.esquive.score() < this.attaque.score()){
			if(adversaire.defense.score() < this.degats.score()){
				this.PX += 1;
				int diff = this.degats.score() - this.defense.score();
				adversaire.PV -= 100/6*diff;
			}
		}
		if(adversaire.PV == 0){
			double ratio = adversaire.PX/this.PX;
			this.PX += 5 * ratio;
		}
	}
	
	public String niveauBlessure(){
		String s;
		switch((int)this.PV){
		case 0 :
			s = "Votre personnage est mort";break;
		case 16 :
			s = "Votre personnage est inconscient";break;
		case 33 :
			s = "Votre personnage est gravement blessé";break;
		case 50 :
			s = "Votre personnage est blessé";break;
		case 66 :
			s = "Votre personnage est légèrement blessé";break;
		case 83 :
			s = "Votre personnage a quelques blessures superficielles";break;
		default :
			s = "Erreur sur le nombre de points de vie";
		}
		return s;
	}
	
	public void experience(){
	}
	
	public void afficheInventaire(){
		System.out.println("\nInventaire\n");
		for(int i=0; i<this.inventaire.size(); i++){
			System.out.println("\n" + this.inventaire.get(i).toString() + "\n");
		}
	}
	
	public void deplacement(int x, int y){
		this.PA -= 2;
	}
	
	public void setForce(int force){
		this.force = force;
	}
	public void setAdresse(int adresse){
		this.adresse = adresse;
	}
	public void setResistance(int resistance){
		this.resistance = resistance;
	}
	public void setUnObjet(Objets o){
		this.inventaire.add(o);
	}
	public void enleverUnObjet(Objets o){
		this.inventaire.remove(o);
	}
	public void setUnV(Vetement v, int position){
		this.equipement.setUnV(v ,position);
	}
	
	public void setMainD(MainDroite m){
		this.equipement.setMainD(m);
	}
	public void setMainG(MainGauche m){
		this.equipement.setMainG(m);
	}
	public void setEquipement(Equipement e){
		this.equipement = e;
	}
	public void setPA(int pa){
		this.PA = pa;
	}
	
	public int getForce(){
		return this.force;
	}
	public int getAdresse(){
		return this.adresse;
	}
	public int getResistance(){
		return this.resistance;
	}
	public boolean contientUnObjet(Objets o){
		return this.inventaire.contains(o);
	}
	public List<Objets> getInventaire(){
		return this.inventaire;
	}
	public Vetement getUnV(int position){
		return this.equipement.getUnV(position);
	}
	
	public MainDroite getMainD(){
		return this.equipement.getMainD();
	}
	
	public MainGauche getMainG(){
		return this.equipement.getMainG();
	}
	
	public Equipement getEquipement(){
		return this.equipement;
	}
	public int getPA(){
		return this.PA;
	}

	public String toString(){
		return super.toString() + "\n\nForce : " + this.force + "\n\nAdresse : " + this.adresse + "\n\nResistance : " + this.resistance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + adresse;
		result = prime * result
				+ ((equipement == null) ? 0 : equipement.hashCode());
		result = prime * result + force;
		result = prime * result
				+ ((inventaire == null) ? 0 : inventaire.hashCode());
		result = prime * result + resistance;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof PJ))
			return false;
		PJ other = (PJ) obj;
		if (adresse != other.adresse)
			return false;
		if (equipement == null) {
			if (other.equipement != null)
				return false;
		} else if (!equipement.equals(other.equipement))
			return false;
		if (force != other.force)
			return false;
		if (inventaire == null) {
			if (other.inventaire != null)
				return false;
		} else if (!inventaire.equals(other.inventaire))
			return false;
		if (resistance != other.resistance)
			return false;
		return true;
	}
}

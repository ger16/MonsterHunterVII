package objets;

import java.util.Arrays;

public class Equipement {
	private Vetement[] v;
	private MainDroite mainD;
	private MainGauche mainG;
	
	public Equipement(){
		this.v = new Vetement[5];
		for(int i=0; i<v.length; i++){
			v[i] = new Vetement();
		}
		this.mainD = new MainDroite();
		this.mainG = new MainGauche();
	}
	
	public Equipement(Vetement[] v, MainDroite mainD, MainGauche mainG){
		this.v = v;
		this.mainD = mainD;
		this.mainG = mainG;
	}
			
	public void setUnV(Vetement v, int position){
		this.v[position] = v;
	}
	public void setV(Vetement[] v){
		this.v = v;
	}
	public void setMainD(MainDroite mainD){
		this.mainD = mainD;
	}
	public void setMainG(MainGauche mainG){
		this.mainG = mainG;
	}
	
	public Vetement getUnV(int position){
		return this.v[position];
	}
	public Vetement[] getV(){
		return this.v;
	}
	public MainDroite getMainD(){
		return this.mainD;
	}
	public MainGauche getMainG(){
		return this.mainG;
	}
	
	public void afficheEquipement(){
		System.out.println("\nVetements :");
		for (int i=0; i<this.v.length; i++){
			System.out.println("\n" + this.v[i].toString() + "\n");
		}
		System.out.println("\nArmes : \n" +mainD.toString() + "\n" + mainG.toString());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mainD == null) ? 0 : mainD.hashCode());
		result = prime * result + ((mainG == null) ? 0 : mainG.hashCode());
		result = prime * result + Arrays.hashCode(v);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Equipement))
			return false;
		Equipement other = (Equipement) obj;
		if (mainD == null) {
			if (other.mainD != null)
				return false;
		} else if (!mainD.equals(other.mainD))
			return false;
		if (mainG == null) {
			if (other.mainG != null)
				return false;
		} else if (!mainG.equals(other.mainG))
			return false;
		if (!Arrays.equals(v, other.v))
			return false;
		return true;
	}
}

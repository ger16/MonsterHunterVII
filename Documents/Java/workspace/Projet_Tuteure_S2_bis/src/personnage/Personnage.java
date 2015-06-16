package personnage;

import org.newdawn.slick.Animation;

import uigame.Map;


public abstract class Personnage {

	protected float x,y;
	protected int xCoord,yCoord;
	protected int direction;
	protected boolean moving;
	protected Animation[] animations;
	
	protected String nom;
	protected double PV;
	protected double PX;
	
	
	protected Niveaux initiative;
	protected Niveaux attaque;
	protected Niveaux esquive;
	protected Niveaux defense;
	protected Niveaux degats;
	
	protected Map map;
	
	public Personnage(Map map){
		this.x = 0f;
		this.y = 0f;
		this.xCoord= 0;
		this.yCoord = 0;
		this.direction = 0;
		this.moving = false;
		this.animations = new Animation[8];
		this.nom = "Innomé";
		this.PV = 100;
		this.PX = 0;
		this.initiative = new Niveaux();
		this.attaque = new Niveaux();
		this.esquive = new Niveaux();
		this.defense = new Niveaux();
		this.degats = new Niveaux();
		this.map = map;
	}
	
	public Personnage(float x, float y, int direction, boolean moving, String nom, double PV, double PX, Niveaux initiative, Niveaux attaque, Niveaux esquive, Niveaux defense, Niveaux degats, Map map){
		this.x = x;
		this.y = y;
		this.xCoord = 0;
		this.yCoord = 0;
		this.direction = direction;
		this.moving = moving;
		this.animations = animations;
		this.nom = nom;
		this.PV = PV;
		this.PX = PX;
		this.initiative = initiative;
		this.esquive = esquive;
		this.attaque = esquive;
		this.defense = defense;
		this.degats = degats;
		this.map = map;
	}
	
	//public abstract void attaquer(Personnage adversaire);
	//public abstract void deplacement(int x, int y);
	
	public Personnage(int x2, int y2, int direction2, boolean moving2, String nom2, Map map2) {
		this.x = x2;
		this.y = y2;
		this.direction = direction2;
		this.moving = moving2;
		this.nom = nom2;
		this.map = map2;
		this.xCoord = 0;
		this.yCoord = 0;
	}
	
	public boolean isDead(){
		if (this.PV <= 0){
			return true;
		}
		return false;
	}
	
	public void updateCoord(){
		this.xCoord = (int)this.x / map.getTiledMap().getWidth();
		this.yCoord = (int)this.y /map.getTiledMap().getHeight();
	}

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
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public Animation[] getAnimations() {
		return animations;
	}

	public void setAnimations(Animation[] animations) {
		this.animations = animations;
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

	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}
}

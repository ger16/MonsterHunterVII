package uigame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import personnage.PJ;
import personnage.Personnage;

public class Camera {
	
	 private PJ player = new PJ();
	 private float xCamera = 0; 
	 private float yCamera = 0;
	 
	 public Camera(PJ player){
		 this.player = player;
		 this.xCamera = player.getX();
		 this.yCamera = player.getY();
	 }
	 
	 public void affichage(GameContainer gc, Graphics g) {
		g.translate(gc.getWidth() / 2 - (int) this.xCamera, gc.getHeight() / 2- (int) this.yCamera);
		}
	 
	public void update(GameContainer container) {
		int w = container.getWidth() / 20;
		if (this.player.getX() > this.xCamera ) {
			this.xCamera = this.player.getX() - w;
		} else if (this.player.getX() < this.xCamera) {
			this.xCamera = this.player.getX() + w;
		}
		int h = container.getHeight() / 20;
		if (this.player.getY() > this.yCamera) {
			this.yCamera = this.player.getY() - h;
		} else if (this.player.getY() < this.yCamera) {
			this.yCamera = this.player.getY() + h;
		}
	}
	 
	public float getxCamera() {
		return xCamera;
	}

	public void setxCamera(float xCamera) {
		this.xCamera = xCamera;
	}

	public float getyCamera() {
		return yCamera;
	}

	public void setyCamera(float yCamera) {
		this.yCamera = yCamera;
	}
}

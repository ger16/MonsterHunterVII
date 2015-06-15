package uigame;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Map {
	private TiledMap tiledMap;
	
	public void init() throws SlickException {
		this.tiledMap = new TiledMap("ressources/map/map.tmx");
	}
	
	public void renderBackground() {
		tiledMap.render(0, 0, 0);
	}
	
	public void renderForeground() {
		tiledMap.render(0,0,1);
		tiledMap.render(0,0,2);
	}
	
	public boolean isCollision(float x, float y) {
		int tileW = this.tiledMap.getTileWidth();
		int tileH = this.tiledMap.getTileHeight();
		
		int Collisions = this.tiledMap.getLayerIndex("Collisions");
		Image tile = this.tiledMap.getTileImage((int) x/tileW, (int)y/tileH, Collisions);
		boolean collision = tile != null;
		
		if(collision) {
			Color color = tile.getColor((int)x, (int)y);
			collision = color.getAlpha() > 0;
		}
		
		return collision;
	}
	
	// Triggers 
	
	public int getObjectCount() {
	    return this.tiledMap.getObjectCount(0);
	}
	public String getObjectType(int objectID) {
	    return this.tiledMap.getObjectType(0, objectID);
	}
	public float getObjectX(int objectID) {
	    return this.tiledMap.getObjectX(0, objectID);
	}
	public float getObjectY(int objectID) {
	    return this.tiledMap.getObjectY(0, objectID);
	}
	public float getObjectWidth(int objectID) {
	    return this.tiledMap.getObjectWidth(0, objectID);
	}
	public float getObjectHeight(int objectID) {
	    return this.tiledMap.getObjectHeight(0, objectID);
	}
	public String getObjectProperty(int objectID, String propertyName, String def) {
	    return this.tiledMap.getObjectProperty(0, objectID, propertyName, def);
	}
	
	
}

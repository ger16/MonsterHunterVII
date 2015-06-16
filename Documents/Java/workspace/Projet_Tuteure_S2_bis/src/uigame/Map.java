package uigame;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Map {
	int val = 0;
	private TiledMap tiledMap;
	
	public Map(){
		
	}
	
	public void init() throws SlickException {
		this.tiledMap = new TiledMap("ressources/map/exemple-collision.tmx");
	}
	
	public void renderBackground() {
		tiledMap.render(val,val,0);
		tiledMap.render(val,val,1);
		tiledMap.render(val,val,2);
	}
	
	
	public void renderForeground() {
		tiledMap.render(val,val,3);
		tiledMap.render(val,val,4);
		//tiledMap.render(val,val,5);
	}
	
	public boolean isCollision(float x, float y) {
		
		int tileW = this.tiledMap.getTileWidth();
		int tileH = this.tiledMap.getTileHeight();
		int collisionID = this.tiledMap.getLayerIndex("logic");
		int collisionInt = this.tiledMap.getTileId(0, 0, collisionID);
		int actualInt = this.tiledMap.getTileId((int) x / tileW, (int) y / tileH, collisionID);
		System.out.println("coordTile X : " + (int)x/tileW + " coordTile Y : " +(int)y/tileH );
		boolean collision = false;
		if (actualInt != 0){
			return true;
		}
		/*for (int i = actualInt; i < actualInt+16; i++){
			if (i == actualInt){
				return true;
			}
		}*/
		/*Image tile = this.tiledMap.getTileImage((int) x / tileW, (int) y / tileH, collisionsInt);
		boolean collision = tile != null;
		
		if(collision) {
			Color color = tile.getColor((int)x, (int)y);
			collision = color.getAlpha() > 0.5;
			collision = this.tiledMap.getTileId((int) x / tileW, (int) y / tileH, collisionsInt) == collisionsInt;
		}*/
		System.out.println(collisionInt);
		System.out.println(actualInt);
		System.out.println(collision);
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

	public TiledMap getTiledMap() {
		return tiledMap;
	}

	public void setTiledMap(TiledMap tiledMap) {
		this.tiledMap = tiledMap;
	}
	
	
}

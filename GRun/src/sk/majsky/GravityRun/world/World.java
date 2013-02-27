package sk.majsky.GravityRun.world;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;

public class World {
	public TiledMap map;
	public List<Rectangle> blocks;
	public int width = 0, height = 0;
	
	public World(String map){
		try{
			this.map = new TiledMap(map, "/res");
		}catch(SlickException e){e.printStackTrace();return;}
		width = this.map.getWidth();
		height = this.map.getHeight();
		blocks = new ArrayList<Rectangle>();
		for(int i=0;i < this.map.getWidth();i++){
			for(int j=0;j<this.map.getHeight();j++){
				if(this.map.getTileProperty(this.map.getTileId(i, j, 0), "collide", "false").equalsIgnoreCase("true")){
					blocks.add(new Rectangle(i*this.map.getTileWidth(), j*this.map.getTileHeight(), this.map.getTileWidth(), this.map.getTileHeight()));
				}
			}
		}
	}
	
	public void offsetCollision(int x, int y){
		List<Rectangle> newCollision = new ArrayList<Rectangle>();
		for(Rectangle r:blocks){
			newCollision.add(new Rectangle(r.getX()/map.getTileWidth() + x * map.getTileWidth(), r.getY()/map.getHeight() + x * map.getHeight(), map.getTileWidth(), map.getTileHeight()));
		}
		blocks = newCollision;
	}
}
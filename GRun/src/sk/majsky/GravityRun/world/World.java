package sk.majsky.GravityRun.world;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.tiled.TiledMap;
//TODO remove
public class World {
	public TiledMap map;
	public List<Polygon> blocks;
	public int width = 0, height = 0;
	
	public World(String map){
		try{
			this.map = new TiledMap(map, "/res");
		}catch(SlickException e){e.printStackTrace();return;}
		width = this.map.getWidth();
		height = this.map.getHeight();
		blocks = new ArrayList<Polygon>();
		for(int i=0;i < this.map.getWidth();i++){
			for(int j=0;j<this.map.getHeight();j++){
				if(this.map.getTileProperty(this.map.getTileId(i, j, 0), "collide", "false").equalsIgnoreCase("true")){
					blocks.add(new Polygon(new float[] {i*this.map.getTileWidth(), j*this.map.getTileHeight(), i*this.map.getTileWidth() + this.map.getTileWidth(), j*this.map.getTileHeight(), i*this.map.getTileWidth(), j*this.map.getTileHeight()+this.map.getTileHeight()}));
				}
			}
		}
	}
}

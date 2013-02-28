package sk.majsky.GravityRun.entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Polygon;

import sk.majsky.GravityRun.states.GameStateSingle;
import sk.majsky.GravityRun.world.World;

public class EntityPlayerSP extends Entity{
	private Animation skin;
	
	public EntityPlayerSP(float x, float y, float width, float height) {
		super(x, y, width, height);
		try {
			SpriteSheet sheet = new SpriteSheet(new Image("/res/player.png"), 64,32);
			skin = new Animation();
			skin.addFrame(sheet.getSubImage(0, 0, 32, 32).getScaledCopy(2F), 100);
			skin.addFrame(sheet.getSubImage(32, 0, 32, 32).getScaledCopy(2F), 100);
			skin.setLooping(true);
			skin.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
		this.setBounds(x, y, skin.getWidth(), skin.getHeight());
	}
	
	public void update(int delta, World w, GameContainer containers){
		Input i = containers.getInput();
		if(i.isKeyDown(Input.KEY_SPACE)){
			for(Polygon r:w.blocks){
				if(leg.intersects(r)){
					switchto = -switchto;
					break;
				}
			}
		}
		super.update(delta, w);
		if(speed == 0)
			skin.stop();
		else
			skin.start();
		GameStateSingle._instace.campos = (int)Math.floor(poly.getX()) - 50;
	}
	
	public void render(Graphics g){
		skin.draw(50, poly.getY());
		g.setColor(Color.green);
		g.drawRect(50, leg.getY(), leg.getWidth(), leg.getHeight());
		g.drawRect(50 + poly.getWidth(), front.getY(), front.getWidth(), front.getHeight());
	}

}

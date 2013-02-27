package sk.majsky.GravityRun.entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import sk.majsky.GravityRun.states.GameStateSingle;
import sk.majsky.GravityRun.world.World;

public class EntityPlayerSP extends Entity{
	private static final long serialVersionUID = 1L;

	private Animation skin;
	
	public EntityPlayerSP(float x, float y, float width, float height) {
		super(x, y, width, height);
		try {
			SpriteSheet sheet = new SpriteSheet(new Image("/res/player.png"), 64,32);
			skin = new Animation();
			skin.addFrame(sheet.getSubImage(0, 0, 32, 32).getScaledCopy(2F), 25);
			skin.addFrame(sheet.getSubImage(32, 0, 32, 32).getScaledCopy(2F), 25);
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
			switchto = -switchto;
		}
		super.update(delta, w);
		GameStateSingle._instace.campos = (int)Math.floor(x) - 50;
	}
	
	public void render(Graphics g){
		//super.render(g);
		g.setColor(Color.cyan);
		//g.fillRect(50, y, width, height);
		skin.draw(50, y);
		g.setColor(Color.green);
		g.drawRect(50, leg.getY(), leg.getWidth(), leg.getHeight());
		g.drawRect(50 + this.getWidth(), front.getY(), front.getWidth(), front.getHeight());
	}

}

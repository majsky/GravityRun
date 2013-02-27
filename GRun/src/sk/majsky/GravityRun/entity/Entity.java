package sk.majsky.GravityRun.entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import sk.majsky.GravityRun.world.World;

public class Entity extends Rectangle {
	private static final long serialVersionUID = 1L;

	public final float FALL_SPEED = 0.1f;
	public final float RUN_SPEED = 0.15f;
	
	private float gravity = 0, speed = 0;
	private Rectangle leg, front;
	
	public Entity(float x, float y, float width, float height) {
		super(x, y, width, height);
		leg = new Rectangle(x +1 , y + height + 1, width - 1, 1);
		front = new Rectangle(x + width + 1, y+1, 1, height-1);	
	}
	
	public void update(int delta, World w){
		gravity = FALL_SPEED;
		speed = RUN_SPEED;
		leg.setX(x + 1);
		leg.setY(y+height+1);
		front.setX(x + width + 1);
		front.setY(y+1);
		for(Rectangle r:w.blocks){
			if(leg.intersects(r)){
				gravity = 0;
			}
			if(front.intersects(r))
				speed = 0;
		}
		setY(y + gravity * delta);
		setX(x + speed * delta);
	}
	
	public void render(Graphics g){
		g.setColor(Color.cyan);
		g.draw(this);
		g.setColor(Color.green);
		g.draw(leg);
		g.draw(front);
		
	}

}

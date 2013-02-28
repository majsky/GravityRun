package sk.majsky.GravityRun.entity;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Polygon;

import sk.majsky.GravityRun.world.World;

public class Entity{
	public final float FALL_SPEED = 0.25f;
	public final float RUN_SPEED = 0.2f;
	
	public Polygon poly, leg, front;
	
	protected float switchto = 0f;
	
	protected float gravity = 0, speed = 0;
	
	public Entity(float x, float y, float width, float height) {
		front = new Polygon(new float[] {x+width, y+5, x+width, y+height-5});
		poly = new Polygon(new float[] {x, y, x+width, y, x+width, y+height, x, y+height});
		leg = new Polygon(new float[] {x+5, y, x+width-5, y});
		
		switchto = FALL_SPEED;
	}
	
	public void setBounds(float x, float y, float width, float height){
		leg = new Polygon(new float[]{x+5, y, x+width-5, y});
		front = new Polygon(new float[] {x+width, y+5, x+width, y+height-5});
		poly = new Polygon(new float[] {x, y, x+width, y, x+width, y+height, x, y+height});
	}
	
	public void update(int delta, World w){
		gravity = switchto;
		speed = RUN_SPEED;
		leg.setX(poly.getX() + 1 +5);
		leg.setY(switchto>0?poly.getY()+poly.getHeight()+1:poly.getY()-1);
		front.setX(poly.getX() + poly.getWidth() + 1);
		front.setY(poly.getY()+5);
		for(Polygon r:w.blocks){
			if(leg.intersects(r))
				gravity = 0;		
			if(front.intersects(r))
				speed = 0;
		}
		poly.setY(poly.getY() + gravity *delta);
		poly.setX(poly.getX() + speed *delta);
	}
	
	public void render(Graphics g){
		g.draw(leg);
		g.draw(front);
		
	}
}

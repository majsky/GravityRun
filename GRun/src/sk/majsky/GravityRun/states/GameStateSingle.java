package sk.majsky.GravityRun.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import sk.majsky.GravityRun.entity.Entity;
import sk.majsky.GravityRun.world.World;

public class GameStateSingle extends BasicGameState{

	private int id;
	public World world;
	private Entity test;
	
	public GameStateSingle(int id){
		this.id = id;
		test = new Entity(10, 10, 50, 75);
	}
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		world = new World("/res/testmap.tmx");
		world.offsetCollision(-5, -5);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		
		
		world.map.render(0, 0, 5, 5, world.map.getWidth(), world.map.getHeight());
		test.render(g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		test.update(delta, world);
	}

	@Override
	public int getID() {
		return id;
	}

}

package sk.majsky.GravityRun.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import sk.majsky.GravityRun.GravityRun;
import sk.majsky.GravityRun.entity.Entity;
import sk.majsky.GravityRun.entity.EntityPlayerSP;
import sk.majsky.GravityRun.world.World;

public class GameStateSingle extends BasicGameState{

	private int id;
	public World world;
	private EntityPlayerSP test;
	public static GameStateSingle _instace;
	
	public int campos = 0;
	
	public GameStateSingle(int id){
		_instace = this;
		this.id = id;
		test = new EntityPlayerSP(10, 10, 50, 75);
	}
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		world = new World("/res/testmap.tmx");
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		
		
		world.map.render(0, 0, campos/world.map.getTileWidth(), 0, world.map.getWidth(), world.map.getHeight());
		test.render(g);
		g.setColor(Color.orange);
		for(Rectangle r:world.blocks){
			g.drawRect((float)(r.getX() - Math.floor(campos)), r.getY(), r.getWidth(), r.getHeight());
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		test.update(delta, world, container);
		if(test.getMinY() - 50 > 600 || test.getMaxY() + 50 < 0){
			game.enterState(GravityRun.GAME_STATE_GAME_OVER);
		}
	}

	@Override
	public int getID() {
		return id;
	}

}

package sk.majsky.GravityRun.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import sk.majsky.GravityRun.GravityRun;
import sk.majsky.GravityRun.entity.Entity;
import sk.majsky.GravityRun.entity.EntityPlayerSP;
import sk.majsky.GravityRun.world.World;

public class GameStateSingle extends BasicGameState{

	private int id, delta;
	public World world;
	private EntityPlayerSP player;
	private Entity test;
	public static GameStateSingle _instace;
	
	public int campos = 0;
	
	public GameStateSingle(int id){
		_instace = this;
		this.id = id;
		player = new EntityPlayerSP(10, 10, 50, 75);
		test = new Entity(1, 1, 1, 1);
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
		
		
		world.map.render(0, 0, campos/world.map.getTileWidth()+1, 0, world.map.getWidth(), world.map.getHeight());
		player.render(g);
		g.setColor(Color.orange);
		g.setColor(Color.black);
		g.fillRect(10, 50, 20, 20);
		g.setColor(Color.white);
		g.drawString(delta + "", 10, 50);
		test.render(g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		player.update(delta, world, container);
		test.update(delta, world);
		if(player.poly.getMinY() - 50 > 600 || player.poly.getMaxY() + 50 < 0){
			game.enterState(GravityRun.GAME_STATE_GAME_OVER);
		}
		this.delta = delta;
	}

	@Override
	public int getID() {
		return id;
	}

}

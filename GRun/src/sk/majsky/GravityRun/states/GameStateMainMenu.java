package sk.majsky.GravityRun.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tests.GUITest;

public class GameStateMainMenu extends BasicGameState {

	private int id;
	
	public GameStateMainMenu(int id){
		this.id = id;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		g.drawString("Testing", 15, 50);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException {
		
	}

	@Override
	public int getID() {
		return id;
	}

}

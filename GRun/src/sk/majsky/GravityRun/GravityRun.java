package sk.majsky.GravityRun;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import sk.majsky.GravityRun.states.GameStateSingle;
import sk.majsky.GravityRun.states.GameStateMainMenu;

public class GravityRun extends StateBasedGame{

	public static GravityRun _instance;
	public static final int GAME_STATE_MENU = 1;
	public static final int GAME_STATE_SINGLE = 2;
	
	public static void main(String[] args){
		try {
			_instance = new GravityRun();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public GravityRun() throws SlickException {
		super("GravityRun");
		
		AppGameContainer agc = new AppGameContainer(this);
		agc.setDisplayMode(800, 600, false);
		agc.setVSync(true);
		agc.start();
		
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.addState(new GameStateMainMenu(GAME_STATE_MENU));
		this.addState(new GameStateSingle(GAME_STATE_SINGLE));
		this.enterState(GAME_STATE_SINGLE);
	}

}

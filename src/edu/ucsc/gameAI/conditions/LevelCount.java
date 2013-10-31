package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class LevelCount implements ICondition {

	int level;
	
	public LevelCount(int level) {
		// TODO Auto-generated constructor stub
		this.level = level;
	}

	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		return game.getCurrentLevel() == level;
	}

}
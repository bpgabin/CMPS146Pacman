package edu.ucsc.gameAI.conditions;

import pacman.game.Constants.GHOST;
import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class EdibleTime implements ICondition {

	GHOST ghost;
	int min;
	int max;
	
	public EdibleTime(GHOST ghost, int min, int max) {
		// TODO Auto-generated constructor stub
		this.ghost = ghost;
		this.min = min;
		this.max = max;
	}

	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		int time = game.getGhostEdibleTime(ghost);
		return ((min <= time) && (max >= time));
	}

}

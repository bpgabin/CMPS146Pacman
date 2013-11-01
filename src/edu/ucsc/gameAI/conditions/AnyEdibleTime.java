package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import pacman.game.Constants.GHOST;
import edu.ucsc.gameAI.ICondition;

public class AnyEdibleTime implements ICondition {
	
	int min;
	int max;
	
	public AnyEdibleTime(int min, int max) {
		// TODO Auto-generated constructor stub
		this.min = min;
		this.max = max;
	}

	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		for(GHOST ghost : GHOST.values()){
			int time = game.getGhostEdibleTime(ghost);
			if((min <= time) && (max >= time)){
				return true;
			}
		}
		return false;
	}

}

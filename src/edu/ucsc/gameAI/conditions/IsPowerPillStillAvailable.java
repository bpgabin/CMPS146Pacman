package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class IsPowerPillStillAvailable implements ICondition {

	int pillIndex;
	
	public IsPowerPillStillAvailable(int pillIndex) {
		// TODO Auto-generated constructor stub
		this.pillIndex = pillIndex;
	}

	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		return game.isPowerPillStillAvailable(pillIndex);
	}

}

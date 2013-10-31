package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class IsPillStillAvailable implements ICondition {

	int pillIndex;
	
	public IsPillStillAvailable(int pillIndex){
		this.pillIndex = pillIndex;
	}
	
	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		return game.isPillStillAvailable(pillIndex);
	}

}

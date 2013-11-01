package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import pacman.game.Constants.DM;
import edu.ucsc.gameAI.ICondition;

public class PowerPillDistance implements ICondition {

	int minDistance;
	
	public PowerPillDistance(int minDistance){
		this.minDistance = minDistance;
	}
	
	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		for(int powerPillIndex : game.getActivePowerPillsIndices()){
			if(game.getDistance(game.getPacmanCurrentNodeIndex(), powerPillIndex, DM.PATH) <= minDistance){
				return true;
			}
		}
		return false;
	}

}

package edu.ucsc.gameAI.conditions;

import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class SafePowerPill implements ICondition {

	int safeDistance;
	
	public SafePowerPill(int safeDistance){
		this.safeDistance = safeDistance;
	}
	
	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		for(int powerPillIndex : game.getActivePowerPillsIndices()){
			boolean safe = true;
			for(GHOST ghost : GHOST.values()){
				if(game.getGhostEdibleTime(ghost)==0 && game.getGhostLairTime(ghost)==0){
					if(game.getDistance(game.getGhostCurrentNodeIndex(ghost), powerPillIndex, game.getGhostLastMoveMade(ghost), DM.PATH) < safeDistance){
						safe = false;
						break;
					}
				}
			}
			if(safe){
				return true;
			}
		}
		return false;
	}

}

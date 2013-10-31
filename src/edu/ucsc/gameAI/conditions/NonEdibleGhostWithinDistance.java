package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import pacman.game.Constants.GHOST;
import edu.ucsc.gameAI.ICondition;

public class NonEdibleGhostWithinDistance implements ICondition {

	int distance;
	
	public NonEdibleGhostWithinDistance(int distance){
		this.distance = distance;
	}
	
	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		for(GHOST ghost : GHOST.values()){
			if(game.getGhostEdibleTime(ghost)==0 && game.getGhostLairTime(ghost)==0){
				if(game.getShortestPathDistance(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(ghost)) < distance){
					return true;
				}
			}
		}
		return false;
	}

}

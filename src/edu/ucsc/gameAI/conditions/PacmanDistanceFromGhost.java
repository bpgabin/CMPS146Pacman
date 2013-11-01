package edu.ucsc.gameAI.conditions;

import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class PacmanDistanceFromGhost implements ICondition {

	GHOST ghost;
	double minDistance;
	
	public PacmanDistanceFromGhost(GHOST ghost, double minDistance){
		this.ghost = ghost;
		this.minDistance = minDistance;
	}
	
	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		
		double distance = game.getDistance(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(ghost), DM.PATH);
		return (distance <= minDistance);
	}

}

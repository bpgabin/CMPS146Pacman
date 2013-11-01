package edu.ucsc.gameAI;

import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class ChaseGhostsAction implements IAction, IBinaryNode {

	MOVE move;
	
	@Override
	public IAction makeDecision(Game game) {
		// TODO Auto-generated method stub
		
		double minDistance = Integer.MAX_VALUE;
		GHOST selectedGhost = null;
		for(GHOST ghost : GHOST.values()){
			if(game.isGhostEdible(ghost)){
				double distance = game.getDistance(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(ghost), DM.PATH);
				if(distance < minDistance){
					minDistance = distance;
					selectedGhost = ghost;
				}
			}
		}
		move = game.getNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(selectedGhost), DM.PATH);
		
		return this;
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public MOVE getMove() {
		// TODO Auto-generated method stub
		return move;
	}

}

package edu.ucsc.gameAI;

import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class ClosestPillAction implements IAction, IBinaryNode {

	MOVE move;
	
	GHOST ghost;
	
	public ClosestPillAction(GHOST ghost){
		this.ghost = ghost;
	}
	
	@Override
	public IAction makeDecision(Game game) {
		// TODO Auto-generated method stub
		
		int selectedPill = -1;
		double minDistance = Integer.MAX_VALUE;
		for(int index : game.getActivePillsIndices()){
			double distance = game.getDistance(game.getPacmanCurrentNodeIndex(), index, DM.PATH);
			if(distance < minDistance){
				minDistance = distance;
				selectedPill = index;
			}
		}
		
		if(selectedPill != -1)
			move = game.getApproximateNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(ghost), selectedPill, game.getGhostLastMoveMade(ghost), DM.PATH);
		
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

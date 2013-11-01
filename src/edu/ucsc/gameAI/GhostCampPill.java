package edu.ucsc.gameAI;

import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class GhostCampPill implements IAction, IBinaryNode {

	MOVE move;
	GHOST ghost;
	
	public GhostCampPill(GHOST ghost){
		this.ghost = ghost;
	}
	
	@Override
	public IAction makeDecision(Game game) {
		// TODO Auto-generated method stub
		
		int targetPillIndex = 0;
		int[] pillIndices = game.getPowerPillIndices();
		if(ghost == GHOST.BLINKY){
			targetPillIndex = pillIndices[0];
		}
		else if(ghost == GHOST.INKY){
			targetPillIndex = pillIndices[1];
		}
		else if(ghost == GHOST.PINKY){
			targetPillIndex = pillIndices[2];
		}
		else if(ghost == GHOST.SUE){
			targetPillIndex = pillIndices[3];
		}
		
		move = game.getApproximateNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(ghost), targetPillIndex, game.getGhostLastMoveMade(ghost), DM.PATH);
		
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

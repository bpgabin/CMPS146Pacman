package edu.ucsc.gameAI;

import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class GhostsChaseAction implements IAction, IBinaryNode {

	MOVE move;
	GHOST ghost;
	
	public GhostsChaseAction(GHOST ghost){
		this.ghost = ghost;
	}
	
	@Override
	public IAction makeDecision(Game game) {
		// TODO Auto-generated method stub
		move = game.getApproximateNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(ghost), game.getPacmanCurrentNodeIndex(), game.getGhostLastMoveMade(ghost), DM.PATH);
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

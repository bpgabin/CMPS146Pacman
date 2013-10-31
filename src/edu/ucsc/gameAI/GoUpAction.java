package edu.ucsc.gameAI;

import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;
import pacman.game.Game;
import pacman.game.Constants.MOVE;

public class GoUpAction implements IAction, IBinaryNode {

	@Override
	public void doAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public IAction makeDecision(Game game) {
		return this;
	}

	@Override
	public MOVE getMove() {
		return MOVE.UP;
	}

}

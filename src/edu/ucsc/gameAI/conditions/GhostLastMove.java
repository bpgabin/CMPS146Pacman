package edu.ucsc.gameAI.conditions;

import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class GhostLastMove implements ICondition {

	GHOST ghost;
	MOVE move;
	
	public GhostLastMove(GHOST ghost, MOVE move) {
		// TODO Auto-generated constructor stub
		this.ghost = ghost;
		this.move = move;
	}

	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		return game.getGhostLastMoveMade(ghost) == move;
	}

}

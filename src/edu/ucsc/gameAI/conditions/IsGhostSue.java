package edu.ucsc.gameAI.conditions;

import pacman.game.Constants.GHOST;
import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class IsGhostSue implements ICondition {

	GHOST ghost;
	
	public IsGhostSue(GHOST ghost){
		this.ghost = ghost;
	}
	
	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		return (ghost == GHOST.SUE);
	}

}

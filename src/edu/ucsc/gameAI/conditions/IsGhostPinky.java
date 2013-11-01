package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import pacman.game.Constants.GHOST;
import edu.ucsc.gameAI.ICondition;

public class IsGhostPinky implements ICondition {

	GHOST ghost;
	
	public IsGhostPinky(GHOST ghost){
		this.ghost = ghost;
	}
	
	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		return (ghost == GHOST.PINKY);
	}

}

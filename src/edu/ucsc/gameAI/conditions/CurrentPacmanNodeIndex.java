package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class CurrentPacmanNodeIndex implements ICondition {

	int index;
	
	public CurrentPacmanNodeIndex(int index) {
		// TODO Auto-generated constructor stub
		this.index = index;
	}

	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		return game.getPacmanCurrentNodeIndex() == index;
	}

}

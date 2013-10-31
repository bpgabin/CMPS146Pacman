package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class GhostEatScore implements ICondition {

	int min;
	int max;
	
	public GhostEatScore(int min, int max){
		this.min = min;
		this.max = max;
	}
	
	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		int score = game.getGhostCurrentEdibleScore();
		return ((min <= score) && (max >= score));
	}

}

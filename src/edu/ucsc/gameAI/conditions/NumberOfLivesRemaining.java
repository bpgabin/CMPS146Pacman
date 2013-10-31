package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class NumberOfLivesRemaining implements ICondition {

	int min;
	int max;
	
	public NumberOfLivesRemaining(int min, int max) {
		// TODO Auto-generated constructor stub
		this.min = min;
		this.max = max;
	}

	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		int lives = game.getPacmanNumberOfLivesRemaining();
		return ((min <= lives) && (max >= lives));
	}

}

package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class Score implements ICondition {

	int min;
	int max;
	
	public Score(int min, int max){
		this.min = min;
		this.max = max;
	}
	
	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		int score = game.getScore();
		return ((min <= score) && (max >= score));
	}

}

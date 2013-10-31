package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class TotalTime implements ICondition {

	int min;
	int max;
	
	public TotalTime(int min, int max){
		this.min = min;
		this.max = max;
	}
	
	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		int time = game.getTotalTime();
		return ((min <= time) && (max >= time));
	}

}

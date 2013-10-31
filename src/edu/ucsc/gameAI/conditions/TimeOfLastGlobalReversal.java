package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class TimeOfLastGlobalReversal implements ICondition {

	int min;
	int max;
	
	public TimeOfLastGlobalReversal(int min, int max){
		this.min = min;
		this.max = max;
	}
	
	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		int time = game.getTimeOfLastGlobalReversal();
		return ((min <= time) && (max >= time));
	}

}

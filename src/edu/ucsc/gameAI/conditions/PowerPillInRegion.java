package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class PowerPillInRegion implements ICondition {

	int x1, y1, x2, y2;
	
	public PowerPillInRegion(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated constructor stub
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		int[] activePills = game.getActivePowerPillsIndices();
		for(int i = 0; i < activePills.length; i++){
			int x = game.getNodeXCood(activePills[i]);
			int y = game.getNodeYCood(activePills[i]);
			if(((x1 <= x) && (x2 >= x)) && ((y1 <= y) && (y2 >= y))){
				return true;
			}
		}
		return false;
	}

}

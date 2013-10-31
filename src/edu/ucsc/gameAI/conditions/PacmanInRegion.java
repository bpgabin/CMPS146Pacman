package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class PacmanInRegion implements ICondition {

	int x1,y1,x2,y2;
	
	public PacmanInRegion(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated constructor stub
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		int index = game.getPacmanCurrentNodeIndex();
		int x = game.getNodeXCood(index);
		int y = game.getNodeYCood(index);
		if(((x1 <= x) && (x2 >= x)) && ((y1 <= y) && (y2 >= y)))
			return true;
		else
			return false;
	}

}

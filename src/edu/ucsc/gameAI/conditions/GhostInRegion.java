package edu.ucsc.gameAI.conditions;

import pacman.game.Constants.GHOST;
import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class GhostInRegion implements ICondition {

	int x1, y1, x2, y2;
	
	public GhostInRegion(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated constructor stub
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		GHOST[] ghosts;
		ghosts = new GHOST[4];
		ghosts[0] = GHOST.BLINKY;
		ghosts[1] = GHOST.INKY;
		ghosts[2] = GHOST.PINKY;
		ghosts[3] = GHOST.SUE;
		for(int i = 0; i < ghosts.length; i++){
			int index = game.getGhostCurrentNodeIndex(ghosts[i]);
			int x = game.getNodeXCood(index);
			int y = game.getNodeYCood(index);
			if(((x1 <= x) && (x2 >= x)) && ((y1 <= y) && (y2 >= y))){
				return true;
			}
		}
		return false;
	}

}

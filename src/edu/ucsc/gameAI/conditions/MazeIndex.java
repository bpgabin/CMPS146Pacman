package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class MazeIndex implements ICondition {

	int index;
	
	public MazeIndex(int index) {
		// TODO Auto-generated constructor stub
		this.index = index;
	}

	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		return game.getMazeIndex() == index;
	}

}

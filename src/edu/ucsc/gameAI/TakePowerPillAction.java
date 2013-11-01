package edu.ucsc.gameAI;

import pacman.game.Constants.DM;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class TakePowerPillAction implements IAction, IBinaryNode {

	MOVE move;
	
	@Override
	public IAction makeDecision(Game game) {
		// TODO Auto-generated method stub
		
		double minDistance = Integer.MAX_VALUE;
		int selectedPowerPillIndex = -1;
		for(int powerPillIndex : game.getActivePowerPillsIndices()){
			double distance = game.getDistance(game.getPacmanCurrentNodeIndex(), powerPillIndex, DM.PATH);
			if(distance < minDistance){
				minDistance = distance;
				selectedPowerPillIndex = powerPillIndex;
			}
		}
		if(selectedPowerPillIndex != -1){
			move = game.getNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(), selectedPowerPillIndex, DM.PATH);
		}
		
		return this;
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public MOVE getMove() {
		// TODO Auto-generated method stub
		return move;
	}

}

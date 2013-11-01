package edu.ucsc.gameAI;

import pacman.game.Constants.DM;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class SafePowerPillAction implements IAction, IBinaryNode {

	MOVE move;
	//int safeDistance;
	int awayDistance;
	
	public SafePowerPillAction(int awayDistance){
		//this.safeDistance = safeDistance;
		this.awayDistance = awayDistance;
	}
	
	@Override
	public IAction makeDecision(Game game) {
		// TODO Auto-generated method stub
		
		double minDistance = Integer.MAX_VALUE;
		int selectedPowerPillIndex = -1;
		for(int powerPillIndex : game.getActivePowerPillsIndices()){
			/*
			boolean safe = true;
			for(GHOST ghost : GHOST.values()){
				if(game.getGhostEdibleTime(ghost)==0 && game.getGhostLairTime(ghost)==0){
					if(game.getDistance(game.getGhostCurrentNodeIndex(ghost), powerPillIndex, game.getGhostLastMoveMade(ghost), DM.PATH) < safeDistance){
						safe = false;
						break;
					}
				}
			}
			*/
			//if(safe){
			double distance = game.getDistance(game.getPacmanCurrentNodeIndex(), powerPillIndex, DM.PATH);
			if(distance < minDistance){
				minDistance = distance;
				selectedPowerPillIndex = powerPillIndex;
			}
		}
		if(selectedPowerPillIndex != -1){
			if(game.getDistance(game.getPacmanCurrentNodeIndex(), selectedPowerPillIndex, DM.PATH) > 10)
				move = game.getNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(), selectedPowerPillIndex, DM.PATH);
			else
				move = game.getNextMoveAwayFromTarget(game.getPacmanCurrentNodeIndex(), selectedPowerPillIndex, DM.PATH);
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

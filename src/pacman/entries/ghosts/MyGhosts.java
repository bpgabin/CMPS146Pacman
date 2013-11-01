package pacman.entries.ghosts;

import java.util.EnumMap;

import edu.ucsc.gameAI.*;
import pacman.game.Constants.*;
import edu.ucsc.gameAI.conditions.*;
import edu.ucsc.gameAI.decisionTrees.binary.*;
import pacman.controllers.Controller;

import pacman.game.Game;

public class MyGhosts extends Controller<EnumMap<GHOST,MOVE>>
{
	private EnumMap<GHOST, MOVE> myMoves = new EnumMap<GHOST, MOVE>(GHOST.class);
	
	public EnumMap<GHOST, MOVE> getMove(Game game, long timeDue){
		myMoves.clear();
		
		for(GHOST ghost : GHOST.values()){
			if(game.doesGhostRequireAction(ghost)){
				BinaryDecision pinkyDecision = new BinaryDecision();
				pinkyDecision.setCondition(new IsGhostPinky(ghost));
				pinkyDecision.setTrueBranch(new GhostsChaseAction(ghost));
				pinkyDecision.setFalseBranch(new ClosestPillAction(ghost));
				
				BinaryDecision sueDecision = new BinaryDecision();
				sueDecision.setCondition(new IsGhostSue(ghost));
				sueDecision.setTrueBranch(new GhostsChaseAction(ghost));
				sueDecision.setFalseBranch(pinkyDecision);
				
				BinaryDecision anyEdibleDecision = new BinaryDecision();
				anyEdibleDecision.setCondition(new AnyEdibleTime(2, 1000));
				anyEdibleDecision.setTrueBranch(new GhostsChaseAction(ghost));
				anyEdibleDecision.setFalseBranch(sueDecision);
				
				BinaryDecision powerPillDecision = new BinaryDecision();
				powerPillDecision.setCondition(new PowerPillDistance(30));
				powerPillDecision.setTrueBranch(new GhostCampPill(ghost));
				powerPillDecision.setFalseBranch(anyEdibleDecision);
				
				BinaryDecision ediblePacmanDistanceDecision = new BinaryDecision();
				ediblePacmanDistanceDecision.setCondition(new PacmanDistanceFromGhost(ghost, 80));
				ediblePacmanDistanceDecision.setTrueBranch(new RunAwayGhostsAction(ghost));
				ediblePacmanDistanceDecision.setFalseBranch(new GhostCampPill(ghost));
				
				BinaryDecision edibleDecision = new BinaryDecision();
				edibleDecision.setCondition(new EdibleTime(ghost, 2, 1000));
				edibleDecision.setTrueBranch(ediblePacmanDistanceDecision);
				edibleDecision.setFalseBranch(powerPillDecision);
				
				MOVE move = edibleDecision.makeDecision(game).getMove();
				myMoves.put(ghost, move);
			}
		}
		
		return myMoves;
	}
}
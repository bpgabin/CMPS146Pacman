package pacman.entries.pacman;

import edu.ucsc.gameAI.*;
import edu.ucsc.gameAI.decisionTrees.binary.*;
import edu.ucsc.gameAI.conditions.*;
import pacman.controllers.Controller;
import pacman.game.Game;
import static pacman.game.Constants.*;

public class MyPacMan extends Controller<MOVE>
{		
	
	private static final int MIN_DISTANCE = 20;
	private static final int CAMP_POWER_PILL_DISTANCE = 5;
	
	public MOVE getMove(Game game, long timeDue)
	{
		
		
		BinaryDecision campPowerPillDecision = new BinaryDecision();
		campPowerPillDecision.setCondition(new NonEdibleGhostWithinDistance(MIN_DISTANCE));
		campPowerPillDecision.setTrueBranch(new TakePowerPillAction());
		campPowerPillDecision.setFalseBranch(new SafePowerPillAction(CAMP_POWER_PILL_DISTANCE));
		
		BinaryDecision runAwayDecision = new BinaryDecision();
		runAwayDecision.setCondition(new NonEdibleGhostWithinDistance(MIN_DISTANCE));
		runAwayDecision.setTrueBranch(new RunAwayAction(MIN_DISTANCE));
		runAwayDecision.setFalseBranch(new SafePowerPillAction(CAMP_POWER_PILL_DISTANCE));
		
		BinaryDecision powerPillDistanceDecision = new BinaryDecision();
		powerPillDistanceDecision.setCondition(new PowerPillDistance(CAMP_POWER_PILL_DISTANCE + 2));
		powerPillDistanceDecision.setTrueBranch(campPowerPillDecision);
		powerPillDistanceDecision.setFalseBranch(runAwayDecision);
		
		BinaryDecision powerPillActiveDecision = new BinaryDecision();
		powerPillActiveDecision.setCondition(new AnyEdibleTime(2, 1000));
		powerPillActiveDecision.setTrueBranch(new ChaseGhostsAction());
		powerPillActiveDecision.setFalseBranch(powerPillDistanceDecision);
		
		return powerPillActiveDecision.makeDecision(game).getMove();
	}
}
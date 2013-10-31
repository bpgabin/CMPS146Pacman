package pacman.entries.pacman;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import edu.ucsc.gameAI.*;
import edu.ucsc.gameAI.decisionTrees.binary.*;
import edu.ucsc.gameAI.conditions.*;
import pacman.controllers.Controller;
import pacman.game.Game;
import static pacman.game.Constants.*;

public class MyPacMan extends Controller<MOVE>
{		
	
	private static final int MIN_DISTANCE = 20;
	private static final int SAFE_POWER_PILL_DISTANCE = 100;
	private static final int CAMP_POWER_PILL_DISTANCE = 20;
	
	public MOVE getMove(Game game, long timeDue)
	{
		BinaryDecision campPowerPill = new BinaryDecision();
		campPowerPill.setCondition(new SafePowerPill(SAFE_POWER_PILL_DISTANCE));
		campPowerPill.setTrueBranch(new SafePowerPillAction(SAFE_POWER_PILL_DISTANCE, CAMP_POWER_PILL_DISTANCE));
		campPowerPill.setFalseBranch(new NeutralAction());
		
		BinaryDecision runAwayDecision = new BinaryDecision();
		runAwayDecision.setCondition(new NonEdibleGhostWithinDistance(MIN_DISTANCE));
		runAwayDecision.setTrueBranch(new RunAwayAction(MIN_DISTANCE));
		runAwayDecision.setFalseBranch(campPowerPill);
		
		return runAwayDecision.makeDecision(game).getMove();
	}
}
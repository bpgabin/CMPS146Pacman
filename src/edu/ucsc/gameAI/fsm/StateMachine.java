package edu.ucsc.gameAI.fsm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import pacman.game.Game;
import edu.ucsc.gameAI.IAction;

public class StateMachine implements IStateMachine {

	IState initialState;
	IState currentState;
	
	@Override
	public Collection<IAction> update(Game game) {
		// TODO Auto-generated method stub
		ITransition triggeredTransition = null;
		
		Collection<ITransition> transitions = currentState.getTransitions();
		for(Iterator<ITransition> i = transitions.iterator(); i.hasNext(); ){
			ITransition transition = i.next();
			if(transition.isTriggered(game)){
				triggeredTransition = transition;
				break;
			}
		}
		
		Collection<IAction> actions = new ArrayList<IAction>();
		
		if(triggeredTransition != null){
			IState targetState = triggeredTransition.getTargetState();
			IAction exit = currentState.getExitAction();
			IAction action = triggeredTransition.getAction();
			IAction entry = targetState.getEntryAction();
			if(exit != null)
				actions.add(exit);
			if(action != null)
				actions.add(action);
			if(entry != null)
				actions.add(entry);
			
			currentState = targetState;
		}
		else{
			IAction action = currentState.getAction();
			actions.add(action);
		}
		
		return actions;
	}

	@Override
	public IState getCurrentState() {
		// TODO Auto-generated method stub
		return currentState;
	}

	@Override
	public void setCurrentState(IState state) {
		// TODO Auto-generated method stub
		currentState = state;
	}

}

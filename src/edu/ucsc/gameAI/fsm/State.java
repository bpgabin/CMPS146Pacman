package edu.ucsc.gameAI.fsm;

import java.util.Collection;

import edu.ucsc.gameAI.IAction;

public class State implements IState {

	IAction action;
	IAction entryAction;
	IAction exitAction;
	Collection<ITransition> transitions;
	
	@Override
	public IAction getAction() {
		// TODO Auto-generated method stub
		return action;
	}

	@Override
	public void setAction(IAction action) {
		// TODO Auto-generated method stub
		this.action = action;
	}

	@Override
	public IAction getEntryAction() {
		// TODO Auto-generated method stub
		return entryAction;
	}

	@Override
	public void setEntryAction(IAction action) {
		// TODO Auto-generated method stub
		entryAction = action;
	}

	@Override
	public IAction getExitAction() {
		// TODO Auto-generated method stub
		return exitAction;
	}

	@Override
	public void setExitAction(IAction action) {
		// TODO Auto-generated method stub
		exitAction = action;
	}

	@Override
	public Collection<ITransition> getTransitions() {
		// TODO Auto-generated method stub
		return transitions;
	}

	@Override
	public void setTransitions(Collection<ITransition> trans) {
		// TODO Auto-generated method stub
		transitions = trans;
	}

}

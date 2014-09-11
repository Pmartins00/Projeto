package br.com.coautores.listener;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;



public class Autorizador implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent e) {
		FacesContext context = e.getFacesContext();
		
		if("/login.xhtml".equals(context.getViewRoot().getViewId())) {
			return;
		}
		
	}

	@Override
	public void beforePhase(PhaseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}

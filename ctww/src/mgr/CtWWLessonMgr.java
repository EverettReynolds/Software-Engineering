package mgr;

import dao.CtWWDAO;

public abstract class CtWWLessonMgr {
	private LessonPanelBean panelBean;
	private CtWWDAO dao;
	
	public abstract LessonPanelBean prepareBean();

}

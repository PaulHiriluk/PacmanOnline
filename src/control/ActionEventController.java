package control;

import java.awt.event.ActionListener;

import view.MainWindow;
import view.MenuBarItem;

public class ActionEventController {
	public static ActionListener getAction(MenuBarItem item, MainWindow frame){
		switch(item){	
			case START: return
							new ExitEvent();
			case PAUSE: return
					new ExitEvent();
			case EXIT: return
					new ExitEvent();
			case MAIN_MENU: return
					new ExitEvent();
			case ABOUT: return
					new ExitEvent();
			default: 
				throw new IllegalArgumentException();
		}
	}
}

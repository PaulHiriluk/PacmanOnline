package model;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import control.ActionEventController;

import view.MainWindow;
import view.MenuBarItem;
import view.MenuTabItem;

public class MenuModel {
	public static JMenu createMenu(MenuTabItem tab, MainWindow frame){
		JMenu menu = new JMenu(tab.getTabName());
		MenuBarItem menuItem;
		JMenuItem tempItem;
		
		for(int itemInd = 0; itemInd < tab.getMenuItems().size(); itemInd++){
			menuItem = tab.getMenuItems().get(itemInd);
			tempItem = new JMenuItem(menuItem.getName(),menuItem.getIcon());
			tempItem.addActionListener(ActionEventController.getAction(menuItem, frame));
			menu.add(tempItem);	
		}
		return menu;
	}
}

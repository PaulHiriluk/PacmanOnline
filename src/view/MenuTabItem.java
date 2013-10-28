<<<<<<< HEAD:src/model/MenuTabItem.java
package model;

import java.util.ArrayList;
import java.util.List;

public enum MenuTabItem {
	GAME("Игра",
			MenuBarItem.START,
			MenuBarItem.PAUSE,
			MenuBarItem.MAIN_MENU,
			MenuBarItem.EXIT
		),
	INFO("Помощь",
			MenuBarItem.ABOUT
		);

	private MenuTabItem(String tabName, MenuBarItem...menuItems) {
		this.setTabName(tabName);
		this.menuItems = new ArrayList<MenuBarItem>();
		
		for(int itemInd = 0; itemInd < menuItems.length; itemInd++){
			this.menuItems.add(menuItems[itemInd]);
		}
	}
	
	public List<MenuBarItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuBarItem> menuItems) {
		this.menuItems = menuItems;
	}

	public String getTabName() {
		return tabName;
	}
	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	private String tabName;
	private List<MenuBarItem> menuItems;
}
=======
package view;

import java.util.ArrayList;
import java.util.List;

public enum MenuTabItem {
	GAME("Игра",
			MenuBarItem.START,
			MenuBarItem.PAUSE,
			MenuBarItem.MAIN_MENU,
			MenuBarItem.EXIT
		),
	INFO("Помощь",
			MenuBarItem.ABOUT
		);

	private MenuTabItem(String tabName, MenuBarItem...menuItems) {
		this.setTabName(tabName);
		this.menuItems = new ArrayList<MenuBarItem>();
		
		for(int itemInd = 0; itemInd < menuItems.length; itemInd++){
			this.menuItems.add(menuItems[itemInd]);
		}
	}
	
	public List<MenuBarItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuBarItem> menuItems) {
		this.menuItems = menuItems;
	}

	public String getTabName() {
		return tabName;
	}
	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	private String tabName;
	private List<MenuBarItem> menuItems;
}
>>>>>>> pacman/master2:src/view/MenuTabItem.java

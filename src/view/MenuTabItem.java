package view;

import java.util.ArrayList;
import java.util.List;

public enum MenuTabItem {
	GAME("Игра", 
			MenuBarItem.START, 
			MenuBarItem.PAUSE, 
			MenuBarItem.MAIN_MENU,
			MenuBarItem.EXIT),
	TOOLS("Инструменты",
			MenuBarItem.SCREENSHOT),
	INFO("Помощь", 
			MenuBarItem.ABOUT);

	private String				tabName;

	private List<MenuBarItem>	menuItems;

	private MenuTabItem(final String tabName, final MenuBarItem... menuItems) {

		setTabName(tabName);
		this.menuItems = new ArrayList<MenuBarItem>();

		for (int itemInd = 0; itemInd < menuItems.length; itemInd++) {
			this.menuItems.add(menuItems[itemInd]);
		}
	}

	public List<MenuBarItem> getMenuItems() {

		return menuItems;
	}

	public String getTabName() {

		return tabName;
	}

	public void setMenuItems(final List<MenuBarItem> menuItems) {

		this.menuItems = menuItems;
	}

	public void setTabName(final String tabName) {

		this.tabName = tabName;
	}
}

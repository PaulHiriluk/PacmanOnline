package view;

import javax.swing.ImageIcon;

public enum MenuBarItem {
	START("Старт", new ImageIcon("")), 
	PAUSE("Пауза", new ImageIcon("")), 
	MAIN_MENU("Главное меню", new ImageIcon("")),
	SCREENSHOT("Скриншот", new ImageIcon("")),
	ABOUT("О программе", new ImageIcon("")), 
	EXIT("Выход", new ImageIcon(""));

	private String		name;
	private ImageIcon 	icon;

	MenuBarItem(final String name, final ImageIcon icon) {
		setName(name);
		setIcon(icon);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
}

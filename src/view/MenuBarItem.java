package view;

import javax.swing.ImageIcon;

public enum MenuBarItem {
	START("�����", new ImageIcon("")), 
	PAUSE("�����", new ImageIcon("")), 
	MAIN_MENU("������� ����", new ImageIcon("")),
	SCREENSHOT("��������", new ImageIcon("")),
	ABOUT("� ���������", new ImageIcon("")), 
	EXIT("�����", new ImageIcon(""));

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

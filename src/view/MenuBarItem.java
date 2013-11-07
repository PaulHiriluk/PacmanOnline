package view;

import javax.swing.ImageIcon;

public enum MenuBarItem {
	START("�����", new ImageIcon("")), PAUSE("�����", new ImageIcon("")), MAIN_MENU(
			"������� ����", new ImageIcon("")), SCREENSHOT("��������", new ImageIcon("")), ABOUT(
			"� ���������", new ImageIcon("")), EXIT("�����", new ImageIcon(""));

	private String		name;
	private ImageIcon	icon;

	MenuBarItem(final String name, final ImageIcon icon) {
		setName(name);
		setIcon(icon);
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public String getName() {
		return name;
	}

	public void setIcon(final ImageIcon icon) {
		this.icon = icon;
	}

	public void setName(final String name) {
		this.name = name;
	}
}

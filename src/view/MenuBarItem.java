package view;

public enum MenuBarItem {
	START("�����"), PAUSE("�����"), MAIN_MENU("������� ����"), ABOUT("� ���������"), EXIT(
			"�����");

	private String	paramName;

	MenuBarItem(final String paramName) {

		setParamName(paramName);
	}

	public String getParamName() {

		return paramName;
	}

	public void setParamName(final String paramName) {

		this.paramName = paramName;
	}
}

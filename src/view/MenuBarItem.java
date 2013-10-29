package view;

public enum MenuBarItem {
	START("Старт"), PAUSE("Пауза"), MAIN_MENU("Главное меню"), ABOUT("О программе"), EXIT(
			"Выход");

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

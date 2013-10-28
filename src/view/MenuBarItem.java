package view;

public enum MenuBarItem {
	START("Старт"),
	PAUSE("Пауза"),
	MAIN_MENU("Главное меню"),
	ABOUT("О программе"),
	EXIT("Выход");
	
	MenuBarItem(String paramName){
		this.setParamName(paramName);
	}
	
	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	private String paramName;
}
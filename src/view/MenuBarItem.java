package view;

public enum MenuBarItem {
	START("�����"),
	PAUSE("�����"),
	MAIN_MENU("������� ����"),
	ABOUT("� ���������"),
	EXIT("�����");
	
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
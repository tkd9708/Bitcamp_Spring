package ex4.test;

public class ServerSetting {

	String driverClass;
	String url;
	String userName;
	String passWord;
	
	public ServerSetting(String driverClass) {
		super();
		this.driverClass = driverClass;
	}

	public String getDriverClass() {
		return driverClass;
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
}

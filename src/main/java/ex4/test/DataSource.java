package ex4.test;

public class DataSource {
	ServerSetting server;
	
	public void setServer(ServerSetting server) {
		this.server = server;
	}
	
	public void serverInfo() {
		System.out.println("** 서버 정보 **");
		System.out.println("드라이버 클래스 : " + server.getDriverClass());
		System.out.println("URL : " + server.getUrl());
		System.out.println("아이디 : " + server.getUserName());
		System.out.println("비밀번호 : " + server.getPassWord());
	}
}

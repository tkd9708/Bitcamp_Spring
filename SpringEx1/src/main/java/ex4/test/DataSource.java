package ex4.test;

public class DataSource {
	ServerSetting server;
	
	public void setServer(ServerSetting server) {
		this.server = server;
	}
	
	public void serverInfo() {
		System.out.println("** ���� ���� **");
		System.out.println("����̹� Ŭ���� : " + server.getDriverClass());
		System.out.println("URL : " + server.getUrl());
		System.out.println("���̵� : " + server.getUserName());
		System.out.println("��й�ȣ : " + server.getPassWord());
	}
}

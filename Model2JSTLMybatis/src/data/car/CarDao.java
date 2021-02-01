package data.car;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.setting.ConnectionManager;

public class CarDao {
	ConnectionManager manager = ConnectionManager.getInstance();
	
	SqlSession session;
	
	private SqlSession getSession() {
		session = manager.openSession();
		return session;
	}
	
	///////////////////////////////////////////////////////////////////
	// ��ü ���� ���ϱ�
	public int getTotalCount() {
		int n = 0;
		session = this.getSession();
		n = session.selectOne("car.totalCountOfCar"); // totalCountOfCar�� sql�� ��� 
		session.close();
		return n;
	}
	
	// insert
	public void insertCar(CarDto dto) {
		session = this.getSession();
		session.insert("car.insertOfCar", dto);
		session.close();
	}
	
	public List<CarDto> getAllDatas(){
		List<CarDto> list = null;
		session = this.getSession();
		list = session.selectList("car.selectAllOfCar");
		
		session.close();
		return list;
	}
	
	public CarDto getData(String num) {
		CarDto dto = new CarDto();
		session = this.getSession();
		dto = session.selectOne("car.selectOneOfCar", num);
		
		session.close();
		return dto;
	}
	
	public void updateCar(CarDto dto) {
		session = this.getSession();
		session.update("car.updateOfCar", dto);
		session.close();
	}
	
	public void deleteCar(String num) {
		session = this.getSession();
		session.delete("deleteOfCar", num);
		session.close();
	}
}

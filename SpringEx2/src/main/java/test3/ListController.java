package test3;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("list") // id�� list�� �ȴ�.
@Component
public class ListController {
	
	//@Resource(name="dao") // �ش� id�� dao�� ã�Ƽ� ����
	
	@Autowired // �ش� Ÿ���� ã�Ƽ� �ڵ����� ���Խ����ش�.
	DaoInter daoInter;

/*	public ListController(DaoInter daoInter) {
		super();
		this.daoInter = daoInter;
	}*/
	
	public void process() {
		System.out.println("db�� insert");
		daoInter.insertData("happy Day");
		
		System.out.println("db ������ ����");
		daoInter.deleteData("5");
	}
}

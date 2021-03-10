package test3;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("list") // id가 list가 된다.
@Component
public class ListController {
	
	//@Resource(name="dao") // 해당 id인 dao를 찾아서 주입
	
	@Autowired // 해당 타입을 찾아서 자동으로 주입시켜준다.
	DaoInter daoInter;

/*	public ListController(DaoInter daoInter) {
		super();
		this.daoInter = daoInter;
	}*/
	
	public void process() {
		System.out.println("db에 insert");
		daoInter.insertData("happy Day");
		
		System.out.println("db 데이터 삭제");
		daoInter.deleteData("5");
	}
}

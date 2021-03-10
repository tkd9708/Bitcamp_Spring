package test3;

import org.springframework.stereotype.Component;

//@Component : �ڵ����� �������Ͽ� Bean ������ִ� annotation
//@Component //  ������ ���, Ŭ������ ���̵� �ȴ� (�� ù���ڴ� �ҹ��� : myDao�� id�� �ȴ�)
@Component("dao")   // �������ָ�, dao�� id���ȴ�.
public class MyDao implements DaoInter {

	@Override
	public void insertData(String str) {
		// TODO Auto-generated method stub

		System.out.println(str + " ������ DB�� �߰��Ϸ�!!");
	}

	@Override
	public void deleteData(String num) {
		// TODO Auto-generated method stub

		System.out.println(num + " ��ȣ�� ���� ������ ���� �Ϸ�!!");
	}

}

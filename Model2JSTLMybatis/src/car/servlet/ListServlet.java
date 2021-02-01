package car.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.car.CarDao;
import data.car.CarDto;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/samsung/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CarDao dao = new CarDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// �� ���� ���ϱ�
		int totalCount=dao.getTotalCount();
		
		// request�� ����
		request.setAttribute("totalCount", totalCount);
		
		// ��� ��������
		List<CarDto> list = dao.getAllDatas();
		
		// request�� ��� ����
		request.setAttribute("list", list);
		
		// jsp ���Ϸ� ������ >> forward�� �ּ�, request, response ���� �ȹٲ�
		RequestDispatcher rd = request.getRequestDispatcher("../car/carlist.jsp"); // ******* mapping �ּҰ� "/car/list"�̸� ���⿡ "carlist.jsp"�� �ϸ��
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

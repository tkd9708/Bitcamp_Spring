package car.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.car.CarDao;
import data.car.CarDto;

/**
 * Servlet implementation class UpdateFormServlet
 */
@WebServlet("/samsung/updateform")
public class UpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	CarDao dao = new CarDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// num �б�
		String num = request.getParameter("num");
		
		// dto ���
		CarDto dto = dao.getData(num);
		
		// request�� ����
		request.setAttribute("dto", dto);
		
		// updateform.jsp ������
		RequestDispatcher rd = request.getRequestDispatcher("../car/updateform.jsp"); 
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

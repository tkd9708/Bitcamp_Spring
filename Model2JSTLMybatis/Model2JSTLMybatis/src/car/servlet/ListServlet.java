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
		// 총 갯수 구하기
		int totalCount=dao.getTotalCount();
		
		// request에 저장
		request.setAttribute("totalCount", totalCount);
		
		// 목록 가져오기
		List<CarDto> list = dao.getAllDatas();
		
		// request에 목록 저장
		request.setAttribute("list", list);
		
		// jsp 파일로 포워드 >> forward는 주소, request, response 전부 안바뀜
		RequestDispatcher rd = request.getRequestDispatcher("../car/carlist.jsp"); // ******* mapping 주소가 "/car/list"이면 여기에 "carlist.jsp"만 하면됌
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

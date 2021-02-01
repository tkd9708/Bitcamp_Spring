package car.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.car.CarDao;
import data.car.CarDto;

/**
 * Servlet implementation class WriteServlet
 */
@WebServlet("/samsung/write")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	CarDao dao = new CarDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 한글 엔코딩
		request.setCharacterEncoding("utf-8");
		
		// 데이터 읽어서 dto에 넣기
		CarDto dto = new CarDto();
		String carname = request.getParameter("carname");
		String carcolor = request.getParameter("carcolor");
		String carguip = request.getParameter("carguip");
		int carprice = Integer.parseInt(request.getParameter("carprice"));
		
		dto.setCarname(carname);
		dto.setCarcolor(carcolor);
		dto.setCarguip(carguip);
		dto.setCarprice(carprice);
		
		// db에 추가
		dao.insertCar(dto);
		
		// 목록으로 이동
		response.sendRedirect("list"); // list 서블릿으로 가서 데이터를 가져온 후 jsp로 가서 출력
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

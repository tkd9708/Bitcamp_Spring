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
 * Servlet implementation class UpdateCarServlet
 */
@WebServlet("/samsung/update")
public class UpdateCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	CarDao dao = new CarDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String num = request.getParameter("num");
		String carname = request.getParameter("carname");
		String carcolor = request.getParameter("carcolor");
		String carguip = request.getParameter("carguip");
		int carprice = Integer.parseInt(request.getParameter("carprice"));
		
		CarDto dto = new CarDto();
		dto.setNum(num);
		dto.setCarcolor(carcolor);
		dto.setCarguip(carguip);
		dto.setCarname(carname);
		dto.setCarprice(carprice);
		
		dao.updateCar(dto);
		
		response.sendRedirect("list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

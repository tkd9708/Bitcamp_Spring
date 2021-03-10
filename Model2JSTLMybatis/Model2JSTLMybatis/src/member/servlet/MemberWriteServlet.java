package member.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.member.CarMemberDao;
import data.member.CarMemberDto;

/**
 * Servlet implementation class MemberWriteServlet
 */
@WebServlet("/member/write")
public class MemberWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	CarMemberDao dao = new CarMemberDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String hp = request.getParameter("hp");
		String addr = request.getParameter("addr");
		/* String gaipday = request.getParameter("gaipday"); */
		
		CarMemberDto dto = new CarMemberDto();
		dto.setAddr(addr);
		/* dto.setGaipday(gaipday); */
		dto.setHp(hp);
		dto.setName(name);
		
		dao.insertMember(dto);
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

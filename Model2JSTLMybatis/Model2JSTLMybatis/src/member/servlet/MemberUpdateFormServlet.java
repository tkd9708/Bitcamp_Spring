package member.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.member.CarMemberDao;
import data.member.CarMemberDto;

/**
 * Servlet implementation class MemberUpdateFormServlet
 */
@WebServlet("/member/updateform")
public class MemberUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	CarMemberDao dao = new CarMemberDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num = request.getParameter("num");
		CarMemberDto dto = new CarMemberDto();
		dto = dao.getMember(num);
		request.setAttribute("dto", dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("updateform.jsp");
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

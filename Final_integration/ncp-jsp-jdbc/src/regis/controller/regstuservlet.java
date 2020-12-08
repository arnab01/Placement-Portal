package regis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import regis.dao.regstudao;
import regis.dao.userdao;
import regis.model.company;
import regis.model.regstuclass;

/**
 * Servlet implementation class regstuservlet
 */
@WebServlet("/regstu")
public class regstuservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private regstudao stu=new regstudao();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regstuservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<regstuclass> liststu = stu.selectAllUsers();
		request.setAttribute("liststu", liststu);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/regstu.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

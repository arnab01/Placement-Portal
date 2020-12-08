package regis.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import regis.dao.logindb;
import regis.dao.regisdao;
import regis.dao.userdao;
import regis.model.User;
import regis.model.company;
import regis.model.login;

/**
 * Servlet implementation class login
 */
@WebServlet("/")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private logindb log= new logindb(); 
	private regisdao reg= new regisdao();
	private userdao us= new userdao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/list":
				listcompany(request, response);
				break;
			
			case "/liststu":
				liststu(request, response);
				break;
				
			case "/deletesch":
				deleteUser(request, response);
				break;
			
			case "/deletestu":
				deletestud(request, response);
				break;
			
			default:
				login(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("scid"));
		reg.deleteUser(id);
		response.sendRedirect("list");
	}
	
	private void deletestud(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		us.deleteUser(id);
		response.sendRedirect("liststu");
	}
	private void listcompany(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<company> listcomp = reg.selectAllUsers();
		request.setAttribute("listcomp", listcomp);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/schedulecomp.jsp");
		dispatcher.forward(request, response);
	}
	private void liststu(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listuser = us.selectAllUsers();
		request.setAttribute("listuser", listuser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/selecstu.jsp");
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

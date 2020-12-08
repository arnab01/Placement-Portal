package regis.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import regis.dao.userdao;
import regis.model.User;
import regis.model.company;

/**
 * Servlet implementation class selstuservlet
 */
@WebServlet("/selstu")
public class selstuservlet extends HttpServlet {
	private userdao userDAO=new userdao();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selstuservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/resulform.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String roll=request.getParameter("rollno");
		String name=request.getParameter("name");
		String offer=request.getParameter("offer");
		String email=request.getParameter("email");
		String company=request.getParameter("compname");
		String role=request.getParameter("role");
		
		User user=new User();
		user.setId(roll);
		user.setName(name);
		user.setEmail(email);
		user.setCompany(company);
		user.setRole(role);
		user.setOffer(offer);
		
			try {
				userDAO.insertUser(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
	}

}

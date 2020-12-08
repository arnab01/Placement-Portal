package regis.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import regis.dao.regisdao;
import regis.model.company;

/**
 * Servlet implementation class regiservlet
 */
@WebServlet("/schedule")
public class regiservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private regisdao reg= new regisdao();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regiservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<company> listcomp = reg.selectAllUsers();
		request.setAttribute("comp", listcomp);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/schedulecomp.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String testname=request.getParameter("testname");
		String compname=request.getParameter("compname");
		Integer roundno=Integer.parseInt(request.getParameter("roundno"));
		String testdate=request.getParameter("tdate");
		String stime=request.getParameter("stime");
		String etime=request.getParameter("etime");
		company comp=new company();
		comp.setCompanyname(compname);
		comp.setTestname(testname);
		comp.setRoundno(roundno);
		comp.setTestdate(testdate);
		comp.setStart(stime);
		comp.setEnd(etime);
		try {
			reg.registerEmployee(comp);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/schedulecomp.jsp");
		dispatcher.forward(request, response);
	}

}



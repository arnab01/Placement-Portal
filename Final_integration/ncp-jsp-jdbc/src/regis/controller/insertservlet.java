package regis.controller;

import java.io.IOException;
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
 * Servlet implementation class insertservlet
 */
@WebServlet("/register")
public class insertservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private regisdao reg= new regisdao();  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/Compreg.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
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
	
	}

}

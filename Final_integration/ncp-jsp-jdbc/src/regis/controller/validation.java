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

import regis.dao.logindb;
import regis.dao.regstudao;
import regis.model.login;
import regis.model.regstuclass;

/**
 * Servlet implementation class validation
 */
@WebServlet("/validation")
public class validation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private logindb log= new logindb(); 
	private regstudao stu=new regstudao();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String username=request.getParameter("username");
		String passwrd=request.getParameter("password");
		int test=0;
		try {
			List<login> loginlist = log.login();
			// u1, p1
            for(int i=0; i<loginlist.size(); i++) {
                if (username.equals(loginlist.get(i).getUsername())  && passwrd.equals(loginlist.get(i).getPassword())) {
				    test=1;
                    break ;
                }
            }
            if (test==1)
            {   List<regstuclass> liststu = stu.selectAllUsers();
    		   request.setAttribute("liststu", liststu);
            	RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/regstu.jsp");
        		dispatcher.forward(request, response);
        		  test=0;
            }
            else
            {
            	RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/logfail.jsp");
        		dispatcher.forward(request, response);
            }
            
            
			
			
			
			
			
		} catch (ClassNotFoundException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

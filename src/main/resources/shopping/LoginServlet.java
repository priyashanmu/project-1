package shopping;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
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
		String userName=reqest.getParameter("userName");
		String pwd=reqest.getParameter("password");
		LoginDAO ln=new LoginDAO();
		RequestDispathcher dis;
		if(ln.isValidUser(userName,pwd)==true)
		{
			dis=reqest.getRequestDispatcher("home.html");
		dis.forward(reqest,response);
				}
		else
		{
			printWriter writer=response.getWriter();
			Writer.println("please enter valid credentials")
            dis=reqest.getRequestDispatcher("f.html");
		dis.include(reqest,respone);
	
	}
	}
		
		
	}

}

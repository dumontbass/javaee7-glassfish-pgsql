package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.Person;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UserDAO userDAO;
	
	@EJB HelloBean bean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		
		out.print("<h1>Hello"+bean.sayHello("name")+"</h1>");
		
		List<Person> personList =
				userDAO.findAll();
		
		out.print("<table>");
		
		out.print("<tr>");
		out.print("<td>Username</td>");
		out.print("<td>Surename</td>");
		out.print("</tr>");
		for(Person person : personList){
			out.print("<tr>");
			out.print("<td style=\"color: blue\">"+ person.getName() +"</td>");
			out.print("<td style=\"color: red\">"+ person.getSurename() +"</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		
		out.print("</html></body>");
		
		response.setContentType("text/html");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

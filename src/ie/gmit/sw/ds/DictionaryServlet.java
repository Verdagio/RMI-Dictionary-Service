package ie.gmit.sw.ds;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DictionaryServlet
 */
@WebServlet("/DictionaryServlet")
public class DictionaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public DictionaryServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response, String res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append(res);
		
		response.sendRedirect("index.jsp?message="+res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InQueue r = new InQueue(request.getParameter("word"));
		new Thread(r).start();
		
		PrintWriter out = response.getWriter();		// for debugging...
		//out.println(r.hashCode());				// double checking hashcode of thread (debugging)		
		try {
			Thread.sleep(1000);					// simulate a wait...?
			String res = r.getResponse();			// get the response from our thread
			//out.println(res.toString());			// checking res (debugging)
			doGet(request, response, res);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// try catch
	}// post



}

package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Player;

/**
 * Servlet implementation class EditPlayerServlet
 */
@WebServlet("/EditPlayerServlet")
public class EditPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPlayerServlet() {
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
		String act = request.getParameter("doThisToPlayer");
		PlayerHelper ph = new PlayerHelper();
		if (act == null) {
			//no button has been selected
			getServletContext().getRequestDispatcher("/ViewAllPlayerServlet").forward(request, response);
		} else if (act.equals("Delete Selected Player")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Player playerToDelete = ph.searchForPlayerById(tempId);
			ph.deletePlayer(playerToDelete);
			getServletContext().getRequestDispatcher("/ViewAllPlayerServlet").forward(request, response);
		} 
		else if (act.equals("Add New Player")) {
			getServletContext().getRequestDispatcher("/AddPlayer.html").forward(request, response);
		}
		else if (act.equals("Back To Menu")) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
	}
	

}

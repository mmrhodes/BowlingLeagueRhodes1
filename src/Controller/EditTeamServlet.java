package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Team;

/**
 * Servlet implementation class EditTeamServlet
 */
@WebServlet("/EditTeamServlet")
public class EditTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTeamServlet() {
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
		String act = request.getParameter("doThisToTeam");
		TeamHelper th = new TeamHelper();
		PlayerHelper ph = new PlayerHelper();
		if (act == null) {
			//no button has been selected
			getServletContext().getRequestDispatcher("/ViewAllTeamsServlet").forward(request, response);
		} else if (act.equals("Delete Selected Team")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Team teamToDelete = th.searchForTeamById(tempId);
			ph.deleteAllPlayersOnTeam(teamToDelete);
			th.deleteTeam(teamToDelete);

			getServletContext().getRequestDispatcher("/ViewAllTeamsServlet").forward(request, response);
		} 
		else if (act.equals("Add New Team")) {
			getServletContext().getRequestDispatcher("/AddTeam.html").forward(request, response);
		}
		else if (act.equals("Back To Menu")) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}
	}
	}



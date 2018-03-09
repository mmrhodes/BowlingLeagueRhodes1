package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Team;
import model.Player;


/**
 * Servlet implementation class addPlayerServlet
 */
@WebServlet("/AddPlayerServlet")
public class AddPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNumber = request.getParameter("phoneNumber");
		String screenName = request.getParameter("screenName");		
		String teamName = request.getParameter("teamName");
		Team team;
		TeamHelper th = new TeamHelper();
		
		PlayerHelper ph = new PlayerHelper();
		if(th.searchForTeamByName(teamName)== null){
			team = new Team(teamName);
			th.insertTeam(team);
		} else {
			team = th.searchForTeamByName(teamName);
		}
		
		
		Player np = new Player(firstName, lastName, phoneNumber, screenName, team);
		
		ph.insertPlayer(np);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
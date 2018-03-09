package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Player;
import model.Team;

public class TeamHelper {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BowlingLeagueRhodes1");

	public void insertTeam(Team t) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();

	}

	public Team searchForTeamByName(String teamName) {
		try {
			EntityManager em = emfactory.createEntityManager();
			TypedQuery<Team> findTeam = em.createQuery("Select t from Team t where t.teamName =:selectedName",
					Team.class);
			findTeam.setParameter("selectedName", teamName);
			findTeam.setMaxResults(1);
			Team foundTeam = findTeam.getSingleResult();
			em.close();
			return foundTeam;

		} catch (NoResultException e) {
			return null;
		}
	}

	public Team searchForTeamById(int teamId) {

		EntityManager em = emfactory.createEntityManager();
		// em.getTransaction().begin();
		Team foundTeam = em.find(Team.class, teamId);
		em.close();
		return foundTeam;
	}

	public List<Team> viewAllTeams() {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Team> allResults = em.createQuery("select t from Team t", Team.class);
		List<Team> allTeams = allResults.getResultList();
		em.close();
		return allTeams;
	}
	
	
	public void deleteTeam(Team teamToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		TypedQuery<Team> deleteTeam = em.createQuery("select t from Team t where t.teamId = :selectedId", Team.class);
		deleteTeam.setParameter("selectedId", teamToDelete.getTeamId());
		deleteTeam.setMaxResults(1);
		Team toDelete = deleteTeam.getSingleResult();
		em.remove(toDelete);
		em.getTransaction().commit();
		em.close();
	}

}

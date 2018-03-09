package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Player;
import model.Team;


public class PlayerHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BowlingLeagueRhodes1");

	public void insertPlayer(Player toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();

	}

	public List<Player> viewAllPlayers() {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Player> allResults = em.createQuery("select li from Player li", Player.class);
		List<Player> allItems = allResults.getResultList();
		em.close();
		return allItems;
	}
 
	public void deletePlayer(Player playerToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> deletePlayer = em.createQuery("select p from Player p where p.playerId = :selectedId", Player.class);
		deletePlayer.setParameter("selectedId", playerToDelete.getPlayerId());
		deletePlayer.setMaxResults(1);
		Player result = deletePlayer.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Player searchForPlayerById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Player foundPlayer = em.find(Player.class, tempId);
		em.close();
		return foundPlayer;
	}
	public void deleteAllPlayersOnTeam(Team team) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> deletePlayers = em.createQuery("delete from Player p where p.team = :selectedTeam", Player.class);
		deletePlayers.setParameter("selectedTeam", team);
		int deleteCount = deletePlayers.executeUpdate();
		if (deleteCount>0) {
			System.out.println("players removed");
					}
		em.getTransaction().commit();
		em.close();
	}
}


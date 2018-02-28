package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "teamId")
	private int teamId;
	@Column(name = "teamName")
	private String teamName;
	@Column(name = "teamType")
	private String teamType;
	@Column(name = "preferredNight")
	private String preferredNight;
	
	
	public Team() {
		super();
	}
	
	
	public Team(String teamName, String teamType, String preferredNight) {
		super();
		this.teamName = teamName;
		this.teamType = teamType;
		this.preferredNight = preferredNight;
	}


	public Team(int teamId, String teamName, String teamType, String preferredNight) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.teamType = teamType;
		this.preferredNight = preferredNight;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamType() {
		return teamType;
	}
	public void setTeamType(String teamType) {
		this.teamType = teamType;
	}
	public String getPreferredNight() {
		return preferredNight;
	}
	public void setPreferredNight(String preferredNight) {
		this.preferredNight = preferredNight;
	}
	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", teamType=" + teamType + ", preferredNight="
				+ preferredNight + "]";
	}
	
	
	
	

}

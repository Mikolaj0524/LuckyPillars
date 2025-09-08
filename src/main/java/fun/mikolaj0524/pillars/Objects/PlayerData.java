package fun.mikolaj0524.pillars.Objects;

public class PlayerData {
	private Integer kills;

	public PlayerData(){
		this.kills = 0;
	}

	public PlayerData(Integer kills){
		this.kills = kills;
	}

	public Integer getKills(){
		return this.kills;
	}

	public void setKills(Integer kills){
		this.kills = kills;
	}

	public void addKill(){
		this.kills++;
	}

}

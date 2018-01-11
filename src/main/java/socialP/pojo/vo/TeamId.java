package socialP.pojo.vo;

public class TeamId {
    private Integer teamId;

    public TeamId() {
    }

    public TeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "TeamId{" +
                "teamId=" + teamId +
                '}';
    }
}

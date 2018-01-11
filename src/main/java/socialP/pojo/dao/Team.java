package socialP.pojo.dao;

public class Team {
    private Integer teamId;

    private String teamName;

    private Integer teamLeaderId;

    private String introduction;

    private String imageURL;

    private String simpleImageURL;

    private String college;

    private String university;

    //DELETED=1
    //UNCHECKED=0
    //PASSED=1
    //UNPASSED=2
    private Integer teamStatus;

    public Team(Integer teamId, String teamName, Integer teamLeaderId, String introduction, String imageURL, String simpleImageURL, String college, String university, Integer teamStatus) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamLeaderId = teamLeaderId;
        this.introduction = introduction;
        this.imageURL = imageURL;
        this.simpleImageURL = simpleImageURL;
        this.college = college;
        this.university = university;
        this.teamStatus = teamStatus;
    }

    public Team() {
        super();
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName == null ? null : teamName.trim();
    }

    public Integer getTeamLeaderId() {
        return teamLeaderId;
    }

    public void setTeamLeaderId(Integer teamLeaderId) {
        this.teamLeaderId = teamLeaderId;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL == null ? null : imageURL.trim();
    }

    public String getSimpleImageURL() {
        return simpleImageURL;
    }

    public void setSimpleImageURL(String simpleImageURL) {
        this.simpleImageURL = simpleImageURL == null ? null : simpleImageURL.trim();
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university == null ? null : university.trim();
    }

    public Integer getTeamStatus() {
        return teamStatus;
    }

    public void setTeamStatus(Integer teamStatus) {
        this.teamStatus = teamStatus;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", teamLeaderId=" + teamLeaderId +
                ", introduction='" + introduction + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", simpleImageURL='" + simpleImageURL + '\'' +
                ", college='" + college + '\'' +
                ", university='" + university + '\'' +
                ", teamStatus=" + teamStatus +
                '}';
    }
}
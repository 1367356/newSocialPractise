package socialP.pojo.vo;

import java.util.List;

public class TeamVo {
    private Integer teamId;

    private String teamName;

    private Integer teamLeaderId;

    private List<TeamAdminVo> teamAdmin;

    private List<TeamStudentVo> teamStudent;

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

    public TeamVo() {
    }

    public TeamVo(Integer teamId, String teamName, Integer teamLeaderId, List<TeamAdminVo> teamAdmin, List<TeamStudentVo> teamStudent, String introduction, String imageURL, String simpleImageURL, String college, String university, Integer teamStatus) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamLeaderId = teamLeaderId;
        this.teamAdmin = teamAdmin;
        this.teamStudent = teamStudent;
        this.introduction = introduction;
        this.imageURL = imageURL;
        this.simpleImageURL = simpleImageURL;
        this.college = college;
        this.university = university;
        this.teamStatus = teamStatus;
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
        this.teamName = teamName;
    }

    public Integer getTeamLeaderId() {
        return teamLeaderId;
    }

    public void setTeamLeaderId(Integer teamLeaderId) {
        this.teamLeaderId = teamLeaderId;
    }

    public List<TeamAdminVo> getTeamAdmin() {
        return teamAdmin;
    }

    public void setTeamAdmin(List<TeamAdminVo> teamAdmin) {
        this.teamAdmin = teamAdmin;
    }

    public List<TeamStudentVo> getTeamStudent() {
        return teamStudent;
    }

    public void setTeamStudent(List<TeamStudentVo> teamStudent) {
        this.teamStudent = teamStudent;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getSimpleImageURL() {
        return simpleImageURL;
    }

    public void setSimpleImageURL(String simpleImageURL) {
        this.simpleImageURL = simpleImageURL;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Integer getTeamStatus() {
        return teamStatus;
    }

    public void setTeamStatus(Integer teamStatus) {
        this.teamStatus = teamStatus;
    }

    @Override
    public String toString() {
        return "TeamVo{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", teamLeaderId=" + teamLeaderId +
                ", teamAdmin=" + teamAdmin +
                ", teamStudent=" + teamStudent +
                ", introduction='" + introduction + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", simpleImageURL='" + simpleImageURL + '\'' +
                ", college='" + college + '\'' +
                ", university='" + university + '\'' +
                ", teamStatus=" + teamStatus +
                '}';
    }
}
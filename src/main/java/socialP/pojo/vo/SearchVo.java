package socialP.pojo.vo;

import java.util.List;

public class SearchVo {
    private Integer studentId;
    private String college;
    private String university;
    private List<TeamId> teamIds;

    //STUDENTID = studentId
    //COLLEGE = college
    //UNIVERSITY = university
    private String type;

    public SearchVo() {
    }

    public SearchVo(Integer studentId, String college, String university, List<TeamId> teamIds, String type) {
        this.studentId = studentId;
        this.college = college;
        this.university = university;
        this.teamIds = teamIds;
        this.type = type;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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

    public List<TeamId> getTeamIds() {
        return teamIds;
    }

    public void setTeamIds(List<TeamId> teamIds) {
        this.teamIds = teamIds;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

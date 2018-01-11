package socialP.pojo.dao;

public class TeamStudent {
    private Integer studentId;

    private Integer teamId;

    //DELETED=1
    //UNCHECKED=0
    //PASSED=1
    //UNPASSED=2
    private Integer studentStatus;

    //STUDENT=1
    //TEAMADMIN=2
    private Integer studentIdentity;

    public TeamStudent(Integer studentId, Integer teamId, Integer studentStatus, Integer studentIdentity) {
        this.studentId = studentId;
        this.teamId = teamId;
        this.studentStatus = studentStatus;
        this.studentIdentity = studentIdentity;
    }

    public TeamStudent() {
        super();
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(Integer studentStatus) {
        this.studentStatus = studentStatus;
    }

    public Integer getStudentIdentity() {
        return studentIdentity;
    }

    public void setStudentIdentity(Integer studentIdentity) {
        this.studentIdentity = studentIdentity;
    }

    @Override
    public String toString() {
        return "TeamStudent{" +
                "studentId=" + studentId +
                ", teamId=" + teamId +
                ", studentStatus=" + studentStatus +
                ", studentIdentity=" + studentIdentity +
                '}';
    }
}
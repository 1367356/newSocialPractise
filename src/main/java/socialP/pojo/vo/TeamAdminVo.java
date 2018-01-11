package socialP.pojo.vo;

public class TeamAdminVo {
    Integer studentId;
    Integer studentIdentityInTeam;

    public TeamAdminVo() {
    }

    public TeamAdminVo(Integer studentId, Integer studentIdentityInTeam) {
        this.studentId = studentId;
        this.studentIdentityInTeam = studentIdentityInTeam;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getStudentIdentityInTeam() {
        return studentIdentityInTeam;
    }

    public void setStudentIdentityInTeam(Integer studentIdentityInTeam) {
        this.studentIdentityInTeam = studentIdentityInTeam;
    }

    @Override
    public String toString() {
        return "TeamAdminVo{" +
                "studentId=" + studentId +
                ", studentIdentityInTeam=" + studentIdentityInTeam +
                '}';
    }
}

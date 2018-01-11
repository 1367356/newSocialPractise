package socialP.pojo.vo;

public class TeamStudentVo {
    private Integer studentId;

    //DELETED=1
    //UNCHECKED=0
    //PASSED=1
    //UNPASSED=2
    private Integer studentStatus;

    public TeamStudentVo() {
    }

    public TeamStudentVo(Integer studentId, Integer studentStatus) {
        this.studentId = studentId;
        this.studentStatus = studentStatus;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(Integer studentStatus) {
        this.studentStatus = studentStatus;
    }

    @Override
    public String toString() {
        return "TeamStudentVo{" +
                "studentId=" + studentId +
                ", studentStatus=" + studentStatus +
                '}';
    }
}
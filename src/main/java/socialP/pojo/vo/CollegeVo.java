package socialP.pojo.vo;

public class CollegeVo {

    private String college;

    public CollegeVo() {
    }

    public CollegeVo(String college) {
        this.college = college;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return "CollegeVo{" +
                "college='" + college + '\'' +
                '}';
    }
}
package socialP.pojo.dao;

public class College {
    private Integer collegeId;

    private Integer universityId;

    private String college;

    public College(Integer collegeId, Integer universityId, String college) {
        this.collegeId = collegeId;
        this.universityId = universityId;
        this.college = college;
    }

    public College() {
        super();
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public Integer getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    @Override
    public String toString() {
        return "College{" +
                "collegeId=" + collegeId +
                ", universityId=" + universityId +
                ", college='" + college + '\'' +
                '}';
    }
}
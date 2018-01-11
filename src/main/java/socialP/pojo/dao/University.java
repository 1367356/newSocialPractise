package socialP.pojo.dao;

public class University {
    private Integer universityId;

    private String university;

    public University(Integer universityId, String university) {
        this.universityId = universityId;
        this.university = university;
    }

    public University() {
        super();
    }

    public Integer getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university == null ? null : university.trim();
    }

    @Override
    public String toString() {
        return "University{" +
                "universityId=" + universityId +
                ", university='" + university + '\'' +
                '}';
    }
}
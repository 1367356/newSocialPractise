package socialP.pojo.vo;

import java.util.List;

public class UniversityVo {

    private String university;
    private List<CollegeVo> colleges;

    public UniversityVo() {
    }

    public UniversityVo(String university, List<CollegeVo> colleges) {
        this.university = university;
        this.colleges = colleges;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public List<CollegeVo> getColleges() {
        return colleges;
    }

    public void setColleges(List<CollegeVo> colleges) {
        this.colleges = colleges;
    }

    @Override
    public String toString() {
        return "UniversityVo{" +
                "university='" + university + '\'' +
                ", colleges=" + colleges +
                '}';
    }
}
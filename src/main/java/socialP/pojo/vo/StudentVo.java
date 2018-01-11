package socialP.pojo.vo;

public class StudentVo {
    private Integer studentId;

    private String studentName;

    private String password;

    private String college;

    private String university;

    private String email;

    private String telephone;

    private String imageURL;

    //STUDENT=1
    //COLLEGEADMIN=2
    //UNIVERSITYADMIN=3
    private Integer identity;

    public StudentVo(Integer studentId, String studentName, String password, String college, String university, String email, String telephone, String imageURL, Integer identity) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.password = password;
        this.college = college;
        this.university = university;
        this.email = email;
        this.telephone = telephone;
        this.imageURL = imageURL;
        this.identity = identity;
    }

    public StudentVo() {
        super();
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL == null ? null : imageURL.trim();
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "StudentVo{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", password='" + password + '\'' +
                ", college='" + college + '\'' +
                ", university='" + university + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", identity=" + identity +
                '}';
    }
}
package socialP.pojo.dao;

import java.util.Date;

public class Document {
    private Integer documentId;

    private Integer studentId;

    private Integer teamId;

    private Date createTime;

    //UNCHECKED=0
    //PASSED=1
    //UNPASSED=2
    private Integer documentStatus;

    //STUDENTDOC=student
    //TEAMAPPLY=teamApply
    //TEAMPROPOSAL=teamProposal
    //TEAMFINISHED=teamFinished
    //SUMMARY=summary
    private String documentType;

    private String documentURL;

    private String content;

    public Document(Integer documentId, Integer studentId, Integer teamId, Date createTime, Integer documentStatus, String documentType, String documentURL, String content) {
        this.documentId = documentId;
        this.studentId = studentId;
        this.teamId = teamId;
        this.createTime = createTime;
        this.documentStatus = documentStatus;
        this.documentType = documentType;
        this.documentURL = documentURL;
        this.content = content;
    }

    public Document() {
        super();
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDocumentStatus() {
        return documentStatus;
    }

    public void setDocumentStatus(Integer documentStatus) {
        this.documentStatus = documentStatus;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType == null ? null : documentType.trim();
    }

    public String getDocumentURL() {
        return documentURL;
    }

    public void setDocumentURL(String documentURL) {
        this.documentURL = documentURL == null ? null : documentURL.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentId=" + documentId +
                ", studentId=" + studentId +
                ", teamId=" + teamId +
                ", createTime=" + createTime +
                ", documentStatus=" + documentStatus +
                ", documentType='" + documentType + '\'' +
                ", documentURL='" + documentURL + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
package socialP.pojo.vo;

public class FileVo {
    private String fileURL;

    public FileVo() {
    }

    public FileVo(String fileURL) {
        this.fileURL = fileURL;
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }

    @Override
    public String toString() {
        return "FileVo{" +
                "fileURL='" + fileURL + '\'' +
                '}';
    }
}

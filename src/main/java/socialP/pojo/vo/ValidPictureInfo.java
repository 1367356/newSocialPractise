package socialP.pojo.vo;

public class ValidPictureInfo {
    private String validNumberURL;
    private String validNumber;

    public ValidPictureInfo() {
    }

    public ValidPictureInfo(String validNumberURL, String validNumber) {
        this.validNumberURL = validNumberURL;
        this.validNumber = validNumber;
    }

    public String getValidNumberURL() {
        return validNumberURL;
    }

    public void setValidNumberURL(String validNumberURL) {
        this.validNumberURL = validNumberURL;
    }

    public String getValidNumber() {
        return validNumber;
    }

    public void setValidNumber(String validNumber) {
        this.validNumber = validNumber;
    }

    @Override
    public String toString() {
        return "ValidPictureInfo{" +
                "validNumberURL='" + validNumberURL + '\'' +
                ", validNumber='" + validNumber + '\'' +
                '}';
    }
}

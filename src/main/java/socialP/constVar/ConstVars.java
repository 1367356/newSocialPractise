package socialP.constVar;

//此类用来存储所有可能用到的常量,包括数据库中的有特殊意义的数字、字符串等
public class ConstVars {
    //文档的状态
    public static DocumentStatus documentStatus;
    //文档的类型
    public static DocumentType documentType;
    //响应状态码
    public static ResponseCode responseCode;
    //响应信息
    public static ResponseMessage responseMessage;
    //用户的身份(学生/院级管理员/校级管理员)
    public static StudentIdentity studentIdentity;
    //学生在团队中的身份(管理员/普通学生)
    public static StudentIdentityInTeam studentIdentityInTeam;
    //学生在团队中的状态(待审核/未审核/通过/被删除)
    public static StudentStatus studentStatus;
    //团队的状态(待审核/未审核/通过/被删除)
    public static TeamStatus teamStatus;
    //学生/团队查询接口的查询类别
    public static SearchVoType searchVoType;

    public static void test(){

    }
}

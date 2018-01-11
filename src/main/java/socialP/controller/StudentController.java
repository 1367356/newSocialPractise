package socialP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import socialP.constVar.ResponseCode;
import socialP.constVar.ResponseMessage;
import socialP.constVar.SearchVoType;
import socialP.constVar.SessionMsg;
import socialP.pojo.vo.SearchVo;
import socialP.pojo.vo.StudentVo;
import socialP.service.StudentService;
import socialP.template.ResponseTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/socialPractise/user")
public class StudentController {

    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentService studentService;


    @ResponseBody
    @RequestMapping("/login.do")
    public ResponseTemplate login(@RequestBody StudentVo studentVo, HttpServletRequest request) {
        System.out.println(studentVo);
        /*
            1.调用接口验证信息并返回
            2.将登录信息存储到session中：
                identity;studentId
         */
        StudentVo returnValue = studentService.loginCheck(studentVo);
        //若用户名或密码错误
        if (returnValue == null)
            return new ResponseTemplate(ResponseCode.ERRORPASSWORD, ResponseMessage.ERRORPASSWORD, null);
        //若密码正确
        HttpSession session = request.getSession();
        session.setAttribute(SessionMsg.ID, returnValue.getStudentId());
        session.setAttribute(SessionMsg.IDENTITY, returnValue.getIdentity());
        return new ResponseTemplate(ResponseCode.SUCCESSCODE, ResponseMessage.SUCCECCMESSAGE, returnValue);
    }

    @ResponseBody
    @RequestMapping("/save.do")
    public ResponseTemplate save(@RequestBody StudentVo studentVo, HttpServletRequest request) {
        System.out.println(studentVo);
        /*
            调用接口判断studentId是否被注册
                若未被注册,执行以下操作：
                    调用register注册
                若已经被注册,则修改信息：
                    先验证身份是否是本人
                    调用update接口
         */
        StudentVo studentVo1 = studentService.getStudentInfoByStudentId(studentVo.getStudentId());
        //已被注册,是修改信息
        if (studentVo1 != null) {
            HttpSession session = request.getSession();
            //若未登录
            if (session.getAttribute(SessionMsg.IDENTITY) == null)
                return new ResponseTemplate(ResponseCode.ERRORCODE, ResponseMessage.ERRORMESSAGE, null);
            //若已经登录,修改信息
            StudentVo studentVo2 = studentService.update(studentVo);
            return new ResponseTemplate(ResponseCode.SUCCESSCODE, ResponseMessage.SUCCECCMESSAGE, studentVo2);
        }
        //若未被注册,注册账号
        StudentVo studentVo2 = studentService.register(studentVo);
        return new ResponseTemplate(ResponseCode.SUCCESSCODE, ResponseMessage.SUCCECCMESSAGE, studentVo2);
    }

    @ResponseBody
    @RequestMapping("/getInfo.do")
    public ResponseTemplate getInfo(@RequestBody SearchVo searchVo, HttpServletRequest request) {
        System.out.println(searchVo);
        /*
            提取type依据type判断
                若是studentId,则只能学生本人或者管理员获取
                若是college或者university,只能管理员获取
         */
        String type = searchVo.getType();

        StudentVo studentVo = null;
        List<StudentVo> studentVos = null;

        //通过studentId查信息
        if (type.equals(SearchVoType.STUDENTID)) {
            studentVo = studentService.getStudentInfoByStudentId(searchVo.getStudentId());
            return new ResponseTemplate(ResponseCode.SUCCESSCODE, ResponseMessage.SUCCECCMESSAGE, studentVo);
        }
        //通过college查询信息
        if (type.equals(SearchVoType.COLLEGE)) {
            studentVos = studentService.getStudentInfoByCollege(searchVo.getCollege());
            return new ResponseTemplate(ResponseCode.SUCCESSCODE, ResponseMessage.SUCCECCMESSAGE, studentVos);
        }
        //通过university查询信息
        if(type.equals(SearchVoType.UNIVERSITY)){
            studentVos=studentService.getStudentInfoByUniversity(searchVo.getUniversity());
            return new ResponseTemplate(ResponseCode.SUCCESSCODE, ResponseMessage.SUCCECCMESSAGE, studentVos);
        }

        return new ResponseTemplate(ResponseCode.ERRORCODE,ResponseMessage.ERRORMESSAGE,null);
    }

}

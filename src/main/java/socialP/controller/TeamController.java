package socialP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import socialP.constVar.*;
import socialP.pojo.vo.SearchVo;
import socialP.pojo.vo.TeamId;
import socialP.pojo.vo.TeamVo;
import socialP.service.TeamService;
import socialP.template.ResponseTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.List;

@Component
@RequestMapping("/socialPractise/team")
public class TeamController {

    @Autowired
    @Qualifier("teamServiceImpl")
    private TeamService teamService;

    @ResponseBody
    @RequestMapping("/saveInfo.do")
    public ResponseTemplate saveInfo(@RequestBody List<TeamVo> teamVos, HttpServletRequest request) {

        /*
            判断teamId：
                若为0：
                    新建team,调用register
                若不为0：
                    修改team信息
                    若为普通学生,只能修改自己的
                    若是管理员,可以修改
                    update
         */
        HttpSession session = request.getSession();
        Integer studentId = (Integer) session.getAttribute(SessionMsg.ID);
        Integer identity = (Integer) session.getAttribute(SessionMsg.IDENTITY);
        List<TeamVo> teamVos1 = new ArrayList<>();

        if (studentId == null)
            return new ResponseTemplate(ResponseCode.ERRORCODE, ResponseMessage.ERRORMESSAGE, null);

        //1.创建团队
        if (teamVos.size() == 1 && teamVos.get(0).getTeamId().equals(0)) {
            //本人注册团队
            if (studentId.equals(teamVos.get(0).getTeamLeaderId())) {
                teamVos1.add(teamService.register(teamVos.get(0)));
                return new ResponseTemplate(ResponseCode.SUCCESSCODE, ResponseMessage.SUCCECCMESSAGE, teamVos1);
            }
            return new ResponseTemplate(ResponseCode.ERRORCODE, ResponseMessage.ERRORMESSAGE, null);
        }


        //2.队长或者管理员修改团队信息
        if (teamVos.size() == 1 && (!teamVos.get(0).getTeamId().equals(0))) {
            //权限符合
            if (studentId.equals(teamVos.get(0).getTeamLeaderId()) ||
                    identity.equals(StudentIdentity.COLLEGEADMIN) ||
                    identity.equals(StudentIdentity.UNIVERSITYADMIN)) {
                teamVos1.add(teamService.update(teamVos.get(0)));
                return new ResponseTemplate(ResponseCode.SUCCESSCODE, ResponseMessage.SUCCECCMESSAGE, teamVos1);
            }

            return new ResponseTemplate(ResponseCode.ERRORCODE, ResponseMessage.ERRORMESSAGE, null);
        }


        //3.管理员修改信息(多个团队)
        //权限符合
        if (identity.equals(StudentIdentity.COLLEGEADMIN) ||
                identity.equals(StudentIdentity.UNIVERSITYADMIN)) {
            for (TeamVo teamVo : teamVos) {
                teamVos1.add(teamService.update(teamVo));
            }
            return new ResponseTemplate(ResponseCode.SUCCESSCODE, ResponseMessage.SUCCECCMESSAGE, teamVos1);
        }

        return new ResponseTemplate(ResponseCode.ERRORCODE, ResponseMessage.ERRORMESSAGE, null);

    }

    @ResponseBody
    @RequestMapping("/getInfo.do")
    public ResponseTemplate getInfo(@RequestBody SearchVo searchVo, HttpServletRequest request) {

        /*
            根据type选择调用,注意权限
         */
        HttpSession session = request.getSession();
        Integer studentId = (Integer) session.getAttribute(SessionMsg.ID);
        Integer identity = (Integer) session.getAttribute(SessionMsg.IDENTITY);

        if(studentId==null)
            return new ResponseTemplate(ResponseCode.ERRORCODE, ResponseMessage.ERRORMESSAGE, null);

        List<TeamVo> teamVos;
        String type=searchVo.getType();
        if(type.equals(SearchVoType.STUDENTID)){
            teamVos= teamService.getTeamInfoByStudentId(searchVo.getStudentId());
            return new ResponseTemplate(ResponseCode.SUCCESSCODE,ResponseMessage.SUCCECCMESSAGE,teamVos);
        }

        if(type.equals(SearchVoType.COLLEGE)){
            teamVos=teamService.getTeamInfoByCollege(searchVo.getCollege());
            return new ResponseTemplate(ResponseCode.SUCCESSCODE,ResponseMessage.SUCCECCMESSAGE,teamVos);
        }

        return new ResponseTemplate(ResponseCode.ERRORCODE, ResponseMessage.ERRORMESSAGE, null);
    }

    @ResponseBody
    @RequestMapping("/delete.do")
    public ResponseTemplate delete(@RequestBody SearchVo searchVo, HttpServletRequest request) {

        /*
            update
         */
        HttpSession session = request.getSession();
        Integer studentId = (Integer) session.getAttribute(SessionMsg.ID);
        Integer identity = (Integer) session.getAttribute(SessionMsg.IDENTITY);

        if(!(identity.equals(StudentIdentity.COLLEGEADMIN)||identity.equals(StudentIdentity.UNIVERSITYADMIN)))
            return new ResponseTemplate(ResponseCode.ERRORCODE, ResponseMessage.ERRORMESSAGE, null);

        List<TeamVo> teamVos=new ArrayList<>();

        for(TeamId teamId: searchVo.getTeamIds()){
            TeamVo teamVo=new TeamVo();
            teamVo.setTeamId(teamId.getTeamId());
            teamVo.setTeamStatus(TeamStatus.DELETED);
            teamVos.add(teamService.update(teamVo));
        }
        return new ResponseTemplate(ResponseCode.SUCCESSCODE,ResponseMessage.SUCCECCMESSAGE,teamVos);
    }


}

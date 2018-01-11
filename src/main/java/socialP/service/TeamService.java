package socialP.service;

import socialP.pojo.vo.TeamVo;

import java.util.List;

public interface TeamService {

    //注册团队
    public TeamVo register(TeamVo teamVo);

    //保存团队信息
    public TeamVo update(TeamVo teamVo);

    //依据studentId获取其加入的团队的信息
    public List<TeamVo> getTeamInfoByStudentId(Integer studentId);

    //依据college获取学院下的所有团队
    public List<TeamVo> getTeamInfoByCollege(String college);

}

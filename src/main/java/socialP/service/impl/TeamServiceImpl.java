package socialP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import socialP.dao.TeamMapper;
import socialP.dao.TeamStudentMapper;
import socialP.pojo.dao.Team;
import socialP.pojo.dao.TeamStudent;
import socialP.pojo.vo.TeamVo;
import socialP.service.TeamService;
import socialP.utils.transform.TeamUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeamServiceImpl implements TeamService {

    @Autowired
    @Qualifier("teamMapper")
    private TeamMapper teamMapper;

    @Autowired
    @Qualifier("teamStudentMapper")
    private TeamStudentMapper teamStudentMapper;


    @Override
    public TeamVo register(TeamVo teamVo) {
        Team team = new Team();
        List<TeamStudent> teamStudents = new ArrayList<>();

        TeamUtils.voToDao(teamVo, team, teamStudents);


        Team team1 = null;
        List<TeamStudent> teamStudents1 = null;
        TeamVo teamVo1=new TeamVo();


        teamMapper.insert(team);
        for(TeamStudent teamStudent:teamStudents)
            teamStudentMapper.insert(teamStudent);

        team1=teamMapper.selectByPrimaryKey(team.getTeamId());
        teamStudents1=teamStudentMapper.selectByTeamId(team.getTeamId());
        TeamUtils.daoToVo(teamVo1,team1,teamStudents1);

        return teamVo1;
    }

    @Override
    public TeamVo update(TeamVo teamVo) {
        Team team = new Team();
        List<TeamStudent> teamStudents = new ArrayList<>();

        TeamUtils.voToDao(teamVo, team, teamStudents);


        Team team1 = null;
        List<TeamStudent> teamStudents1 = null;
        TeamVo teamVo1=new TeamVo();


        teamMapper.updateByPrimaryKeySelective(team);
        for(TeamStudent teamStudent:teamStudents)
            teamStudentMapper.updateByTeamIdAndStudentIdSelective(teamStudent);

        team1=teamMapper.selectByPrimaryKey(team.getTeamId());
        teamStudents1=teamStudentMapper.selectByTeamId(team.getTeamId());

        TeamUtils.daoToVo(teamVo1,team1,teamStudents1);

        return teamVo1;
    }

    @Override
    public List<TeamVo> getTeamInfoByStudentId(Integer studentId) {
        List<TeamStudent> teamStudents=teamStudentMapper.selectByStudentId(studentId);
        List<TeamVo> teamVos=new ArrayList<>();

        for(TeamStudent teamStudent:teamStudents){

            Team team1 = null;
            List<TeamStudent> teamStudents1 = null;
            TeamVo teamVo1=new TeamVo();

            team1=teamMapper.selectByPrimaryKey(teamStudent.getTeamId());
            teamStudents1=teamStudentMapper.selectByTeamId(teamStudent.getTeamId());

            TeamUtils.daoToVo(teamVo1,team1,teamStudents1);

            teamVos.add(teamVo1);
        }

        return teamVos;
    }

    @Override
    public List<TeamVo> getTeamInfoByCollege(String college) {
        List<Team> teams=teamMapper.selectByCollege(college);
        List<TeamVo> teamVos=new ArrayList<>();

        for(Team team:teams){

            Team team1 = null;
            List<TeamStudent> teamStudents1 = null;
            TeamVo teamVo1=new TeamVo();

            team1=teamMapper.selectByPrimaryKey(team.getTeamId());
            teamStudents1=teamStudentMapper.selectByTeamId(team.getTeamId());

            TeamUtils.daoToVo(teamVo1,team1,teamStudents1);

            teamVos.add(teamVo1);
        }

        return teamVos;
    }
}

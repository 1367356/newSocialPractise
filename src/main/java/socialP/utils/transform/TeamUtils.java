package socialP.utils.transform;

import socialP.constVar.StudentIdentityInTeam;
import socialP.constVar.StudentStatus;
import socialP.pojo.dao.Team;
import socialP.pojo.dao.TeamStudent;
import socialP.pojo.vo.TeamAdminVo;
import socialP.pojo.vo.TeamStudentVo;
import socialP.pojo.vo.TeamVo;

import java.util.ArrayList;
import java.util.List;

public class TeamUtils {

    public static boolean voToDao(TeamVo teamVo, Team team, List<TeamStudent> teamStudents) {
        team.setTeamId(teamVo.getTeamId());
        team.setTeamName(teamVo.getTeamName());
        team.setTeamLeaderId(teamVo.getTeamLeaderId());
        team.setIntroduction(teamVo.getIntroduction());
        team.setImageURL(teamVo.getImageURL());
        team.setSimpleImageURL(teamVo.getSimpleImageURL());
        team.setCollege(teamVo.getCollege());
        team.setUniversity(teamVo.getUniversity());

        //设置队员身份
        for (TeamAdminVo teamAdminVo:teamVo.getTeamAdmin()){
            TeamStudent teamStudent=new TeamStudent();

            teamStudent.setStudentId(teamAdminVo.getStudentId());//studentId
            teamStudent.setTeamId(teamVo.getTeamId());//teamId
            teamStudent.setStudentIdentity(teamAdminVo.getStudentIdentityInTeam());//设置队员身份

            teamStudents.add(teamStudent);
        }
        //设置队员状态
        for (TeamStudentVo teamStudentVo:teamVo.getTeamStudent()){
            TeamStudent teamStudent=new TeamStudent();
            teamStudent.setStudentId(teamStudentVo.getStudentId());//studentId
            teamStudent.setTeamId(teamVo.getTeamId());//teamId
            teamStudent.setStudentStatus(teamStudentVo.getStudentStatus());//设置状态

            teamStudents.add(teamStudent);
        }


        return true;
    }

    public static boolean daoToVo(TeamVo teamVo, Team team,List<TeamStudent> teamStudents) {
        teamVo.setTeamId(team.getTeamId());
        teamVo.setTeamName(team.getTeamName());
        teamVo.setTeamLeaderId(team.getTeamLeaderId());
        teamVo.setIntroduction(team.getIntroduction());
        teamVo.setImageURL(team.getImageURL());
        teamVo.setSimpleImageURL(team.getSimpleImageURL());
        teamVo.setCollege(team.getCollege());
        teamVo.setUniversity(team.getUniversity());


        List<TeamAdminVo> teamAdminVoList=new ArrayList<>();
        List<TeamStudentVo> teamStudentVoList=new ArrayList<>();

        //管理员
        for (TeamStudent teamStudent:teamStudents){
            if(teamStudent.getStudentIdentity().equals(StudentIdentityInTeam.TEAMADMIN)){
                teamAdminVoList.add(new TeamAdminVo(teamStudent.getStudentId(),teamStudent.getStudentIdentity()));
            }
        }

        //队员
        for(TeamStudent teamStudent:teamStudents){
            teamStudentVoList.add(new TeamStudentVo(teamStudent.getStudentId(),teamStudent.getStudentStatus()));
        }

        teamVo.setTeamAdmin(teamAdminVoList);
        teamVo.setTeamStudent(teamStudentVoList);

        return true;
    }



    public static void main(String[] args) {
        TeamVo teamVo=new TeamVo();
        Team team=new Team();
        List<TeamStudent> teamStudents=new ArrayList<>();

        List<TeamAdminVo> teamAdminVoList=new ArrayList<>();
        teamAdminVoList.add(new TeamAdminVo(1,StudentIdentityInTeam.STUDENT));
        teamAdminVoList.add(new TeamAdminVo(2,StudentIdentityInTeam.TEAMADMIN));
        teamAdminVoList.add(new TeamAdminVo(3,StudentIdentityInTeam.TEAMADMIN));

        List<TeamStudentVo> teamStudentVoList=new ArrayList<>();
        teamStudentVoList.add(new TeamStudentVo(3, StudentStatus.UNCHECKED));
        teamStudentVoList.add(new TeamStudentVo(4, StudentStatus.UNCHECKED));
        teamStudentVoList.add(new TeamStudentVo(5, StudentStatus.PASSED));
        teamStudentVoList.add(new TeamStudentVo(6, StudentStatus.UNPASSED));

        teamVo.setTeamId(20);
        teamVo.setTeamName("电子科技大学");
        teamVo.setTeamAdmin(teamAdminVoList);
        teamVo.setTeamStudent(teamStudentVoList);

        TeamUtils.voToDao(teamVo,team,teamStudents);

        System.out.println(team);
        System.out.println(teamStudents);


        //After
        TeamVo teamVoAfter=new TeamVo();
        Team teamAfter=new Team();
        List<TeamStudent> teamStudentListAfter=new ArrayList<>();

        teamAfter.setTeamId(10);
        teamAfter.setTeamName("电子科技大学");
        teamStudentListAfter.add(new TeamStudent(1,10,StudentStatus.UNCHECKED,StudentIdentityInTeam.STUDENT));
        teamStudentListAfter.add(new TeamStudent(2,10,StudentStatus.PASSED,StudentIdentityInTeam.STUDENT));
        teamStudentListAfter.add(new TeamStudent(3,10,StudentStatus.PASSED,StudentIdentityInTeam.TEAMADMIN));
        teamStudentListAfter.add(new TeamStudent(4,10,StudentStatus.PASSED,StudentIdentityInTeam.TEAMADMIN));



        TeamUtils.daoToVo(teamVoAfter,teamAfter,teamStudentListAfter);
        System.out.println(teamVoAfter);

    }
}

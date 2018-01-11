package socialP.dao;

import org.springframework.stereotype.Component;
import socialP.pojo.dao.TeamStudent;

import java.util.List;

@Component
public interface TeamStudentMapper {
    int insert(TeamStudent record);

    int insertSelective(TeamStudent record);


    //根据teamId查询出所有teamStudent信息
    List<TeamStudent> selectByTeamId(Integer teamId);

    //根据studentId查询出所有teamStudent信息
    List<TeamStudent> selectByStudentId(Integer studentId);


    //根据teamId和studentId selective更新
    List<TeamStudent> updateByTeamIdAndStudentIdSelective(TeamStudent teamStudent);

}
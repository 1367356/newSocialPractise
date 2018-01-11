package socialP.dao;

import org.springframework.stereotype.Component;
import socialP.pojo.dao.Team;

import java.util.List;

@Component
public interface TeamMapper {
    int deleteByPrimaryKey(Integer teamId);

    int insert(Team record);//返回主键

    int insertSelective(Team record);

    Team selectByPrimaryKey(Integer teamId);

    int updateByPrimaryKeySelective(Team record);

    int updateByPrimaryKey(Team record);


    //依据college查询团队信息
    List<Team> selectByCollege(String college);
}
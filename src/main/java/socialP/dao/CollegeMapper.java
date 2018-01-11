package socialP.dao;

import org.springframework.stereotype.Component;
import socialP.pojo.dao.College;

import java.util.List;

@Component
public interface CollegeMapper {
    int deleteByPrimaryKey(Integer collegeId);

    int insert(College record);

    int insertSelective(College record);

    College selectByPrimaryKey(Integer collegeId);

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);

    //通过universityId筛选college
    List<College> selectByUniversityId(Integer universityId);
}
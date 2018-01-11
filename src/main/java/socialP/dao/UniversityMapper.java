package socialP.dao;

import org.springframework.stereotype.Component;
import socialP.pojo.dao.University;

@Component
public interface UniversityMapper {
    int deleteByPrimaryKey(Integer universityId);

    int insert(University record);

    int insertSelective(University record);

    University selectByPrimaryKey(Integer universityId);

    int updateByPrimaryKeySelective(University record);

    int updateByPrimaryKey(University record);
}
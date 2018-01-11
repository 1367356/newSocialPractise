package socialP.dao;

import org.springframework.stereotype.Component;
import socialP.pojo.dao.Student;
import socialP.pojo.vo.StudentVo;

import java.util.List;

@Component
public interface StudentMapper {
    int deleteByPrimaryKey(Integer studentId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);


    //依据college查询学生信息,返回List<Student>
    List<StudentVo> selectByCollege(String college);

    //依据university查询学生信息,返回List<Student>
    List<StudentVo> selectByUniversity(String university);

}
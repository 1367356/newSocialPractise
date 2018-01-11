package socialP.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import socialP.dao.StudentMapper;
import socialP.pojo.dao.Student;
import socialP.pojo.vo.StudentVo;
import socialP.service.StudentService;
import socialP.utils.transform.StudentUtils;

import java.util.List;

@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    @Qualifier("studentMapper")
    private StudentMapper studentMapper;


    @Override
    public StudentVo loginCheck(StudentVo studentVo) {

        Student student = studentMapper.selectByPrimaryKey(studentVo.getStudentId());
        //check成功
        if (StringUtils.equals(student.getPassword(), studentVo.getPassword())) {
            StudentVo studentVo1 = new StudentVo();
            student.setPassword(null);

            StudentUtils.daoToVo(studentVo, student);
            return studentVo1;
        }
        //失败
        return null;
    }

    @Override
    public StudentVo register(StudentVo studentVo) {
        Student student = new Student();
        StudentUtils.voToDao(studentVo, student);

        //注册
        studentMapper.insert(student);

        //查询刚注册的信息
        Student student1 = studentMapper.selectByPrimaryKey(student.getStudentId());
        student1.setPassword(null);
        StudentVo studentVo1 = new StudentVo();
        StudentUtils.daoToVo(studentVo1, student1);

        return studentVo1;
    }

    @Override
    public StudentVo update(StudentVo studentVo) {
        Student student = new Student();
        StudentUtils.voToDao(studentVo, student);

        //update
        studentMapper.updateByPrimaryKeySelective(student);

        //查询刚修改的信息
        Student student1 = studentMapper.selectByPrimaryKey(student.getStudentId());
        student1.setPassword(null);
        StudentVo studentVo1 = new StudentVo();
        StudentUtils.daoToVo(studentVo1, student1);

        return studentVo1;
    }

    @Override
    public StudentVo getStudentInfoByStudentId(int studentId) {
        Student student = studentMapper.selectByPrimaryKey(studentId);
        //studentId不存在
        if (student == null)
            return null;

        //studentId存在
        StudentVo studentVo = new StudentVo();
        student.setPassword(null);
        StudentUtils.daoToVo(studentVo, student);
        return studentVo;
    }

    @Override
    public List<StudentVo> getStudentInfoByCollege(String college) {

        List<StudentVo> studentVos = studentMapper.selectByCollege(college);

        return studentVos;
    }

    @Override
    public List<StudentVo> getStudentInfoByUniversity(String university) {
        List<StudentVo> studentVos = studentMapper.selectByUniversity(university);
        return studentVos;
    }
}

package socialP.utils.transform;

import socialP.pojo.dao.Student;
import socialP.pojo.vo.StudentVo;

public class StudentUtils {

    public static boolean voToDao(StudentVo studentVo, Student student){
        student.setPassword(studentVo.getPassword());
        student.setCollege(studentVo.getCollege());
        student.setEmail(studentVo.getEmail());
        student.setIdentity(studentVo.getIdentity());
        student.setImageURL(studentVo.getImageURL());
        student.setStudentId(studentVo.getStudentId());
        student.setStudentName(studentVo.getStudentName());
        student.setTelephone(studentVo.getTelephone());
        student.setUniversity(studentVo.getUniversity());
        return true;
    }

    public static boolean daoToVo(StudentVo studentVo, Student student){
        studentVo.setPassword(student.getPassword());
        studentVo.setCollege(student.getCollege());
        studentVo.setEmail(student.getEmail());
        studentVo.setIdentity(student.getIdentity());
        studentVo.setImageURL(student.getImageURL());
        studentVo.setStudentId(student.getStudentId());
        studentVo.setStudentName(student.getStudentName());
        studentVo.setTelephone(student.getTelephone());
        studentVo.setUniversity(student.getUniversity());
        return true;
    }
}

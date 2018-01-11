package socialP.service;

import socialP.pojo.vo.StudentVo;

import java.util.List;

public interface StudentService {

    //根据传入的类的studentId和password判断是否正确
        //若正确返回登陆者的信息(password需置空)
        //若错误返回null
    public StudentVo loginCheck(StudentVo studentVo);


//    //根据传入的studentId获取数据库中信息的条数并返回
//    public int registerCheck(StudentVo studentVo);


    //注册学生信息(无需验证账号是否存在,此过程会在controller完成)
    //返回注册信息(password置空)
    public StudentVo register(StudentVo studentVo);


    //修改信息,依据主键
    //返回修改后的信息
    public StudentVo update(StudentVo studentVo);


    //通过studentId获取学生信息
    public StudentVo getStudentInfoByStudentId(int studentId);


    //通过college或者university获取学生信息
    public List<StudentVo> getStudentInfoByCollege(String college);
    public List<StudentVo> getStudentInfoByUniversity(String university);
}

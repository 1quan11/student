package cn.nnxy.testserver.service;


import cn.nnxy.testserver.entity.Student;

import java.util.List;

/**
 * @author huangjianquan
 * @date 2022/9/2
 **/
public interface StudentService {

    //根据学号查询学生信息
    Student queryByNo(String stuno);

    //查询所有学生信息
    List<Student> getAll();

    //修改学生信息
    int updateStu(Student student);

    //删除学生信息
    int deleteById(String stuno);

    //增加学生信息
    int insert(Student student);

    //根据姓名模糊查询
    List<Student> queryByName(String name);
}

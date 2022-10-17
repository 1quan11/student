package cn.nnxy.testserver.service.impl;

import cn.nnxy.testserver.entity.Student;
import cn.nnxy.testserver.mapper.StudentMapper;
import cn.nnxy.testserver.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huangjianquan
 * @date 2022/9/2
 **/
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public Student queryByNo(String stuno) {
        return studentMapper.queryByNo(stuno);
    }

    @Override
    public List<Student> getAll() {
        return studentMapper.getAll();
    }

    @Override
    public int updateStu(Student student) {
        return studentMapper.updateStu(student);
    }

    @Override
    public int deleteById(String stuno) {
        return studentMapper.deleteById(stuno);
    }

    @Override
    public int insert(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public List<Student> queryByName(String name) {
        return studentMapper.queryByName(name);
    }
}

package cn.nnxy.student.saervice.impl;

import cn.nnxy.student.entity.Student;
import cn.nnxy.student.mapper.StudentMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author huangjianquan
 * @date 2022/4/9
 **/
@Service
@CacheConfig(cacheNames = "student")
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements StudentService {

    /**********注入*********/
    @Autowired
    private StudentMapper studentMapper;

    /*********获取学生信息*****
    @Cacheable(value = "student", key = "#studentId", unless = "#result == null")
    @Override
    public Student getStuById(Integer studentId) {
        if (null == studentId) {
            return null;
        }
        return studentMapper.getStuById(studentId);

    }

    *//*更新学生信息*//*
    @CachePut(value = "student", key = "#student.id")
    @Override
    public Student updateStu(Student student) {
        if (null == student || null == student.getId()) {
            return null;
        }
        Student oldStudent = studentMapper.getStuById(student.getId());
        if (null == student) {
            return null;
        }
        student.setGender(student.getGender());
        student.setStuid(student.getStuid());
        int num = studentMapper.updateStu(student);

        if (num == 1) {
            return oldStudent;
        }
        return null;
    }

    *//**********删除学生信息*********//*
    @CacheEvict(value = "student", key = "#studentId" , allEntries = true)
    @Override
    public int deleteStuById(Integer studentId) {
        if (null == studentId) {
            return 0;
        }
        return studentMapper.deleteStuById(studentId);
    }

    *//***********添加学生信息*********//*
    @Override
    public Student addStu(Student student) {
        if (null == student.getId()) {
            return null;
        }
        int number = studentMapper.addStu(student);
        if (1 == number) {
            return student;
        }
        return null;
    }*/

    @Override
    public IPage<Student> selectStudentinfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            //根据供应商名称精确查询
            queryWrapper.eq("sname",param);
        }
        Page<Student> page = new Page<>(pageNum,pageSize);
        return studentMapper.selectPage(page,queryWrapper);
    }
}

package cn.nnxy.student.saervice.impl;

import cn.nnxy.student.entity.Student;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author huangjianquan
 * @date 2022/4/9
 **/
public interface StudentService extends IService<Student> {

  /*  Student getStuById(Integer studentId);
    public IPage<Studentinfo> getStuById(int pageNum, int pageSize, String param);

    Student updateStu(Student student);

    int deleteStuById(Integer studentId);

    Student addStu(Student student);*/
    /**
     * 分页查询账单信息数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-账单信息名称
     * @return
     */
    public IPage<Student> selectStudentinfoPage(int pageNum, int pageSize, String param);
}

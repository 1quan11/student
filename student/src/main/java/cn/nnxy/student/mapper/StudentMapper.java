package cn.nnxy.student.mapper;

import cn.nnxy.student.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author huangjianquan
 * @date 2022/4/9
 **/
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

   /* Student getStuById(Integer studentId);
    public IPage<Studentinfo> getStuById(int pageNum, int pageSize, String param);

    int updateStu(Student student);

    int deleteStuById(Integer studentId);

    int addStu(Student student);
*/
}

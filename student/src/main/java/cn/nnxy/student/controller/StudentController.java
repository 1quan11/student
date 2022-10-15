package cn.nnxy.student.controller;

import cn.nnxy.student.common.ResultMapUtil;
import cn.nnxy.student.entity.Student;
import cn.nnxy.student.common.ResultMapUtil;
import cn.nnxy.student.saervice.impl.StudentService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author huangjianquan
 * @date 2022/4/9
 **/
@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**********查询学生信息************/
    /*@RequestMapping("/index")
    @ResponseBody
    public String index() {

        return "/index";

    }*/
    /*@GetMapping("getStu/{studentId}")
    public Student getStuById(@PathVariable("studentId") Integer studentId) {
        if (null == studentId) {
            return null;
        }
        return studentService.getStuById(studentId);
    }*/
    @RequestMapping
    public String studentinfo(){
        return "/index";
    }
    @RequestMapping(value = "/studentinfoQueryPage")
    @ResponseBody
    public Object studentinfoQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        try{
            IPage<Student> iPage = studentService.selectStudentinfoPage(pageNum,pageSize,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
}

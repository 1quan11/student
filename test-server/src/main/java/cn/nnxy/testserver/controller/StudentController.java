package cn.nnxy.testserver.controller;

import cn.nnxy.testserver.entity.Student;
import cn.nnxy.testserver.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author huangjianquan
 * @date 2022/9/2
 **/
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 根据id查询学生信息
     * @param stuno
     * @return
     */
    @RequestMapping(value = "/getQueryByNo/{stuno}")
    @ResponseBody
    public Student getQueryByNo(@PathVariable("stuno") String stuno) {
        Student student = studentService.queryByNo(stuno);
        System.out.println(student.toString());
        return student;
    }

    /**
     * 查询所有学生信息
     * @return
     */
    @RequestMapping("getAll")
    @ResponseBody
    public List<Student> getAll() {
        List<Student> list = studentService.getAll();
        return list;
    }

    /**
     * 添加学生信息
     * @return
     */
    @RequestMapping("addStudent")
    @ResponseBody
    public String addStudent() {
        Student student = new Student();
        student.setStuno("999");
        student.setName("泉帅");
        student.setMajor("物联网工程");
        int i = studentService.insert(student);
        if (i == 1) {
            return "添加成功！";
        }else {
            return "添加失败！";
        }
    }

    /**
     * 删除学生信息
     * @param stuno
     * @return
     */
    @RequestMapping("/deleteStudentById/{stuno}")
    @ResponseBody
    public String deleteStudentById(@PathVariable("stuno") String stuno) {
        int i = studentService.deleteById(stuno);
        if (i == 1) {
            return "删除成功！";
        }else {
            return "删除失败！";
        }
    }

    /**
     * 修改学生信息
     * @return
     */
    @RequestMapping("editStudent")
    @ResponseBody
    public String editStudent() {
        Student student = new Student();
        student.setStuno("999");
        student.setName("泉帅999");
        student.setMajor("物联网工程");
        int i = studentService.updateStu(student);
        if (i == 1) {
            return "修改成功！";
        }else {
            return "修改失败！";
        }
    }

    /**
     * 根据姓名模糊查询
     * @param name
     * @return
     */
    @RequestMapping("/queryByName/{name}")
    @ResponseBody
    public List<Student> queryByName(@PathVariable("name") String name) {
        List<Student> list = studentService.queryByName(name);
        return list;
    }

}

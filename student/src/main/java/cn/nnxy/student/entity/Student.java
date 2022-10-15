package cn.nnxy.student.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huangjianquan
 * @date 2022/4/9
 **/
@Data
@TableName(value = "studentinfo")
public class Student implements Serializable {

    private Integer id;
    private String name;
    private String gender;
    private String stuid;
    private String phone;
    private String email;
    private Date birthday;
    private String major;
}

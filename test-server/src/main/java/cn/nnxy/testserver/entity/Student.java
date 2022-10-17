package cn.nnxy.testserver.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author huangjianquan
 * @date 2022/9/8
 **/
@Data
public class Student {

    private Integer id;
    private String stuno;
    private String name;
    private String major;
}

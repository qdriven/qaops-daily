package io.qdriven.qaopsdaily.upms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author MrBird
 */
@Data
@TableName("test_table")
public class Test implements Serializable {

    private static final long serialVersionUID = -2510534697977648681L;
    private String name;
    private int age;

}

package io.qdriven.qaopsdaily.upms.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author MrBird
 */
@Data
@TableName("t_user_data_permission")
public class UserDataPermission {

    @TableField("USER_ID")
    private Long userId;
    @TableField("DEPT_ID")
    private Long deptId;

}
package io.qdriven.qaopsdaily.upms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Patrick
 */
@Data
@TableName("deptartments")
//@Excel("部门信息表")
public class Dept implements Serializable {

    public static final Long TOP_NODE = 0L;
    private static final long serialVersionUID = 5702271568363798328L;
    /**
     * 部门 ID
     */
    @TableId(value = "DEPT_ID", type = IdType.AUTO)
    private Long deptId;

    /**
     * 上级部门 ID
     */
    @TableField("PARENT_ID")
    private Long parentId;

    /**
     * 部门名称
     */
    @TableField("DEPT_NAME")
    @NotBlank(message = "{required}")
    @Size(max = 10, message = "{noMoreThan}")
//    @ExcelField(value = "部门名称")
    private String deptName;

    /**
     * 排序
     */
    @TableField("ORDER_NUM")
    private Long orderNum;

    /**
     * 创建时间
     */
    @TableField("created_time")
//    @ExcelField(value = "创建时间", writeConverter = TimeConverter.class)
    private Date createTime;

    @TableField("updated_TIME")
//    @ExcelField(value = "修改时间", writeConverter = TimeConverter.class)
    private Date modifyTime;

}

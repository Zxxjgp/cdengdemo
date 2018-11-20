package com.vedeng.message.demo.easypoi;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.controller2
 * @ClassName: TeacherEntity
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/9/29 9:04
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/9/29 9:04
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Data
@ExcelTarget("teacherEntity")
public class TeacherEntity implements Serializable {
    @Excel(name = "我是新增列", orderNum = "1", width = 25, needMerge = true )
    private String name;

    public TeacherEntity(String name) {
        this.name = name;
    }
}

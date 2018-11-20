package com.vedeng.message.demo.easypoi;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.util.Date;

@Data
@ExcelTarget("studentEntity")
public class StudentEntity implements java.io.Serializable {
    /**
     * id
     */
    private String        id;
    /**
     * 学生姓名
     */
    @Excel(name = "学生姓名", height = 20, width = 30, isImportField = "true_st" , needMerge = true)
    private String        name;
    /**
     * 学生性别
     */
    @Excel(name = "学生性别", replace = { "男_1", "女_2" }, suffix = "生", isImportField = "true_st" , needMerge = true)
    private int           sex;

    @Excel(name = "出生日期", databaseFormat = "yyyyMMdd", format = "yyyy-MM-dd", isImportField = "true_st", width = 20 , needMerge = true)
    private Date birthday;

    @Excel(name = "进校日期", databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd")
    private Date registrationDate;



    public StudentEntity(String id, String name, int sex, Date birthday ) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;

    }
}
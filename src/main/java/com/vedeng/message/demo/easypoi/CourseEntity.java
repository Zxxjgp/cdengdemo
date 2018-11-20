package com.vedeng.message.demo.easypoi;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.util.List;

@Data
@ExcelTarget("courseEntity")
 public class CourseEntity implements java.io.Serializable {
    /** 主键 */
    private String        id;
    /** 课程名称 */


    @Excel(name = "课程名称", orderNum = "1", width = 25 , needMerge = true  )
    private String        name;



    @Excel(name = "任课老师", orderNum = "1", width = 25, needMerge = true )
    private String mathTeacher;


   @Excel(name = "课程图片", type = 2 ,width = 25 ,imageType = 1 , needMerge = true)
   private String  companyLogo;

    @ExcelCollection(name = "学生", orderNum = "4")
    private List<StudentEntity> students;

    @ExcelEntity(id = "absent")
    private TeacherEntity teacherEntity;


   public CourseEntity(String id, String name, String mathTeacher, List<StudentEntity> students) {
      this.id = id;
      this.name = name;
      this.mathTeacher = mathTeacher;
      this.students = students;
   }


}
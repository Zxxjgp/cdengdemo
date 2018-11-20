package com.vedeng.message.demo.easypoi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.vedeng.message.demo.utils.EasyPoiUtil;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 功能描述
 * className
 *
 * @author Bert
 * @date 2018/11/17 15:50
 * @Description //TODO
 * @version: 1.0
 */
public class EasyTest {
    public static void main(String[] args) throws IOException {
        HttpServletResponse response = null;
        List<CourseEntity> listss = new ArrayList<>();
        List<StudentEntity> list = new ArrayList<>();

        StudentEntity s1 =  new StudentEntity("1","王江明",1,new Date());
        StudentEntity s2 =  new StudentEntity("2","王江明",1,new Date());
        list.add(s1);
        list.add(s2);
        CourseEntity l = new CourseEntity("1","翠花", "小强" , list);

        CourseEntity ll = new CourseEntity("2","翠花", "小强" , list);
        ll.setTeacherEntity(new TeacherEntity("我是错管"));
        listss.add(l);
        listss.add(ll);
        ExportParams exportParams = new ExportParams("计算机一班学生", "学生");

        EasyPoiUtil.exportExcel( listss,"江苏华生基因", "2", CourseEntity.class, "11111", true,response);

    }
}

package com.vedeng.message.demo.testeasy;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;

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
 * @date 2018/11/17 16:08
 * @Description //TODO
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) throws IOException {
        List<StudentEntity> list = new ArrayList<>();
        StudentEntity  studentEntity= new StudentEntity("wew","ewqe",2, new Date(),new Date());
        list.add(studentEntity);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生"),
                StudentEntity .class, list);
        FileOutputStream f = new FileOutputStream("D:/excel/werew.xls");
        f.close();
    }
}

package com.vedeng.message.demo.easypoi;

import cn.afterturn.easypoi.entity.ImageEntity;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.controller2
 * @ClassName: TestOne
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/9/29 10:40
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/9/29 10:40
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class TestOne {


    public static void main(String[] args) throws IOException {
        TemplateExportParams params = new TemplateExportParams(
                "doc/exportTemp_image.xlsx", true);
        Map<String, Object> map = new HashMap<String, Object>();
        // sheet 2
        map.put("month", 10);
        Map<String, Object> temp;
        for (int i = 1; i < 8; i++) {
            temp = new HashMap<String, Object>();
            temp.put("per", i * 10);
            temp.put("mon", i * 1000);
            temp.put("summon", i * 10000);
            ImageEntity image = new ImageEntity();
            image.setHeight(200);
            image.setWidth(500);
            image.setRowspan(4);
            image.setColspan(2);
            image.setUrl("imgs/company/baidu.png");
            temp.put("image", image);
            map.put("i" + i, temp);
        }
        Workbook book = ExcelExportUtil.exportExcel(params, map);
        File savefile = new File("D:/excel/");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("D:/excel/exportTemp_image_span.xlsx");
        book.write(fos);
        fos.close();
    }
}

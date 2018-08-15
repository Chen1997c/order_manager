package com.blank.util;

import com.blank.entity.Dish;
import org.apache.poi.hssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.util.List;

/**
 * <p>
 * 功能描述:导出菜品工具类
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.13
 */
public class ExportDishes {

    /**
     * 导出到Excel
     *
     * @param response
     * @param dishes
     */
    public static void exportDishes(HttpServletResponse response, List<Dish> dishes) {
        response.setContentType("application/binary;charset=UTF-8");
        try {
            String fileName = new String("dish-INF".getBytes(), "UTF-8");
            response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xls");
            String[] titles = {"菜品id", "菜名", "价格", "是否推荐", "描述", "详情"};

            // 创建一个workbook，对应一个Excel文件
            HSSFWorkbook workbook = new HSSFWorkbook();

            // 在webbook中添加一个sheet,对应Excel文件中的sheet
            HSSFSheet hssfSheet = workbook.createSheet("sheet1");

            // 在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
            HSSFRow hssfRow = hssfSheet.createRow(0);

            // 创建单元格，并设置值表头
            HSSFCellStyle hssfCellStyle = workbook.createCellStyle();

            HSSFCell hssfCell = null;
            for (int i = 0; i < titles.length; i++) {
                hssfCell = hssfRow.createCell(i);//列索引从0开始
                hssfCell.setCellValue(titles[i]);//列名1
                hssfCell.setCellStyle(hssfCellStyle);//列居中显示

            }

            //写入实体数据
            if (dishes != null && !dishes.isEmpty()) {
                for (int i = 0; i < dishes.size(); i++) {
                    hssfRow = hssfSheet.createRow(i + 1);
                    Dish dish = dishes.get(i);

                    // 创建单元格，并设置值
                    hssfRow.createCell(0).setCellValue(dish.getD_id());
                    hssfRow.createCell(1).setCellValue(dish.getD_name());
                    hssfRow.createCell(2).setCellValue(dish.getD_price());
                    hssfRow.createCell(3).setCellValue(dish.getD_isGood());
                    hssfRow.createCell(4).setCellValue(dish.getD_description());
                    hssfRow.createCell(5).setCellValue(dish.getD_txt());
                }
            }

            // 第七步，将文件输出到客户端浏览器
            try {
                FileOutputStream fileOutputStream = new FileOutputStream("C:/dish-INF.xls");//指定路径与名字和格式
                workbook.write(fileOutputStream);//将数据写出去
                // fileOutputStream.close();//关闭输出流
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

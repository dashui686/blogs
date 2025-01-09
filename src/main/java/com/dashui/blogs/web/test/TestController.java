package com.dashui.blogs.web.test;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

@RestController
@RequestMapping("/test")
public class TestController {



    @GetMapping("exportTest")
    public void exportTest(HttpServletResponse response) throws IOException {
        // Prepare the response to send the image
        response.reset();
        response.setContentType("image/png");  // Set content type as image
        response.setCharacterEncoding("utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.setHeader("Access-Control-Expose-Headers", "Content-disposition");

        // Set file name for the image
        String fileName = "excel_to_image.png";
        response.setHeader("Content-Disposition", "attachment; fileName=" + URLEncoder.encode(fileName, "utf-8"));

        // Step 1: Read Excel template into memory
        try (InputStream resourceAsStream = this.getClass().getResourceAsStream("/templates/sales.xlsx");
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

            // Step 2: Copy the template into byte array stream
            byte[] buffer = new byte[1024];
            int length;
            while ((length = resourceAsStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, length);
            }
            byte[] excelTemplateData = byteArrayOutputStream.toByteArray();

            // Step 3: Create data for the Excel
            ArrayList<HashMap<String, Object>> hashMaps = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("userName", "张三");
                map.put("area", "颛桥");
                map.put("salesRank", "1");
                map.put("todaySale", "50");
                map.put("salesTotal", "1000");
                map.put("distributionRank", "1");
                map.put("todayDistribution", "50");
                map.put("distributionTotal", "10000");
                hashMaps.add(map);
            }

            // Step 4: Write Excel content to response output stream using EasyExcel
            try (ServletOutputStream outputStream = response.getOutputStream()) {
                ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(new ByteArrayInputStream(excelTemplateData))
                        .excelType(ExcelTypeEnum.XLSX).build();
                WriteSheet writeSheet = EasyExcel.writerSheet().build();
                excelWriter.fill(hashMaps, writeSheet);
                excelWriter.finish();  // Finish writing Excel content

                // Step 5: Convert Excel to Image using Apache POI
                convertExcelToImage(new ByteArrayInputStream(excelTemplateData), outputStream);  // Reuse byte array stream for image
            }

        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions (e.g., logging)
        }
    }

    private void convertExcelToImage(InputStream excelInputStream, OutputStream outputStream) throws IOException {
        // Load the Excel file using Apache POI
        Workbook workbook = new XSSFWorkbook(excelInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        // Calculate image size based on sheet data
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        int cellWidth = 100;  // Set cell width (in pixels)
        int cellHeight = 20;  // Set cell height (in pixels)

        // Calculate the image dimensions
        int width = colCount * cellWidth;
        int height = rowCount * cellHeight;

        // Create a BufferedImage to hold the image
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = bufferedImage.createGraphics();

        // Set the background color to white
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Arial", Font.PLAIN, 12));

        // Render Excel content to image
        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            for (int colIndex = 0; colIndex < colCount; colIndex++) {
                Cell cell = row.getCell(colIndex);
                String cellValue = (cell != null) ? cell.toString() : "";
                graphics.drawString(cellValue, colIndex * cellWidth + 5, rowIndex * cellHeight + 15);
            }
        }

        // Output the image to the response output stream
        ImageIO.write(bufferedImage, "PNG", outputStream);

        graphics.dispose();
        workbook.close();
    }
}

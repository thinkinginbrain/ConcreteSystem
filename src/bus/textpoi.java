package bus;


import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class textpoi {


		public static void main(String[] args) {
			// TODO 自动生成的方法存根
//	       XSSFWorkbook workbook = new XSSFWorkbook();
//	       Sheet sheet =workbook.createSheet();
//	       
//	       Row row = sheet.createRow(0);
//	       
//	       String[] title= {"id","name","sex"};
//	       Cell cell =null;
//	       for(int i=0;i<title.length;i++)
//	       {
//	    	   cell=row.createCell(i);
//	    	   cell.setCellValue(title[i]);
//	       }
//	       for (int i=1;i<10;i++){
//	           Row nextrow=sheet.createRow(i);
//	           Cell cell2=nextrow.createCell(0);
//	           cell2.setCellValue("a"+i);
//	           cell2=nextrow.createCell(1);
//	           cell2.setCellValue("user"+i);
//	           cell2=nextrow.createCell(2);
//	           cell2.setCellValue("男");
//	       }
//	       File file=new File("D:/poi_test.xlsx");
//	       try {
//	       file.createNewFile();
//	       FileOutputStream stream= FileUtils.openOutputStream(file);
//	       workbook.write(stream);
//	       stream.close();}
//	      catch (Exception e) {
//			// TODO: handle exception
//		}
	//   
			File file=new File("D:/7.xls");
			HSSFWorkbook workbook;
			
				try {
					workbook = new HSSFWorkbook(FileUtils.openInputStream(file));

	        //两种方式读取工作表
	      //  HSSFSheet sheet=workbook.getSheet("Sheet0");
	        HSSFSheet sheet=workbook.getSheetAt(0);
			
	        //获取sheet中最后一行行号
	        int lastRowNum=sheet.getLastRowNum();
	 //       System.out.println(lastRowNum);
	        for (int i=0;i<=lastRowNum;i++){
	            HSSFRow row=sheet.getRow(i);
	            //获取当前行最后单元格列号
	           int lastCellNum=row.getLastCellNum();
	  //         System.out.println(lastCellNum);
	            for (int j=0;j<lastCellNum;j++){
	                HSSFCell cell=row.getCell(j);
	                cell.setCellType(CellType.STRING);
	                String value=cell.getStringCellValue();
	                System.out.print(value+" ");
	            }

		
	            System.out.println();

	        }
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}


		}

	}


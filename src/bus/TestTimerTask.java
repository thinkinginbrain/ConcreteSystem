package bus;
import mdl.Business;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.TimerTask;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class TestTimerTask extends TimerTask{
	

	/*
	 * private String taskName;
	 * 
	 * public TestTimerTask(String taskName) { this.taskName = taskName; }
	 */

	    @Override
	    public void run() {
	        //System.out.println(new Date() + " : 任务「" + taskName + "」被执行。");
	    	File file=new File("D:/78.xls");
			HSSFWorkbook workbook;
			
		    try {
				workbook = new HSSFWorkbook(FileUtils.openInputStream(file));

	        //两种方式读取工作表
	        //  HSSFSheet sheet=workbook.getSheet("Sheet0");
	        HSSFSheet sheet=workbook.getSheetAt(0);
			
	        //获取sheet中最后一行行号
	        int lastRowNum=sheet.getLastRowNum();
	        //System.out.println(lastRowNum);
	      //  System.out.println(lastRowNum);
	        for (int i=lastRowNum-10;i<=lastRowNum;i++){
	            HSSFRow row=sheet.getRow(i);
	            //获取当前行最后单元格列号
	           int lastCellNum=row.getLastCellNum();
	       //    System.out.println(lastCellNum);
	           HSSFCell cell =row.getCell(lastCellNum-1);
	           
	           cell.setCellType(CellType.NUMERIC);
	           double data=cell.getNumericCellValue();
	  //         System.out.println(data);
	          
	           Business business=new Business();
	           String result=business.FirstModel(data);
	           System.out.println(result);
	           /* for (int j=0;j<lastCellNum;j++){
	                HSSFCell cell=row.getCell(j);
	                cell.setCellType(CellType.STRING);
	                String value=cell.getStringCellValue();
	                System.out.print(value+" ");
	            }*/

		
	          //  System.out.println();

	        }
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}


		}

	    }




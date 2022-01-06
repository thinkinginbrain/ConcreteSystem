package bus;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import mdl.Business;

public class TestData {
	
	public String read()
	{
		File file = new File("D:/78.xls");

		try {
			HSSFWorkbook workbook;
			workbook = new HSSFWorkbook(FileUtils.openInputStream(file));

			// 两种方式读取工作表
			// HSSFSheet sheet=workbook.getSheet("Sheet0");
			HSSFSheet sheet = workbook.getSheetAt(0);

			// 获取sheet中最后一行行号
			int lastRowNum = sheet.getLastRowNum();
			// System.out.println(lastRowNum);
			// System.out.println(lastRowNum);
			// 获取最后一行
			HSSFRow row = sheet.getRow(lastRowNum);
			// 获取最后一行最后一列的列号
			int lastCellNum = row.getLastCellNum();
			// 获取最后一行的最后一个元素
			HSSFCell cell1 = row.getCell(lastCellNum - 1);
			cell1.setCellType(CellType.NUMERIC);
			// 将元素转为double格式的数据
			double data = cell1.getNumericCellValue();
			// 获取最后一行的倒数第二个元素
			HSSFCell cell2 = row.getCell(lastCellNum - 1);
			cell2.setCellType(CellType.NUMERIC);
			// 将元素转为int格式的数据
		    int serial = (int)cell2.getNumericCellValue();
			// 放入模型中处理
			System.out.println(data);
			Business business = new Business();
			String result = business.FirstModel(data);
			// 删除最后一行数据
		    //sheet.shiftRows(lastRowNum-1, lastRowNum, -1);
//			sheet.removeRow(row);
//			FileOutputStream os = new FileOutputStream("D:/78.xls");
//            workbook.write(os);
			workbook.close();
//			os.close();
			return result;
			

			
			
			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return "失败";
		}
	}
		
		public int readSerial()
		{
			File file = new File("D:/78.xls");
			

			try {
				HSSFWorkbook workbook;
				workbook = new HSSFWorkbook(FileUtils.openInputStream(file));

				// 两种方式读取工作表
				// HSSFSheet sheet=workbook.getSheet("Sheet0");
				HSSFSheet sheet = workbook.getSheetAt(0);

				// 获取sheet中最后一行行号
				int lastRowNum = sheet.getLastRowNum();
				// System.out.println(lastRowNum);
				// System.out.println(lastRowNum);
				// 获取最后一行
				HSSFRow row = sheet.getRow(lastRowNum);
				// 获取最后一行最后一列的列号
				int lastCellNum = row.getLastCellNum();
				// 获取最后一行的最后一个元素
				HSSFCell cell1 = row.getCell(lastCellNum - 1);
				cell1.setCellType(CellType.NUMERIC);
				// 将元素转为double格式的数据
				double data = cell1.getNumericCellValue();
				// 获取最后一行的倒数第二个元素
				HSSFCell cell2 = row.getCell(lastCellNum - 2);
				cell2.setCellType(CellType.NUMERIC);
				// 将元素转为int格式的数据
			    int serial = (int)cell2.getNumericCellValue();
				// 放入模型中处理
				System.out.println(serial);
				Business business = new Business();
				String result = business.FirstModel(data);
				// 删除最后一行数据
			    //sheet.shiftRows(lastRowNum-1, lastRowNum, -1);
				sheet.removeRow(row);
				FileOutputStream os = new FileOutputStream("D:/78.xls");
	            workbook.write(os);
				workbook.close();
				os.close();
				return serial;

			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				return 0;
			}
		
		
	}
}

package commondp;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.annotations.Test;
public class ReadExcel {
	 @Test(dataProvider = "fetchdata") 
		public static String[][] excelRead(String filename) throws IOException
		{
			
			String[][] exceldata;
			XSSFWorkbook wb=new XSSFWorkbook("./data/"+filename+".xlsx");
			XSSFSheet ws=wb.getSheet("Sheet1");
			int rownum=ws.getLastRowNum();
			int cell =ws.getRow(1).getLastCellNum();
			 exceldata = new String[rownum][cell];
			for(int i=1;i<=rownum;i++)
			{
				for(int j=0;j<cell;j++)
				{
					exceldata[i-1][j]=ws.getRow(i).getCell(j).getStringCellValue();
					
				}
			}
			
			return exceldata;
	   
		}
		
}

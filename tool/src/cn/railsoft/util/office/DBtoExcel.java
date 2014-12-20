package cn.railsoft.util.office;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import cn.railsoft.util.db.mapping.Vtables;
import cn.railsoft.util.db.mapping.VtablesDAO;

public class DBtoExcel {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		VtablesDAO dao = new VtablesDAO();
		List list = dao.findAll();
		Iterator iter = list.iterator();
		Workbook wbOut = null;
		String out = "./count.xls";
		wbOut = new HSSFWorkbook();
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(out);
			Sheet sheet = wbOut.createSheet("输出结果");
			//Sheet sheet = wbOut.getSheet("输出结果");
			
			// 创建一个单元格并填充一个整数的值
			Row row1 = sheet.createRow(0);
			Cell cellz = row1.createCell(0);
			cellz.setCellValue("id");
			Cell cell1z = row1.createCell(1);
			cell1z.setCellValue("tableName");
			Cell cell2z = row1.createCell(2);
			cell2z.setCellValue("tableRows");
			
			int i=0;
			while (iter.hasNext()) {
				Object o = iter.next();
				if (o instanceof Vtables && o!=null){
					i++;
					Vtables co = ((Vtables)o);
					// 创建一行并放一些单元格到该行中，行的索引是以0开始的
					Row row = sheet.createRow(i);
					// 创建一个单元格并填充一个整数的值
					Cell cell = row.createCell(0);
					cell.setCellValue(i);
					Cell cell1 = row.createCell(1);
					cell1.setCellValue(co.getId().getTableName());
					Cell cell2 = row.createCell(2);
					cell2.setCellValue(co.getId().getTableRows()==null?0:co.getId().getTableRows());
					System.out.println(""+i);
				}
			}

			
			wbOut.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

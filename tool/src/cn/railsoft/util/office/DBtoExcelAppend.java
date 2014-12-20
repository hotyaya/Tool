package cn.railsoft.util.office;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import cn.railsoft.util.db.mapping.Vtables;
import cn.railsoft.util.db.mapping.VtablesDAO;

public class DBtoExcelAppend {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		//Vector v = new Vector();
		Hashtable<String,Vtables> h = new Hashtable<String,Vtables>();
		VtablesDAO dao = new VtablesDAO();
		List list = dao.findAll();
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			Object o = iter.next();
			if (o instanceof Vtables && o!=null){
				Vtables co = ((Vtables)o);
				//v.add(co);
				h.put(co.getId().getTableName(), co);
			}
		}
		String out = "./count.xls";
		Workbook wbOut = null;
		FileOutputStream fileOut;
		try {
			wbOut = new HSSFWorkbook(new FileInputStream(out));
			fileOut = new FileOutputStream(out);
			Sheet sheet = wbOut.getSheet("输出结果");
			boolean isblank = false;
			int j = 0;
			Row row0 = sheet.getRow(0);
			while (!isblank){
				if ((row0.getCell(j)!=null)){
					j++;
					System.out.println("="+j);
				}else{
					isblank = !isblank;
				}
			}
			
			boolean isblank2 = false;
			int r = 1;
			Row row = null;
			while (!isblank2){
				System.out.println("="+r);
				row = sheet.getRow(r);
				if ((row!=null && row.getCell(1)!=null)){
					row.createCell(j).setCellValue((h.get(row.getCell(1).toString().trim()).getId().getTableRows()));
					r++;
				}else{
					isblank2 = !isblank2;
				}
			}
			sheet.getRow(0).createCell(j).setCellValue(""+new java.sql.Timestamp(System.currentTimeMillis()));
			System.out.println("OK!");
			
//			for (int i = 0; i<v.size();i++){
				
//				i++;
//				// 创建一行并放一些单元格到该行中，行的索引是以0开始的
//				Row row = sheet.createRow(i);
//				// 创建一个单元格并填充一个整数的值
//				Cell cell = row.createCell(0);
//				cell.setCellValue(i);
//				Cell cell1 = row.createCell(1);
//				cell1.setCellValue(co.getId().getTableName());
//				Cell cell2 = row.createCell(2);
//				cell2.setCellValue(co.getId().getTableRows()==null?0:co.getId().getTableRows());
//				System.out.println(""+i);

				
//			}
			
			/**
			 * 读取，追加写的方式实验成功！
			 */
//			Row row1 = sheet.getRow(0);
//			Cell cellz = row1.getCell(0);
//			cellz.setCellValue(0);
//			Cell cell1z = row1.getCell(1);
//			cell1z.setCellValue("tableNameX");
//			Cell cell2z = row1.getCell(2);
//			cell2z.setCellValue("tableRowsX");

			wbOut.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

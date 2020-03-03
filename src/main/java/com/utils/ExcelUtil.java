package main.java.com.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletResponse;

import main.java.com.po.entity.EmailAppendixExcelEntity;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;

/**
 * excel工具类
 * 
 * @author ylyao
 * @version 1.0
 */
public class ExcelUtil {

	public static void exportExcel(List<?> list, String title,
			String sheetName, Class<?> pojoClass, String fileName,
			boolean isCreateHeader, HttpServletResponse response)
			throws Exception {
		ExportParams exportParams = new ExportParams(title, sheetName);
		exportParams.setCreateHeadRows(isCreateHeader);
		defaultExport(list, pojoClass, fileName, response, exportParams);

	}

	public static void exportExcel(List<?> list, String title,
			String sheetName, Class<?> pojoClass, String fileName,
			HttpServletResponse response) throws Exception {
		defaultExport(list, pojoClass, fileName, response, new ExportParams(
				title, sheetName));
	}

	public static void exportExcel(List<Map<String, Object>> list,
			String fileName, HttpServletResponse response) throws Exception {
		defaultExport(list, fileName, response);
	}

	private static void defaultExport(List<?> list, Class<?> pojoClass,
			String fileName, HttpServletResponse response,
			ExportParams exportParams) throws Exception {
		Workbook workbook = ExcelExportUtil.exportExcel(exportParams,
				pojoClass, list);
		if (workbook != null)
			;
		downLoadExcel(fileName, response, workbook);
	}

	private static void downLoadExcel(String fileName,
			HttpServletResponse response, Workbook workbook) throws Exception {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setHeader("content-Type", "application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment;filename="
					+ URLEncoder.encode(fileName, "UTF-8"));
			workbook.write(response.getOutputStream());

		} catch (IOException e) {
			throw new Exception(e.getMessage());
		}
	}

	private static void defaultExport(List<Map<String, Object>> list,
			String fileName, HttpServletResponse response) throws Exception {
		Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
		if (workbook != null)
			;
		downLoadExcel(fileName, response, workbook);
	}

	public static <T> List<T> importExcel(String filePath, Integer titleRows,
			Integer headerRows, Class<T> pojoClass) throws Exception {
		if (StringFunctionUtil.isEmpty(filePath)) {
			return null;
		}
		ImportParams params = new ImportParams();
		params.setTitleRows(titleRows);
		params.setHeadRows(headerRows);
		List<T> list = null;
		try {
			list = ExcelImportUtil.importExcel(new File(filePath), pojoClass,
					params);
		} catch (NoSuchElementException e) {
			throw new Exception("模板不能为空");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return list;
	}

	public static <T> List<T> importExcel(MultipartFile file,
			Integer titleRows, Integer headerRows, Class<T> pojoClass)
			throws Exception {
		if (file == null) {
			return null;
		}
		ImportParams params = new ImportParams();
		params.setTitleRows(titleRows);
		params.setHeadRows(headerRows);
		List<T> list = null;
		try {
			list = ExcelImportUtil.importExcel(file.getInputStream(),
					pojoClass, params);
		} catch (NoSuchElementException e) {
			throw new Exception("excel文件不能为空");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return list;
	}

	/**
	 * 本地生成excel
	 * @param pojoClass 设置表头
	 * @param list 数据
	 * @param title 
	 * @param sheetName
	 * @param filePath
	 * @return 生成excel文件的路径
	 */
	public static String createExcel(Class<?> pojoClass, List<?> list, String title, String sheetName, String filePath) {
		OutputStream out = null;

		try {
			Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(title, sheetName), pojoClass, list);
			out = new FileOutputStream(new File(filePath));
			workbook.write(out);

			return filePath;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}

	}

	public static void main(String[] args) {
		List<EmailAppendixExcelEntity> line = new ArrayList<EmailAppendixExcelEntity>();
		EmailAppendixExcelEntity entity = new EmailAppendixExcelEntity("JX00122222222222222","sdfsdfffffffdfsdfwe客户收到附件深刻的很疯狂", "1111", "222", "JX001", "1111", "1111", "222");
		line.add(entity);
		System.out.println(createExcel(EmailAppendixExcelEntity.class, line, null, "订单" , "D:/txt.xls"));
		
	}

}

package main.java.com.po.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import main.java.com.utils.StringFunctionUtil;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class TestItex {

	public static void main(String[] args) throws Exception, IOException {
		String fileNameDemo = "D:/pdfTest/testTableDemo"
				+ StringFunctionUtil.getApplyNo() + ".pdf";
		BaseFont baseFont = BaseFont.createFont("STSong-Light,Bold",
				"UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);

		Font font = new Font(baseFont);
		font.setSize(5); //设置字体大小

		// 创建文件
		Document document = new Document(PageSize.A5);
		// 建立一个书写器
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileNameDemo));
		// 打开文件
		document.open();

		PdfPTable table = new PdfPTable(10);
		List<PdfPRow> listRowDemo = table.getRows();
		// 设置列宽
		float[] columnWidthsDemo = { 1f, 1f,1f,1f,1f, 1f,1f,1f,1f, 1f};
		table.setWidths(columnWidthsDemo);

		// 行1
		PdfPCell cells1Demo[] = new PdfPCell[10];
		PdfPRow row1Demo = new PdfPRow(cells1Demo);
		// 单元格
		cells1Demo[0] = new PdfPCell(new Paragraph("项次",font));// 单元格内容
		cells1Demo[0].setBorderColor(BaseColor.BLUE);// 边框验证
//		cells1Demo[0].setPaddingLeft(20);// 左填充20
		cells1Demo[0].setHorizontalAlignment(Element.ALIGN_CENTER);// 水平居中
		cells1Demo[0].setVerticalAlignment(Element.ALIGN_LEFT);// 垂直居中
//		cells1Demo[0].setColspan(5);

		cells1Demo[1] = new PdfPCell(new Paragraph("222",font));
		cells1Demo[2] = new PdfPCell(new Paragraph("333",font));
		cells1Demo[3] = new PdfPCell(new Paragraph("444",font));
		cells1Demo[4] = new PdfPCell(new Paragraph("445",font));
		cells1Demo[5] = new PdfPCell(new Paragraph("555",font));
		cells1Demo[6] = new PdfPCell(new Paragraph("666",font));
		cells1Demo[7] = new PdfPCell(new Paragraph("777",font));
		cells1Demo[8] = new PdfPCell(new Paragraph("888",font));
		cells1Demo[9] = new PdfPCell(new Paragraph("999",font));
		// 行2
		PdfPCell cells2Demo[] = new PdfPCell[10];
		PdfPRow row2Demo = new PdfPRow(cells2Demo);
		cells2Demo[0] = new PdfPCell(new Paragraph("444"));
		cells2Demo[0].setColspan(5);
		cells2Demo[5] = new PdfPCell(new Paragraph("555"));
		cells2Demo[5].setColspan(5);

		// 把第一行添加到集合
		listRowDemo.add(row1Demo);
		listRowDemo.add(row2Demo);
		// 把表格添加到文件中
		document.add(table);

		// 关闭文档
		document.close();
		// 关闭书写器
		writer.close();
	}
}

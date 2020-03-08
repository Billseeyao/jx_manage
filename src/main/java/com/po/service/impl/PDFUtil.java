package main.java.com.po.service.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import main.java.com.utils.StringFunctionUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFUtil {
	
    
	private Logger logger = LoggerFactory.getLogger(PDFUtil.class);

	 public static void createPDF(String filename) throws IOException {
		    Document document = new Document(PageSize.A4);
		    try {
		        PdfWriter.getInstance(document, new FileOutputStream(filename));
		        document.addTitle("example of PDF");
		        document.open();
		        document.add(new Paragraph("Hello World!"));
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        document.close();
		    }
	}

	 public static PdfPTable createTable(PdfWriter writer) throws DocumentException, IOException{
		    PdfPTable table = new PdfPTable(2);//生成一个两列的表格
		    PdfPCell cell;
		    int size = 15;
		    cell = new PdfPCell(new Phrase("one"));
		    cell.setFixedHeight(size);//设置高度
		    table.addCell(cell);
		    cell = new PdfPCell(new Phrase("two"));
		    cell.setFixedHeight(size);
		    table.addCell(cell);
		    cell = new PdfPCell(new Phrase("three"));
		    cell.setFixedHeight(size);
		    table.addCell(cell);
		    cell = new PdfPCell(new Phrase("four"));
		    cell.setFixedHeight(size);
		    table.addCell(cell);
		    return table;
	 }
	 
	  public static void createPDF2(String filename) throws IOException {
		    Document document = new Document(PageSize.A3);
		    try {
		        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
		        document.addTitle("example of PDF");
		        document.open();
		        PdfPTable table = createTable(writer);
//		        PdfPTable table = createTable3(writer);
		        document.add(table);
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (DocumentException e) {
		        e.printStackTrace();
		    } finally {
		        document.close();
		    }
	  }
	  
	  public static PdfPTable createTable3(PdfWriter writer) throws Exception {
		    BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		    Font font = new Font(baseFont);
		    
		  PdfPTable table = new PdfPTable(2);//生成一个两列的表格
		    PdfPCell cell;
		    int size = 15;
		    cell = new PdfPCell(new Phrase("项次"));
		    cell.setFixedHeight(size);
		    table.addCell(cell);
		    cell = new PdfPCell(new Phrase("内容"));
		    cell.setFixedHeight(size);
		    table.addCell(cell);
//		    cell = new PdfPCell(new Phrase("描述"));
//		    cell.setFixedHeight(size);
//		    table.addCell(cell);
//		    cell = new PdfPCell(new Phrase("数量"));
//		    cell.setFixedHeight(size);
//		    table.addCell(cell);
//		    cell = new PdfPCell(new Phrase("单价（不含税）"));
//		    cell.setFixedHeight(size);
//		    table.addCell(cell);
//		    cell = new PdfPCell(new Phrase("金额"));
//		    cell.setFixedHeight(size);
//		    table.addCell(cell);
//		    cell = new PdfPCell(new Phrase("税率"));
//		    cell.setFixedHeight(size);
//		    table.addCell(cell);
//		    cell = new PdfPCell(new Phrase("税额"));
//		    cell.setFixedHeight(size);
//		    table.addCell(cell);
//		    cell = new PdfPCell(new Phrase("到货日期"));
//		    cell.setFixedHeight(size);
//		    table.addCell(cell);
//		    cell = new PdfPCell(new Phrase("备注"));
//		    cell.setFixedHeight(size);
//		    table.addCell(cell);
//		    cell = new PdfPCell(new Phrase("单价（不含税）"));
//		    cell.setFixedHeight(size);
//		    table.addCell(cell);
//		    cell = new PdfPCell(new Phrase("单价（不含税）"));
//		    cell.setColspan(2);//设置所占列数
//		    cell.setFixedHeight(size*2);//设置高度
//		    cell.setHorizontalAlignment(Element.ALIGN_CENTER);//设置水平居中
//		    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直居中
//		    table.addCell(cell);
		    return table;
	  }
	  
	  
	public static void createPDF4(String fileName) throws Exception{
		
	    BaseFont baseFont = BaseFont.createFont("STSong-Light,Bold", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
	    
	    Font font = new Font(baseFont,5);
	    Font fontBold = new Font(baseFont,5,Font.BOLD);
//	    font.setSize(5);

        //创建文件
        Document document = new Document(PageSize.A5.rotate());
        //建立一个书写器
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
        //打开文件
        document.open();
        
        //图片
        String imagePath = "file:///D:/pdfTest/logo.png";
        Image image = Image.getInstance(new URL(imagePath));
        //设置图片的宽度和高度
        image.scaleAbsolute(35, 35);
        //设置图片位置的x轴和y周
//      image.setAbsolutePosition(100f, 550f);
//        document.add(image);
        
        //添加内容
//        Paragraph p = new Paragraph("收到订单后请在24小时内以电子邮件的方式进行确认。"
//        		+ "请核对内容、确认无误后邮件回复：标题与内容统一为”订单收到，将按订单要求送货；",font);
//        p.setAlignment(1);
//        document.add(p);
        
        //添加内容
//        document.add(new Paragraph("订购单                                                                            日期：2020-02-02",font));
        
        // 3列的表.
        PdfPTable table = new PdfPTable(10); 
        table.setWidthPercentage(100); // 宽度100%填充
        table.setSpacingBefore(10f); // 前间距
        table.setSpacingAfter(10f); // 后间距

        List<PdfPRow> listRow = table.getRows();
        //设置列宽
        float[] columnWidths = {1f, 1f,1f,1f,1f, 1f,1f,1f,1f, 1f};
        table.setWidths(columnWidths);
        
        //行1
        PdfPCell cells1[]= new PdfPCell[10];
        PdfPRow row1 = new PdfPRow(cells1);
        //单元格
        cells1[0] = new PdfPCell(image);//单元格内容
        cells1[0].disableBorderSide(15);
        cells1[5] = new PdfPCell(new Paragraph("收到订单后请在24小时内以电子邮件的方式进行确认。",font));
        cells1[5].disableBorderSide(15);
        cells1[0].setColspan(5);
        cells1[5].setColspan(5);

        //行2
        PdfPCell cells2[]= new PdfPCell[10];
        PdfPRow row2 = new PdfPRow(cells2);
        //单元格
        cells2[0] = new PdfPCell(new Paragraph("订 购 单",fontBold));//单元格内容
        cells2[5] = new PdfPCell(new Paragraph("日期：2020-02-02",font));
        cells2[0].disableBorderSide(15);
        cells2[5].disableBorderSide(15);
        cells2[0].setColspan(5);
        cells2[5].setColspan(5);
        
        //行3
        PdfPCell cells3[]= new PdfPCell[10];
        PdfPRow row3 = new PdfPRow(cells3);
        //单元格
        cells3[0] = new PdfPCell(new Paragraph("订购单：CNF200120",fontBold));//单元格内容
        cells3[5] = new PdfPCell(new Paragraph("授权人：康保强",font));
        cells3[0].setColspan(5);
        cells3[5].setColspan(5);
        
        //行3
        PdfPCell cells4[]= new PdfPCell[10];
        PdfPRow row4 = new PdfPRow(cells4);
        //单元格
        cells4[0] = new PdfPCell(new Paragraph("供应商：",fontBold));
        cells4[1] = new PdfPCell(new Paragraph("湖南省凯纳方科技有限公司",font));
        cells4[5] = new PdfPCell(new Paragraph("收货信息：",fontBold));
        cells4[0].disableBorderSide(2);
        cells4[1].disableBorderSide(2);
        cells4[5].disableBorderSide(2);
        cells4[1].setColspan(4);
        cells4[5].setColspan(5);
        
        //行5
        PdfPCell cells5[]= new PdfPCell[10];
        PdfPRow row5 = new PdfPRow(cells5);
        //单元格
        cells5[0] = new PdfPCell(new Paragraph("注册地址：湖南省郴州市北湖区科技大道工业园区3号，电话：010-1209890",font));
        cells5[5] = new PdfPCell(new Paragraph("收货地址：上海市奉贤区冷泾新村78号",font));
        cells5[0].disableBorderSide(3);
        cells5[5].disableBorderSide(3);
        cells5[0].setColspan(5);
        cells5[5].setColspan(5);
        
        //行6
        PdfPCell cells6[]= new PdfPCell[10];
        PdfPRow row6 = new PdfPRow(cells6);
        //单元格
        cells6[0] = new PdfPCell(new Paragraph("",font));
        cells6[5] = new PdfPCell(new Paragraph("收货人：姚金芳 手机：13123906145 座机：021-5239 3758",font));
        cells6[0].disableBorderSide(3);
        cells6[5].disableBorderSide(3);
        cells6[0].setColspan(5);
        cells6[5].setColspan(5);

        //行7
        PdfPCell cells7[]= new PdfPCell[10];
        PdfPRow row7 = new PdfPRow(cells7);
        //单元格
        cells7[0] = new PdfPCell(new Paragraph("联系人：何志能 手机：137 0263 6038 邮箱：1439290331@qq.com",font));
        cells7[5] = new PdfPCell(new Paragraph("传真：021-5239 3758 邮箱：jinfangyao@shjiaxin.com",font));
        cells7[0].disableBorderSide(3);
        cells7[5].disableBorderSide(3);
        cells7[0].setColspan(5);
        cells7[5].setColspan(5);
        
        //行8
        PdfPCell cells8[]= new PdfPCell[10];
        PdfPRow row8 = new PdfPRow(cells8);
        //单元格
        cells8[0] = new PdfPCell(new Paragraph("电话：0735-2909888、2998018 传真：0735-2998118",font));
        cells8[5] = new PdfPCell(new Paragraph("",font));
        cells8[0].disableBorderSide(3);
        cells8[5].disableBorderSide(3);
        cells8[0].setColspan(5);
        cells8[5].setColspan(5);
        
        //行9
        PdfPCell cells9[]= new PdfPCell[10];
        PdfPRow row9 = new PdfPRow(cells9);
        //单元格
        cells9[0] = new PdfPCell(new Paragraph("地址：湖南省郴州市北湖区南岭大道长冲科技工业园 2#楼，邮编：423000",font));
        cells9[5] = new PdfPCell(new Paragraph("开票资料（请在发票备注栏注明订单号；发票单价与订单保持一致，小数点后最多保留 4 位）：",font));
        cells9[0].disableBorderSide(3);
        cells9[5].disableBorderSide(3);
        cells9[0].setColspan(5);
        cells9[5].setColspan(5);
        
        //行10
        PdfPCell cells10[]= new PdfPCell[10];
        PdfPRow row10 = new PdfPRow(cells10);
        //单元格
        cells10[0] = new PdfPCell(new Paragraph("",font));
        cells10[5] = new PdfPCell(new Paragraph("名称：上海加鑫净化设备有限公司 税号：913 101 177 432 715 06H",font));
        cells10[0].disableBorderSide(3);
        cells10[5].disableBorderSide(3);
        cells10[0].setColspan(5);
        cells10[5].setColspan(5);
        
        //行11
        PdfPCell cells11[]= new PdfPCell[10];
        PdfPRow row11 = new PdfPRow(cells11);
        //单元格
        cells11[0] = new PdfPCell(new Paragraph("付款信息：",fontBold));
        cells11[5] = new PdfPCell(new Paragraph("注册地址：上海市松江区南乐路 158 号 1 幢 1 层 Z1 室，电话：021-62115062",font));
        cells11[0].disableBorderSide(3);
        cells11[5].disableBorderSide(3);
        cells11[0].setColspan(5);
        cells11[5].setColspan(5);
        
        //行12
        PdfPCell cells12[]= new PdfPCell[10];
        PdfPRow row12 = new PdfPRow(cells12);
        //单元格
        cells12[0] = new PdfPCell(new Paragraph("开户行；华融湘江银行股份有限公司郴州分行 账号：71010302000024080",font));
        cells12[5] = new PdfPCell(new Paragraph("开户行及账号：中国银行上海市杨思支行 452 059 215 440",font));
        cells12[0].disableBorderSide(3);
        cells12[5].disableBorderSide(3);
        cells12[0].setColspan(5);
        cells12[5].setColspan(5);

        //行13
        PdfPCell cells13[]= new PdfPCell[10];
        PdfPRow row13 = new PdfPRow(cells13);
        //单元格
        cells13[0] = new PdfPCell(new Paragraph("货币：RMB",font));
        cells13[5] = new PdfPCell(new Paragraph("发票寄送：",fontBold));
        cells13[0].disableBorderSide(3);
        cells13[5].disableBorderSide(3);
        cells13[0].setColspan(5);
        cells13[5].setColspan(5);
        
        //行14
        PdfPCell cells14[]= new PdfPCell[10];
        PdfPRow row14 = new PdfPRow(cells14);
        //单元格
        cells14[0] = new PdfPCell(new Paragraph("",font));
        cells14[5] = new PdfPCell(new Paragraph("地址：上海市浦东新区南码头路 101 号 1606 室 收票人：姚金芳 手机：13123906145",font));
        cells14[0].disableBorderSide(1);
        cells14[5].disableBorderSide(1);
        cells14[0].setColspan(5);
        cells14[5].setColspan(5);
        
        
        //行15
        PdfPCell cells15[]= new PdfPCell[10];
        PdfPRow row15 = new PdfPRow(cells15);
        //单元格
        cells15[0] = new PdfPCell(new Paragraph("项次",fontBold));
        cells15[1] = new PdfPCell(new Paragraph("内容",fontBold));
        cells15[2] = new PdfPCell(new Paragraph("描述",fontBold));
        cells15[3] = new PdfPCell(new Paragraph("数量",fontBold));
        cells15[4] = new PdfPCell(new Paragraph("单价（不含税）",fontBold));
        cells15[5] = new PdfPCell(new Paragraph("金额",fontBold));
        cells15[6] = new PdfPCell(new Paragraph("税率",fontBold));
        cells15[7] = new PdfPCell(new Paragraph("税额",fontBold));
        cells15[8] = new PdfPCell(new Paragraph("到货日期",fontBold));
        cells15[9] = new PdfPCell(new Paragraph("备注",fontBold));
        
        //行16
        PdfPCell cells16[]= new PdfPCell[10];
        PdfPRow row16 = new PdfPRow(cells16);
        cells16[0] = new PdfPCell(new Paragraph("价税合计",fontBold));
        cells16[6] = new PdfPCell(new Paragraph("12121221.89",fontBold));
        cells16[0].setColspan(6);
        cells16[0].setHorizontalAlignment(Element.ALIGN_RIGHT);
        cells16[6].setColspan(4);
        
        //行177 空一行
        PdfPCell cells177[]= new PdfPCell[10];
        PdfPRow row177 = new PdfPRow(cells177);
        cells177[0] = new PdfPCell(new Paragraph("",font));
        cells177[0].setColspan(10);
        cells177[0].disableBorderSide(15);
        
        //行17
        PdfPCell cells17[]= new PdfPCell[10];
        PdfPRow row17 = new PdfPRow(cells17);
        cells17[0] = new PdfPCell(new Paragraph("送货须知：",fontBold));
        cells17[0].setColspan(10);
        cells17[0].disableBorderSide(15);
        
        //行18
        PdfPCell cells18[]= new PdfPCell[10];
        PdfPRow row18 = new PdfPRow(cells18);
        cells18[0] = new PdfPCell(new Paragraph("1.请在送货单及船运文件上注明订单号、产品名称、数量、是否携带产品抽查小样。",font));
        cells18[0].setColspan(10);
        cells18[0].disableBorderSide(15);
        
        //行19
        PdfPCell cells19[]= new PdfPCell[10];
        PdfPRow row19 = new PdfPRow(cells19);
        cells19[0] = new PdfPCell(new Paragraph("2.请随货发送产品质量证明文件与每卷产品抽查小样。到货前需将随货发送的文件（产品质量证明文件、送货单等）电子版发送至收货人电子邮箱。",font));
        cells19[0].setColspan(10);
        cells19[0].disableBorderSide(15);
        
        //行20
        PdfPCell cells20[]= new PdfPCell[10];
        PdfPRow row20 = new PdfPRow(cells20);
        cells20[0] = new PdfPCell(new Paragraph("3.供应商自行承担费用将符合产品质量标准的产品在订单要求的到货日期（当日或提前）交付至订单指定的地点。",font));
        cells20[0].setColspan(10);
        cells20[0].disableBorderSide(15);
        
        //行21
        PdfPCell cells21[]= new PdfPCell[10];
        PdfPRow row21 = new PdfPRow(cells21);
        cells21[0] = new PdfPCell(new Paragraph("4.所有货物包装必须按照国家有关部门的规定进行标识，卖方保证以上价格已包含上述包装所需的费用。",font));
        cells21[0].setColspan(10);
        cells21[0].disableBorderSide(15);
        
        
        
        //把第一行添加到集合
        listRow.add(row1);
        listRow.add(row2);
        listRow.add(row3);
        listRow.add(row4);
        listRow.add(row5);
        listRow.add(row6);
        listRow.add(row7);
        listRow.add(row8);
        listRow.add(row9);
        listRow.add(row10);
        listRow.add(row11);
        listRow.add(row12);
        listRow.add(row13);
        listRow.add(row14);
        listRow.add(row15);
        listRow.add(row16);
        listRow.add(row17);
        listRow.add(row177);
        listRow.add(row18);
        listRow.add(row19);
        listRow.add(row20);
        listRow.add(row21);
        
        //把表格添加到文件中
        document.add(table);


        //关闭文档
      document.close();
       //关闭书写器
      writer.close();
}
	 
//	public void tableDemo(Document document){
//        PdfPTable table = new PdfPTable(3); 
//        table.setWidthPercentage(100); // 宽度100%填充
//        table.setSpacingBefore(10f); // 前间距
//        table.setSpacingAfter(10f); // 后间距
//
//        List<PdfPRow> listRow = table.getRows();
//        //设置列宽
//        float[] columnWidths = { 1f, 2f, 3f };
//        table.setWidths(columnWidths);
//        
//        //行1
//        PdfPCell cells1[]= new PdfPCell[3];
//        PdfPRow row1 = new PdfPRow(cells1);
//        //单元格
//        cells1[0] = new PdfPCell(new Paragraph("111"));//单元格内容
//        cells1[0].setBorderColor(BaseColor.BLUE);//边框验证
//        cells1[0].setPaddingLeft(20);//左填充20
//        cells1[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
//        cells1[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
//
//        cells1[1] = new PdfPCell(new Paragraph("222"));
//        cells1[2] = new PdfPCell(new Paragraph("333"));
//        
//        //行2
//        PdfPCell cells2[]= new PdfPCell[3];
//        PdfPRow row2 = new PdfPRow(cells2);
//        cells2[0] = new PdfPCell(new Paragraph("444"));
//
//        //把第一行添加到集合
//        listRow.add(row1);
//        listRow.add(row2);
//        //把表格添加到文件中
//        document.add(table);
//	}
	
	public static void main(String[] args) throws Exception {
	    
//		/**一个简单的pdf*/
//	    String filename = "D:/pdfTest/testTable.pdf";
//	    createPDF(filename);
//	    System.out.println("打印完成");
	    
//	    /**一个表格的pdf*/
//	    String filename2 = "D:/pdfTest/testTable2.pdf";
//	    createPDF2(filename2);
//	    System.out.println("2打印完成");
	    /**一个表格的pdf*/
//	    String filename3 = "D:/pdfTest/testTable3"+StringFunctionUtil.getApplyNo()+".pdf";
//	    File file3 =new File(filename3);
//	    if(file3.exists()){
//	    	file3.delete();
//	    }
//	    createPDF2(filename3);
//	    System.out.println("3打印完成");
	    
	    String fileName4 = "D:/pdfTest/testTable4"+StringFunctionUtil.getApplyNo()+".pdf";
	    createPDF4(fileName4);
	    

	}

}

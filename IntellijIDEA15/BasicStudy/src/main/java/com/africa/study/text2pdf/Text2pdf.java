package com.africa.study.text2pdf;


import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author zhuhusheng
 * @date 2016/10/26
 */
public class Text2pdf {

    private static final Path FILE_DIR = Paths.get("pdftest");

    public static void initDir() {
        try {
            Files.createDirectory(FILE_DIR);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void simplePDF() throws FileNotFoundException, IOException, DocumentException {
        //Step 1—Create a Document.
        Document document = new Document();
        //Step 2—Get a PdfWriter instance.
        PdfWriter.getInstance(document, new FileOutputStream(FILE_DIR.resolve("createSamplePDF.pdf").toFile()));
        //Step 3—Open the Document.
        document.open();

        BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
        Font bold_fontChinese = new Font(bfChinese, 12, Font.BOLD,
                BaseColor.BLACK);
        Font italic_fontChinese = new Font(bfChinese, 12, Font.ITALIC,
                BaseColor.BLACK);
        Font impressFont = new Font(bfChinese, 16, Font.BOLDITALIC,
                BaseColor.BLACK);

        //Step 4—Add content.
        document.add(new Paragraph("第一页", bold_fontChinese));

        document.newPage();
        document.add(new Paragraph("第二页", italic_fontChinese));

        document.newPage();
        document.add(new Paragraph("第三页", impressFont));

        //Step 5—Close the Document.
        document.close();
    }

    public static void complicatedPDF() throws FileNotFoundException, DocumentException {
//        // 页面大小
        Rectangle rect = new Rectangle(PageSize.B5.rotate());
//        // 页面背景色
        rect.setBackgroundColor(BaseColor.GRAY);

        Document doc = new Document(rect);
        FileOutputStream out = new FileOutputStream(FILE_DIR.resolve("complicatedPDF.pdf").toFile());
        PdfWriter writer = PdfWriter.getInstance(doc, out);
        writer.setPdfVersion(PdfWriter.VERSION_1_7);

//        // 设置密码为："World"
//        writer.setEncryption("Hello".getBytes(), "World".getBytes(),
//                PdfWriter.ALLOW_SCREENREADERS,
//                PdfWriter.STANDARD_ENCRYPTION_128);

        //文档属性
        doc.addTitle("康复训练报告");
        doc.addAuthor("Author@zhuhusheng");
        doc.addSubject("Subject@iText sample");
        doc.addKeywords("Keywords@iText");
        doc.addCreator("Creator@iText");

        //页边空白
        doc.setMargins(10, 20, 30, 40);

        doc.open();
        doc.add(new Paragraph("Hello World"));

        doc.add(new Paragraph("First page"));

        doc.newPage();
        writer.setPageEmpty(false);

        doc.newPage();
        doc.add(new Paragraph("New page"));
        doc.close();
    }

    public static void addStamper(String pdfName) throws IOException, FileNotFoundException, DocumentException {
        // 图片水印
        PdfReader reader = new PdfReader(FILE_DIR.resolve(pdfName).toFile().getAbsolutePath());
        PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(FILE_DIR.resolve("setWatermark2.pdf").toFile()));
        Image img = Image.getInstance("resource/watermark.png");
        img.setAbsolutePosition(200, 400);
        PdfContentByte under = stamp.getUnderContent(1);
        under.addImage(img);

//         文字水印
        PdfContentByte over = stamp.getOverContent(2);
        over.beginText();
        BaseFont bf = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
        over.setFontAndSize(bf, 30);
        over.setTextMatrix(30, 30);
        over.showTextAligned(Element.ALIGN_LEFT, "卓道医疗科技ABC123", 230, 430, 45);
        over.endText();

//         背景图
        Image img2 = Image.getInstance("resource/test.jpg");
        img2.setAbsolutePosition(0,0);

        PdfContentByte under2 = stamp.getUnderContent(3);
        under2.addImage(img2);

        stamp.close();
        reader.close();
    }


    public static void main(String[] args) throws FileNotFoundException, IOException, DocumentException {
//        initDir();
//        simplePDF();
        complicatedPDF();
        addStamper("createSamplePDF.pdf");
    }
}

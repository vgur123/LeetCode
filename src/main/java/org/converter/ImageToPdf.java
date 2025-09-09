package org.converter;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.SneakyThrows;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageToPdf {
    private static void generatePDFFromImage(String filename, String extension) throws MalformedURLException {
        String localFilePath = "C:\\Work\\LeetCode\\src\\main\\resources\\sun_cert.jpg";
        URL input = new URL("file:///" + localFilePath.replace("\\", "/"));

        Document document = new Document();
        //String input = "file://"+filename + "." + extension;
        String output = "src/output/" + filename + ".pdf";
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(output);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        PdfWriter writer = null;
        try {
            writer = PdfWriter.getInstance(document, fos);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        writer.open();
        document.open();
        try {
            Image image = Image.getInstance((input));
            //image.setAlignment(Element.ALIGN_CENTER);
            image.scaleToFit(640,480);
            document.add(image);
        } catch (DocumentException | IOException e) {
            throw new RuntimeException(e);
        }
        document.close();
        writer.close();
    }

    public static void textToPdf() throws DocumentException {
        String fileName = "C:\\Work\\LeetCode\\src\\main\\resources\\CV.txt";

        Document pdfDoc = new Document(PageSize.A4);
        try {
            PdfWriter.getInstance(pdfDoc, new FileOutputStream("src/output/txt.pdf"))
                    .setPdfVersion(PdfWriter.PDF_VERSION_1_7);
        } catch (DocumentException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        pdfDoc.open();

        Font myfont = new Font();
        myfont.setStyle(Font.NORMAL);
        myfont.setSize(11);
        pdfDoc.add(new Paragraph("\n"));

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String strLine;
        while (true) {
            try {
                if (!((strLine = br.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Paragraph para = new Paragraph(strLine + "\n", myfont);
            para.setAlignment(Element.ALIGN_JUSTIFIED);
            pdfDoc.add(para);
        }
        pdfDoc.close();
        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @SneakyThrows
    public static void main(String [] argv) throws MalformedURLException {
        //generatePDFFromImage("sun_cert","jpg");
        //textToPdf();
    }
}

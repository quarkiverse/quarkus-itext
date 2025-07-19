/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package io.quarkiverse.itext.openpdf.it;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Objects;

import javax.imageio.ImageIO;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import org.openpdf.renderer.PDFFile;
import org.openpdf.renderer.PDFPage;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfDictionary;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfString;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.parser.PdfTextExtractor;
import com.lowagie.text.xml.xmp.XmpWriter;

@Path("/openpdf")
@ApplicationScoped
public class OpenPDFResource {
    // add some rest methods here

    @GET
    @Path("/helloWorldPdf")
    public String helloWorldPdf() {
        // step 1: creation of a document-object
        Document document = new Document();
        try {
            // step 2:
            // we create a writer that listens to the document
            // and directs a PDF-stream to a file
            final PdfWriter instance = PdfWriter.getInstance(document, new ByteArrayOutputStream());

            instance.setEncryption("Hello".getBytes(), "World".getBytes(), PdfWriter.ALLOW_COPY | PdfWriter.ALLOW_PRINTING,
                    PdfWriter.STANDARD_ENCRYPTION_128);

            // step 3: we add some metadata open the document
            document.addTitle("Hello World example");
            document.addSubject("This example explains how to add metadata.");
            document.addKeywords("iText, Hello World, step 3, metadata");
            document.addCreator("My program using iText");
            document.addAuthor("Bruno Lowagie");

            // step 4: we open the document
            document.open();
            instance.getInfo().put(PdfName.CREATOR, new PdfString(Document.getVersion()));

            // step 5: we add a paragraph to the document
            Paragraph paragraph = new Paragraph("Hello World");
            addEmptyLine(paragraph, 3);
            document.add(paragraph);
            document.add(addTable());
        } catch (DocumentException de) {
            de.printStackTrace();
            System.err.println(de.getMessage());
            throw new RuntimeException(de);
        } finally {
            // step 5: we close the document
            if (document.isOpen()) {
                document.close();
            }
        }

        return "Hello OpenPDF";
    }

    @GET
    @Path("/conformanceA1B")
    public String conformanceA1B() {
        // step 1: creation of a document-object
        Document document = new Document();
        try {
            // step 2: create writer and set conformance
            PdfWriter writer = PdfWriter.getInstance(document, new ByteArrayOutputStream());
            writer.setPDFXConformance(com.lowagie.text.pdf.PdfWriter.PDFA1B);

            // step 3: open the document
            document.open();

            // create pdf dictionary with required entry
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.put(PdfName.CREATIONDATE, writer.getInfo().get(PdfName.CREATIONDATE));
            pdfDictionary.put(PdfName.MODDATE, writer.getInfo().get(PdfName.MODDATE));

            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

                // embed dictionary in XmpWriter
                XmpWriter xmpWriter = new XmpWriter(baos, pdfDictionary, PdfWriter.PDFA1B);
                xmpWriter.close();

                byte[] xmpMetadata = baos.toByteArray();

                // set xmp metadata and output intents
                writer.setXmpMetadata(xmpMetadata);
                writer.setOutputIntents("Custom", "", null, "sRGB IEC61966-2.1",
                        ICC_Profile.getInstance(ColorSpace.CS_sRGB));
            }

            // step 4:
            // we make some content
            BaseFont notoBase = BaseFont.createFont(
                    Objects.requireNonNull(
                            this.getClass().getClassLoader().getResource("fonts/noto/NotoSans-Regular.ttf")).getFile(),
                    BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font noto = new Font(notoBase, 10, Font.NORMAL);

            // a paragraph
            Paragraph p1 = new Paragraph("This document is compliant with PDF-A/1b requirements", noto);

            // some paragraph
            Paragraph p2 = new Paragraph("blah, blah, blah", noto);

            // we add the content
            document.add(p1);
            document.add(p2);
            document.add(p2);
            document.add(p2);
            document.add(p2);
            document.add(p2);
            document.add(p2);
            document.add(p2);
        } catch (DocumentException | IOException de) {
            de.printStackTrace();
            System.err.println(de.getMessage());
            throw new RuntimeException(de);
        } finally {
            // step 5: we close the document
            if (document.isOpen()) {
                document.close();
            }
        }

        return "Conformance A1B";
    }

    @GET
    @Path("/encrypted-aes256")
    public String encrypted() throws IOException {
        String text;
        try (InputStream resource = getClass().getResourceAsStream("/encrypted/Demo1_encrypted_.pdf")) {
            assert resource != null;
            PdfReader pdfReader = new PdfReader(resource);
            if (!pdfReader.isEncrypted()) {
                pdfReader.close();
                throw new RuntimeException("PdfReader fails to report test file to be encrypted.");
            }
            text = new PdfTextExtractor(pdfReader).getTextFromPage(1);
            pdfReader.close();
        }
        return text;
    }

    @GET
    @Path("/renderer-image")
    public String imageRenderer() throws IOException {
        int pageIndex = 1; // 1-based index

        // Load PDF file from test resources
        URL resourceUrl = getClass().getClassLoader().getResource("/image/HelloWorldMeta.pdf");

        assert resourceUrl != null;
        File file = new File(resourceUrl.getFile());

        try (FileInputStream fis = new FileInputStream(file);
                FileChannel fc = fis.getChannel()) {

            ByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
            PDFFile pdfFile = new PDFFile(bb);
            PDFPage page = pdfFile.getPage(pageIndex);

            Rectangle rect = new Rectangle(0, 0,
                    (int) page.getBBox().getWidth(),
                    (int) page.getBBox().getHeight());

            Image img = page.getImage(rect.width, rect.height, rect, null, true, true);

            // Convert to BufferedImage
            BufferedImage bufferedImage = new BufferedImage(rect.width, rect.height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = bufferedImage.createGraphics();
            g2.drawImage(img, 0, 0, null);
            g2.dispose();

            // Save output image to target/test-output
            File outputDir = new File("target/test-output");
            outputDir.mkdirs();
            File outputImageFile = new File(outputDir, "page_" + pageIndex + ".png");
            ImageIO.write(bufferedImage, "png", outputImageFile);


            return "Rendered page " + pageIndex + " to " + outputImageFile.getName();
        }
    }

    protected void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    protected PdfPTable addTable() {
        PdfPTable pdfTable = new PdfPTable(5);
        PdfPCell cell = new PdfPCell(new Paragraph(" "));
        pdfTable.addCell(cell);
        return pdfTable;
    }
}
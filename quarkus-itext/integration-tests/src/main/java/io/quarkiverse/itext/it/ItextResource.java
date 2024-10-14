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
package io.quarkiverse.itext.it;

import java.io.ByteArrayOutputStream;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfString;
import com.lowagie.text.pdf.PdfWriter;

@Path("/itext")
@ApplicationScoped
public class ItextResource {
    // add some rest methods here

    @GET
    public String hello() {
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
            System.err.println(de.getMessage());
            throw new RuntimeException(de);
        } finally {
            // step 5: we close the document
            document.close();
        }

        return "Hello itext";
    }

    protected void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.addParagraph(new Paragraph(" "));
        }
    }

    protected PdfPTable addTable() {
        PdfPTable pdfTable = new PdfPTable(5);
        PdfPCell cell = new PdfPCell(new Paragraph(" "));
        pdfTable.addCellAsCell(cell);
        return pdfTable;
    }
}
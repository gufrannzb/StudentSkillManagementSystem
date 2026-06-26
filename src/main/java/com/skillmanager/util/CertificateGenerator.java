package com.skillmanager.util;

import java.io.IOException;
import java.io.OutputStream;

import java.io.InputStream;

import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

public class CertificateGenerator {

    public static void generateCertificate(
OutputStream outputStream,
String imagePath,
String studentName,
String skillName,
double percentage,
String level,
String certificateCode,
String issueDate,
String verifyUrl)
throws IOException {

PDDocument document =
        new PDDocument();

PDPage page =
        new PDPage(
                new PDRectangle(
                        PDRectangle.A4.getHeight(),
                        PDRectangle.A4.getWidth()
                ));

document.addPage(page);

PDPageContentStream content =
        new PDPageContentStream(
                document,
                page);

BufferedImage bufferedImage =
        ImageIO.read(
                new java.io.File(
                        imagePath));

PDImageXObject background =
        LosslessFactory.createFromImage(
                document,
                bufferedImage);

content.drawImage(
        background,
        0,
        0,
        page.getMediaBox().getWidth(),
        page.getMediaBox().getHeight());

// STUDENT NAME

content.beginText();

content.setFont(
        new PDType1Font(
                Standard14Fonts.FontName.HELVETICA_BOLD),
        20);

content.newLineAtOffset(
        75,
        333);

content.showText(
        studentName);

content.endText();

// SKILL NAME

content.beginText();

content.setFont(
        new PDType1Font(
                Standard14Fonts.FontName.HELVETICA),
        18);

content.newLineAtOffset(
        75,
        258);

content.showText(
        skillName);

content.endText();

// SCORE

content.beginText();

content.setFont(
        new PDType1Font(
                Standard14Fonts.FontName.HELVETICA),
        14);

content.newLineAtOffset(
        125,
        180);

content.showText(
        String.valueOf(
                percentage)
        + "%");

content.endText();

// LEVEL

content.beginText();

content.setFont(
        new PDType1Font(
                Standard14Fonts.FontName.HELVETICA),
        14);

content.newLineAtOffset(
        125,
        142);

content.showText(
        level);

content.endText();

// CERTIFICATE CODE

content.beginText();

content.setFont(
        new PDType1Font(
                Standard14Fonts.FontName.HELVETICA),
        12);

content.newLineAtOffset(
        165,
        118);

content.showText(
        certificateCode);

content.endText();

// ISSUE DATE

content.beginText();

content.setFont(
        new PDType1Font(
                Standard14Fonts.FontName.HELVETICA),
        12);

content.newLineAtOffset(
        145,
        85);

content.showText(
        issueDate);

content.endText();

// VERIFY URL

content.beginText();

content.setFont(
        new PDType1Font(
                Standard14Fonts.FontName.HELVETICA),
        8);

content.newLineAtOffset(
        411,
        113);

content.showText(
        verifyUrl);

content.endText();

content.close();

document.save(
        outputStream);

document.close();

}
}

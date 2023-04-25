package ma.emsi.livrable_java.tasks;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFromDocxFileGetText {
    public static void main(String[] args) throws InvalidFormatException, IOException {


        FileInputStream fis = new FileInputStream("src/main/resources/inputData.docx");
        XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
        XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
        System.out.println(extractor.getText());

    }
}

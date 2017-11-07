package RelateExcel;

import dictionary.Colection;
import dictionary.ManageDictionary;
import dictionary.Word;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Administrator
 */
public class Excel {
    
    private String fileName = "Files/Words.xlsx";

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    
    
    public void writeExcel(String fileName, ManageDictionary dictionay) throws FileNotFoundException, IOException {
        //Tao workbook
        Workbook wb = new XSSFWorkbook();
        //Tao sheet
        Sheet sheet = wb.createSheet("new sheet");
        //Tao row
     
        int indexRow = 0;
        for(Colection oneColection: dictionay.getColections()){
            for(Word oneWord : oneColection.getWords()){
                Row row = sheet.createRow(++indexRow);
                row.createCell(0).setCellValue(oneColection.getName());
                row.createCell(1).setCellValue(oneWord.getEnglish());
                row.createCell(2).setCellValue(oneWord.getVietnamese());
                row.createCell(3).setCellValue(oneWord.getLastTime());
                row.createCell(4).setCellValue(oneWord.getImage());
                
            }
        }
        
        //Write into file
        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
            wb.write(fileOut);
            fileOut.close();
        }
    }

    public ManageDictionary readExcel(String fileName) throws FileNotFoundException, IOException {
        ManageDictionary dictionary = null;
        try (OPCPackage pkg = OPCPackage.open(new File(fileName))) {
            XSSFWorkbook wb = new XSSFWorkbook(pkg);
            
            dictionary = new ManageDictionary();
            
            for (Sheet sheet : wb) {
                int rowStart = Math.min(15, sheet.getFirstRowNum());
                int rowEnd = Math.max(1400, sheet.getLastRowNum());
                
                for(int rowNum = rowStart; rowNum < rowEnd; rowNum++){
                    Row row = sheet.getRow(rowNum);

                    if(!(row == null)){
                        Word newWord = new Word();
                        newWord.setEnglish(row.getCell(1).toString());
                        newWord.setVietnamese(row.getCell(2).toString());
                        newWord.setLastTime((long) Float.parseFloat(row.getCell(3).toString()));
                        newWord.setImage(row.getCell(4).toString());
                        
                        Colection oneColection = dictionary.getColectionByName(row.getCell(0).toString());
                        if(oneColection != null){
                            oneColection.addWord(newWord);
                        }else{
                            oneColection = new Colection(row.getCell(0).toString());
                            oneColection.addWord(newWord);
                            dictionary.addColection(oneColection);
                        }
                    }
                }
            }
            
        } catch (InvalidFormatException ex) {
            System.out.println(ex);
        }
        return dictionary;
    }
}

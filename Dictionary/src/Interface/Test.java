/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import RelateExcel.Excel;
import dictionary.ManageDictionary;
import dictionary.Word;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Date date = new Date();
        long time = System.currentTimeMillis();
        System.out.println("Now: " + date + " is " + System.currentTimeMillis());
        System.out.println("Time: " + time);
        

        Study s = new Study(4, 4);
        
        Excel m = new Excel();
        String fileName = m.getFileName();
        ManageDictionary dictionary;
        dictionary = m.readExcel(fileName);
        
        ArrayList<Word> xxx = s.getWordsByLastTime(dictionary);
        
        for(Word oneWord: xxx){
            System.out.println(oneWord.getEnglish());
        }
    
    }
}

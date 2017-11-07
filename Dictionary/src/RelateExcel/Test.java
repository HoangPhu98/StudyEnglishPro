/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RelateExcel;

import dictionary.Colection;
import dictionary.ManageDictionary;
import dictionary.Word;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Test {
    public static void main(String[] args) {
        try {
            Excel m = new Excel();
            String fileName = m.getFileName();
            ManageDictionary dictionary;
            dictionary = m.readExcel(fileName);
            for(Colection oneColection : dictionary.getColections()){
                ArrayList<Word> wo = oneColection.getWords();
                System.out.println("Name Colection: " + oneColection.getName());
                for (int i = 0; i < wo.size(); i++) {
                    System.out.println(wo.get(i).getEnglish() + " is mean "
                            + wo.get(i).getVietnamese() + " have time "
                            + wo.get(i).getLastTime() + " have image "
                            + wo.get(i).getImage());
                }
            }
            m.writeExcel(fileName, dictionary);
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }
}

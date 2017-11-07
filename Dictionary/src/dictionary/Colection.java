package dictionary;

import java.util.ArrayList;

/**
 *
 * @author hoangphu
 */
public class Colection {

    private ArrayList<Word> words;

    private String name;

    public Colection() {
        this.words = new ArrayList();
        this.name = "none";
    }
    
    public Colection(ArrayList<Word> words){
        this.words = words;
        this.name = "none";
    }
    
    public Colection(String name) {
        this.words = new ArrayList();
        this.name = name;
    }

    public Colection(ArrayList<Word> words, String name) {
        this.words = words;
        this.name = name;
    }
    
    
    
    public String getName() {
        return name;
    }

    public ArrayList<Word> getWords(){
        return this.words;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void createNewWord(String english, String vietnamese, long lastTime, String image){
        Word newWord = new Word(english, vietnamese, lastTime, image);
        words.add(newWord);
    }
    
    public void addWord(Word newWord) {
        words.add(newWord);
    }
    
    public void editEnglishFromEnglish(String oldNameEnglish, String re_english){
        int i = 0;
        while (words.get(i).getEnglish().equalsIgnoreCase(oldNameEnglish) && i < words.size()) {
            i++;
        }
        if (i < words.size()) {
            words.get(i).setEnglish(re_english);
        } else {
            System.out.println("Not found word invalid!");
        }
    }
    
    public void editEnglishFromVietnamese(String vietnamese, String re_english){
        int i = 0;
        while (words.get(i).getVietnamese().equalsIgnoreCase(vietnamese) && i < words.size()) {
            i++;
        }
        if (i < words.size()) {
            words.get(i).setEnglish(re_english);
        } else {
            System.out.println("Not found word invalid!");
        }
    }
    
    public void editVietnameseFromVietnamese(String oldNameVietnamese, String re_vietnamese){
        int i = 0;
        while (words.get(i).getVietnamese().equalsIgnoreCase(oldNameVietnamese) && i < words.size()) {
            i++;
        }
        if (i < words.size()) {
            words.get(i).setVietnamese(re_vietnamese);
        } else {
            System.out.println("Not found word invalid!");
        }
    }
    
    public void editVietnameseFromEnglish(String english, String re_vietnamese){
        int i = 0;
        while (words.get(i).getEnglish().equalsIgnoreCase(english) && i < words.size()) {
            i++;
        }
        if (i < words.size()) {
            words.get(i).setVietnamese(re_vietnamese);
        } else {
            System.out.println("Not found word invalid!");
        }
    }
    
    public void removeEnglish(String english) {
        int i = 0;
        while (words.get(i).getEnglish().equalsIgnoreCase(english) && i < words.size()) {
            i++;
        }
        if (i < words.size()) {
            words.remove(i);
        } else {
            System.out.println("Not found word invalid!");
        }
    }
    
    
    public void removeVietnamese(String vietnamese) {
        int i = 0;
        while (words.get(i).getVietnamese().equalsIgnoreCase(vietnamese) && i < words.size()) {
            i++;
        }
        if (i < words.size()) {
            words.remove(i);
        } else {
            System.out.println("Not found word invalid!");
        }
    }
}


package dictionary;

import java.util.Comparator;


/**
 *
 * @author hoangphu
 */
public class Word {
    String vietnamese;
    String english;
    long lastTime;
    String image;

    public Word() {
        this.vietnamese = "none";
        this.english = "none";
        this.lastTime = 0;
        this.image = "NaN";
    }
    
    public Word(String vietnamese, String english, long lastTime, String image) {
        this.vietnamese = vietnamese;
        this.english = english;
        this.lastTime = lastTime;
        this.image = image;
    }
    
    public void setAll(String vietnamese, String english, long lastTime, String image) {
        this.vietnamese = vietnamese;
        this.english = english;
        this.lastTime = lastTime;
        this.image = image;
    }
    
    public String getVietnamese() {
        return vietnamese;
    }

    public String getEnglish() {
        return english;
    }

    public long getLastTime() {
        return lastTime;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    public void setVietnamese(String vietnamese) {
        this.vietnamese = vietnamese;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }

    public String getImage() {
        return image;
    }
    
            /*Comparator for sorting the list by roll no*/
    public static Comparator<Word> WordLastTime = (Word w1, Word w2) -> {
        long timeNo1 = w1.getLastTime();
        long timeNo2 = w2.getLastTime();
        
        /*For ascending order*/
        return (int) (timeNo1-timeNo2);
        
        /*For descending order*/
        //rollno2-rollno1;
    };
    
}

package Interface;

import dictionary.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Hoang Van Phu
 */
public class Study {

    private int numberWordsLearn;
    private int numberWordReview;   //Gia tri phai lon hon 6

    public Study(int numberWordsLearn, int numberWordReview) {
        this.numberWordsLearn = numberWordsLearn;
        this.numberWordReview = numberWordReview;
    }

    public Study() {
        this.numberWordsLearn = 7;
        this.numberWordReview = 7;
    }

    public int getNumberWordsLearn() {
        return numberWordsLearn;
    }

    public int getNumberWordReview() {
        return numberWordReview;
    }

    public void setNumberWordsLearn(int numberWordsLearn) {
        this.numberWordsLearn = numberWordsLearn;
    }

    public void setNumberWordReview(int numberWordReview) {
        this.numberWordReview = numberWordReview;
    }

    public void learn(ManageDictionary dictionary) {
        int number = 0;
        Scanner var = new Scanner(System.in);
        for (Colection oneColection : dictionary.getColections()) {
            for (Word oneWord : oneColection.getWords()) {
                if (number >= numberWordsLearn) {
                    break;
                }
                if (oneWord.getLastTime() == 0) {
                    System.out.println(oneWord.getEnglish() + " is mean " + oneWord.getVietnamese()
                            + " image " + oneWord.getImage());
                    oneWord.setLastTime(System.currentTimeMillis());
                    boolean flag;
                    do {
                        flag = false;
                        System.out.println("Write English of \"" + oneWord.getVietnamese() + "\": ");
                        String yourAnswer = var.nextLine();
                        if (oneWord.getEnglish().equalsIgnoreCase(yourAnswer)) {
                            System.out.println("All right");
                            flag = true;
                        } else {
                            System.out.println("Wou weong");
                            System.out.println("You cam Remember " + oneWord.getEnglish() + " is mean " + oneWord.getVietnamese()
                                    + " image " + oneWord.getImage());
                        }
                    } while (!flag);
                    number++;
                }
            }
            if (number >= numberWordsLearn) {
                break;
            }
        }
        System.out.println("Mission Sucessfull");
    }

    //Lấy ra danh sách các từ để ôn
    //Private
    public ArrayList<Word> getWordsByLastTime(ManageDictionary dictionary) {
        ArrayList<Word> allWord = new ArrayList<>();
        ArrayList<Word> result = new ArrayList<>();

        for (Colection oneColection : dictionary.getColections()) {
            for (Word oneWord : oneColection.getWords()) {
                allWord.add(oneWord);
            }
        }

        Collections.sort(allWord, Word.WordLastTime);

        int number = 0;

        for (Word oneWord : allWord) {
            if (this.numberWordReview <= number) {
                break;
            }
            if (oneWord.getLastTime() != 0) {
                result.add(oneWord);
                number++;
            }
        }

        return result;
    }

    public void review(ManageDictionary dictionary) {

        Scanner var = new Scanner(System.in);

        ArrayList<Word> wordsReview = this.getWordsByLastTime(dictionary);

        int j;

        for (int inc = 0; inc < 2; inc++) {
            for (int i = 0; i < 6; i++) {
                Word wordReview = wordsReview.get(i);
                int rand = (int) (Math.random() * 2);
                ArrayList<String> selections = new ArrayList<>();
                if (rand == 0) {    //English -> VietNamese
                    System.out.println(wordReview.getEnglish() + " is mean ?");
                    selections.add(wordReview.getVietnamese());
                    j = i;
                    for (int ii = 0; ii < 5; ii++) {
                        if (j + 1 >= wordsReview.size()) {
                            j = 0;
                        } else {
                            j++;
                        }
                        selections.add(wordsReview.get(j).getVietnamese());
                    }
                    Collections.shuffle(selections);    //Xao tron vi tri cac ket qua

                    for (int ii = 0; ii < 6; ii++) {
                        System.out.println((ii + 1) + ": " + selections.get(ii));
                    }
                    int index = var.nextInt();
                    if (selections.get(index - 1).equalsIgnoreCase(wordReview.getVietnamese())) {
                        System.out.println("You are genius");
                    } else {
                        System.out.println("You are stupid");
                        System.out.println("Result: " + wordReview.getVietnamese());
                    }
                } else {    //VietNamese -> English
                    System.out.println(wordReview.getVietnamese() + " tuong duong voi:");
                    selections.add(wordReview.getEnglish());
                    j = i;
                    for (int ii = 0; ii < 5; ii++) {
                        if (j + 1 >= wordsReview.size()) {
                            j = 0;
                        } else {
                            j++;
                        }
                        selections.add(wordsReview.get(j).getEnglish());
                    }
                    Collections.shuffle(selections);    //Xao tron vi tri cac ket qua

                    for (int ii = 0; ii < 6; ii++) {
                        System.out.println((ii + 1) + ": " + selections.get(ii));
                    }
                    int index = var.nextInt();
                    if (selections.get(index - 1).equalsIgnoreCase(wordReview.getEnglish())) {
                        System.out.println("You are genius");
                    } else {
                        System.out.println("You are stupid");
                        System.out.println("Result: " + wordReview.getEnglish());
                    }
                }
            }
        }
    }
}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Caden Chock
 * */

public class SpellCheck {


    /**
     * checkWords finds all words in text that are not present in dictionary
     *
     * @param text The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all mispelled words in the order they appear in text. No duplicates.
     */
    public String[] checkWords(String[] text, String[] dictionary) {
        Set<String> notWords = new HashSet<String>();
        ArrayList<String> sortNotWords = new ArrayList<String>();

        for(int i = 0; i < text.length; i++){
            // Binary Search to Check if Word is in Dictionary
            boolean isWord = searchDic(text[i], 0, dictionary.length-1, dictionary);
            if(!isWord){
                if(notWords.add(text[i])){
                    sortNotWords.add(text[i]);
                }
            }
        }
        return sortNotWords.toArray(new String[0]);
    }

    // Uses Binary Search to Find a Word in a Dictionary taken from Spelling Bee
    public boolean searchDic(String s, int start, int end, String[] dictionary){
        int divide = start + (end-start)/2;
        String check = dictionary[divide];
        if(s.equals(check)){
            return true;
        }
        if(start >= end){
            return false;
        }
        if(s.compareTo(check) < 0){
            return searchDic(s,start, divide-1, dictionary);
        }
        else{
            return searchDic(s,divide +1,end, dictionary);
        }
    }

    public boolean searchList(String s, int start, int end, ArrayList<String> dictionary){
        int divide = start + (end-start)/2;
        String check = dictionary.get(divide);
        if(s.equals(check)){
            return true;
        }
        if(start >= end){
            return false;
        }
        if(s.compareTo(check) < 0){
            return searchList(s,start, divide - 1, dictionary);
        }
        else{
            return searchList(s,divide +1, end, dictionary);
        }
    }
}



/* Using a Set
Set<String> notWords = new HashSet<String>();
        ArrayList<String> sortNotWords = new ArrayList<String>();
        for(int i = 0; i < text.length; i++){
            // Binary Search to Check if Word is in Dictionary
            boolean isWord = searchDic(text[i], 0, dictionary.length-1, dictionary);
            if(!isWord){
                notWords.add(text[i]);
                if(notWords.contains(text[i])){
                    sortNotWords.add(text[i]);
                }
            }
        }
        return sortNotWords.toArray(new String[0]);
 */

/* Using a Loop
ArrayList<String> notWords = new ArrayList<String>();
        for(int i = 0; i < text.length; i++){
            // Binary Search to Check if Word is in Dictionary
           if(notWords.isEmpty()){
               boolean isWord = searchDic(text[i], 0, dictionary.length-1, dictionary);
               if(!isWord){
                   notWords.add(text[i]);
               }
           }
           else{
               if(!notWords.contains(text[i])){
                   boolean isWord = searchDic(text[i], 0, dictionary.length-1, dictionary);
                   if(!isWord){
                       notWords.add(text[i]);
                   }
               }
           }

        }
        return notWords.toArray(new String[0]);
 */
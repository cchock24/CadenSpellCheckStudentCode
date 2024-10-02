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
        ArrayList<String> notWords = new ArrayList<String>();
        Node rootDic = new Node();
        setTrie(dictionary, rootDic);
        Node rootNot = new Node();
        for(String s: text){
            // Checks if in notWord
            if(checkTrie(s, rootNot)){
                // Checks if in Dictionary
                if(checkTrie(s, rootDic)){
                    notWords.add(s);
                    addTrie(rootNot, s);
                }
            }
        }
        return notWords.toArray(new String[0]);
    }

    public void setTrie(String[] dictionary, Node root) {
        Node start = root;
        for (String s : dictionary) {
            root = start;
            for (int i = 0; i < s.length(); i++) {
                // Get Character's Node
                char c = s.charAt(i);
                int character = 0;
                if (!Character.isLetter(c)) {
                    character = 26;
                }
                else {
                    c = Character.toLowerCase(s.charAt(i));
                    character = c - 'a';
                }
                if(i == s.length()-1){
                    root.getNodes()[character] = new Node(true);
                }
                else{
                    if(root.getNodes()[character] == null){
                        root.getNodes()[character] = new Node();
                    }
                }
                root = root.getNodes()[character];
            }
        }
    }

    public boolean checkTrie(String s, Node root){
        char c;
        int character;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != '"') {
                c = Character.toLowerCase(s.charAt(0));
                character = c - 'a';
            }
            else{
                character = 26;
            }
            if(root.getNodes()[character] == null){
                return false;
            }
            if(root.getNodes()[character].isTerminate()){
                return true;
            }
            root = root.getNodes()[character];
        }
        return false;
    }

    public void addTrie(Node root, String s){
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int character = 0;
            if (!Character.isLetter(c)) {
                character = 26;
            }
            else {
                c = Character.toLowerCase(s.charAt(i));
                character = c - 'a';
            }
            if(i == s.length()-1){
                root.getNodes()[character] = new Node(true);
            }
            else{
                root.getNodes()[character] = new Node();
            }
            root = root.getNodes()[character];
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
                if(notWords.add(text[i])){
                    sortNotWords.add(text[i]);
                }
            }
        }
        return sortNotWords.toArray(new String[0]);

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
 */
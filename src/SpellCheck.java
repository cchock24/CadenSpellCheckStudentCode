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

    // The Array Spots for TST_Node
    int great = 2;
    int equal = 1;
    int less = 0;

    /**
     * checkWords finds all words in text that are not present in dictionary
     *
     * @param text The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all mispelled words in the order they appear in text. No duplicates.
     */
    public String[] checkWords(String[] text, String[] dictionary) {
        ArrayList<String> notWords = new ArrayList<String>();
        TST_Node rootDic = new TST_Node('a');
        setTrie(dictionary, rootDic);
        TST_Node rootNot = new TST_Node('a');
        for(String s: text){
            // Checks if in notWord
            if(!checkTrie(s, rootNot)){
                // Checks if in Dictionary
                if(!checkTrie(s, rootDic)){
                    notWords.add(s);
                    addTrie(rootNot, s);
                }
            }
        }
        return notWords.toArray(new String[0]);
    }

    public void setTrie(String[] dictionary, TST_Node root) {
        TST_Node current = root;
        for (String s : dictionary) {
            current = root;
            boolean b = false;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                b = false;
                while(!b){
                    if(current.getC() == 0){
                        if(i == s.length()-1){
                            current.setC(c);
                            current.setTerminate(true);
                        }
                        else{
                            current.setC(c);
                        }
                        break;
                    }
                    else{
                        if(c == current.getC()){
                            if(current.getNodes()[equal] == null){
                                if(i == s.length()-1){
                                    current.getNodes()[equal] = new TST_Node(c);
                                    current.getNodes()[equal].setTerminate(true);
                                }
                                else{
                                    current.getNodes()[equal] = new TST_Node();
                                }
                                b= true;
                            }
                            current = current.getNodes()[equal];
                        }
                        else if(c > current.getC()){
                            if(current.getNodes()[great] == null){
                                if(i == s.length()-1){
                                    current.getNodes()[great] = new TST_Node(c);
                                    current.getNodes()[great].setTerminate(true);
                                }
                                else{
                                    current.getNodes()[great] = new TST_Node();
                                }
                                b= true;
                            }
                            current = current.getNodes()[great];
                        }
                        else if(c < current.getC()){
                            if(current.getNodes()[less] == null){
                                if(i == s.length()-1){
                                    current.getNodes()[less] = new TST_Node(c);
                                    current.getNodes()[less].setTerminate(true);
                                }
                                else{
                                    current.getNodes()[less] = new TST_Node();
                                }
                                b= true;
                            }
                            current = current.getNodes()[less];
                        }
                    }
                }
            }

        }
    }

    public boolean checkTrie(String s, TST_Node root){
        boolean b = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            b = false;
            while(!b){
                if(root == null){
                   return false;
                }
                if(c == root.getC()){
                    if(i == s.length()-1 && root.isTerminate()){
                        return true;
                    }
                    root = root.getNodes()[equal];
                    b = true;
                }
                else if(c > root.getC()){
                    root = root.getNodes()[great];
                }
                else{
                    root = root.getNodes()[less];
                }
            }
        }
        return false;
    }

    public void addTrie(TST_Node root, String s){
        TST_Node current = root;
        boolean b = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            b = false;
            while(!b){
                if(c == current.getC()){
                    if(current.getNodes()[equal] == null){
                        b = true;
                        if(i == s.length()-1){

                            current.getNodes()[equal] = new TST_Node(true, c);
                        }
                        else{
                            current.getNodes()[equal] = new TST_Node(c);
                        }
                    }
                    current = current.getNodes()[equal];
                }
                else if(c > current.getC()){
                    if(current.getNodes()[great] == null){
                        b = true;
                        if(i == s.length()-1){
                            current.getNodes()[great] = new TST_Node(true,c);

                        }
                        else{
                            current.getNodes()[great] = new TST_Node(c);
                        }
                    }
                    current = current.getNodes()[great];
                }
                else if(c < current.getC()){
                    if(current.getNodes()[less] == null){
                        b = true;
                        if(i == s.length()-1){
                            current.getNodes()[less] = new TST_Node(true,c);
                        }
                        else{
                            current.getNodes()[less] = new TST_Node(c);
                        }
                    }
                    current = current.getNodes()[less];
                }
            }
        }
    }
}






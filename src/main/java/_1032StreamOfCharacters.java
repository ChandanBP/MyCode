import java.util.ArrayDeque;

public class _1032StreamOfCharacters {

    class Trie{
        boolean isWord;
        Trie trie[];
    }

    Trie root = new Trie();
    ArrayDeque<Character>query;

    public int charToInt(char c){
        return c-'a';
    }

    public void insertIntoTrie(String word){

        Trie node = root;
        for(int j=word.length()-1;j>=0;j--){
            char ch = word.charAt(j);
            int cToInt = charToInt(ch);
            if(node.trie==null)
                node.trie = new Trie[26];
            if(node.trie[cToInt]==null)
                node.trie[cToInt] = new Trie();

            node = node.trie[cToInt];
        }
        node.isWord = true;
    }

    public _1032StreamOfCharacters(String[] words) {
        query = new ArrayDeque<>();
        for(int i=0;i<words.length;i++){
            String word = words[i];
            insertIntoTrie(word);
        }
    }

    public boolean query(char letter) {
        query.addFirst(letter);
        Trie node = root;
        for(char ch:query){
            int cToInt = charToInt(ch);

            if(node.trie==null)return false;
            if(node.trie[cToInt]==null)return false;
            node = node.trie[cToInt];
            if(node.isWord)return true;
        }
        return node.isWord;
    }

    public static void main(String[] args) {
        _1032StreamOfCharacters streamChecker = new _1032StreamOfCharacters(new String[]{"cd","f","kl"});
        streamChecker.query('a');          // return false
        streamChecker.query('b');          // return false
        streamChecker.query('c');          // return false
        streamChecker.query('d');          // return true, because 'cd' is in the wordlist
        streamChecker.query('e');          // return false
        streamChecker.query('f');          // return true, because 'f' is in the wordlist
        streamChecker.query('g');          // return false
        streamChecker.query('h');          // return false
        streamChecker.query('i');          // return false
        streamChecker.query('j');          // return false
        streamChecker.query('k');          // return false
        streamChecker.query('l');          // return true, because 'kl' is in the wordlist
    }
}

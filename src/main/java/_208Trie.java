public class _208Trie {

    class TrieNode{
        boolean isEnd;
        TrieNode trie[];
    }

    TrieNode root = new TrieNode();

    public int charToInt(char ch){
        return ch-'a';
    }

    public void insert(String word) {

        if(word==null||word.length()<1)return;

        TrieNode node = root;
        for(int i=0;i<word.length();i++){

            if(node.trie==null)node.trie = new TrieNode[26];

            if(node.trie[charToInt(word.charAt(i))]==null){
                node.trie[charToInt(word.charAt(i))] = new TrieNode();
            }
            node = node.trie[charToInt(word.charAt(i))];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        if(node.trie==null)return false;
        for(int i=0;i<word.length();i++){
            if(node.trie==null||node.trie[charToInt(word.charAt(i))]==null)return false;
            node = node.trie[charToInt(word.charAt(i))];
        }
        return (node.isEnd==true)?true:false;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        if(node.trie==null)return false;
        for(int i=0;i<prefix.length();i++){
            if(node.trie==null||node.trie[charToInt(prefix.charAt(i))]==null)return false;
            node = node.trie[charToInt(prefix.charAt(i))];
        }
        return true;
    }

    public static void main(String[] args) {
        _208Trie obj = new _208Trie();
        obj.insert("hello");
        obj.search("hell");
        obj.search("helloa");
        obj.search("hello");
        obj.startsWith("hell");
        obj.startsWith("helloa");
        obj.startsWith("hello");
    }
}

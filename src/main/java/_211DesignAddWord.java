public class _211DesignAddWord {
    Trie root;
    class Trie{
        Trie trie[];
        boolean isEnd;
    }

    /** Initialize your data structure here. */
    public _211DesignAddWord() {
        root = new Trie();
        root.trie = new Trie[26];
    }

    public int charToInt(char c){
        return c-'a';
    }


    public void addWord(String word) {

        if(word==null || word.length()==0)return;

        Trie node = root;
        for(int i=0;i<word.length();i++){
            int index = charToInt(word.charAt(i));
            if(node.trie==null)
                node.trie = new Trie[26];
            if(node.trie[index]==null)
                node.trie[index] = new Trie();
            node = node.trie[index];
        }
        node.isEnd = true;
    }

    public boolean dfs(Trie node,String word,int i){

        if(i==word.length() && !node.isEnd)return false;
        if(i==word.length() && node.isEnd)return true;
        if(node==null||node.trie==null)return false;

        boolean val = false;
        if(word.charAt(i)!='.'){
            int index = charToInt(word.charAt(i));
            if(node.trie[index]==null)return false;
            val = dfs(node.trie[index],word,i+1);
        }else{
            for(int j=0;j<26;j++){
                if(node.trie[j]!=null){
                    if(dfs(node.trie[j],word,i+1)){
                        val = true;
                        break;
                    }
                }
            }

        }
        return val;
    }

    public boolean search(String word) {
        return dfs(root,word,0);
    }
}

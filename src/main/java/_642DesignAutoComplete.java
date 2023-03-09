import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class _642DesignAutoComplete {

    int k = 3;
    List<String>result = new LinkedList<>();
    StringBuilder query = new StringBuilder();
    class Trie{
        int count[] = new int[32];
        Trie trie[] = new Trie[32];
    }

    class CharacterCount implements Comparable<CharacterCount>{
        int count;
        char ch;
        public CharacterCount(int count,char ch){
            this.ch = ch;
            this.count = count;
        }

        @Override
        public int compareTo(CharacterCount characterCount) {
            return characterCount.count-this.count;
        }
    }

    Trie root,crawl;

    public void insertSentence(String sentence){

        if(root==null) root=new Trie();

        Trie node = root;
        for(int i=0;i<sentence.length();i++){
            char ch = sentence.charAt(i);

            if(node==null)node = new Trie();
            if(ch==' '){
                node.count[31]++;
                if(node.trie[31]==null){
                    node.trie[31] = new Trie();
                }
                node = node.trie[31];
            }
            else{
                node.count[ch-'a']++;
                if(node.trie[ch-'a']==null){
                    node.trie[ch-'a'] = new Trie();
                }
                node = node.trie[ch-'a'];
            }
        }
    }

    public boolean checkEndOfString(int ch[]){
        for (int c:ch)if(c!=0)return false;
        return true;
    }

    public _642DesignAutoComplete(String[] sentences, int[] times) {
        for(int i=0;i<times.length;i++){
            int time = times[i];
            while((time--)>0){
                insertSentence(sentences[i]);
            }
        }
    }

    public List<String> input(char c) {
        query.append(c);
        if(crawl==null)crawl = root;
        if(crawl.trie==null)return result;

        crawl = (c==' ')?crawl.trie[31]:crawl.trie[c-'a'];
        if(crawl==null)return result;

        PriorityQueue<CharacterCount>queue = new PriorityQueue<>();
        for(int i=0;i<32;i++){
            if(crawl.count[i]>0){
                char ch = (i==31)?' ':(char)('a'+i);
                queue.add(new CharacterCount(crawl.count[i],ch));
            }
        }

        while (!queue.isEmpty() && result.size()<k){
            CharacterCount cc = queue.poll();
            Trie node = crawl.trie[(cc.ch==' ')?31:cc.ch-'a'];
            getSentence(node,(c==31)?' ':(char)('a'+(cc.ch-'a')));
        }
        LinkedList r = new LinkedList(result);
        result = new LinkedList<>();
        return r;
    }

    public void getSentenceUtil(Trie node,int c,StringBuilder sb){

        if(result.size()==k||node==null)return;

        if(checkEndOfString(node.count)){
            result.add(query.toString()+sb.toString());
            return;
        }
        PriorityQueue<CharacterCount>queue = new PriorityQueue<>();
        for(int i=0;i<32;i++){
            if(node.count[i]>0){
                char ch = (i==31)?' ':(char)('a'+i);
                queue.add(new CharacterCount(node.count[i],ch));
            }
        }
        while (!queue.isEmpty() && result.size()<k){
            CharacterCount cc = queue.poll();
            Trie node1 = node.trie[(cc.ch==' ')?31:cc.ch-'a'];
            getSentenceUtil(node1,cc.ch-'a',new StringBuilder(sb).append(cc.ch));
        }
    }

    public void getSentence(Trie node,char c){

        StringBuilder sb = new StringBuilder();
        sb.append(c);

        if(checkEndOfString(node.count)){
            result.add(sb.toString());
            return;
        }

        int i=0;
        while(i<32){
            if(node.count[i]>0 && result.size()<k){
                sb.append((i==31)?' ':(char)('a'+i));
                getSentenceUtil(node.trie[i],i,sb);
            }
            ++i;
        }
    }

    public static void main(String[] args) {

        String sentences[] = new String[]{"i love you","island","ironman","i love leetcode"};
        int[] times = new int[]{5,3,2,2};
        _642DesignAutoComplete obj = new _642DesignAutoComplete(sentences,times);
        obj.input('i');
        obj.input(' ');
        obj.input('a');
        System.out.println();
    }
}

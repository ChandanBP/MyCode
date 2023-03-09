import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class _642DesignAutoComplete1 {

    PriorityQueue<StringCount>queue;
    StringBuilder query = new StringBuilder();
    class Trie{
        int count;
        Trie trie[];
    }

    class StringCount implements Comparable<StringCount>{
        int count;
        String str;
        public StringCount(int count,String str){
            this.str = str;
            this.count = count;
        }

        @Override
        public int compareTo(StringCount strCount) {
            if(this.count==strCount.count){
                return this.str.compareTo(strCount.str);
            }
            return this.count-strCount.count;
        }
    }

    public int charToInt(char ch){
        return (ch==' ')?31:ch-'a';
    }

    public char intToChar(int i){
        return (i==31)?' ':(char)('a'+i);
    }

    Trie root,crawl;
    public void insertSentence(String sentence,int time){

        Trie node = root;
        for(int i=0;i<sentence.length();i++){

            char ch = sentence.charAt(i);
            if(node.trie==null)node.trie = new Trie[32];

            if(node.trie[charToInt(ch)]==null){
                node.trie[charToInt(ch)] = new Trie();
            }
            node=node.trie[charToInt(ch)];
        }
        node.count += time;
    }

    public _642DesignAutoComplete1(String[] sentences, int[] times) {
        root=new Trie();
        crawl=root;
        for(int i=0;i<times.length;i++){
            insertSentence(sentences[i],times[i]);
        }
    }

    public void findStart(String s,Trie node){
        for(int i=0;i<s.length();i++){
            if(node.trie==null || node.trie[charToInt(s.charAt(i))]==null){
                return;
            }
            node = node.trie[charToInt(s.charAt(i))];
        }
        getSentence(node,new StringBuilder(s));
    }

    public List<String> input(char c) {

        LinkedList<String>result = new LinkedList<>();

        queue = new PriorityQueue<>();

        if(c=='#'){
            insertSentence(query.toString(),1);
            query = new StringBuilder();
            crawl=root;
        }else{
            query.append(c);
            findStart(query.toString(),root);

        }
        while (!queue.isEmpty()){
            result.add(queue.poll().str);
        }
        Collections.reverse(result);
        return result;
    }

    public void getSentence(Trie node, StringBuilder sb){

        if(node.count>0){
            StringCount sc = new StringCount(node.count,sb.toString());
            if(queue.size()<3){
                queue.add(sc);
            }else{
                if(sc.count>queue.peek().count){
                    queue.poll();
                    queue.add(sc);
                }
                if(sc.count==queue.peek().count){
                    if(sb.toString().compareTo(queue.peek().str)<0){
                        queue.poll();
                        queue.add(sc);
                    }
                }
            }
        }

        if(node.trie==null)return;

        for(int i=0;i<32;i++){
            if(node.trie!=null){
                if(node.trie[i]!=null)
                    getSentence(node.trie[i],new StringBuilder(sb).append(intToChar(i)));
            }
            if(i==25)i=31;
        }
    }

    public static void main(String[] args) {

        String sentences[] = new String[]{"abc","abbc","a"};
        int[] times = new int[]{3,3,3};
        _642DesignAutoComplete1 obj = new _642DesignAutoComplete1(sentences,times);
        List<String>res =  obj.input('b');
        obj.input('c');
        obj.input('#');
        obj.input('b');
        obj.input('c');
        obj.input('#');
        obj.input('a');
        obj.input('b');
        obj.input('c');
        obj.input('#');
        obj.input('a');
        obj.input('b');
        obj.input('c');
        obj.input('#');
    }
}

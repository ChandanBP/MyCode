public class _14LongestCommonPrefix {

    class Trie{
        int count;
        Trie children[];
    }
    Trie root;
    String result="";
    int max=-1;
    public String insertIntoTrie(String str){

        if(root==null){
            root=new Trie();
        }
        Trie node = root;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            
            if(node.children==null)node.children = new Trie[26];
            if(node.children[str.charAt(i)-'a']==null)node.children[str.charAt(i)-'a'] = new Trie();
            node.children[str.charAt(i)-'a'].count++;
            if(node.children[str.charAt(i)-'a'].count>1 &&
               node.children[str.charAt(i)-'a'].count>=max){
                max=node.children[str.charAt(i)-'a'].count;
                sb.append(str.charAt(i));
            }
            node=node.children[str.charAt(i)-'a'];
        }

        return sb.toString();
    }

    public String longestCommonPrefix(String[] strs) {

        if(strs.length==1)return strs[0];

        boolean first=true;
        for(String word:strs){
            String res = insertIntoTrie(word);
            if(first){
                first=false;
            }else{
                if (res.length()==0)return "";
                else result=res;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new _14LongestCommonPrefix().longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}

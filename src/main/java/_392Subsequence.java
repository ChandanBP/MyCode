public class _392Subsequence {

    public boolean isSubsequence(String s, String t) {
        if(s.length()==0)return true;
        if(t.length()==0)return false;

        int k=0;
        for(int i=0;i<t.length();i++){
            if(k==s.length())return true;
            if(t.charAt(i)==s.charAt(k))++k;
        }
        return (k==s.length())?true:false;
    }

    public static void main(String[] args) {
        System.out.println(new _392Subsequence().isSubsequence("axc","ahbgdc"));
    }
}

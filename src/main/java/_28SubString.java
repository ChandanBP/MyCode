public class _28SubString {

    public int strStr(String haystack, String needle) {

        if(haystack==null || haystack.length()==0)return 0;
        if(haystack.length()<needle.length())return -1;
        int matching = -1;

        int j=0;
        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i)==needle.charAt(j)){
                if(j==0)matching = i;
                ++j;
            }else{
                matching = -1;
                j=0;
            }
            if(j>needle.length()-1)return matching;
        }
        return matching;
    }

    public static void main(String[] args) {
        System.out.println(new _28SubString().strStr("mississippi","issip"));
    }
}

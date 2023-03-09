public class _125ValidPalindrome {

    public boolean isPalindrome(String s) {
        if(s==null||s.isEmpty())return false;

        int i=0;
        int j=s.length()-1;
        s = s.toLowerCase();
        while(i<j){

            while(i<s.length() && !Character.isLetterOrDigit(s.charAt(i))){
                ++i;
            }


            while(j>=0 && !Character.isLetterOrDigit(s.charAt(j))){
                --j;
            }

            if(i>j)return true;

            if(s.charAt(i)!=s.charAt(j))return false;
            ++i;
            --j;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _125ValidPalindrome().isPalindrome("0P"));
    }
}

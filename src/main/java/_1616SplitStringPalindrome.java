public class _1616SplitStringPalindrome {

    public boolean checkStrings(String a,String b){
        int i=0;
        int j=b.length()-1;
        int n = a.length();
        int diff = (n%2==0)?1:2;

        while((j-i)>=diff){
            if(a.charAt(i)!=b.charAt(j))return false;
            ++i;
            --j;
        }
        return true;
    }

    public boolean checkPalindromeFormation(String a, String b) {

        if(a.length()<=1)return true;
        return checkStrings(a,b)||checkStrings(b,a);
    }

    public static void main(String[] args) {
        System.out.println(new _1616SplitStringPalindrome().checkPalindromeFormation("abda","acmc"));
    }
}

public class _1328BreakPalindrome {

    public static String breakPalindrome(String palindrome) {

        if(palindrome.length()==1) return "";

        char arr[] = palindrome.toCharArray();
        int i = 0;
        while (i<palindrome.length()/2){
            if(palindrome.charAt(i)!='a'){
                arr[i] = 'a';
                return new String(arr);
            }
            ++i;
        }

        if(i==palindrome.length()-1) arr[i] = 'b';
        else arr[i+1] = 'b';

        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(breakPalindrome("abccba"));
        System.out.println(breakPalindrome("aa"));
    }
}

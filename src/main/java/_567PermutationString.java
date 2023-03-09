import java.util.HashMap;

public class _567PermutationString {

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())return false;

        int s1count[] = new int[26];
        for(int i=0;i<s1.length();i++){
            s1count[s1.charAt(i)-'a']++;
        }

        int end = 0;
        int start = 0;
        int s2count[] = new int[26];
        while(end<s2.length()){
            char ch = s2.charAt(end);
            s2count[ch-'a']++;

            if((end-start+1)==s1.length()){
                if(isPermutation(s1count,s2count))return true;

                s2count[s2.charAt(start)-'a']--;
                ++start;
            }
            ++end;
        }
        return false;
    }

    public boolean isPermutation(int count1[],int count2[]){
        for(int i=0;i<26;i++){
            if(count1[i]!=count2[i])return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _567PermutationString().checkInclusion("ab","eidbbbaoo"));
    }
}

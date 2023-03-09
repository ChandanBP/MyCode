public class _38CountAndSay {

    public String countAndSay(int n) {

        if(n==1)return "1";

        int i = 2;
        String s = "11";

        // Number of iterations
        while(i<n){

            int j=1;
            StringBuilder res = new StringBuilder();
            while(j<s.length()){

                int c = 1;
                while(j<s.length() && s.charAt(j)==s.charAt(j-1)){
                    ++j;
                    ++c;
                }
                res.append(c);
                res.append(s.charAt(j-1));
                if(j==s.length()-1 && s.charAt(j)!=s.charAt(j-1)){
                    res.append(1);
                    res.append(s.charAt(j));
                }
                ++j;
            }
            s = res.toString();
            ++i;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new _38CountAndSay().countAndSay(30));
    }
}

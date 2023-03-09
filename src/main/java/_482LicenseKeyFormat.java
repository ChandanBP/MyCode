public class _482LicenseKeyFormat {

    public String licenseKeyFormatting(String S, int K) {

        StringBuilder res = new StringBuilder();
        int c=K;
        int i = S.length()-1;
        while(i>=0){
            if(S.charAt(i)!='-'){
                if(c==0 && i>=0){
                    res.append('-');
                    c=K;
                }
                if(Character.isAlphabetic(S.charAt(i))){
                    res.append(Character.toUpperCase(S.charAt(i)));
                }else{
                    res.append(S.charAt(i));
                }
                c--;
            }
            --i;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        new _482LicenseKeyFormat().licenseKeyFormatting("2-5g-3-J",2);
    }
}

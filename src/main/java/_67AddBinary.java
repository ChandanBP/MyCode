public class _67AddBinary {

    public String addBinary(String a, String b) {
        if(a.length() == 0 && b.length() == 0) {
            return "";
        }

        int i = a.length() - 1;
        int j = b.length() - 1;
        int s = 0;
        int c = 0;

        StringBuilder sb = new StringBuilder();

        while(i>=0 || j>=0) {

            s = c;

            if(i>=0) {
                s+= a.charAt(i) - '0';
                i--;
            }

            if(j>=0) {
                s+= b.charAt(j)  - '0';
                j--;
            }

            if(s >= 2) {
                c = s/2;
                s = s%2;
            }
            else {
                c = 0;
            }
            sb.insert(0, s);
        }

        if(c > 0) {
            sb.insert(0, c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        new _67AddBinary().addBinary("1010","1010");
    }
}

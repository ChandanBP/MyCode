public class _8ATOI {

    public void processDigits(int i,String str){

    }

    public int myAtoi(String str) {

        int i =0;
        while(i<str.length()&&str.charAt(i)==' '){
            ++i;
        }

        if(i==str.length())return 0;

        if(Character.isAlphabetic(str.charAt(i))){
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        if(str.charAt(i)=='+' || str.charAt(i)=='-'){
            sb.append(str.charAt(i++));
        }

        int count = 0;
        while(i<str.length()&& Character.isDigit(str.charAt(i))){
            sb.append(str.charAt(i));
            ++count;
            ++i;
        }

        if(count==0)return 0;

        double val = Double.valueOf(sb.toString());
        if(val>Integer.MAX_VALUE)return Integer.MAX_VALUE;
        else if(val<Integer.MIN_VALUE)return Integer.MIN_VALUE;
        else return (int) val;
    }

    public static void main(String[] args) {
        System.out.println(new _8ATOI().myAtoi("20000000000000000000"));
    }
}

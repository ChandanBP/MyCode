public class _1088ConfusingNumberII {

    char[][] map = new char[][]{{'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'}};
    public int confusingNumberII(int N) {
        //find total number combined from 5 digit <=N
        //minus palindrome
        String num = Integer.toString(N);
        int totalNumber = getTotalNumber(num);
        for (int i = 1; i <= num.length(); i++){
            char[] sub = new char[i];
            totalNumber -= util(sub, num, 0, i-1);
        }
        return totalNumber;
    }

    // 321 - [0, 300), [300, 320), [320, 321)
    private int getTotalNumber(String num){
        if (num.length() == 0) {
            return 1;
        }
        char fChar = num.charAt(0);
        //getCount all num that first < num first char 0/1<2
        int ret = getCount(num) * (int) Math.pow(5, num.length() - 1); // 5 possibiliteis
        //if first in map, getCount num that first char equal to target
        if (fChar =='0' || fChar == '1' || fChar == '6' || fChar == '8' || fChar == '9')
            ret += getTotalNumber(num.substring(1));
        return ret ;
    }

    private int getCount(String num){
        if (num.length()==0) {
            return 0;
        }
        int count = 0;
        char firstChar = num.charAt(0);
        for (char[] pair : map){
            if (pair[0] < firstChar) {
                count++;
            }
        }
        return count;
    }

    private int util(char[] arr, String num, int left, int right){
        int count=0;
        if( left > right){
            String sb = new String(arr);
            // compareTo compare dictionary order, 8>20, so compare only when length equal
            if (sb.length()<num.length() || sb.compareTo(num)<=0)
                count=1;
        } else {
            for(char[] pair: map){
                if ((left == 0 && pair[0] == '0' && arr.length>1) ||  // Should not start with 0.
                        (left == right && pair[0] != pair[1])) continue; // mid shouldn't be 6,9
                arr[left]=pair[0];
                arr[right]=pair[1];
                count += util(arr, num, left + 1, right - 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new _1088ConfusingNumberII().confusingNumberII(100));
    }
}

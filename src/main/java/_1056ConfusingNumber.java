public class _1056ConfusingNumber {
    public boolean isConfusing(String number){
        StringBuilder sb = new StringBuilder();
        for(int i=number.length()-1;i>=0;i--){
            char ch = number.charAt(i);
            if(ch=='2' || ch=='3' || ch=='4' || ch=='5' || ch=='7')return false;
            if(ch=='0')sb.append('0');
            if(ch=='1')sb.append('1');
            if(ch=='6')sb.append('9');
            if(ch=='8')sb.append('8');
            if(ch=='9')sb.append('6');
        }
        return !sb.toString().equals(number);
    }

    public boolean confusingNumber(int n) {
        return isConfusing(String.valueOf(n));
    }

    public static void main(String[] args) {
        System.out.println(new _1056ConfusingNumber().confusingNumber(000));
        /*
        16 - 91
        616 - 919
        * */
    }
}

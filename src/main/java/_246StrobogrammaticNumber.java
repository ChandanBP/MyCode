public class _246StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num) {

        int n = num.length();
        for(int i=0;i<num.length();i++){
            int digit = Integer.parseInt(num.charAt(i)+"");
            if(digit>=2 && digit<=5)return false;
            else if(digit==7)return false;
            else if(digit==6 && '9'!=num.charAt(n-1-i))return false;
            else if(digit==9 && '6'!=num.charAt(n-1-i))return false;
            else if(digit==0 || digit ==1 || digit==8){
                if(num.charAt(i)!=num.charAt(n-1-i))return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _246StrobogrammaticNumber().isStrobogrammatic("10"));
    }
}

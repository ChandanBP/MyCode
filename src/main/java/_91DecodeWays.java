import java.util.HashMap;

public class _91DecodeWays {

    HashMap<Integer,Integer>map = new HashMap<>();
    public int recurse(String s,int index){

        if(index>=s.length()-1)return 1;
        if(s.charAt(index)=='0')return 0;

        int res=0;
        // For one character
        res = recurse(s,index+1);
        if(Integer.parseInt(s.substring(index,index+2))<=26){
            res+=recurse(s,index+2);
        }

        map.put(index,res);
        return res;
    }

    public int numDecodings(String s) {

        if(s==null || s.length()==0)return 0;
        return recurse(s,0);
    }

    public static void main(String[] args) {
        System.out.println(new _91DecodeWays().numDecodings("12"));
    }
}

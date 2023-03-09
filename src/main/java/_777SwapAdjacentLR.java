public class _777SwapAdjacentLR {

    public boolean canTransform(String start, String end) {

        if(start==end)return true;
        if(start==null || end==null)return false;
        if(start.length()==0 || end.length()==0)return false;

        StringBuilder sb = new StringBuilder();
        int i=1;
        int t=0;
        while(i<end.length()){
            String s = ""+end.charAt(i-1)+end.charAt(i);
            if(s.equals("XR")){
                sb.append("A");
                t=i;
                i+=2;
            }
            else if(s.equals("LX")){
                sb.append("B");
                t=i;
                i+=2;
            }else{
                sb.append(end.charAt(i-1));
                t=i-1;
                i+=1;
            }
        }

        t+=1;
        while(t<end.length()){
            sb.append(end.charAt(t));
            ++t;
        }

        String s = sb.toString();
        sb = new StringBuilder();

        for(i=0;i<s.length();i++){
            if(s.charAt(i)=='A'){
                sb.append("RX");
            }else if(s.charAt(i)=='B'){
                sb.append("XL");
            }else{
                sb.append(s.charAt(i));
            }
        }

        return (sb.toString().equals(start))?true:false;
    }

    public static void main(String[] args) {
        _777SwapAdjacentLR obj = new _777SwapAdjacentLR();
        System.out.println(obj.canTransform("XXXLXXXXXX","XXXLXXXXXX"));
    }
}

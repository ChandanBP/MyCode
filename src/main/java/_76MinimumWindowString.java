public class _76MinimumWindowString {

    char count[]=new char[256];
    char init[]=new char[256];

    public String minWindow(String s, String t) {

        int start=0,end=0;
        int s1=0,e1=0;

        for(int i=0;i<t.length();i++){
            init[t.charAt(i)]++;
        }

        int min=s.length()+1;
        while(end<s.length()){
            if(checkIfZero()){
                if(((end-1-start)+1)<min){
                    min=(end-1-start)+1;
                    s1=start;
                    e1=end;
                }
                ++start;
                char ch = s.charAt(start-1);
                if(init[ch]>0)
                    count[ch]--;
            }else{
                char ch=s.charAt(end);
                if(init[ch]>0)count[ch]++;
                ++end;
            }
        }

        end--;
        while(start<=end){
            if(checkIfZero()){
                if(((end-start)+1)<min){
                    min=(end-start)+1;
                    s1=start;
                    e1=end+1;
                }
                char ch = s.charAt(start);
                if(init[ch]>0)
                    count[ch]--;
            }
            ++start;
        }

        return (min==s.length()+1)?"":s.substring(s1,e1);
    }

    public boolean checkIfZero(){
        for(int i=0;i<256;i++){
            if(init[i]>0 && count[i]<init[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _76MinimumWindowString().minWindow("ADOBECODEBANC","ABC"));
    }
}

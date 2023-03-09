import java.util.Stack;

public class _1209RemoveAdjacentDuplicates {

    class CC{
        int count;
        char c;
        public CC(char c){
            this.c=c;
            this.count=1;
        }
    }

    public String removeDuplicates(String s, int k) {

        Stack<CC>stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(stack.isEmpty()){
                stack.push(new CC(s.charAt(i)));
            }else{
                // previous character
                CC cc = stack.peek();
                if(cc.c!=s.charAt(i)){
                    stack.push(new CC(s.charAt(i)));
                }else{
                    cc = stack.pop();
                    cc.count++;
                    if(cc.count<k){
                        stack.push(cc);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            CC cc = stack.pop();
            while(cc.count!=0){
                sb.append(cc.c);
                cc.count--;
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {

    }
}

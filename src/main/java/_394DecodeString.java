import java.util.Stack;

public class _394DecodeString {

    public String decodeString(String s) {

        Stack<Character>stack = new Stack<>();
        StringBuilder sb;
        StringBuilder answer = new StringBuilder();

        int i = 0;
        while(i<s.length()){
            if(s.charAt(i)==']'){
                sb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek()!='['){
                    sb.append(stack.pop());
                }
                stack.pop();
                String str = sb.reverse().toString();

                sb = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    sb.append(stack.pop());
                }
                int digit = Integer.parseInt(sb.reverse().toString());

                sb = new StringBuilder();
                while(digit!=0){
                    sb.append(str);
                    --digit;
                }

                str = sb.toString();
                for(int k=0;k<str.length();k++){
                    stack.push(str.charAt(k));
                }
            }else{
                stack.push(s.charAt(i));
            }
            ++i;
        }

        while(!stack.isEmpty())
            answer.append(stack.pop());

        return answer.reverse().toString();
    }

    public static void main(String[] args) {
        _394DecodeString obj = new _394DecodeString();
        System.out.println(obj.decodeString("3[a]2[bc]"));
        System.out.println(obj.decodeString("3[a2[c]]"));
        System.out.println(obj.decodeString("2[abc]3[cd]ef"));
    }
}

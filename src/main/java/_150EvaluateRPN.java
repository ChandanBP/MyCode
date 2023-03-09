import java.util.HashSet;
import java.util.Stack;

public class _150EvaluateRPN {

    public int evalRPN(String[] tokens) {

        if(tokens==null || tokens.length==0)return 0;
        if(tokens.length==1)return 1;

        Stack<String>stack = new Stack<>();

        HashSet<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        int res=0;
        for(String token:tokens){

            if(operators.contains(token)){
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());

                switch (token){
                    case "+":res = op1+op2;
                    break;
                    case "-":res = op1-op2;
                    break;
                    case "*":res = op1*op2;
                    break;
                    case "/":res = op1/op2;
                    break;
                }
                stack.push(String.valueOf(res));
            }else{
                stack.push(token);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _150EvaluateRPN().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}

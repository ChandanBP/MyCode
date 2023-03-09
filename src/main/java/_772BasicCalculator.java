import java.util.HashSet;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _772BasicCalculator {

    String expression;
    HashSet<Character>operators = new HashSet<>();
    HashSet<Character>braces = new HashSet<>();

    public void init(String s){
        operators.add('+');
        operators.add('-');
        operators.add('/');
        operators.add('*');
        braces.add('(');
        braces.add(')');
        expression = s;
    }

    public String evaluateBraces(String str){
        int mulInd = str.indexOf('*');
        int divInd = str.indexOf('/');
        int addInd = str.indexOf('+');
        int subInd = str.indexOf('-');

        if(mulInd!=-1 && divInd!=-1){
            if(mulInd<divInd){
                str = perform(str,'*');
                str = perform(str,'/');
            }else{
                str = perform(str,'/');
                str = perform(str,'*');
            }
        }else if(mulInd!=-1 && divInd==-1){
            str = perform(str,'*');
        }else if(mulInd==-1 && divInd!=-1){
            str = perform(str,'/');
        }else{
            // do nothing
        }

        // Addition and substraction
        if(addInd!=-1 && subInd!=-1){
            if(addInd<subInd){
                str = perform(str,'+');
                str = perform(str,'-');
            }else{
                str = perform(str,'-');
                str = perform(str,'+');
            }
        }else if(addInd!=-1 && subInd==-1){
            str = perform(str,'+');
        }else if(addInd==-1 && subInd!=-1){
            str = perform(str,'-');
        }else{
            // do nothing
        }

        return str;
    }


    public String getLeftOperand(String str,int index){

        if(str.charAt(index)=='('||str.charAt(index)==')') return "";
        if(index==0 && str.charAt(0)=='-')return "";
        if(index-1>=0 && operators.contains(str.charAt(index-1)))--index;

        StringBuilder sb = new StringBuilder();
        index-=1;
        while(index>=0 &&
              !operators.contains(str.charAt(index)) &&
              !braces.contains(str.charAt(index))){
            sb.append(str.charAt(index));
            --index;
        }
        if(index>=0){
            if(index==0 && str.charAt(index)=='-') sb.append('-');
            if(index-1>=0 && operators.contains(str.charAt(index-1)) || index-1>=0 &&braces.contains(str.charAt(index-1)))
                sb.append(str.charAt(index-1));
        }
        return sb.reverse().toString();
    }

    public String getRightOperand(String str,int index){
        StringBuilder sb = new StringBuilder();
        index+=1;
        if(operators.contains(str.charAt(index))){
            sb.append(str.charAt(index));
            index++;
        }
        while(index<str.length() &&
                !operators.contains(str.charAt(index)) &&
                !braces.contains(str.charAt(index))){
            sb.append(str.charAt(index));
            ++index;
        }
        return sb.toString();
    }

    public long calculator(long op1,char operator,long op2){
        switch (operator){
            case '+':return op1+op2;
            case '-':return op1-op2;
            case '*':return op1*op2;
            default:return op1/op2;
        }
    }

    public String perform(String str,char operator){
        int i=0;
        while(i<str.length()){
            if(str.charAt(i)!=' ' && str.charAt(i)==operator){

                String op1 = getLeftOperand(str,i);
                Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
                Matcher matcher = pattern.matcher(op1);
                if(!matcher.matches())return str;

                String op2= getRightOperand(str,i);
                StringBuilder sb = new StringBuilder();
                int index1 = str.substring(0,i).length()-op1.length();
                sb.append(str.substring(0,index1));
                long val = calculator(Long.parseLong(op1),operator,Long.parseLong(op2));
                sb.append(val);
                sb.append(str.substring(i+op2.length()+1,str.length()));
                i = i-op1.length()-1;
                i+=String.valueOf(val).length();
                str = sb.toString();
            }
            ++i;
        }
        return str;
    }

    public int performCalculation(String s,int start,int end){

        Stack<String>stack = new Stack<>();

        int i = 0;
        while(i<s.length()){
            if(s.charAt(i)==' '){
                ++i;
                continue;
            }

            if(s.charAt(i)!=')'){
                stack.push(s.charAt(i)+"");
            }else{
                int t = 0;
                StringBuilder sb = new StringBuilder();
                String expr="";
                while(!stack.peek().equals("(")){
                    String temp = stack.pop();
                    sb.append(temp);
                    expr = temp+expr;
                    t=t+temp.length();
                }
                stack.pop();
                ++t;
                ++t;
                int index1 = s.substring(0,i).length()-sb.toString().length()-1;
                sb = new StringBuilder();
                sb.append(s.substring(0,index1));
                String evaluate = evaluateBraces(expr);
                sb.append(evaluate);
                stack.push(evaluate);
                sb.append(s.substring(i+1,s.length()));
                s=sb.toString();
                t = i-t;
                i=t+evaluate.length();
            }
            ++i;
        }
        StringBuilder sb = new StringBuilder();
        for(i=0;i<stack.size();i++){
            sb.append(stack.get(i));
        }
        return Integer.parseInt(evaluateBraces(sb.toString()));
    }

    public int calculate(String s) {
        if(s==null||s.length()<1)return 0;
        init(s);
        return performCalculation(s,0,s.length());
    }

    public static void main(String[] args) {
        _772BasicCalculator obj = new _772BasicCalculator();
        String s = "2-4-(8+2-6+(8+4-(1)+8-10))";
        obj.init(s);
        System.out.println(obj.calculate(s));
    }
}

import java.util.Deque;
import java.util.LinkedList;

public class _227BasicCalculator {

    public String getRightOperand(String s,int i){
        i++;
        StringBuilder sb = new StringBuilder();
        while(i<s.length() && (s.charAt(i)>='0' &&
                s.charAt(i)<='9')){
            sb.append(s.charAt(i));
            ++i;
        }
        return sb.toString();
    }

    public long performCalculation(char operator,int op1,int op2){
        long res=0;
        switch (operator){
            case '+':res= op1+op2;
            break;
            case '-':res= op1-op2;
            break;
            case '*':res= op1*op2;
            break;
            case '/':res= op1/op2;
        }
        return res;
    }

    public int calculate(String s) {

        Deque<String> queue = new LinkedList();

        StringBuilder t = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' ')t.append(s.charAt(i));
        }

        s=t.toString();
        int i=0;
        StringBuilder sb = new StringBuilder();
        while(i<s.length()){
            char ch = s.charAt(i);

            if(ch==' '){

            }
            else if(ch>='0' && ch<='9'){
                sb.append(ch);
            }else if(ch=='*'||ch=='/'){

                if(sb.toString().length()>0)queue.add(sb.toString());
                int left = Integer.parseInt(queue.pollLast());
                String strRight = getRightOperand(s,i);
                int right = Integer.parseInt(strRight);
                i+=strRight.length();
                queue.add(String.valueOf(performCalculation(ch,left,right)));
                sb=new StringBuilder();
            }else{
                if(sb.toString().length()>0)queue.add(sb.toString());
                queue.add(ch+"");
                sb=new StringBuilder();
            }
            ++i;
        }

        if(sb.toString().length()>0)queue.addLast(sb.toString());
        // Perform for addition and subtraction
        char operator='\0';
        String left="";
        String right="";
        while(!queue.isEmpty()){
            String s1 = queue.pollFirst();
            if(queue.isEmpty() && left=="")return Integer.parseInt(s1);
            if(s1.length()==1 && (s1.charAt(0)=='+' || s1.charAt(0)=='-')){
                operator=s1.charAt(0);
            }
            else if(left==""){
                left=s1;
            }else{
                right=s1;
                long res = performCalculation(operator,Integer.parseInt(left),Integer.parseInt(right));
                queue.addFirst(String.valueOf(res));
                operator='\0';
                left="";
            }
        }

        return Integer.parseInt(queue.pollFirst());
    }

    public static void main(String[] args) {
        System.out.println(new _227BasicCalculator().calculate("2*3*4"));
    }
}

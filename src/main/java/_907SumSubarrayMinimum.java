import java.util.Stack;

public class _907SumSubarrayMinimum {

    class Pair{
        int count;
        int element;
        public Pair(int count,int element){
            this.count=count;
            this.element=element;
        }
    }

    public int sumSubarrayMins(int[] A) {

        Stack<Pair>stack1 = new Stack<>();
        Stack<Pair>stack2 = new Stack<>();

        int left[] = new int[A.length];
        int right[] = new int[A.length];

        for(int i=0;i<A.length;i++){
            int count = 1;
            while(!stack1.isEmpty() && A[i]<stack1.peek().element){
                count+=stack1.peek().count;
                stack1.pop();
            }
            Pair p = new Pair(count,A[i]);
            stack1.push(p);
            left[i]=count;
        }


        for(int i=A.length-1;i>=0;i--){
            int count = 1;
            while(!stack2.isEmpty() && A[i]<=stack2.peek().element){
                count+=stack2.peek().count;
                stack2.pop();
            }
            Pair p = new Pair(count,A[i]);
            stack2.push(p);
            right[i]=count;
        }

        int res=0;
        for(int i=0;i<A.length;i++){
            res+=(A[i]*left[i]*right[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _907SumSubarrayMinimum().sumSubarrayMins(new int[]{3,1,2,4}));
    }
}

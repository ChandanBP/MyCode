import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int arr[] = new int[]{13, 7, 6, 12};

        Stack<Integer> stack = new Stack();
        int nge[] = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]){
                stack.pop();
            }
            nge[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        for(int i=0;i<arr.length;i++){
            if(nge[i]!=-1)
                System.out.println(arr[nge[i]]);
            else
                System.out.println(-1);
        }
    }
}

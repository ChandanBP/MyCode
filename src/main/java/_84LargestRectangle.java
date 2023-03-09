import java.util.Stack;

public class _84LargestRectangle {

    public int largestRectangleArea(int[] heights) {

        if(heights==null || heights.length==0)return 0;

        Stack<Integer> stack = new Stack<>();

        int area=0;
        int i=0;
        while(i<heights.length){
            if(stack.isEmpty() || heights[stack.peek()]<=heights[i]){
                stack.push(i++);
            }else{
                int index = stack.pop();
                int ele = heights[index];
                if(stack.isEmpty()){
                    area = Math.max(area,i*ele);
                }else{
                    area = Math.max(area,(i-stack.peek()-1)*ele);
                }
            }
        }

        while(!stack.isEmpty()){
            int index = stack.pop();
            int ele = heights[index];
            if(stack.isEmpty()){
                area = Math.max(area,i*ele);
            }else{
                area = Math.max(area,(i-stack.peek()-1)*ele);
            }
        }

        return area;
    }

    public static void main(String[] args) {
        System.out.println(new _84LargestRectangle().largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}

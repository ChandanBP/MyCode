import java.util.Stack;

public class _735AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer>stack = new Stack<>();
        int i=0;
        while(i<asteroids.length){
            if(asteroids[i]>0){
                stack.push(asteroids[i]);
                ++i;
            }else{

                if(stack.isEmpty() || stack.peek()<0){
                    stack.push(asteroids[i]);
                    ++i;
                }else if(Math.abs(stack.peek())<Math.abs(asteroids[i])){
                    stack.pop();
                }else if(Math.abs(stack.peek())>Math.abs(asteroids[i])){
                    ++i;
                }else{
                    stack.pop();
                    ++i;
                }
            }
        }
        int result[] = new int[stack.size()];
        i=result.length-1;
        while (!stack.isEmpty()){
            result[i--]=stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        new _735AsteroidCollision().asteroidCollision(new int[]{10,5,-2,2,3,-4});
    }
}

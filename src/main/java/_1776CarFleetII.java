import java.nio.file.Path;
import java.util.Stack;

public class _1776CarFleetII {

    public double[] getCollisionTimes(int[][] cars) {

        int len = cars.length;
        Stack<double[]>stack = new Stack();

        double answer[] = new double[len];
        for(int i=len-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()[1]!=-1){
                double t = getTime(cars[i],cars[(int)stack.peek()[0]]);
                if(t>=stack.peek()[1] || t<0){
                    stack.pop();
                }else{
                    break;
                }
            }
            answer[i] = stack.isEmpty()?-1:getTime(cars[i],cars[(int)stack.peek()[0]]);
            answer[i] = (answer[i]>0)?answer[i]:-1;
            stack.push(new double[]{i,answer[i]});
        }
        return answer;
    }

    // p1<p2
    public double getTime(int[] car1,int car2[]){

        int p1 = car1[0];
        int s1 = car1[1];

        int p2 = car2[0];
        int s2 = car2[1];
        if(s1==s2)return -1;
        double val = (double)(p2-p1)/(s1-s2);
        return val>0?val:-2;
    }

    public static void main(String[] args) {
        int cars[][] = {{1,4},{4,5},{7,1},{13,4},{14,3},{15,2},{16,5},{19,1}};
        _1776CarFleetII obj = new _1776CarFleetII();
        obj.getCollisionTimes(cars);
    }
}

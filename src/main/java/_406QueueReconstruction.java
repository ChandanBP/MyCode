import java.util.Arrays;
import java.util.LinkedList;

public class _406QueueReconstruction {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(p1,p2)->(p1[0]==p2[0])?p1[1]-p2[1]:p1[0]-p2[0]);
        LinkedList<int[]>result = new LinkedList();
        for(int[]p:people)
            result.add(p[1],p);
        return result.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        LinkedList<Integer>list = new LinkedList<>();
        list.add(0,1);
        list.add(1,3);
        list.add(0,2);
        list.forEach(i-> System.out.println(i));
    }
}

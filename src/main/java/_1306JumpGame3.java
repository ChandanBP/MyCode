import java.util.LinkedList;
import java.util.List;

public class _1306JumpGame3 {

    static boolean visited[];
    static boolean reachable = false;
    static int indices[];
    static  int destination;
    static LinkedList graph[];

    public static void buildGraph(int arr[]){

        graph = new LinkedList[arr.length];
        for(int i=0;i<arr.length;i++){

            if(graph[i]==null){
                graph[i] = new LinkedList();
            }

            if(arr[i]!=0){
                if(i+arr[i]<=arr.length-1){
                    graph[i].add(i+arr[i]);
                }

                if(i-arr[i]>=0){
                    graph[i].add(i-arr[i]);
                }
            }
        }
    }

    public void dfs(int root,int target){

        List<Integer>list = graph[root];

        for(int i=0;i<list.size();i++){
            int child = list.get(i);
            if(!visited[child]){
                visited[child] = true;
                if(indices[child]==0){
                    reachable = true;
                    break;
                }
                dfs(child,target);
            }
        }
    }

    public static void findDestination(int[] arr){

        int i=0;
        destination = -1;
        for(int ele:arr){
            if(ele==0) {
                destination = i;
                break;
            }
            i++;
        }
    }

    public boolean canReach(int[] arr, int start) {

        if(arr[start]==0)return true;

        reachable = false;
        indices = arr;
        findDestination(arr);

        if(destination==-1)return false;

        buildGraph(arr);
        visited = new boolean[arr.length];
        visited[start] = true;
        dfs(start,destination);
        return reachable;
    }

    public static void main(String[] args) {
        System.out.println(new _1306JumpGame3().canReach(new int[]{0},0));
    }
}

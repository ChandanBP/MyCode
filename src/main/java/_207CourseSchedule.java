import java.util.LinkedList;
import java.util.ListIterator;

public class _207CourseSchedule {

    LinkedList graph[];
    int status[];

    public boolean dfs(int root){

        if(status[root]==1)return false;

        if(graph[root]==null){
            status[root]=2;
            return true;
        }

        status[root]=1;
        ListIterator<Integer>listIterator = graph[root].listIterator();
        while(listIterator.hasNext()){
            int depCourse = listIterator.next();
            if(status[depCourse]==1)return false;
            if(status[depCourse]==0){
                boolean ret = dfs(depCourse);
                if(ret==false)return false;
            }
        }
        status[root]=2;
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        graph = new LinkedList[numCourses];

        for(int i=0;i<prerequisites.length;i++){
            if(graph[prerequisites[i][0]]==null)graph[prerequisites[i][0]]=new LinkedList<Integer>();
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        status = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(status[i]==0)
                if(!dfs(i))return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _207CourseSchedule().canFinish(2,new int[][]{{1,0},{0,1}}));
    }
}

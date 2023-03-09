import java.util.HashSet;

public class _2101DetonateMax {
	
	int max = 1;
	int val = 1;
	HashSet<Integer>visited;
	
	public void dfs(int[][] bombs,int i) {

		visited.add(i);

		int x1 = bombs[i][0];
		int y1 = bombs[i][1];
		int r1 = bombs[i][2];

		for(int index=0;index<bombs.length;index++){
			if(index!=i && !visited.contains(index)){
				int x2 = bombs[index][0];
				int y2 = bombs[index][1];
				
				double dist = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
				if(dist<=r1){
					++val;
					dfs(bombs,index);
				}
			}
		}
	}
	
	
	public int maximumDetonation(int[][] bombs) {
		
		for(int i=0;i<bombs.length;i++) {
			visited = new HashSet<Integer>();
			val = 1;
			dfs(bombs,i);
			if(val>max)
				max = val;
		}
		return max;
    }
	
	public static void main(String[] args) {
		System.out.println(new _2101DetonateMax().maximumDetonation(new int[][] {{2,1,3},{6,1,4}}));
	}
}
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

public class _967SameConsecutiveDiff {

    HashMap<Integer,LinkedList<String>> map = new HashMap();

    public void dfs(int n,int k){

        LinkedList<String>prevList = map.get(n-1);

        for(int i=1;i<=9;i++){
            ListIterator<String>ite = prevList.listIterator();
            LinkedList<String>result = new LinkedList();
            while(ite.hasNext()){
                String str = ite.next();
                if(Math.abs(Integer.parseInt(str.charAt(0)+"")-i)==k){
                    result.add(i+str);
                }
            }
            map.put(n,result);
        }
    }

    public int[] numsSameConsecDiff(int n, int k) {
        for(int i=1;i<=n;i++){
            if(i==1){
                LinkedList<String> list = new LinkedList();
                for(int j=0;j<=9;j++){

                    list.add(j+"");
                    map.put(j,list);
                }
            }else{
                dfs(i,k);
            }
        }

        LinkedList<String>resultList = map.get(n);
        if(resultList==null||resultList.size()==0)return new int[]{};

        ListIterator<String> ite = resultList.listIterator();
        int[] result = new int[resultList.size()];
        int i=0;
        while(ite.hasNext()){
            String str = ite.next();
            result[i++] = Integer.parseInt(str);
        }
        return result;
    }

    public static void main(String[] args) {
        new _967SameConsecutiveDiff().numsSameConsecDiff(3,7);
    }
}

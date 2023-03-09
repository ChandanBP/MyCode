import java.util.*;

public class _752OpenLock {

    HashSet<String>visited = new HashSet<>();

    public String getDigits(char op,int i,String source){

        char ch[] = source.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(source, 0, i);

        int digit = Character.getNumericValue(source.charAt(i));
        if(op=='-')
            sb.append((digit==0)?9:digit-1);
        else
            sb.append((digit==9)?0:digit+1);
        sb.append((i<=2)?source.substring(i+1,4):"");
        return sb.toString();
    }


    public int bfs(String source,String target){

        PriorityQueue<Integer>q = new PriorityQueue<>(2);


        Queue<String>queue = new LinkedList<>();
        visited.add(source);
        queue.add(source);
        int d = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String str = queue.poll();
                if(str.equals(target)){
                    return d;
                }else{
                    for(int k=0;k<4;k++){

                        String s = getDigits('+',k,str);
                        if(!visited.contains(s)){
                            visited.add(s);
                            queue.add(s);
                        }

                        s = getDigits('-',k,str);
                        if(!visited.contains(s)){
                            visited.add(s);
                            queue.add(s);
                        }
                    }
                }
            }
            ++d;
        }
        return -1;
    }

    public int openLock(String[] deadends, String target) {

        for(String deadEnd:deadends){
            visited.add(deadEnd);
        }
        if(visited.contains("0000"))return -1;
        if(target=="0000")return 0;

        return bfs("0000",target);
    }

    public static void main(String[] args) {
        System.out.println(new _752OpenLock().openLock(new String[]{"0201","0101","0102","1212","2002"},"0202"));
    }
}

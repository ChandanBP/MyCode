import java.util.LinkedList;
import java.util.Queue;

public class _843GuessTheWord {

    int dist[][];
    interface Master{
        default int guess(String word){
            return 1;
        }
    }

    public int editDistance(String word1,String word2){
        int count = 0;
        for(int i=0;i<word1.length();i++){
            if(word1.charAt(i)==word2.charAt(i))++count;
        }
        return count;
    }

    public void findSecretWord(String[] wordlist, Master master) {

        dist = new int[wordlist.length][wordlist.length];
        for(int i=0;i<wordlist.length-1;i++){
            for(int j=i+1;j<wordlist.length;j++){
                dist[i][j] = dist[j][i] = editDistance(wordlist[i],wordlist[j]);
            }
        }

        Queue<Integer> queue = new LinkedList();
        queue.add(0);

        while(!queue.isEmpty()){
            int index1 = queue.poll();
            String word1 = wordlist[index1];
            int distance1 = master.guess(word1);
            if(distance1==6)return;

            int size = queue.size();
            for(int i=1;i<=size;i++){
                int index2 = queue.poll();
                int distance2 = dist[index1][index2];
                if(distance2>=distance1){
                    queue.add(index2);
                }
            }
        }
    }
}

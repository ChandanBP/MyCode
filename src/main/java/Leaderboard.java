import java.util.*;

public class Leaderboard {

    TreeSet<ScoreCount>treeSet;
    HashMap<Integer,ScoreCount>map;
    public Leaderboard(){
        treeSet = new TreeSet<>();
        map = new HashMap<>();
    }

    class ScoreCount implements Comparable<ScoreCount>{
        int id;
        int score;
        public ScoreCount(int id,int score){
            this.id=id;
            this.score=score;
        }

        @Override
        public int compareTo(ScoreCount scoreCount) {
            if(scoreCount.score==this.score)return this.id-scoreCount.id;
            return scoreCount.score-this.score;
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof ScoreCount))return false;

            ScoreCount sc = (ScoreCount)obj;
            if(this.id==sc.id && this.score==sc.score)return true;
            return false;
        }

        @Override
        public int hashCode() {
            return this.id;
        }
    }

    public void addScore(int playerId, int score) {
        if(map.containsKey(playerId)){
            ScoreCount sc = map.get(playerId);
            int c = sc.score;
            map.remove(playerId);
            treeSet.remove(sc);

            ScoreCount s1 = new ScoreCount(playerId,score+c);
            treeSet.add(s1);
            map.put(playerId,s1);
        }else{
            ScoreCount sc = new ScoreCount(playerId,score);
            treeSet.add(sc);
            map.put(playerId,sc);
        }
    }

    public int top(int K) {
        int sum=0;
        Iterator<ScoreCount>iterator = treeSet.iterator();
        while(iterator.hasNext()){
            if(K==0)break;
            sum+=iterator.next().score;
            --K;
        }
        return sum;
    }

    public void reset(int playerId) {
        ScoreCount sc = map.get(playerId);
        treeSet.remove(sc);
        map.remove(playerId);
    }

    public static void main(String[] args) {
        Leaderboard leaderBoard = new Leaderboard();
        leaderBoard.addScore(1,73);
        leaderBoard.addScore(2,56);
        leaderBoard.addScore(3,39);
        leaderBoard.addScore(4,51);
        leaderBoard.addScore(5,4);
        System.out.println(leaderBoard.top(1));
        leaderBoard.reset(1);
        leaderBoard.reset(2);
        leaderBoard.addScore(2,51);
        System.out.println(leaderBoard.top(3));
    }
}

public class _299BullsAndCows {

    public String getHint(String secret, String guess) {

        int secretcount[] = new int[10];
        int guesscount[] = new int[10];

        int bulls = 0;
        for(int i=0;i<secret.length();i++){
            secretcount[Integer.parseInt(secret.charAt(i)+"")]++;
            guesscount[Integer.parseInt(guess.charAt(i)+"")]++;
            if(secret.charAt(i)==guess.charAt(i)){
                ++bulls;
            }
        }

        int cows = 0;
        for(int i=0;i<=9;i++){
            cows+=Math.min(secretcount[i],guesscount[i]);
        }

        return bulls+"A"+(Math.abs(bulls-cows))+"B";
    }

    public static void main(String[] args) {
        System.out.println(new _299BullsAndCows().getHint("1807","7810"));
        System.out.println(new _299BullsAndCows().getHint("1123","0111"));
    }
}

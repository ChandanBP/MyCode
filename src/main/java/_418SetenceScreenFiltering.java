public class _418SetenceScreenFiltering {

    public int wordsTyping(String[] sentence, int rows, int cols) {

        if(sentence==null ||
           sentence.length==0 ||
           rows==0 || cols==0)return 0;

        int row;
        int lenRequired[] = new int[cols];

        for(int col=0;col<cols;col++){

            row = 0;
            int t = col;

            for(int k=0;k<sentence.length;k++){

                String word = sentence[k];
                if(word.length()>cols)return 0;
                if(k!=0 && t!=0){
                    ++t;
                }

                int remLen = cols-t;
                if(remLen>=word.length()){
                    t+=word.length() ;
                }else{
                    ++row;
                    t=word.length();
                }

                if(k==sentence.length-1){
                    int len = (row==0)?(t-col):cols-col+t;
                    if(((row+1)-2)>0)
                        len+=((row+1)-2)*cols;

                    lenRequired[col]=len;
                }
                if(t==cols){
                    ++row;
                    t=0;
                }
            }
        }

        int i=0,numTimes=0,totalLen = (rows*cols);
        while(i<totalLen){
            int len = (i%cols==0)?lenRequired[0]:1+lenRequired[(i+1)%cols];
            i+=len;
            if((i-1)>=(totalLen))break;
            ++numTimes;
        }

        return numTimes;
    }

    public int method2(String[] sentence, int rows, int cols){

        String entireSentence = String.join(" ", sentence) + " ";
        int sentenceLength = entireSentence.length();

        int total = 0;
        for (int i = 0; i < rows; i++) {
            total += cols;
            if (entireSentence.charAt(total % sentenceLength) == ' ')
                total++;
            else {
                while (total > 0 &&
                        entireSentence.charAt((total - 1) % sentenceLength) != ' ')
                    total--;
            }
        }
        return total / sentenceLength;
    }

    public static void main(String[] args) {
        //System.out.println(String.join(" ",new String[]{"f","p","a"}).length());
        System.out.println(new _418SetenceScreenFiltering().method2(new String[]{"hello","world"},2,8));
    }
}

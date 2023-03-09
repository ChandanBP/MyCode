public class __1138AlphabetBoard {

    public void appendMoves(StringBuilder sb,char ch,int count){
        while (count!=0){
            sb.append(ch);
            --count;
        }
    }

    public void moveX(int x1,int x2,StringBuilder sb){
        if(x1<x2)
            appendMoves(sb,'D',x2-x1);
        else if(x2<x1)
            appendMoves(sb,'U',x1-x2);
    }

    public void moveY(int y1,int y2,StringBuilder sb){
        if(y1<y2)
            appendMoves(sb,'R',y2-y1);
        else if(y2<y1)
            appendMoves(sb,'L',y1-y2);
    }

    public String alphabetBoardPath(String target) {

        int x1 = 0;
        int y1 = 0;

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<target.length();i++){
            int in = target.charAt(i)-'a';
            int x2 = in/5;
            int y2 = in%5;

            int fx = (x1>x2)?x1-(x1-x2):x1+(x2-x1);
            int fy = (y1>y2)?y1-(y1-y2):y1+(y2-y1);

            if(fx==5 && (y1>=1 && y1<=4)){
                moveY(y1,y2,sb);
                moveX(x1,x2,sb);
            }
            else if(x1==5 && (fy>=1 && fy<=4)){
                moveX(x1,x2,sb);
                moveY(y1,y2,sb);
            }else{
                moveX(x1,x2,sb);
                moveY(y1,y2,sb);
            }
            sb.append("!");
            x1 = x2;
            y1 = y2;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new __1138AlphabetBoard().alphabetBoardPath("gzz"));
    }
}
